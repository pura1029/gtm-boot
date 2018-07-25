package com.vmware.gtmboot.service;

public class ErrorResponse {

	private int code;
	private String desc;
	public ErrorResponse() {
		super();
		this.code = 400;
		this.desc = "Student data not found!";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
