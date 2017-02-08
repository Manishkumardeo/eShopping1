package com.ggktech.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ggktech.model.Common;

@Repository
public class AuthenticationDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean login(String email, String password) {
		//System.out.println("inside Login1");
		
		List<Common> common = jdbcTemplate.query(
				"select * from userDetails where Email=? and password=?",
				new Object[] { email, password }, new BeanPropertyRowMapper(
						Common.class));

		if (common.size() != 0)
			return true;
		else
			return false;
	}


		

	public int roleId(String email, String password) {
		//System.out.println("Inside RoleId");
		int roleId = jdbcTemplate.queryForObject(
				"select roleId from userDetails where email=? and password=?",
				new Object[] { email, password }, Integer.class);
		return roleId;
	}

	public int userId(String email, String password) {
		System.out.println("Inside UserId");
		int userId = jdbcTemplate.queryForObject(
				"select userId from userDetails where email=? and password=?",
				new Object[] { email, password }, Integer.class);
		return userId;
	}

}
