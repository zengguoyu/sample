package com.kenny.common.mybatis.pager.executor;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.CallableStatementHandler;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.SimpleStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.logging.jdbc.ConnectionLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import com.kenny.common.mybatis.pager.model.Page;
import com.kenny.common.mybatis.pager.model.PageBounds;

public class MybatisCachingExecutor_bak extends CachingExecutor {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public MybatisCachingExecutor_bak(Executor delegate) {
		super(delegate);
	}

	private CommonExecutor commonExecutor;

	public void setCommonExecutor(CommonExecutor commonExecutor) {
		this.commonExecutor = commonExecutor;
	}

	@Override
	public <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds,
			@SuppressWarnings("rawtypes") ResultHandler resultHandler, CacheKey key, BoundSql boundSql)
			throws SQLException {
		if (commonExecutor != null) {
			// 1,这里进行计算出count，如果你是要分页查询的话
			String countSql = commonExecutor.getCountSql(rowBounds, boundSql);
			if (countSql != null) {
				Statement stmt = null;
				try {
					String originalSql = boundSql.getSql();
					Field field = ReflectionUtils.findField(BoundSql.class, "sql");
					ReflectionUtils.makeAccessible(field);
					// 先替换成countSql，做完事在换回来originalSql
					ReflectionUtils.setField(field, boundSql, countSql);
					RowBounds countRowBounds = RowBounds.DEFAULT;
					StatementHandler handler = new RoutingStatementHandler(this, ms, parameter, countRowBounds,
							resultHandler, boundSql);
					// 这里生成了Statement某个实现类的对象
					stmt = prepareStatement(handler, ms.getStatementLog());

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
					int totalCount = 0;
					if (rs != null && rs.next()) {
						totalCount = rs.getInt(1);
					}
					logger.info("totalCount = " + totalCount);
					// 如果是我们自己写的分页Bounds，则塞入total
					if (rowBounds instanceof PageBounds) {
						((PageBounds) rowBounds).setTotal(totalCount);
					}
					// 先替换成countSql，做完事在换回来originalSql
					ReflectionUtils.setField(field, boundSql, originalSql);
					/* *** 查总数方案1.end */

				} finally {
					closeStatement(stmt);
				}
			}
			// 2,下面是正确的物理分页查询出list，但是会改变rowBounds的成员变量值
			String targetSql = commonExecutor.getPageSql(rowBounds, boundSql);
			if (targetSql != null) {
				Field field = ReflectionUtils.findField(BoundSql.class, "sql");
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, boundSql, targetSql);
			}
		}
		return super.query(ms, parameter, rowBounds, resultHandler, key, boundSql);
	}

	// 直接抄org.apache.ibatis.executor.SimpleExecutor.class
	private Statement prepareStatement(StatementHandler handler, Log statementLog) throws SQLException {
		Statement stmt;
		Connection connection = getConnection(statementLog);
		stmt = handler.prepare(connection, getTransaction().getTimeout());
		handler.parameterize(stmt);
		return stmt;
	}

	// 直接抄org.apache.ibatis.executor.BaseExecutor.class
	// for backward compatibility with 3.0 style logging
	private static final Log connectionLog = LogFactory.getLog(Connection.class);

	protected Connection getConnection(Log statementLog) throws SQLException {
		Connection connection = getTransaction().getConnection();
		if (statementLog.isDebugEnabled() || connectionLog.isDebugEnabled()) {
			return ConnectionLogger.newInstance(connection, statementLog, 1);
		} else {
			return connection;
		}
	}

	protected void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// ignore
			}
		}
	}

	/******************************** 查总数方案2.下面是抄网上的查询总数代码，它原本有错误，我已修复，可以正常使用了。它只支持PreparedStatement模式的分页，我觉得够用，但如果能支持跟多模式更好 ***************************************/
	/**
	 * 获取总记录数
	 * 
	 * <pre>
	 [DEBUG] 2017-02-01 14:07:26,710 [java.sql.Connection:DEBUG 47 main]===> ==>  Preparing: select count(*) as rs_count from (select id, code, name, sex from tb_student_info WHERE ( name like ? )) T_TEMP 
	[DEBUG] 2017-02-01 14:07:26,740 [java.sql.PreparedStatement:DEBUG 47 main]===> ==> Parameters: %senvon%(String)
	setPageParameter#totalCount=8
	 * </pre>
	 * 
	 * @param sql
	 * @param connection
	 * @param mappedStatement
	 * @param boundSql
	 * @param page
	 */
	@SuppressWarnings("unused")
	private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement, BoundSql boundSql,
			Page<?> page) {
		// 记录总记录数
		// String countSql = "select count(0) from (" + sql + ")";
		String countSql = sql;
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			countStmt = connection.prepareStatement(countSql);
			// BoundSql countBS = new
			// BoundSql(mappedStatement.getConfiguration(), countSql,
			// boundSql.getParameterMappings(), boundSql.getParameterObject());
			// 注意，不能新建一个BoundSql
			// countBS，原因是boundSql中additionalParameters和metaParameters有值，但是新建的countBS中这两个成员变量是没有值得，这样造成了塞参数错误。
			setParameters(countStmt, mappedStatement, boundSql, boundSql.getParameterObject());
			rs = countStmt.executeQuery();
			int totalCount = 0;
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			page.setTotal(totalCount);
			logger.info("setPageParameter#totalCount=" + totalCount);
		} catch (SQLException e) {
			logger.error("Ignore this exception", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
			try {
				countStmt.close();
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
		}
	}

	/**
	 * 代入参数值
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
		parameterHandler.setParameters(ps);
	}

}
