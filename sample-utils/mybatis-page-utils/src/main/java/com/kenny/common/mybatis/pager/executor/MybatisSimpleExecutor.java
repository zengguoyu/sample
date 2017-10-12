package com.kenny.common.mybatis.pager.executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisSimpleExecutor extends SimpleExecutor implements IPageExecutor {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(getClass());

	public MybatisSimpleExecutor(Configuration configuration, Transaction transaction) {
		super(configuration, transaction);
	}

	private CommonExecutor commonExecutor;

	public void setCommonExecutor(CommonExecutor commonExecutor) {
		this.commonExecutor = commonExecutor;
	}

	@Override
	public <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds,
			@SuppressWarnings("rawtypes") ResultHandler resultHandler) throws SQLException {

		if (rowBounds == null) {
			rowBounds = new RowBounds();
		}
		return super.query(ms, parameter, rowBounds, resultHandler);
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

	public Statement prepareStatement(StatementHandler handler, Log statementLog) throws SQLException {
		Statement stmt;
		Connection connection = getConnection(statementLog);
		stmt = handler.prepare(connection, transaction.getTimeout());
		handler.parameterize(stmt);
		return stmt;
	}

	public void myCloseStatement(Statement statement) {
		super.closeStatement(statement);
	}

}
