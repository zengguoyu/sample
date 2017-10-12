package com.kenny.common.mybatis.pager.dialect;

public enum EnumDbDialect {

	/**
	 * DB2
	 */
	DIALECT_DB2(DB2Dialect.class.getName()),
	/**
	 * MYSQL
	 */
	DIALECT_MYSQL(MysqlDialect.class.getName()),
	/**
	 * MSSQL
	 */
	DIALECT_MSSQL(MSSqlDialect.class.getName()),
	/**
	 * ORACLE
	 */
	DIALECT_ORACLE(OracleDialect.class.getName());

	private String className;

	private EnumDbDialect(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public static EnumDbDialect resolveName(String name) {
		try {
			return valueOf(name);
		} catch (NullPointerException | IllegalArgumentException e) {
			return null;
		}
	}
}
