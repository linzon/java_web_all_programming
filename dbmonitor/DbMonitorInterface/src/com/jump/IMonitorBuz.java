package com.jump;

import java.sql.SQLException;

public interface IMonitorBuz extends IDB{

	/**
	 * ��ȡcpu������
	 * @param args ������չ�����ֶΣ���ʱ���ù�ע
	 * @return ����ֵΪjson��ʽ      "[{"���ݿ�cpu������":"10%"}]
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCpu(String args) throws SQLException;
	
	/**
	 * ��ȡ�ڴ�������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getMemery(String args) throws SQLException;
	
	/**
	 * ��ȡ�Ự��
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getSession(String args) throws SQLException;
	
	/**
	 * ��ȡ�û�������
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getUserConnections(String args) throws SQLException;
	/**
	 * ��ȡ���ݿ�汾
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDatabaseVersion(String args) throws SQLException;
	/**
	 * ��ȡ���ݿ����
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDatabaseNum(String args) throws SQLException;
	
	/**
	 * ��ȡĬ���ַ���
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getCharacters(String args) throws SQLException;
	
	/**
	 * ��ȡ��������ʱ��
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getUpTime(String args) throws SQLException;
	
	/**
	 * ��ȡ����Ŀ¼
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDataFileDir(String args) throws SQLException;
}
