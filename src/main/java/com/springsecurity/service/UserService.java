package com.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springsecurity.entity.User;

public interface UserService extends UserDetailsService {
	
	void save(User user);
	
	boolean existById(String id);
	
	void deleteById(String id);
	
	void changePasswors(String username, String newPassword);
	
}
