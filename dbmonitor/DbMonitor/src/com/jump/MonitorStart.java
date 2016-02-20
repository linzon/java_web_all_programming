package com.jump;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class MonitorStart{
	private static Connection dbConnection = null;
	
	private static String DB_CLASS = "com.jump.MysqlMonitor";
	private static String targets = "";
	private static String filename = "";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final int ERROR_CODE = 9999;
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/jdba_conf";
	static{
		try {
			Class.forName(DB_DRIVER);
			dbConnection = DriverManager.getConnection(DB_URL, "root","jump1999");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/**
		 * 48 10.0.9.90 3306 root jump1999
		 */
		
		try {
			DatabaseBasicInfo databaseBasicInfo = new DatabaseBasicInfo();
			String databaseUrl = "";
			//监控id
			int monitorId = Integer.parseInt(args[0]);
			
			//监控指标范围,隔开
			targets = args[1];
			String monitorTargets = "";
			if("0".equals(targets)){
				monitorTargets = args[2];
				filename = args[3];
			}else{
				monitorTargets = args[1];
				filename = args[2];
			}
			//协议id
			int protocolID = 35;
			//数据库服务器ip
			String hostIp = "";
			//端口
			String port = "";
			//用户名
			String userName = "";
			//密码
			String passWord = "";
			String dbname = "";
			String service = "";
			String version = "";
			ResultSet confRes = DBUtil.executeQuery("select protocol,ip_addr,port,username,password,service,dbname,version from conf_monitor where id="+monitorId, dbConnection);
			while(confRes.next()){
				protocolID = confRes.getInt("protocol");
				hostIp = confRes.getString("ip_addr");
				port = confRes.getString("port");
				userName = confRes.getString("username");
				passWord = confRes.getString("password");
				dbname = confRes.getString("dbname");
				service = confRes.getString("service");
				version = confRes.getString("version");
				databaseBasicInfo.setIp(hostIp);
				databaseBasicInfo.setPort(port);
				databaseBasicInfo.setDbversion(version);
			}
			// 测试地址连通性
			boolean isConnectionSuccess = MonitorUtil.isReachAble(hostIp);
			if(!isConnectionSuccess){
				MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据库连接超时，请稍后重试。");
				MonitorUtil.toJson(monitorMessage,filename);
				return;
			}
			switch (protocolID) {
				//ms-sql
				case 35:
					if("MSSQL2000".equals(version)){
						DB_CLASS = "com.jump.MsSql2000Monitor";
						MsSql2000Monitor msSql2000Monitor = new MsSql2000Monitor();
						msSql2000Monitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord);
						doMethod(msSql2000Monitor,monitorTargets,databaseBasicInfo);
						msSql2000Monitor.destroy();
					}else{
						DB_CLASS = "com.jump.MsSqlMonitor";
						MsSqlMonitor msSqlMonitor = new MsSqlMonitor();
						msSqlMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord);
						doMethod(msSqlMonitor,monitorTargets,databaseBasicInfo);
						msSqlMonitor.destroy();
					}
					break;
				//oracle
				case 36:
					DB_CLASS = "com.jump.OracleMonitor";
					OracleMonitor oracleMonitor = new OracleMonitor();
					oracleMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord +"&dbname=" + dbname);
					doMethod(oracleMonitor,monitorTargets,databaseBasicInfo);
					oracleMonitor.destroy();
					break;
				//db2
				case 39:
					DB_CLASS = "com.jump.DB2Monitor";
					DB2Monitor db2Monitor = new DB2Monitor();
					db2Monitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord +"&dbname=" + dbname);
					doMethod(db2Monitor,monitorTargets,databaseBasicInfo);
					db2Monitor.destroy();
					break;
				//informix
				case 40:
					DB_CLASS = "com.jump.InformixMonitor";
					InformixMonitor informixMonitor = new InformixMonitor();
					informixMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord + "&dbname=" + dbname+ "&service=" + service);
					doMethod(informixMonitor,monitorTargets,databaseBasicInfo);
					informixMonitor.destroy();
					break;
				//mysql
				case 48:
					DB_CLASS = "com.jump.MysqlMonitor";
					MysqlMonitor mysqlMonitor = new MysqlMonitor();
					mysqlMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord);
					doMethod(mysqlMonitor,monitorTargets,databaseBasicInfo);
					mysqlMonitor.destroy();
					break;
				//postgresql
				case 49:
					DB_CLASS = "com.jump.PostgresqlMonitor";
					PostgresqlMonitor postgresqlMonitor = new PostgresqlMonitor();
					postgresqlMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord);
					doMethod(postgresqlMonitor,monitorTargets,databaseBasicInfo);
					postgresqlMonitor.destroy();
					break;
					//postgresql
				case 104:
					DB_CLASS = "com.jump.HighgoMonitor";
					HighgoMonitor highgoMonitor = new HighgoMonitor();
					highgoMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord+"&dbname=" + dbname);
					doMethod(highgoMonitor,monitorTargets,databaseBasicInfo);
					highgoMonitor.destroy();
					break;
				case 58:
					DB_CLASS = "com.jump.GbaseMonitor";
					GbaseMonitor gbaseMonitor = new GbaseMonitor();
					gbaseMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord+"&dbname=" + dbname);
					doMethod(gbaseMonitor,monitorTargets,databaseBasicInfo);
					gbaseMonitor.destroy();
					break;
				case 53:
					DB_CLASS = "com.jump.DmMonitor";
					DmMonitor dmMonitor = new DmMonitor();
					dmMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord+"&dbname=" + dbname);
					doMethod(dmMonitor,monitorTargets,databaseBasicInfo);
					dmMonitor.destroy();
					break;
				case 101:
					DB_CLASS = "com.jump.OscarMonitor";
					OscarMonitor oscarMonitor = new OscarMonitor();
					oscarMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord+"&dbname=" + dbname);
					doMethod(oscarMonitor,monitorTargets,databaseBasicInfo);
					oscarMonitor.destroy();
					break;
				case 102:
					DB_CLASS = "com.jump.MaxdbMonitor";
					MaxdbMonitor maxdbMonitor = new MaxdbMonitor();
					maxdbMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord+"&dbname=" + dbname);
					doMethod(maxdbMonitor,monitorTargets,databaseBasicInfo);
					maxdbMonitor.destroy();
					break;
				case 52:
					DB_CLASS = "com.jump.KingbaseMonitor";
					KingbaseMonitor kingbaseMonitor = new KingbaseMonitor();
					kingbaseMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord+"&dbname=" + dbname);
					doMethod(kingbaseMonitor,monitorTargets,databaseBasicInfo);
					kingbaseMonitor.destroy();
					break;
				case 57:
					DB_CLASS = "com.jump.SybaseMonitor";
					SybaseMonitor sybaseMonitor = new SybaseMonitor();
					sybaseMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord+"&dbname=" + dbname);
					doMethod(sybaseMonitor,monitorTargets,databaseBasicInfo);
					sybaseMonitor.destroy();
					break;
//				case 50:
//					DB_CLASS = "com.jump.TeradataMonitor";
//					TeradataMonitor teradataMonitor = new TeradataMonitor();
//					teradataMonitor.init("host="+hostIp + "&port="+ port +"&username="+ userName +"&password=" + passWord+"&dbname=" + dbname);
//					doMethod(teradataMonitor,monitorTargets,databaseBasicInfo);
//					teradataMonitor.destroy();
//					break;
				default:
					break;
			}
			dbConnection.close();
		} catch (NumberFormatException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据采集异常，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		} catch (SQLException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据库连接异常，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		} catch (ClassNotFoundException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据库连接异常，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		} catch (IllegalArgumentException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据采集异常，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		} catch (IllegalAccessException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据采集异常，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		} catch (InvocationTargetException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据采集异常，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		} catch (SecurityException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据采集异常，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		} catch (NoSuchMethodException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据采集异常，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		} catch (IOException e) {
			MonitorMessage monitorMessage = new MonitorMessage(ERROR_CODE, false, "数据库连接超时，请稍后重试。");
			MonitorUtil.toJson(monitorMessage,filename);
		}
	}
	
	
	/**
	 * 执行调用监控参数方法
	 * @param object
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * 2014-12-13
	 * Administrator
	 * void
	 */
	private static void doMethod(Object object,String region,DatabaseBasicInfo basicInfo) throws SQLException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		String sql = "";
		String res[] = region.split(",");
		if("0".equals(targets)){
			sql = "select id,name_intro,name,unit,history_monitor,protocol_name from conf_monitor_index where is_monitor!=0 and id="+res[0]+" or id="+res[1]+" order by monitor_order";
		}else{
			if(res.length>1){
				sql = "select id,name_intro,name,unit,history_monitor,protocol_name from conf_monitor_index where is_monitor!=0 and id>="+res[0]+" and id<="+res[1]+" order by monitor_order";
			}else{
				sql = "select id,name_intro,name,unit,history_monitor,protocol_name from conf_monitor_index where is_monitor!=0 and id="+res[0]+" order by monitor_order";
			}
			
		}
		ResultSet resultSet = DBUtil.executeQuery(sql, dbConnection);
		List<MonitorRes> monitorRes = new ArrayList<MonitorRes>();
		while(resultSet.next()){
			if("0".equals(targets)){
				String name = resultSet.getString("name_intro");
				Class cls = Class.forName(DB_CLASS); 
				Class partypes[] = new Class[1]; 
				partypes[0] = String.class;
				Method meth = cls.getMethod(name, partypes); 
				Object arglist[] = new Object[1]; 
				arglist[0] = new String(""); 
				String retobj = null;
				try {
					retobj = (String) meth.invoke(object, arglist);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				if(null!=retobj && !"".equals(retobj)){
					if(name.equals("getCharacters")){
						basicInfo.setCharacters(retobj);
					}
					if(name.equals("getDatabaseVersion")){
						basicInfo.setVersion(retobj);
					}
				}
				basicInfo.setProtocol(resultSet.getString("protocol_name"));
				
			}else{
				MonitorRes monitorRes2 = new MonitorRes();
				String name = resultSet.getString("name");
				monitorRes2.setIndexId(resultSet.getString("id"));
				String monitorFun = resultSet.getString("name_intro");
				monitorRes2.setIndexName(name);
				monitorRes2.setIndexTime(System.currentTimeMillis()+"");
				monitorRes2.setHistory_monitor(resultSet.getString("history_monitor"));
				String unit = "";
				if(null!=resultSet.getString("unit")){
					unit = resultSet.getString("unit");
				}
				Class cls = Class.forName(DB_CLASS); 
				Class partypes[] = new Class[1]; 
				partypes[0] = String.class;
				Method meth = cls.getMethod(monitorFun, partypes); 
				Object arglist[] = new Object[1]; 
				arglist[0] = new String(""); 
				String retobj = null;
				try {
					retobj = (String) meth.invoke(object, arglist);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				if(null!=retobj && !"".equals(retobj)){
					if(unit.indexOf("%")!=-1){
						retobj = convert(Double.parseDouble(retobj));
					}
					if(unit.indexOf("/秒")!=-1){
						retobj = substringNumber(retobj);
					}
					if(unit.indexOf("MB")!=-1){
						if(retobj.indexOf("KB")!=-1){
							retobj = convert(Double.parseDouble(retobj.substring(0, retobj.indexOf("KB")))/1024);
						}else{
							retobj = convert(Double.parseDouble(retobj)/1024/1024);
						}
						
					}
					monitorRes2.setIndexValue(retobj);
					monitorRes2.setIndexValueUnit(retobj + unit);
					monitorRes2.setIndexUnit(unit);
					monitorRes.add(monitorRes2);
				}
				
				//DBUtil.execute("insert into nm_monitor_database_history_mysql(monitor_index,monitor_value,monitor_time,dev_ip) values("+index+",'"+retobj.toString()+"',"+System.currentTimeMillis()+",'"+hostIp+"')", connection);
			//[{"name":"cpu利用率","value":"100","time":"2014.12.23 12:23:10"},{"key":"内存利用率","value":"90","time":"2014.12.23 12:23:10"}]
			}
			
		}
		if("0".equals(targets)){
			MonitorUtil.toJson(basicInfo,filename);
		}else{
			MonitorUtil.toJson(monitorRes,filename);
		}
		
	}
	private static String convert(double value){
		long l1 = Math.round(value*100); //四舍五入
		double ret = l1/100.0; //注意:使用 100.0 而不是 100
		return ret+"";
	}
	private static String substringNumber(String value){
		if(value.length()>5){
			return value.substring(0, value.indexOf(".")+3);
		}else{
			return value;
		}
		
	}
}
