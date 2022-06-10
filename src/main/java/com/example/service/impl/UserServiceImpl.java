package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.enitity.User;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserDao userDao;

//ログイン
public User login(String userId,String password) {
	return userDao.login(userId, password);
}
/**
 * 登録
 */

public void insert(User user) {
    userDao.insert(user);
}
//更新
public void update(User user) {
	userDao.update(user);
}
}
