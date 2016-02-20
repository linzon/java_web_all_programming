package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MaxdbMonitor  implements IMonitorBuz{
	private static Connection connection = null;

	@Override
	public String getCharacters(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select value from sysinfo.activeconfiguration where lower(parametername) = lower('default_code')", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select cpuload from sysinfo.machineutilization", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select value from sysinfo.activeconfiguration where lower(parametername) = lower('rundirectory')", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from domain.serverdbs", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select id from sysinfo.version", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select (physicalmemorysize - physicalmemoryusable) / physicalmemorysize from sysinfo.machineconfiguration, sysinfo.machineutilization", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select count(*) session_count from sysinfo.sessions", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}
	/**
	 * 获取数据库服务器运行时间
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	private long getLastRunSeconds() throws SQLException {
		String date_time = "";
		ResultSet resultSet = DBUtil.executeQuery("select restart_date || ' ' || restart_time || '|' || now() from dbtimes", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			date_time = resultSet.getString(1);
		}
		resultSet.close();
		if (date_time.trim().length() <= 0) {
			throw new SQLException("not get Start Date Time");
		}

		int sepIndex = date_time.indexOf("|");
		if (sepIndex < 0) {
			throw new SQLException("not get Now Date Time");
		}

		try {

			String restart_date_time = date_time.substring(0, sepIndex);
			String now_date_time = date_time.substring(sepIndex + 1);

			SimpleDateFormat dateFormat = new SimpleDateFormat();

			dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
			Date restart_dt = dateFormat.parse(restart_date_time);
			long restart_sec = restart_dt.getTime();

			dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
			Date now_dt = dateFormat.parse(now_date_time);
			long now_sec = now_dt.getTime();

			long sec_distance = (now_sec - restart_sec) / 1000;

			return sec_distance;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException(e);
		}
	}

	@Override
	public String getUpTime(String args) throws SQLException {
		long last_run_seconds = getLastRunSeconds(); 
		String days = String.valueOf(last_run_seconds / (60 * 60 * 24));
		String hours = String.valueOf((last_run_seconds % (60 * 60 * 24)) / (60 * 60));
		String minites = String.valueOf(((last_run_seconds % (60 * 60 * 24)) % (60 * 60)) / 60);
		String seconds = String.valueOf(((last_run_seconds % (60 * 60 * 24)) % (60 * 60)) % 60);
		return days + "天" + hours + "小时" + minites + "分钟" + seconds + "秒";
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from domain.connectedusers", connection);
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
		Class.forName("com.sap.dbtech.jdbc.DriverSapDB");
		String url = "jdbc:sapdb://" + host + ":" + port + "/" + dbname;
		connection = DriverManager.getConnection(url, username,password);
	}

}
