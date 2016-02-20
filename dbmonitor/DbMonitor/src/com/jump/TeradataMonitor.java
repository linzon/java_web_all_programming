package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeradataMonitor implements IMonitorBuz{
	private static Connection connection = null;


	@Override
	public String getCharacters(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery(" select ParamValue from tdwm.GlobalParams where ParamName = 'TDWM_CHARSET'", connection);
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
		return null;
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
		ResultSet resultSet = DBUtil.executeQuery("SELECT COUNT(*) FROM DBC.Dbase", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("  select ParamValue from tdwm.GlobalParams where ParamName = 'TDWM_VERSION'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("  SELECT SUM(MaxSpool) FROM DBC.DiskSpace", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("SELECT COUNT(*) FROM DBC.SessionInfo", connection);
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
		return null;
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("SELECT COUNT(*) FROM DBC.Users", connection);
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
		String host = "10.0.5.193";
		String port = "1025";
		String username = "dbc";
		String password = "dbc";
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
//		Class.forName("com.teradata.jdbc.Driver");
		Class.forName("com.teradata.jdbc.TeraDriver");
		connection = DriverManager.getConnection("jdbc:teradata://" + host + ":"+port+"", username,password);
	}

	
}
