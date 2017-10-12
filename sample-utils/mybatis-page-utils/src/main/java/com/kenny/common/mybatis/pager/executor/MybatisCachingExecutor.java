package com.kenny.common.mybatis.pager.executor;

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

import com.kenny.common.mybatis.pager.model.Page;

public class MybatisCachingExecutor extends CachingExecutor implements IPageExecutor {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public MybatisCachingExecutor(Executor delegate) {
		super(delegate);
	}

	private CommonExecutor commonExecutor;

	public void setCommonExecutor(CommonExecutor commonExecutor) {
		this.commonExecutor = commonExecutor;
	}

	@Override
	public <E> List<E> query(MappedStatement ms, Object parameterObject, RowBounds rowBounds,
			@SuppressWarnings("rawtypes") ResultHandler resultHandler) throws SQLException {
		if (rowBounds == null) {
			rowBounds = new RowBounds();
		}
		return super.query(ms, parameterObject, rowBounds, resultHandler);
	}

	@Override
	public <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds,
			@SuppressWarnings("rawtypes") ResultHandler resultHandler, CacheKey key, BoundSql boundSql)
			throws SQLException {
		if (rowBounds == null) {
			rowBounds = new RowBounds();
		}

		if (commonExecutor != null) {
			// 如果是分页查询，则先查询总数并塞值到rowBounds中，最后返回物理分页sql。物理分页会改变rowBounds的值
			commonExecutor.queryCountAndSetRowBoundsAndPageSql(this, ms, parameter, rowBounds, resultHandler, key,
					boundSql);
		}
		return super.query(ms, parameter, rowBounds, resultHandler, key, boundSql);
	}

	// 直接抄org.apache.ibatis.executor.SimpleExecutor.class
	public Statement prepareStatement(StatementHandler handler, Log statementLog) throws SQLException {
		Statement stmt;
		Connection connection = getConnection(statementLog);
		stmt = handler.prepare(connection, getTransaction().getTimeout());
		handler.parameterize(stmt);
		return stmt;
	}

	// 直接抄org.apache.ibatis.executor.BaseExecutor.class
	// for backward compatibility with 3.0 style logging
	private static final Log connectionLog = LogFactory.getLog(Connection.class);

	@Override
	public void myCloseStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// ignore
			}
		}
	}

	public Connection getConnection(Log statementLog) throws SQLException {
		Connection connection = getTransaction().getConnection();
		if (statementLog.isDebugEnabled() || connectionLog.isDebugEnabled()) {
			return ConnectionLogger.newInstance(connection, statementLog, 1);
		} else {
			return connection;
		}
	}

	/******************************** 查总数方案2.下面是抄网上的查询总数代码，它原本有错误，我已修复，可以正常使用了。它只支持PreparedStatement模式的分页，我觉得够用，但如果能支持跟多模式更好 ***************************************/
	/**
	 * 获取总记录数
	 * 
	 * <pre>
	 *	setPageParameter#totalCount=8
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
