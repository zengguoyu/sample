package com.kenny.common.mybatis.pager.executor;

import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;

/**
 * 为了抽象出模块化
 * 
 * @author xxc
 *
 */
public interface IPageExecutor {

	
	Statement prepareStatement(StatementHandler handler, Log statementLog) throws SQLException;

	/**
	 * closeStatement这个方法名和BaseExecutor#protected void closeStatement()方法同名，但是BaseExecutor里是protected修饰的。</br>
	 * 测试过程序运行正确，但我觉得在某些情况下会导致程序不知调哪个方法好的情况 比如在BaseExecutor的子类中。故改名myCloseStatement。
	 * 
	 * @param statement
	 */
	void myCloseStatement(Statement statement);

}
