package com.jump;

import java.sql.SQLException;

public interface DB2MonitorBuz extends IMonitorBuz{
	/**
	 * 获取远程连接数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getRemoteConnnections(String args) throws SQLException;
	
	/**
	 * 获取尝试连接总数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getTryConnections(String args) throws SQLException;
	
	/**
	 * 获取本地连接总数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getLocalConnections(String args) throws SQLException;
	
	/**
	 * 获取代理数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getAgencyConnections(String args) throws SQLException;
	
	/**
	 * 获取活动代理数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getActiveAgencyConnections(String args) throws SQLException;
	
	/**
	 * 获取空闲代理数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getFreeAgencyConnections(String args) throws SQLException;
	
	/**
	 * 获取日志利用率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getLogUseRate(String args) throws SQLException;
	
	/**
	 * 获取IO读次数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getIOReadTime(String args) throws SQLException;
	
	/**
	 * 获取IO写次数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getIOWriteTime(String args) throws SQLException;
	
	/**
	 * 获取TCP/IP服务名称
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getTCPIPService(String args) throws SQLException;
	
	/**
	 * 获取数据库日志大小
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDatabaseLogSize(String args) throws SQLException;
}
