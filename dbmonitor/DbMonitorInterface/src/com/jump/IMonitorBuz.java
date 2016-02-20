package com.jump;

import java.sql.SQLException;

public interface IMonitorBuz extends IDB{

	/**
	 * 获取cpu利用率
	 * @param args 后期扩展参数字段，暂时不用关注
	 * @return 返回值为json格式      "[{"数据库cpu利用率":"10%"}]
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getCpu(String args) throws SQLException;
	
	/**
	 * 获取内存利用率
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getMemery(String args) throws SQLException;
	
	/**
	 * 获取会话数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getSession(String args) throws SQLException;
	
	/**
	 * 获取用户连接数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getUserConnections(String args) throws SQLException;
	/**
	 * 获取数据库版本
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDatabaseVersion(String args) throws SQLException;
	/**
	 * 获取数据库个数
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	public String getDatabaseNum(String args) throws SQLException;
	
	/**
	 * 获取默认字符集
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getCharacters(String args) throws SQLException;
	
	/**
	 * 获取持续运行时间
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getUpTime(String args) throws SQLException;
	
	/**
	 * 获取数据目录
	 * @param args
	 * @return
	 * 2014-12-10
	 * Administrator
	 * String
	 */
	
	public String getDataFileDir(String args) throws SQLException;
}
