package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MsSqlMonitor implements MssqlMonitorBuz{
	private static Connection connection = null;

	@Override
	public String getCpu(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@CPU_BUSY*1.0/(@@IDLE + @@CPU_BUSY)*100", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getWriteRatePerSecond(String args) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getReadRatePerSecond(String args) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getReadWriteErrorPerSecond(String args) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}	
	@Override
	public String getHighCachePool(String args) throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name like '%SQL Cache Memory (KB)%'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name ='SQL Cache Memory (KB)'", connection);
		while (resultSet.next()) {
		//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res+"KB";
	}

	@Override
	public String getHighSpeedCache(String args) throws SQLException {
		// select * from sys.dm_os_performance_counters where counter_name like '%Cache page%' and instance_name='_Total'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name like '%Cache page%' and instance_name='_Total'", connection);
		while (resultSet.next()) {
		//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}
	
	
	
	@Override
	public String getOptimizeMemery(String args) throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name ='Optimizer Memory (KB)';
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name ='Optimizer Memory (KB)'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res+"KB";
	}
	@Override
	public String getBlockProgressNum(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from sysprocesses where blocked > 0 ", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}
  
	@Override
	public String getCPUBusyTimePercent(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@CPU_BUSY*1.0/(@@IDLE + @@CPU_BUSY)*100", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getCPUFreePercent(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@IDLE*1.0/(@@IDLE + @@CPU_BUSY)*100", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getCacheHitRate(String args) throws SQLException {
		//select cntr_value from sys.dm_os_performance_counters where counter_name='Buffer cache hit ratio'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Buffer cache hit ratio'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDataPacketErrorRatePerSecond(String args)
			throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@PACKET_ERRORS*1.0/(@@PACK_SENT+@@PACK_RECEIVED)*100", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDataPacketReceiveRatePerSecond(String args)
			throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@PACK_RECEIVED / @@CPU_BUSY", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDataPacketSendRatePerSecond(String args)
			throws SQLException {		
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@PACK_SENT / @@CPU_BUSY", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDiedLockNum(String args) throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name='Mars Deadlocks'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Mars Deadlocks'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	

	@Override
	public String getHighCacheObjectUseRate(String args) throws SQLException {
		// TODO Auto-generated method stub
		//select cntr_value from sys.dm_os_performance_counters where counter_name='Buffer cache hit ratio'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Buffer cache hit ratio'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getHighSpeedCacheObject(String args) throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name='Cache Object Counts'and instance_name='_Total'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Cache Object Counts'and instance_name='_Total'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getIOOperationUseCPUPercent(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@IO_BUSY*1.0 / @@CPU_BUSY", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}
	@Override
	public String getLockNum(String args) throws SQLException {
		// TODO Auto-generated method stub
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from sys.dm_tran_locks", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLockRequestRatePerSecond(String args) throws SQLException {
		//select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='_Total'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='_Total'", connection);
		while (resultSet.next()) {
		//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getKeyLockRequestRatePerSecond(String args)
			throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='Key'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='Key'", connection);
		while (resultSet.next()) {
		//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}
	
	@Override
	public String getExpandLockRequestRatePerSecond(String args)
			throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='Extent'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='Extent'", connection);
		while (resultSet.next()) {
		//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}
	@Override
	public String getLockMemery(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Memory (KB)'", connection);
		while (resultSet.next()) {
		//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res+"KB";
	}

	

	@Override
	public String getLogoutPerSecond(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Logouts/sec'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	
	@Override
	public String getPageLockRequestRatePerSecond(String args)
			throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='Page'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='Page'", connection);
		while (resultSet.next()) {
		//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getPageReadRatePerSecond(String args) throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name='Page reads/sec'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Page reads/sec'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getPageWriteRatePerSecond(String args) throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name='Page writes/sec'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Page writes/sec'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getRawIDLockRequestRatePerSecond(String args)
			throws SQLException {
		// select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='RID'
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Lock Requests/sec' and instance_name='RID'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

		
	@Override
	public String getRegisterPerSecond(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Logins/sec'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getUserConnectionsPercent(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value from sys.dm_os_performance_counters where counter_name='Connection Reset/sec'", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}	

	@Override
	public String getBusinessNum(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@TRANCOUNT", connection);
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
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select filename from sys.sysfiles", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from sys.databases", connection);
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
	public String getMaxConnections(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select @@MAX_CONNECTIONS", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select cntr_value/1024 from sys.dm_os_performance_counters where counter_name='Max memory (KB)'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from sys.dm_exec_sessions where host_process_id >0 ", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select ms_ticks/1000 from sys.dm_os_sys_info", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		
		//返回结果
		return  MonitorUtil.toDate(res);
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		String res = "";
		//执行sql查询
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from sys.dm_exec_connections where net_transport='TCP'", connection);
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
		// 

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
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connection = DriverManager.getConnection("jdbc:sqlserver://" + host + ":"+port, username,password);
			
	}
	
	
}
