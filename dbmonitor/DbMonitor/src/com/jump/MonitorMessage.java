package com.jump;

public class MonitorMessage {

	private int errorCode;
	private boolean success;
	private String message;
	private boolean failure;
	
	public MonitorMessage() {
		
	}
	
	public MonitorMessage(int errorCode, boolean success, String message) {
		super();
		this.errorCode = errorCode;
		this.success = success;
		this.message = message;
	}
	public MonitorMessage(int errorCode, boolean success, String message,boolean failure) {
		super();
		this.errorCode = errorCode;
		this.success = success;
		this.message = message;
		this.failure=failure;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isFailure() {
		return failure;
	}

	public void setFailure(boolean failure) {
		this.failure = failure;
	}

}
