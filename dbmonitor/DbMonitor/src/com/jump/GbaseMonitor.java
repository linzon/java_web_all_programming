package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GbaseMonitor implements IMonitorBuz{
	private static Connection connection = null;


	@Override
	public String getCharacters(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select `VARIABLE_VALUE` from `information_schema`.`GLOBAL_VARIABLES` where   `VARIABLE_NAME` = 'CHARACTER_SET_CONNECTION'", connection);
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
		// TODO Auto-generated method stub
				String res = "";
		ResultSet resultSet = DBUtil.executeQuery("  SELECT VARIABLE_VALUE FROM `information_schema`.`SESSION_STATUS` WHERE VARIABLE_NAME = 'MEMINFO_CACHE_HIT_RATE_%' ", connection);
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
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT VARIABLE_VALUE FROM `information_schema`.`SESSION_VARIABLES` WHERE  VARIABLE_NAME='GBASE_CACHE_DATA_DIR'", connection);
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
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery(" SELECT COUNT(*) FROM `information_schema`.`SCHEMATA` ", connection);
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
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select version()", connection);
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
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("  SELECT (SELECT VARIABLE_VALUE FROM `information_schema`.`SESSION_STATUS` WHERE VARIABLE_NAME='MEMINFO_DC_HEAP_USED_SIZE')/((SELECT VARIABLE_VALUE FROM `information_schema`.`SESSION_STATUS` WHERE VARIABLE_NAME='MEMINFO_DC_HEAP_TOTAL_SIZE')+0.0)", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getSession(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery(" SELECT VARIABLE_VALUE FROM `information_schema`.`SESSION_STATUS` WHERE  VARIABLE_NAME='THREADS_CONNECTED'", connection);
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
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery(" SELECT VARIABLE_VALUE FROM `information_schema`.`GLOBAL_STATUS` WHERE VARIABLE_NAME = 'UPTIME'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return MonitorUtil.toDate(res);
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT VARIABLE_VALUE FROM `information_schema`.`GLOBAL_STATUS` WHERE VARIABLE_NAME = 'CONNECTIONS'", connection);
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
		}
		Class.forName("com.gbase.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:gbase://" + host + ":"+port, username,password);
	}

}
