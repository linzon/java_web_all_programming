package com.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InformixMonitor  implements InformixMonitorBuz{
	private static Connection connection = null;
	@Override
	public String getBufferFlushToDiskRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'flushes') / (select sh_boottime from sysmaster:sysshmvals)) flushes_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}
	
	@Override
	public String getBufferRegionReadHitRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select (bufreads - dskreads) / bufreads as bufread_hit_rate from sysmaster:sysbufpool", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getBufferRegionWriteHitRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select (bufwrites - dskwrites) / bufwrites as bufwrite_hit_rate from sysmaster:sysbufpool", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getChunkWriteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'chunkwrites') / (select sh_boottime from sysmaster:sysshmvals)) disksorts_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDeidLockRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'deadlks') / (select sh_boottime from sysmaster:sysshmvals)) deadlks_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getDsikOrderRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'disksorts') / (select sh_boottime from sysmaster:sysshmvals)) disksorts_rate from sysmaster:sysdual", connection);
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
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'lockreqs') / (select sh_boottime from sysmaster:sysshmvals)) lockreqs_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLockTimeoutRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'lktouts') / (select sh_boottime from sysmaster:sysshmvals)) lktouts_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getOrderScanRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'seqscans') / (select sh_boottime from sysmaster:sysshmvals)) seqscans_rate from sysmaster:sysdual", connection);
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
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'pagreads') / (select sh_boottime from sysmaster:sysshmvals)) pagreads_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getPageSize(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select os_pagesize from sysmaster:sysmachineinfo", connection);
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
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'pagwrites') / (select sh_boottime from sysmaster:sysshmvals)) pagwrites_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getPieceSpaceSum(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*) dbspaces_count from sysmaster:sysdbspaces", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getPieceSum(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*) chunk_count from sysmaster:syschunks", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	

	@Override
	public String getVirtualProcesses(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from sysmaster:sysvpprof", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}


	@Override
	public String getBusinessRollbackRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'isrollbacks') / (select sh_boottime from sysmaster:sysshmvals)) isrollbacks_rate from sysmaster:sysdual", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select env_name from sysmaster:sysenv where env_name = 'DBLANG'", connection);
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
		return null;
	}

	@Override
	public String getDataFileDir(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select cf_effective as rootpath from sysmaster:sysconfig where cf_name = 'ROOTPATH'", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from sysmaster:sysdatabases", connection);
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
		ResultSet resultSet = DBUtil.executeQuery(" select dbinfo('version','full')  from sysmaster:sysdual", connection);
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
		return null;
	}


	@Override
	public String getSession(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*) session_count from sysmaster:syssessions", connection);
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
		ResultSet resultSet = DBUtil.executeQuery("select sh_boottime last_run_time from sysmaster:sysshmvals", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return MonitorUtil.toDate((Double.parseDouble(res)/1000)+"");
	}

	@Override
	public String getUserConnections(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(distinct(username))  from sysmaster:syssessions", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	
	/**
	 * 物理写速率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getPhysicalWriteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'dskwrites') / (select sh_boottime from sysmaster:sysshmvals)) dskwrites_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	/**
	 * 物理读速率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getPhysicalReadRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'dskreads') / (select sh_boottime from sysmaster:sysshmvals)) dskreads_rate from sysmaster:sysdual", connection);
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
		String service = "";
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
			if(paras[i].indexOf("service=")!=-1){
				service = paras[i].substring(paras[i].indexOf("=")+1);
			}
		}
		Class.forName("com.informix.jdbc.IfxDriver");
		String url = "jdbc:informix-sqli://" + host + ":" + port + "/"
		+ dbname + ":informixserver=" + service + ";user="
		+ username + ";password=" + password;
		connection = DriverManager.getConnection(url);
	}

	@Override
	public String getCheckPointWaiteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'ckptwts') / (select value from sysmaster:sysprofile where name = 'numckpts')) ckptwts_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLRUWriteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'lruwrites') / (select sh_boottime from sysmaster:sysshmvals)) lruwrites_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLatchWaiteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'latchwts') / (select sh_boottime from sysmaster:sysshmvals)) latchwts_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLogicalLogFileCount(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select count(*) from sysmaster:syslogs", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLogicalLogPageWriteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'llgpagewrites') / (select sh_boottime from sysmaster:sysshmvals)) llgpagewrites_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLogicalLogRecordWriteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'llgrecs') / (select sh_boottime from sysmaster:sysshmvals)) llgrecs_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getLogicalLogWriteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'llgwrites') / (select sh_boottime from sysmaster:sysshmvals)) llgwrites_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getNumCheckPointRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'numckpts') / (select sh_boottime from sysmaster:sysshmvals)) numckpts_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getPhysicalLogPageWriteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'plgpagewrites') / (select sh_boottime from sysmaster:sysshmvals)) plgpagewrites_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getPhysicalLogWriteRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'plgwrites') / (select sh_boottime from sysmaster:sysshmvals)) plgwrites_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getTransactionCommitRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'iscommits') / (select sh_boottime from sysmaster:sysshmvals)) iscommits_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}

	@Override
	public String getTransactionRollbackRate(String args) throws SQLException {
		String res = "";
		ResultSet resultSet = DBUtil.executeQuery("select ((select value from sysmaster:sysprofile where name = 'isrollbacks') / (select sh_boottime from sysmaster:sysshmvals)) isrollbacks_rate from sysmaster:sysdual", connection);
		while (resultSet.next()) {
			//解析结果集，必要时进行结果计算
			res = resultSet.getString(1);
		}
		resultSet.close();
		//返回结果
		return res;
	}
}
