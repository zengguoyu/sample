package com.kenny.common.mybatis.pager.executor;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.CallableStatementHandler;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.SimpleStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import com.kenny.common.mybatis.pager.dialect.Dialect;
import com.kenny.common.mybatis.pager.model.PageBounds;

/**
 * 通用执行SQL执行器
 * 
 */
public final class CommonExecutor {

	private Dialect dialect;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public CommonExecutor(Dialect dialect) {
		this.dialect = dialect;
	}

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	/**
	 * 这里是获取物理分页list的sql<br/>
	 * 会改变rowBounds的值，<br/>
	 * 所以一定要在getCountSql()之后
	 * 
	 * @param rowBounds
	 * @param boundSql
	 * @return 如果是分页的查询则返回limitSql，否则返回null
	 * @throws SQLException
	 */
	public String getPageSql(RowBounds rowBounds, BoundSql boundSql) throws SQLException {
		if (dialect != null && rowBounds != null && rowBounds.getLimit() != RowBounds.NO_ROW_LIMIT) {
			// 下面是物理分页查出数据
			String limitSql = dialect.getLimitString(boundSql.getSql(), rowBounds.getOffset(), rowBounds.getLimit());
			// 上面已经完成了物理分页sql的拼装，
			// 现在要查询全部的数据，
			// 故将该rowBounds的值置为默认值逃避mybatis默认的逻辑分页程序，
			// 必须用反射，要改变其内存所在地的数据

			// 下面这段反射对RowBounds的子类一样适用
			Field offset = ReflectionUtils.findField(RowBounds.class, "offset");
			ReflectionUtils.makeAccessible(offset);
			ReflectionUtils.setField(offset, rowBounds, RowBounds.NO_ROW_OFFSET);
			Field limit = ReflectionUtils.findField(RowBounds.class, "limit");
			ReflectionUtils.makeAccessible(limit);
			ReflectionUtils.setField(limit, rowBounds, RowBounds.NO_ROW_LIMIT);
			
			return limitSql;
		}
		return null;
	}

	/**
	 * 这里是获取物理分页list的sql，<br/>
	 * 会改变rowBounds的值，<br/>
	 * 所以一定要在getCountSql()之后
	 * 
	 * @param rowBounds
	 * @param boundSql
	 * @return 如果是分页的查询则返回改变值后的boundSql，<br/>
	 *         否则返回入参时的boundSql
	 * @throws SQLException
	 */
	public BoundSql queryPageSql(//
			RowBounds rowBounds, //
			BoundSql boundSql) throws SQLException {
		// 2,下面是正确的物理分页查询出list，
		// 但是会改变rowBounds的成员变量值
		String targetSql = getPageSql(rowBounds, boundSql);
		if (targetSql != null) {
			Field field = ReflectionUtils.findField(BoundSql.class, "sql");
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, boundSql, targetSql);
		}
		return boundSql;
	}

	/**
	 * 获取count的sql，这里不会改变rowBounds的值
	 * 
	 * @param rowBounds
	 * @param boundSql
	 * @return 如果是分页的查询则返回countsql，否则返回null
	 * @throws SQLException
	 */
	public String getCountSql(RowBounds rowBounds, BoundSql boundSql) throws SQLException {
		if (dialect != null && rowBounds != null && rowBounds.getLimit() != RowBounds.NO_ROW_LIMIT) {
			return dialect.getCountSqlString(boundSql.getSql());
		}
		return null;
	}

	/**
	 * 无状态的方法。分页查询统计总数，并塞值到rowBounds(要我们自己写的PageBounds)
	 * 
	 * @param executor
	 * @param ms
	 * @param parameter
	 * @param rowBounds
	 * @param resultHandler
	 * @param key
	 * @param boundSql
	 * @return
	 * @throws SQLException
	 */
	public RowBounds queryCountAndSetRowBounds(Executor executor, MappedStatement ms, Object parameter,
			RowBounds rowBounds, @SuppressWarnings("rawtypes") ResultHandler resultHandler, CacheKey key,
			BoundSql boundSql) throws SQLException {
		// 1,这里进行计算出count，如果你是要分页查询的话
		String countSql = getCountSql(rowBounds, boundSql);
		int totalCount = 0;
		if (countSql != null) {
			totalCount = doQueryCount(executor, countSql, ms, parameter, rowBounds, resultHandler, key, boundSql);
			// 2,如果是我们自己写的分页Bounds，则塞入total
			if (rowBounds instanceof PageBounds) { 
				// 不加totalCount>0的限制
				((PageBounds) rowBounds).setTotal(totalCount);
			}
		}
		return rowBounds;
	}

	/**
	 * 实际计算总数的函数。代码都是参考mybatis源码编写的
	 * 
	 * @param executor
	 * @param countSql
	 * @param ms
	 * @param parameter
	 * @param rowBounds
	 * @param resultHandler
	 * @param key
	 * @param boundSql
	 * @return
	 * @throws SQLException
	 */
	public int doQueryCount(Executor executor, String countSql, MappedStatement ms, Object parameter,
			RowBounds rowBounds, @SuppressWarnings("rawtypes") ResultHandler resultHandler, CacheKey key,
			BoundSql boundSql) throws SQLException {
		int totalCount = 0;
		if (countSql != null) {
			IPageExecutor pageExecutor = (IPageExecutor) executor;
			Statement stmt = null;
			try {
				/* *** 查总数方案1.begin。以下代码都是参考mybatis源码编写的 */
				/**
				 * <pre>
				 * originalSql是boundSql的原生sql，先替换成countSql，做完事在换回来originalSql
				 * 理由：我看了源码，塞参操作是没有改变boundSql内的数据，只读的；如果以后发现有改变数据的地方，则改为新建一个BoundSql对象，然后把additionalParameters和metaParameters的值反射塞数据进去。
				 * // 这里自己构造自己的rowBounds和boundSql
				//Configuration configuration = ms.getConfiguration();
				//BoundSql countBoundSql = new BoundSql(configuration, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
				//然后把boundSql中additionalParameters和metaParameters的值反射塞入countBoundSql。
				 * </pre>
				 */
				String originalSql = boundSql.getSql();
				Field field = ReflectionUtils.findField(BoundSql.class, "sql");
				ReflectionUtils.makeAccessible(field);

				// 先替换成countSql，做完事在换回来originalSql
				ReflectionUtils.setField(field, boundSql, countSql);
				RowBounds countRowBounds = RowBounds.DEFAULT;
				StatementHandler handler = new RoutingStatementHandler(executor, ms, parameter, countRowBounds,
						resultHandler, boundSql);
				// 这里生成了Statement某个实现类的对象
				stmt = pageExecutor.prepareStatement(handler, ms.getStatementLog());
				
				// 下面就是return handler.<E>query(stmt, resultHandler);做的事情了
				// delegate
				Field delegateField = ReflectionUtils.findField(RoutingStatementHandler.class, "delegate");
				ReflectionUtils.makeAccessible(delegateField);
				Object delegate = ReflectionUtils.getField(delegateField, handler);
				if (delegate instanceof CallableStatementHandler) {
					CallableStatement cs = (CallableStatement) stmt;
					cs.execute();
				} else if (delegate instanceof PreparedStatementHandler) {
					PreparedStatement ps = (PreparedStatement) stmt;
					ps.execute();
				} else if (delegate instanceof SimpleStatementHandler) {
					String sql = boundSql.getSql();
					stmt.execute(sql);
				}
				// handleResultSets(Statement stmt)
				ResultSet rs = null;
				rs = stmt.getResultSet();
				if (rs != null && rs.next()) {
					totalCount = rs.getInt(1);
				}
				logger.info("CommonExecutor#totalCount = " + totalCount);
				//
				// 先替换成countSql，做完事在换回来originalSql
				ReflectionUtils.setField(field, boundSql, originalSql);
				/* *** 查总数方案1.end */
			}
			// 不捕获异常
			// catch(Exception e){
			// e.printStackTrace();
			// //throw e;
			// }
			finally {
				pageExecutor.myCloseStatement(stmt);
			}
		}
		return totalCount;
	}

	/**
	 * 如果是分页查询，则先查询总数并塞值到rowBounds中(要我们自己写的PageBounds)，最后返回物理分页sql。物理分页会改变rowBounds的值
	 * 
	 * @param executor
	 * @param ms
	 * @param parameter
	 * @param rowBounds
	 * @param resultHandler
	 * @param key
	 * @param boundSql
	 * @return 如果是分页的查询则返回改变值后的boundSql，否则返回入参时的boundSql
	 * @throws SQLException
	 */
	public BoundSql queryCountAndSetRowBoundsAndPageSql(//
			Executor executor, //
			MappedStatement ms, //
			Object parameter, //
			RowBounds rowBounds, //
			@SuppressWarnings("rawtypes") ResultHandler resultHandler, //
			CacheKey key, //
			BoundSql boundSql) throws SQLException {
		// 1,如果是分页查询，这里进行计算出count统计总数，并塞值到rowBounds中
		queryCountAndSetRowBounds(executor, ms, parameter, rowBounds, resultHandler, key, boundSql);
		// 2,下面是正确的物理分页查询出list的sql，但是会改变rowBounds的成员变量值,所以一定要放在最后
		return queryPageSql(rowBounds, boundSql);
	}

}
