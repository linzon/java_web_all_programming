package com.jump;

import java.sql.SQLException;

public interface InformixMonitorBuz  extends IMonitorBuz{
	/**
	 * ��ȡ����ʱ��
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockTimeoutRate(String args) throws SQLException;
	
	/**
	 * ��ȡ˳��ɨ����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOrderScanRate(String args) throws SQLException;
	
	/**
	 * ��ȡ����ˢ�µ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBufferFlushToDiskRate(String args) throws SQLException;
	
	/**
	 * ��ȡchunkд����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getChunkWriteRate(String args) throws SQLException;
	
	/**
	 * ��ȡ����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDsikOrderRate(String args) throws SQLException;
	
	/**
	 * ��ȡҳ��С
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPageSize(String args) throws SQLException;
		
	/**
	 * ��ȡ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getVirtualProcesses(String args) throws SQLException;
	
	/**
	 * ��ȡ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPieceSum(String args) throws SQLException;
	
	/**
	 * ��ȡ��ռ�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPieceSpaceSum(String args) throws SQLException;
	
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
	 * ��ȡ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDeidLockRate(String args) throws SQLException;
	
	/**
	 * ��ȡ��������������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBufferRegionReadHitRate(String args) throws SQLException;
	
	/**
	 * ��ȡ������д������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBufferRegionWriteHitRate(String args) throws SQLException;
	
	/**
	 * ��ȡ����ع���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBusinessRollbackRate(String args) throws SQLException;
	/**
	 * ��ȡ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getPhysicalReadRate(String args) throws SQLException;
	/**
	 * ��ȡ����д����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getPhysicalWriteRate(String args) throws SQLException;
	/**
	 * LRUд����
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLRUWriteRate(String args) throws SQLException ;
	
	/**
	 * ����ع���
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getTransactionRollbackRate(String args) throws SQLException ;
	/**
	 * Latch�ȴ���
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLatchWaiteRate(String args) throws SQLException ;
	/**
	 * ������/��
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getNumCheckPointRate(String args) throws SQLException ;
	/**
	 * ����ȴ���
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getCheckPointWaiteRate(String args) throws SQLException ;
	/**
	 * �����ύ��
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getTransactionCommitRate(String args) throws SQLException ;
	/**
	 * �߼���־��¼д����
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLogicalLogRecordWriteRate(String args) throws SQLException ;

	/**
	 * �߼���־ҳ��д����
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLogicalLogPageWriteRate(String args) throws SQLException ;
	/**
	 * ������־ҳ��д����
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getPhysicalLogPageWriteRate(String args) throws SQLException ;
	/**
	 * �߼���־д����
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLogicalLogWriteRate(String args) throws SQLException ;
	/**
	 * ������־д����
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getPhysicalLogWriteRate(String args) throws SQLException ;
	/**
	 * �߼���־�ļ���
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public String getLogicalLogFileCount(String args) throws SQLException ;
	
}
