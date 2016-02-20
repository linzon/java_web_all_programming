package com.jump;

import java.sql.SQLException;

public interface PostgresqlMonitorBuz  extends IMonitorBuz{
	/**
	 * 获取硬盘请求数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDiskRequest(String args) throws SQLException;
	
	/**
	 * 获取缓冲区磁盘块请求数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBufferRegionDiskPieceRequest(String args) throws SQLException;
	
	
	/**
	 * 获取共享池
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getSharePool(String args) throws SQLException;
	
	/**
	 * 获取排序页大小
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getSortPageSize(String args) throws SQLException;
	
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
	 * 获取归档模式
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getFileMode(String args) throws SQLException;
	
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
	 * 获取事务回滚率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBusinessRollbackRate(String args) throws SQLException;
	
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
