package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB2Monitor  implements DB2MonitorBuz{
	private static Connection connection = null;
	@Override
	public String getActiveAgencyConnections(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select COUNT(*) from table(snapshot_appl('',-2)) WHERE INBOUND_COMM_ADDRESS != ''", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getAgencyConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select COUNT(*) from table(snapshot_appl('',-2))", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDatabaseLogSize(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select TOTAL_LOG_AVAILABLE_KB from SYSIBMADM.LOG_UTILIZATION", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getFreeAgencyConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select COUNT(*) from table(snapshot_appl('',-2)) WHERE INBOUND_COMM_ADDRESS = ''", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getIOReadTime(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select TOTAL_PHYSICAL_READS from SYSIBMADM.BP_READ_IO WHERE BP_NAME= 'IBMDEFAULTBP'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getIOWriteTime(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select TOTAL_WRITES from SYSIBMADM.BP_WRITE_IO WHERE BP_NAME= 'IBMDEFAULTBP'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLocalConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select LOCAL_CONS from SYSIBMADM.SNAPDBM", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLogUseRate(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select LOG_UTILIZATION_PERCENT from SYSIBMADM.LOG_UTILIZATION", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getRemoteConnnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select REM_CONS_IN from SYSIBMADM.SNAPDBM", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getTCPIPService(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select VALUE from SYSIBMADM.DBMCFG where NAME = 'svcename'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getTryConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select VALUE from SYSIBMADM.DBMCFG where NAME = 'max_connretries'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}



	@Override
	public String getCharacters(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select VALUE from SYSIBMADM.DBCFG where NAME = 'codeset'", connection);
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
		String res1 = "";
		String res2 = "";
		ResultSet resultSet = DBUtil.executeQuery("select sum(AGENT_USR_CPU_TIME_S*1000000 + AGENT_USR_CPU_TIME_MS) from sysibmadm.SNAPAPPL", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res1 = resultSet.getString(1);
		}
		resultSet.close();
		
		ResultSet resultSet2 = DBUtil.executeQuery("select sum(AGENT_SYS_CPU_TIME_S*1000000 + AGENT_SYS_CPU_TIME_MS) from sysibmadm.SNAPAPPL", connection);
		while (resultSet2.next()) {
			//解析结果集，必要时进行结果计算
			res2 = resultSet2.getString(1);
		}
		resultSet2.close();
		//返回结果
		float r1 = Float.valueOf(res1);
		float r2 = Float.valueOf(res2);
		res = (r1/r2) +"";
		
		return res;
	}

	@Override
	public String getDataFileDir(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select CONTAINER_NAME from SYSIBMADM.CONTAINER_UTILIZATION where TBSP_NAME = 'USERSPACE1'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select VALUE from SYSIBMADM.DBMCFG where NAME = 'numdb'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select VERSIONNUMBER from SYSIBM.SYSVERSIONS", connection);
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
		String res1 = "";
		String res2 = "";
		ResultSet resultSet = DBUtil.executeQuery("select sum(POOL_CUR_SIZE) from SYSIBMADM.SNAPDB_MEMORY_POOL", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res1 = resultSet.getString(1);
		}
		resultSet.close();
		
		ResultSet resultSet2 = DBUtil.executeQuery("select TOTAL_MEMORY from sysibmadm.ENV_SYS_INFO", connection);
		while (resultSet2.next()) {
			//解析结果集，必要时进行结果计算
			res2 = resultSet2.getString(1);
		}
		resultSet2.close();
		//返回结果
		float f1 = Float.valueOf(res1);
		float f2 = Float.valueOf(res2);
		res = f1/(f2*1024*1024) + "";
		
		return res;
	}

	@Override
	public String getSession(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select COUNT(*) from table(snapshot_appl('',-2))", connection);
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
		String res = "";//select DB2START_TIME from SYSIBMADM.SNAPDBM
		ResultSet resultSet = DBUtil.executeQuery("select DB2START_TIME from SYSIBMADM.SNAPDBM", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		long distime = (System.currentTimeMillis()-MonitorUtil.ParseDate(res))/1000;
		
		return MonitorUtil.toDate(distime+"");
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select LOCAL_CONS + REM_CONS_IN from SYSIBMADM.SNAPDBM", connection);
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
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		connection = DriverManager.getConnection("jdbc:db2://" + host + ":"+port+"/"+dbname, username,password);
	}

}
