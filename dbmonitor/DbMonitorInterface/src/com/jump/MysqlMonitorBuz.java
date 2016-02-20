package com.jump;

import java.sql.SQLException;

public interface MysqlMonitorBuz extends IMonitorBuz{
	/**
	 * ��ȡ�����߳���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getThreadConnections(String args) throws SQLException;
	
	/**
	 * ��ȡ���Ӵ���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getConnections(String args) throws SQLException;
	
	
	/**
	 * ��ȡ�����߳���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getRunningThreads(String args) throws SQLException;
	
	/**
	 * ��ȡ�����߳���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getCacheThreads(String args) throws SQLException;
	
	/**
	 * ��ȡ����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getCacheRequestNum(String args) throws SQLException;
	
	/**
	 * ��ȡ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getCacheVisitRate(String args) throws SQLException;
	
	/**
	 * ��ȡ�����ļ�������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDataFileRequestNum(String args) throws SQLException;
	
	
	/**
	 * ��ȡ��ɨ�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getTableScanRate(String args) throws SQLException;
	
	/**
	 * ��ȡֱ����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDirectLockTime(String args) throws SQLException;
	/**
	 * ��ȡ���������С
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getKeyCacheSize(String args) throws SQLException;
	
	/**
	 * ��ȡ��ǰ�򿪱������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOpenTableNum(String args) throws SQLException;
	
	/**
	 * ��ȡ��ǰ���ļ�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOpenFileNum(String args) throws SQLException;
	
	/**
	 * ��ȡ����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	
	public String getOpenFlowNum(String args) throws SQLException;
	
	/**
	 * ��ȡ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOpenConnections(String args) throws SQLException;
	/**
	 * ��ȡ��˯���߳���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getWakeupThreads(String args) throws SQLException;
	
	/**
	 * ��ȡ���ȴ�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getLockWaitTime(String args) throws SQLException;
	
	/**
	 * ��ȡ��ѯ�����С
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getQueryCacheSize(String args) throws SQLException;
	
	/**
	 * ��ȡ���ݿ�洢����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getStorageEngine(String args) throws SQLException;
	/**
	 * ��ȡ���ݿ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDatabaseServiceProcessNum(String args) throws SQLException;
	
	/**
	 * ��ȡ��ѯ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getQueryRequestNum(String args) throws SQLException;
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
