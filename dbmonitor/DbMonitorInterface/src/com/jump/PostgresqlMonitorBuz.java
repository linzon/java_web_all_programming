package com.jump;

import java.sql.SQLException;

public interface PostgresqlMonitorBuz  extends IMonitorBuz{
	/**
	 * ��ȡӲ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDiskRequest(String args) throws SQLException;
	
	/**
	 * ��ȡ���������̿�������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getBufferRegionDiskPieceRequest(String args) throws SQLException;
	
	
	/**
	 * ��ȡ�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getSharePool(String args) throws SQLException;
	
	/**
	 * ��ȡ����ҳ��С
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getSortPageSize(String args) throws SQLException;
	
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
	 * ��ȡ�鵵ģʽ
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getFileMode(String args) throws SQLException;
	
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
	public String getMaxConnections(String args) throws SQLException ;
}
