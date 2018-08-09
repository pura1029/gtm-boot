package com.vmware.boot.producer.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ErrorResponse {

	private int code;
	private String desc;
	public ErrorResponse() {
		super();
		this.code = 400;
		this.desc = "Student data not found!";
	}
}
