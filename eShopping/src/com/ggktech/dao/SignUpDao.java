package com.ggktech.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ggktech.model.SignUpModel;

@Repository
public class SignUpDao {
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

	public boolean signUp(SignUpModel signUpModel , Integer userRole) {
		String sql = "insert into userDetails (fName , lname , mobile , email , password, roleId) values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { signUpModel.getfName(), signUpModel.getlName(),
						signUpModel.getMobile(), signUpModel.getEmail(),
						signUpModel.getPassword() ,userRole});
		return true;
	}

}
