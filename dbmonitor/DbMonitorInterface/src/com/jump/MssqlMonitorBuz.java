package com.jump;

import java.sql.SQLException;

public interface MssqlMonitorBuz  extends IMonitorBuz{
	/**
	 * 获取高速缓存页
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getHighSpeedCache(String args) throws SQLException;
	
	/**
	 * 获取高速对象计数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getHighSpeedCacheObject(String args) throws SQLException;
	
	/**
	 * 获取用户连接比率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getUserConnectionsPercent(String args) throws SQLException;
	
	/**
	 * 获取扩展锁请求率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getExpandLockRequestRatePerSecond(String args) throws SQLException;
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
	 * 获取关键锁请求率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getKeyLockRequestRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取页面锁请求率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getPageLockRequestRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取行ID锁请求率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getRawIDLockRequestRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取每秒注册数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getRegisterPerSecond(String args) throws SQLException;
	
	
	/**
	 * 获取每秒注销数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLogoutPerSecond(String args) throws SQLException;
	
	
	/**
	 * 获取阻塞进程数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getBlockProgressNum(String args) throws SQLException;
	
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
	 * 获取缓存命中率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCacheHitRate(String args) throws SQLException;
	
	/**
	 * 获取读写错误
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getReadWriteErrorPerSecond(String args) throws SQLException;
	
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
	 * 获取数据包错误率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDataPacketErrorRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取数据包发送速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDataPacketSendRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取数据包接收速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDataPacketReceiveRatePerSecond(String args) throws SQLException;
	
	/**
	 * 获取io操作占用cpu资源百分比
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getIOOperationUseCPUPercent(String args) throws SQLException;
	
	/**
	 * 获取cpu空闲百分比
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCPUFreePercent(String args) throws SQLException;
	
	
	/**
	 * 获取cpu繁忙时间百分比
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCPUBusyTimePercent(String args) throws SQLException;
	
	
	/**
	 * 获取优化器内存
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getOptimizeMemery(String args) throws SQLException;

	/**
	 * 获取数据库写入速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getWriteRatePerSecond(String args) throws SQLException;
	
	
	/**
	 * 获取数据库读取速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getReadRatePerSecond(String args) throws SQLException;
	
	
	
	/**
	 * 获取高速缓存对象使用速率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getHighCacheObjectUseRate(String args) throws SQLException;
	
	
	/**
	 * 获取高速缓冲池
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getHighCachePool(String args) throws SQLException;
	
	/**
	 * 获取锁内存
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockMemery(String args) throws SQLException;
	
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
	 * 获取最大连接数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getMaxConnections(String args) throws SQLException ;
}
