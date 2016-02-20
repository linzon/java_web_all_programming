package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DmMonitor implements IMonitorBuz{
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
		ResultSet resultSet = DBUtil.executeQuery("select PARA_VALUE FROM \"SYS\".\"V$DM_INI\"  WHERE PARA_NAME = 'WORKER_CPU_PERCENT'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select PATH from \"SYS\".\"V$DATAFILE\" where GROUP_ID = '0'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from \"SYS\".\"V$DATABASE\"", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("SELECT DB_VERSION FROM \"SYS\".\"V$INSTANCE\" WHERE NAME = 'DMSERVER'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("SELECT A.MEMUSED FROM (SELECT STAT_VAL MEMUSED FROM SYS.V$SYSSTAT WHERE UPPER(NAME)='MEMORY USED BYTES'  AND SF_GET_EP_SEQNO(rowid)=0) A, (SELECT STAT_VAL CPUUSED FROM SYS.V$SYSSTAT WHERE UPPER(NAME)='OS DM DATABASE CPU RATE' AND SF_GET_EP_SEQNO(rowid)=0) B,(SELECT COUNT(*)THREADCOUNT FROM SYS.V$THREADS WHERE SF_GET_EP_SEQNO(rowid)=0) C,(SELECT  COUNT(*) SESSIONCOUNT  FROM SYS.V$SESSIONS WHERE SF_GET_EP_SEQNO(rowid)=0) D", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("SELECT COUNT(*) FROM \"SYS\".\"V$SESSION_EVENT\"", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select CURRENT_TIMESTAMP()", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select COUNT(*) FROM SYS.V$SESSIONS", connection);
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
		Class.forName("dm.jdbc.driver.DmDriver");
		connection = DriverManager.getConnection("jdbc:dm://" + host + ":"+port, username,password);
	}


}
