package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OscarMonitor implements IMonitorBuz{
	private static Connection connection = null;

	@Override
	public String getCharacters(String args) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCpu(String args) throws SQLException {
		// TODO Auto-generated method stub
		
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("show CPU_OPERATOR_COST", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		return res;
	}

	@Override
	public String getDataFileDir(String args) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDatabaseNum(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from info_schem.v_sys_database_info", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		return res;
	}


	@Override
	public String getDatabaseVersion(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT VERSION()", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		return res;
	}



	@Override
	public String getMemery(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select sum(\"TOTAL SIZE\") from v_sys_globaltopmemorycontext where \"MEMORYCONTEXT NAME\" like '%Global%'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		return res;
	}

	@Override
	public String getSession(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*)  from v_sys_sessions", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		return res;
	}


	@Override
	public String getUpTime(String args) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*)  from v_sys_sessions", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
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
			}
		}
		Class.forName("com.oscar.Driver");
//		String url = "jdbc:oscar://10.0.5.158:2003/testdb";
		connection = DriverManager.getConnection("jdbc:oscar://"+host+":"+port+"/"+dbname, username,password);
	}

}
