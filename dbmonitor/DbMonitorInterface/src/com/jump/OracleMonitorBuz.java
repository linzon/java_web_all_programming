package com.jump;

import java.sql.SQLException;

public interface OracleMonitorBuz  extends IMonitorBuz{

	/**
	 * ��ȡ�����ֵ仺��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getWordbookCacheHitRate(String args) throws SQLException;
	
	/**
	 * ��ȡ�ڴ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getMemerySortRate(String args) throws SQLException;
	
	/**
	 * ��ȡÿ���ӵ�¼�Ự��
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLoginPerMinute(String args) throws SQLException;
	
	/**
	 * ��ȡ��ǰ�򿪵��α���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getOpenCusorNum(String args) throws SQLException;
	
	/**
	 * ��ȡ�����п�
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getMaxFreePiece(String args) throws SQLException;
	
	/**
	 * ��ȡ�Ự����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getSessionFreeConnnections(String args) throws SQLException;
	
	/**
	 * ��ȡ��ռ����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getTableSpaceNum(String args) throws SQLException;
	
	
	/**
	 * ��ȡ�����ļ�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDataFileNum(String args) throws SQLException;
	
	/**
	 * ��ȡjava��
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getJavaPool(String args) throws SQLException;
	
	/**
	 * ��ȡ��־�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getLogCachePool(String args) throws SQLException;
	
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
	 * ��ȡ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getLockNum(String args) throws SQLException;
	
	/**
	 * ��ȡPGA
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPGA(String args) throws SQLException;
	
	/**
	 * ��ȡ�����ڴ�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getPhysicsMemery(String args) throws SQLException;
	
	/**
	 * ��ȡ�����������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDiskSortTime(String args) throws SQLException;
	
	/**
	 * ��ȡ�ڴ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getMemerySortTime(String args) throws SQLException;
	

	
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
	 * ��ȡ�鵵ģʽ
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getFileMode(String args) throws SQLException;
	
	/**
	 * ��ȡ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBlockLockNum(String args) throws SQLException;
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
	 * ��ȡÿ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getBusinessNum(String args) throws SQLException;
	
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
	 * ��ȡ���ݿ���������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDatabaseServiceProcessNum(String args) throws SQLException;
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
