package com.dev.beans;

public class Response
{
	private int statusCode;
	private String message;
	private String description;
//	private StudentInfo info;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public StudentInfo getInfo() {
//		return info;
//	}
//	public void setInfo(StudentInfo info) {
//		this.info = info;
//	}
	

}
