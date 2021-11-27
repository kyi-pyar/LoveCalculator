package com.springmvc.calculator.api;

import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.springmvc.calculator.Validator.AgeValidator;

public class LoverUser {
	int id;
	Love love;
	
	@NotEmpty(message = "email should not be empty.")
	@Email(message = "Invalid email format")
	String email;
	/*
	 * @AgeValidator(lower=10, upper=40, message="Age between 10 to 40") int age;
	 */
	String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Love getLove() {
		return love;
	}
	public void setLove(Love love) {
		this.love = love;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoverUser [id=" + id + ", love=" + love + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
