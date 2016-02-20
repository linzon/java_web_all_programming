package com.jump;

public class DatabaseBasicInfo {

	private String ip;
	private String port;
	private String protocol;
	private String version;
	private String characters;
	private String dbversion;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getCharacters() {
		return characters;
	}
	public void setCharacters(String characters) {
		this.characters = characters;
	}
	public String getDbversion() {
		return dbversion;
	}
	public void setDbversion(String dbversion) {
		this.dbversion = dbversion;
	}
	
}
