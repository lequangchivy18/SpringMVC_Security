package com.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springsecurity.entity.User;

public interface UserService extends UserDetailsService {
	
	public void save(User user);
	
}
