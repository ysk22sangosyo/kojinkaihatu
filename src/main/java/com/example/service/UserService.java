package com.example.service;

import com.example.enitity.User;

public interface UserService {

public User login(String userId,String password);	
public void insert(User user);
public void update(User user);
}
