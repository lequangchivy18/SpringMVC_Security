package com.springsecurity.service;

import java.util.List;

import com.springsecurity.entity.User;

public interface UserService {

	public List<User> findAll();
}
