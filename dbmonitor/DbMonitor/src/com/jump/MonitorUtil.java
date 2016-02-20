package com.jump;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import net.sf.json.JSONArray;
/**
 * json操作类
 * @author Administrator
 *
 */
public class MonitorUtil {

	/**
	 * 转换json格式数据
	 * @param object
	 * @return
	 * 2014-12-13
	 * Administrator
	 * String
	 * @throws IOException 
	 */
	public static void toJson(Object object,String fileName){
		try {
			Object output = JSONArray.fromObject(object);
//		System.out.println(output.toString());
			File file = new File(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			bufferedWriter.write(output.toString());
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String toDate(String time){
		double last_run_seconds = Double.parseDouble(time);
		int days = (int) (last_run_seconds / (60 * 60 * 24));
		int hours =(int)((last_run_seconds % (60 * 60 * 24)) / (60 * 60));
		int minites = (int)(((last_run_seconds % (60 * 60 * 24)) % (60 * 60)) / 60);
		int seconds = (int)(((last_run_seconds % (60 * 60 * 24)) % (60 * 60)) % 60);
		return days + "天" + hours + "小时" + minites + "分钟" + seconds + "秒";
	}
	//获取指定时间串的时间戳
	public static long ParseDate(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(date).getTime();
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	/**
	 * 测试ip连通性
	 * @param ip
	 * @return
	 * @throws IOException
	 * 2014-12-18
	 * Administrator
	 * boolean
	 */
	public static boolean isReachAble(String ip) throws IOException{
		InetAddress address = InetAddress.getByName(ip);//ping this IP 
	      if(address.isReachable(5000)){ 
	          return true; 
	      }else{ 
	         return false;
	      } 
	}
}
