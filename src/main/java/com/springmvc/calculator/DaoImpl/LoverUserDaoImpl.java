package com.springmvc.calculator.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.calculator.Dao.LoveUserDao;
import com.springmvc.calculator.api.Love;
import com.springmvc.calculator.api.LoverUser;

public class LoverUserDaoImpl implements LoveUserDao{
	
	JdbcTemplate jdbctemplate;
	
	public LoverUserDaoImpl(DataSource datasource) {
		jdbctemplate=new JdbcTemplate(datasource);
	}


	@Override
	public void save(LoverUser user) {
		String sql="INSERT INTO `love`( `user_name`, `crush_name`, `result`, `email`, `PASSWORD`) VALUES (?,?,?,?,?)";
		jdbctemplate.update(sql, user.getLove().getUser_name(), user.getLove().getCrush_name(), user.getLove().getResult(), user.getEmail(), user.getPassword());
		System.out.println("saved record in love table.");
	}


	@Override
	public LoverUser get(String email) {
		String sql="select * from love where email=?";
	return jdbctemplate.queryForObject(sql, new Object[] {email}, new RowMapper<LoverUser>() {
			@Override
			public LoverUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoverUser user=new LoverUser();
				Love love=new Love();
				love.setUser_name(rs.getString(2));
				love.setCrush_name(rs.getString(3));
				love.setResult(rs.getString(4));
				user.setId(rs.getInt(1));
				user.setLove(love);
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				return user;
			}
		});		
	}


	@Override
	public LoverUser loginCheck(String name, String pwd) {
		String sql="select * from love where user_name=? and password=?";
		return jdbctemplate.queryForObject(sql, new Object[] {name, pwd}, new RowMapper<LoverUser>() {

			@Override
			public LoverUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoverUser user=new LoverUser();
				Love love=new Love();
				love.setUser_name(rs.getString(2));
				love.setCrush_name(rs.getString(3));
				love.setResult(rs.getString(4));
				user.setId(rs.getInt(1));
				user.setLove(love);
				user.setEmail(rs.getString(5));
				user.setPassword(rs.getString(6));
				return user;
			}
		});
		
	}

}
