package com.jump;

import java.sql.SQLException;

public interface MssqlMonitorBuz  extends IMonitorBuz{
	/**
	 * ��ȡ���ٻ���ҳ
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getHighSpeedCache(String args) throws SQLException;
	
	/**
	 * ��ȡ���ٶ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getHighSpeedCacheObject(String args) throws SQLException;
	
	/**
	 * ��ȡ�û����ӱ���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getUserConnectionsPercent(String args) throws SQLException;
	
	/**
	 * ��ȡ��չ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getExpandLockRequestRatePerSecond(String args) throws SQLException;
	/**
	 * ��ȡÿ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getBusinessNum(String args) throws SQLException;
	
	
	/**
	 * ��ȡ�ؼ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getKeyLockRequestRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡҳ����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getPageLockRequestRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡ��ID��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getRawIDLockRequestRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡÿ��ע����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getRegisterPerSecond(String args) throws SQLException;
	
	
	/**
	 * ��ȡÿ��ע����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLogoutPerSecond(String args) throws SQLException;
	
	
	/**
	 * ��ȡ����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getBlockProgressNum(String args) throws SQLException;
	
	/**
	 * ��ȡ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockRequestRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡҳ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getPageReadRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡҳд����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getPageWriteRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡ����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCacheHitRate(String args) throws SQLException;
	
	/**
	 * ��ȡ��д����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getReadWriteErrorPerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockNum(String args) throws SQLException;
	
	/**
	 * ��ȡ���ݰ�������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDataPacketErrorRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡ���ݰ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDataPacketSendRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡ���ݰ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDataPacketReceiveRatePerSecond(String args) throws SQLException;
	
	/**
	 * ��ȡio����ռ��cpu��Դ�ٷֱ�
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getIOOperationUseCPUPercent(String args) throws SQLException;
	
	/**
	 * ��ȡcpu���аٷֱ�
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCPUFreePercent(String args) throws SQLException;
	
	
	/**
	 * ��ȡcpu��æʱ��ٷֱ�
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCPUBusyTimePercent(String args) throws SQLException;
	
	
	/**
	 * ��ȡ�Ż����ڴ�
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getOptimizeMemery(String args) throws SQLException;

	/**
	 * ��ȡ���ݿ�д������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getWriteRatePerSecond(String args) throws SQLException;
	
	
	/**
	 * ��ȡ���ݿ��ȡ����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getReadRatePerSecond(String args) throws SQLException;
	
	
	
	/**
	 * ��ȡ���ٻ������ʹ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getHighCacheObjectUseRate(String args) throws SQLException;
	
	
	/**
	 * ��ȡ���ٻ����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getHighCachePool(String args) throws SQLException;
	
	/**
	 * ��ȡ���ڴ�
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockMemery(String args) throws SQLException;
	
	/**
	 * ��ȡ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDiedLockNum(String args) throws SQLException;
	/**
	 * ��ȡ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getMaxConnections(String args) throws SQLException ;
}
