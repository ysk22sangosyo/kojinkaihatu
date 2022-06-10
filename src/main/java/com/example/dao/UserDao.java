package com.example.dao;

import com.example.enitity.User;

//userテーブル用DAO
public interface UserDao {

 
	public User login(String userId,String password);
	public void insert(User user);
	public void update(User user);
}
