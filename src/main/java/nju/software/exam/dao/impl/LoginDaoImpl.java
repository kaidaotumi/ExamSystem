package nju.software.exam.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nju.software.exam.dao.LoginDao;
import nju.software.exam.entity.User;
@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public User isValid(String email, String password) {
		User result = new User();
		String sql = "select * from user where email = ?";
		List<User> list = jdbcTemplate.query(sql, new Object[]{email},new BeanPropertyRowMapper(User.class));
		if (list == null) {
			result = null;//账号或密码不正确
		}else{
			result = list.get(0);	 
		}
		return result;
	}

}
