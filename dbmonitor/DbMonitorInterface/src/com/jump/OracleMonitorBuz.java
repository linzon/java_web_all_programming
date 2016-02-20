package com.jump;

import java.sql.SQLException;

public interface OracleMonitorBuz  extends IMonitorBuz{

	/**
	 * 获取数据字典缓存命中率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getWordbookCacheHitRate(String args) throws SQLException;
	
	/**
	 * 获取内存排序比率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getMemerySortRate(String args) throws SQLException;
	
	/**
	 * 获取每分钟登录会话数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLoginPerMinute(String args) throws SQLException;
	
	/**
	 * 获取当前打开的游标数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOpenCusorNum(String args) throws SQLException;
	
	/**
	 * 获取最大空闲块
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getMaxFreePiece(String args) throws SQLException;
	
	/**
	 * 获取会话空闲连接数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getSessionFreeConnnections(String args) throws SQLException;
	
	/**
	 * 获取表空间个数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getTableSpaceNum(String args) throws SQLException;
	
	
	/**
	 * 获取数据文件个数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDataFileNum(String args) throws SQLException;
	
	/**
	 * 获取java池
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getJavaPool(String args) throws SQLException;
	
	/**
	 * 获取日志缓冲池
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getLogCachePool(String args) throws SQLException;
	
	/**
	 * 获取缓存命中率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCacheHitRate(String args) throws SQLException;
	
	/**
	 * 获取锁数量
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockNum(String args) throws SQLException;
	
	/**
	 * 获取PGA
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPGA(String args) throws SQLException;
	
	/**
	 * 获取物理内存容量
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPhysicsMemery(String args) throws SQLException;
	
	/**
	 * 获取磁盘排序次数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDiskSortTime(String args) throws SQLException;
	
	/**
	 * 获取内存排序次数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getMemerySortTime(String args) throws SQLException;
	

	
	/**
	 * 获取物理读速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPhysicalReadRate(String args) throws SQLException;
	
	/**
	 * 获取物理写速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPhysicalWriteRate(String args) throws SQLException;
	
	/**
	 * 获取归档模式
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getFileMode(String args) throws SQLException;
	
	/**
	 * 获取阻塞锁
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBlockLockNum(String args) throws SQLException;
	/**
	 * 获取死锁数量
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDiedLockNum(String args) throws SQLException;
	/**
	 * 获取每秒事务数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getBusinessNum(String args) throws SQLException;
	
	/**
	 * 获取事务回滚率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBusinessRollbackRate(String args) throws SQLException;
	
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
	 * 获取最大连接数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getMaxConnections(String args) throws SQLException ;
}
