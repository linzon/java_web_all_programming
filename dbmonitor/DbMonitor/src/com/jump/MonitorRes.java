package com.jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class MonitorRes {

	private String indexName;
	private String indexValue;
	private String indexTime;
	private String indexValueUnit;
	private String indexUnit;
	private String history_monitor;
	private String indexId;
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getIndexValue() {
		return indexValue;
	}
	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue;
	}
	public String getIndexTime() {
		return indexTime;
	}
	public void setIndexTime(String indexTime) {
		this.indexTime = indexTime;
	}
	public String getIndexValueUnit() {
		return indexValueUnit;
	}
	public void setIndexValueUnit(String indexValueUnit) {
		this.indexValueUnit = indexValueUnit;
	}
	public String getIndexUnit() {
		return indexUnit;
	}
	public void setIndexUnit(String indexUnit) {
		this.indexUnit = indexUnit;
	}
	public String getHistory_monitor() {
		return history_monitor;
	}
	public void setHistory_monitor(String historyMonitor) {
		history_monitor = historyMonitor;
	}
	public String getIndexId() {
		return indexId;
	}
	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}
	
	public static void main(String[] args) {
	}
	private static String convert(double value){
		long l1 = Math.round(value*1000); //四舍五入
		double ret = l1/1000.0; //注意:使用 100.0 而不是 100
		return ret+"";
	}
}
