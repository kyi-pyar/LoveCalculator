package com.springmvc.calculator.api;

import javax.validation.constraints.NotEmpty;

public class Love {
	
	@NotEmpty(message = "user name should not be empty.")
	String user_name;
	@NotEmpty(message = "cursh name should not be empty.")
	String crush_name;
	String result;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCrush_name() {
		return crush_name;
	}
	public void setCrush_name(String crush_name) {
		this.crush_name = crush_name;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Love [user_name=" + user_name + ", crush_name=" + crush_name + ", result=" + result + "]";
	}
	
	

}
