package com.jump;

import java.sql.SQLException;

public interface DB2MonitorBuz extends IMonitorBuz{
	/**
	 * ��ȡԶ��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getRemoteConnnections(String args) throws SQLException;
	
	/**
	 * ��ȡ������������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getTryConnections(String args) throws SQLException;
	
	/**
	 * ��ȡ������������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getLocalConnections(String args) throws SQLException;
	
	/**
	 * ��ȡ������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getAgencyConnections(String args) throws SQLException;
	
	/**
	 * ��ȡ�������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getActiveAgencyConnections(String args) throws SQLException;
	
	/**
	 * ��ȡ���д�����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getFreeAgencyConnections(String args) throws SQLException;
	
	/**
	 * ��ȡ��־������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getLogUseRate(String args) throws SQLException;
	
	/**
	 * ��ȡIO������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getIOReadTime(String args) throws SQLException;
	
	/**
	 * ��ȡIOд����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getIOWriteTime(String args) throws SQLException;
	
	/**
	 * ��ȡTCP/IP��������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getTCPIPService(String args) throws SQLException;
	
	/**
	 * ��ȡ���ݿ���־��С
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDatabaseLogSize(String args) throws SQLException;
}
