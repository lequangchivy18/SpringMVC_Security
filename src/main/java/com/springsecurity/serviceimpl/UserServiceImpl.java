package com.springsecurity.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.User;
import com.springsecurity.repository.UserRepository;
import com.springsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) repository.findAll();
	}

}
