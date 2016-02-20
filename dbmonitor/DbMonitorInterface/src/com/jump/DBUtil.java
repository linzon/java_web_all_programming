package com.jump;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	/**
	 * 执行查询返回结果集
	 * @param sql
	 * @param connection
	 * @return
	 * @throws SQLException
	 * 2014-12-11
	 * Administrator
	 * ResultSet
	 */
	public static ResultSet executeQuery(String sql,Connection connection) {
		Statement stat = null;
		ResultSet resultSet = null;
		try {
			stat = connection.createStatement();
			resultSet = stat.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			stat = null;
		}
		return resultSet;
	}
	
	/**
	 * 执行查询返回结果集
	 * @param sql
	 * @param connection
	 * @return
	 * @throws SQLException
	 * 2014-12-11
	 * Administrator
	 * ResultSet
	 */
	public static boolean execute(String sql,Connection connection) {
		Statement stat = null;
		boolean isSuccess = false;
		try {
			stat = connection.createStatement();
			isSuccess = stat.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			stat = null;
		}
		return isSuccess;
	}
}
