package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.enitity.User;

@Repository
public class PgUserDao implements UserDao{
private static final String SELECT_ID_PASS = "SELECT * FROM users WHERE user_id=:userId AND password=:password";
//private static final String SELECT_ID_PASS = "SELECT * FROM users as u JOIN characters as c ON u.user_id=c.user_id WHERE c.user_id=:userId AND password=:password";
private static final String INSERT ="INSERT INTO users(user_id,password,name) VALUES(:userId,:password,:name)";
private static final String UPDATE ="UPDATE users SET user_id =:userId , password =:password, name =:name,profile =:profile,img =:img WHERE user_id =:userId";
@Autowired
private NamedParameterJdbcTemplate jdbcTemplate;

//ログイン
@Override
public User login(String userId,String password) {
	String sql = SELECT_ID_PASS;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("userId",userId);
	param.addValue("password",password);
	 
	List<User> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));
	return resultList.isEmpty() ? null :resultList.get(0);
}
//ユーザ登録
@Override
public void insert(User user){
	String sql = INSERT;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("userId", user.getUserId());
	param.addValue("password", user.getPassword());
	param.addValue("name", user.getName());



	 
    jdbcTemplate.update(sql, param);
	
	
}
//更新
@Override
public void update(User user) {
	String sql =UPDATE;
	MapSqlParameterSource param = new MapSqlParameterSource();
	param.addValue("userId", user.getUserId());
	param.addValue("password", user.getPassword());
	param.addValue("name", user.getName());
	param.addValue("profile", user.getProfile());
	param.addValue("img", user.getImg());
	
	 jdbcTemplate.update(sql, param);
}
}
