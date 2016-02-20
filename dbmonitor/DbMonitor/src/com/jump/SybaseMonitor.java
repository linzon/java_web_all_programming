package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SybaseMonitor implements IMonitorBuz{
	private static Connection connection = null;
	
	@Override
	public String getMemery(String args) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getSession(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select count( *) from master.dbo.sysprocesses where ipaddr!=''", connection);
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
	public String getCharacters(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@LANGUAGE", connection);
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
		// select phyname from  dbo.sysdevices where phyname like '%sysp%'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery(" select phyname from  dbo.sysdevices", connection);
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
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from dbo.sysdatabases", connection);
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
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@VERSION", connection);
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
		//select starttime from sysengines
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select starttime from sysengines", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		long distime = (System.currentTimeMillis()-MonitorUtil.ParseDate(res))/1000;
	
		return MonitorUtil.toDate(distime+"");
	}
	
	@Override
	public String getUserConnections(String args) throws SQLException {
		// select * from dbo.sysprocesses where status like '%recv%'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select count(distinct(ipaddr)) from master.dbo.sysprocesses", connection);
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
			}
		}
		//dbDriver:com.sybase.jdbc3.jdbc.SybDriver
		//jdbc:sybase:Tds:10.0.5.109:5000/tempdb
		Class.forName("com.sybase.jdbc3.jdbc.SybDriver");
		connection = DriverManager.getConnection("jdbc:sybase:Tds:" + host + ":"+port + "/"+dbname, username,password);
	}
}
