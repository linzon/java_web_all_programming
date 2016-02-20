package com.jump;

import java.sql.SQLException;

public interface MysqlMonitorBuz extends IMonitorBuz{
	/**
	 * 获取连接线程数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getThreadConnections(String args) throws SQLException;
	
	/**
	 * 获取连接次数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getConnections(String args) throws SQLException;
	
	
	/**
	 * 获取运行线程数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getRunningThreads(String args) throws SQLException;
	
	/**
	 * 获取缓存线程数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getCacheThreads(String args) throws SQLException;
	
	/**
	 * 获取缓存请求数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getCacheRequestNum(String args) throws SQLException;
	
	/**
	 * 获取缓存访问率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getCacheVisitRate(String args) throws SQLException;
	
	/**
	 * 获取数据文件请求数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDataFileRequestNum(String args) throws SQLException;
	
	
	/**
	 * 获取表扫描比率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getTableScanRate(String args) throws SQLException;
	
	/**
	 * 获取直接锁定次数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDirectLockTime(String args) throws SQLException;
	/**
	 * 获取主键缓存大小
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getKeyCacheSize(String args) throws SQLException;
	
	/**
	 * 获取当前打开表的数量
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOpenTableNum(String args) throws SQLException;
	
	/**
	 * 获取当前打开文件数量
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOpenFileNum(String args) throws SQLException;
	
	/**
	 * 获取打开流的数量
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	
	public String getOpenFlowNum(String args) throws SQLException;
	
	/**
	 * 获取打开连接数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOpenConnections(String args) throws SQLException;
	/**
	 * 获取非睡眠线程数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getWakeupThreads(String args) throws SQLException;
	
	/**
	 * 获取锁等待次数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getLockWaitTime(String args) throws SQLException;
	
	/**
	 * 获取查询缓存大小
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getQueryCacheSize(String args) throws SQLException;
	
	/**
	 * 获取数据库存储引擎
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getStorageEngine(String args) throws SQLException;
	/**
	 * 获取数据库服务进程数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDatabaseServiceProcessNum(String args) throws SQLException;
	
	/**
	 * 获取查询请求数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getQueryRequestNum(String args) throws SQLException;
	/**
	 * 获取最大连接数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getMaxConnections(String args) throws SQLException ;
}
