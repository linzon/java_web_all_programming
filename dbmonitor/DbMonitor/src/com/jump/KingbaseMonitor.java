package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KingbaseMonitor implements IMonitorBuz{
	private static Connection connection = null;
	private String dbname = "";


	@Override
	public String getCharacters(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT GETDATABASEENCODING()", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getCpu(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT CURRENT_SETTING('cpu_operator_cost')", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDataFileDir(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT CURRENT_SETTING('data_directory')", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDatabaseNum(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT count(*) FROM sys_database", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getDatabaseVersion(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT version()", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getMemery(String args) throws SQLException {
//		String res = "";
//		ResultSet resultSet = DBUtil.executeQuery("SELECT CURRENT_SETTING('work_mem')", connection);
//		while (resultSet.next()) {
//			//解析结果集，必要时进行结果计算
//			res = resultSet.getString(1);
//		}
//		resultSet.close();
//		//返回结果
//		return res;
		return null;
	}


	@Override
	public String getSession(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT count(*) FROM sys_stat_activity", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getUpTime(String args) throws SQLException {
		return null;
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT CONNECTIONS();", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public void destroy() throws SQLException {
		connection.close();
	}


	@Override
	public void init(String param) throws SQLException, ClassNotFoundException {
		String host = "";
		String port = "";
		String username = "";
		String password = "";
		String dbname = "";
		String[] paras = param.split("&");
		for (int i = 0; i < paras.length; i++) {
			if(paras[i].indexOf("host=")!=-1){
				host = paras[i].substring(paras[i].indexOf("=")+1);
			}
			if(paras[i].indexOf("port=")!=-1){
				port = paras[i].substring(paras[i].indexOf("=")+1);
			}
			if(paras[i].indexOf("username=")!=-1){
				username = paras[i].substring(paras[i].indexOf("=")+1);
			}
			if(paras[i].indexOf("password=")!=-1){
				password = paras[i].substring(paras[i].indexOf("=")+1);
			}
			if(paras[i].indexOf("dbname=")!=-1){
				dbname = paras[i].substring(paras[i].indexOf("=")+1);
				this.dbname = dbname;
			}
		}
		Class.forName("com.kingbase.Driver");
		connection = DriverManager.getConnection("jdbc:kingbase://" + host + ":"+port+"/"+dbname, username,password);
	}

	
}
