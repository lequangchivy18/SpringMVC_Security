package com.springsecurity.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.UserAuthority;
import com.springsecurity.entity.UserAuthorityId;
import com.springsecurity.repository.UserAuthorityRepository;
import com.springsecurity.service.UserAuthorityService;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService{

	@Autowired
	private UserAuthorityRepository authorityRepository;
	
	@Override
	public void save(UserAuthority authority, UserAuthorityId userAuthorityId) {
		authorityRepository.save(authority);
		userAuthorityId.setAuthority_id(authority.getAuthorityId().getAuthority_id());
	}
	
}
