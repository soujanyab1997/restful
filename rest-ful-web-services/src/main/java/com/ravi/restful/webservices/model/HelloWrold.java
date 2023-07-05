package com.ravi.restful.webservices.model;

public class HelloWrold {
	private String message;

	
	public HelloWrold(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWrold [message=" + message + "]";
	}
	
}
