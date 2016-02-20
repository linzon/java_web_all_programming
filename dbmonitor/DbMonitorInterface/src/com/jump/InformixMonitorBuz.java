package com.jump;

import java.sql.SQLException;

public interface InformixMonitorBuz  extends IMonitorBuz{
	/**
	 * 获取锁超时率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockTimeoutRate(String args) throws SQLException;
	
	/**
	 * 获取顺序扫描率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOrderScanRate(String args) throws SQLException;
	
	/**
	 * 获取缓冲刷新到磁盘速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBufferFlushToDiskRate(String args) throws SQLException;
	
	/**
	 * 获取chunk写速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getChunkWriteRate(String args) throws SQLException;
	
	/**
	 * 获取磁盘排序率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDsikOrderRate(String args) throws SQLException;
	
	/**
	 * 获取页大小
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPageSize(String args) throws SQLException;
		
	/**
	 * 获取虚拟进程数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getVirtualProcesses(String args) throws SQLException;
	
	/**
	 * 获取块总数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPieceSum(String args) throws SQLException;
	
	/**
	 * 获取块空间总数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPieceSpaceSum(String args) throws SQLException;
	
	/**
	 * 获取锁请求率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockRequestRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取页读速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getPageReadRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取页写速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getPageWriteRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取死锁率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDeidLockRate(String args) throws SQLException;
	
	/**
	 * 获取缓冲区读命中率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBufferRegionReadHitRate(String args) throws SQLException;
	
	/**
	 * 获取缓冲区写命中率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBufferRegionWriteHitRate(String args) throws SQLException;
	
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
	 * LRU写速率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLRUWriteRate(String args) throws SQLException ;
	
	/**
	 * 事务回滚率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getTransactionRollbackRate(String args) throws SQLException ;
	/**
	 * Latch等待率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLatchWaiteRate(String args) throws SQLException ;
	/**
	 * 检查点数/秒
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getNumCheckPointRate(String args) throws SQLException ;
	/**
	 * 检查点等待率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getCheckPointWaiteRate(String args) throws SQLException ;
	/**
	 * 事务提交率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getTransactionCommitRate(String args) throws SQLException ;
	/**
	 * 逻辑日志记录写速率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLogicalLogRecordWriteRate(String args) throws SQLException ;

	/**
	 * 逻辑日志页面写速率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLogicalLogPageWriteRate(String args) throws SQLException ;
	/**
	 * 物理日志页面写速率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getPhysicalLogPageWriteRate(String args) throws SQLException ;
	/**
	 * 逻辑日志写速率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLogicalLogWriteRate(String args) throws SQLException ;
	/**
	 * 物理日志写速率
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getPhysicalLogWriteRate(String args) throws SQLException ;
	/**
	 * 逻辑日志文件数
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLogicalLogFileCount(String args) throws SQLException ;
	
}
