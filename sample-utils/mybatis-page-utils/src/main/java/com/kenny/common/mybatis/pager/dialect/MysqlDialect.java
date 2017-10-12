/**
 * 
 */
package com.kenny.common.mybatis.pager.dialect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author SenVon mysql db dialect implement
 */
public class MysqlDialect implements Dialect {

	private final Logger logger = LoggerFactory.getLogger(MysqlDialect.class);

	public String getCountSqlString(String sql) {
		if (sql != null && sql.length() > 0) {
			StringBuffer sb = new StringBuffer("SELECT COUNT(*) AS " + RS_COUNT + " FROM (" + sql + ") T_TEMP ");
			return sb.toString();
		}
		return null;
	}

	public String getLimitString(String sql, int offset, int limit) {
		if (sql != null && sql.length() > 0) {
			if (limit > 0) {
				StringBuffer sb = new StringBuffer();
				sb.append("SELECT * FROM (").append(sql).append(") T_TEMP");
				if (sql.toUpperCase().indexOf("ORDER BY") < 0) {
					sb.append(" ORDER BY 1 ");
				}
				logger.debug("==>" + (offset > 0 ? offset : 0) + "," + limit);
				sb.append(" LIMIT " + (offset > 0 ? offset : 0) + "," + limit);
				return sb.toString();
			}
			return sql;
		}
		return null;
	}
}
