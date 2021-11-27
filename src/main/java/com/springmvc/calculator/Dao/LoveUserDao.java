package com.springmvc.calculator.Dao;

import java.util.List;

import com.springmvc.calculator.api.Love;
import com.springmvc.calculator.api.LoverUser;

public interface LoveUserDao {
	public void save(LoverUser user);
	public LoverUser get(String email);
	public LoverUser loginCheck(String name, String pwd);

}
