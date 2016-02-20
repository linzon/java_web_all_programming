package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlMonitor implements MysqlMonitorBuz{
	private static Connection connection = null;
	@Override
	public String getCacheRequestNum(String args) throws SQLException {
		String res = "";
		String res1 = "";
		String res2 = "";
		//执行sql查询
		ResultSet resultSet1 = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='KEY_READ_REQUESTS'", connection);
		while (resultSet1.next()) {
			//解析结果集，必要时进行结果计算
			res1 = resultSet1.getString(1);
		}
		resultSet1.close();
		ResultSet resultSet2 = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='KEY_WRITE_REQUESTS'", connection);
		while (resultSet2.next()) {
			//解析结果集，必要时进行结果计算
			res2 = resultSet2.getString(1);
		}
		resultSet2.close();
		int i1 = Integer.parseInt(res1);
		int i2 = Integer.parseInt(res2);
		int sum = (i1+i2);
		res = Integer.toString(sum); 
		return res;
	}


	@Override
	public String getCacheThreads(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Threads_cached'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getCacheVisitRate(String args) throws SQLException {
		String res = "";
		String res1 = "";
		String res2 = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='QCACHE_FREE_MEMORY'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res1 = resultSet.getString(1);
		}
		resultSet.close();
		//执行sql查询
		ResultSet resultSet2 = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME='QUERY_CACHE_SIZE'", connection);
		while (resultSet2.next()) {
			//解析结果集，必要时进行结果计算
			res2 = resultSet2.getString(1);
		}
		resultSet2.close();
		//返回结果
		Float f1 = Float.parseFloat(res1);
		Float f2 = Float.parseFloat(res2);
		res = (f2 - f1) / f1 * 100 + "";
		return res;
	}


	@Override
	public String getConnections(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='CONNECTIONS'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getDataFileRequestNum(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='HANDLER_READ_RND_NEXT'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getDirectLockTime(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Table_locks_immediate'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getKeyCacheSize(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME = 'KEY_BUFFER_SIZE'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getLockWaitTime(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Table_locks_waited'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getOpenConnections(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select COUNT(*) FROM information_schema.GLOBAL_STATUS  where VARIABLE_NAME Like '%onn%'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getOpenFileNum(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME='INNODB_OPEN_FILES'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getOpenFlowNum(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='OPEN_STREAMS'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getOpenTableNum(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='OPEN_TABLES'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getQueryCacheSize(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME = 'QUERY_CACHE_SIZE'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getRunningThreads(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='THREADS_CONNECTED'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getTableScanRate(String args) throws SQLException {
		String res = "";
		String res1 = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Handler_read_rnd_next'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res1 = resultSet.getString(1);
		}
		resultSet.close();
		
		String res2 = "";
		//执行sql查询
		ResultSet resultSet2 = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Com_select'", connection);
		while (resultSet2.next()) {
			//解析结果集，必要时进行结果计算
			res2 = resultSet2.getString(1);
		}
		resultSet2.close();
		//返回结果
		Float f1 = Float.valueOf(Float.parseFloat(res1));
		Float f2 = Float.valueOf(Float.parseFloat(res2));
		res = String.valueOf(f1.floatValue() / f2.floatValue());
		return res;
	}


	@Override
	public String getThreadConnections(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='THREADS_CREATED'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getWakeupThreads(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Threads_running'", connection);
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
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME='CHARACTER_SET_SERVER'", connection);
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
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Threads_cached'", connection);
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
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME = 'DATADIR'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select count(*) FROM information_schema.SCHEMATA", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getDatabaseServiceProcessNum(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select count(*) FROM information_schema.PROCESSLIST", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME = 'VERSION'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getMaxConnections(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME='MAX_CONNECTIONS'", connection);
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
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Threads_cached'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getQueryRequestNum(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='QUESTIONS'", connection);
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
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select count(*) FROM information_schema.processlist", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getStorageEngine(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_VARIABLES where VARIABLE_NAME = 'DEFAULT_STORAGE_ENGINE'", connection);
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
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='UPTIME'", connection);
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
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select variable_value FROM information_schema.GLOBAL_STATUS where VARIABLE_NAME='Threads_connected'", connection);
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
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://" + host + ":"+port, username,password);
	}

}
