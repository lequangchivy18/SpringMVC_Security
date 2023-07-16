package com.springsecurity.service;

import com.springsecurity.entity.UserAuthority;
import com.springsecurity.entity.UserAuthorityId;

public interface UserAuthorityService {

	public void save(UserAuthority authority, UserAuthorityId authorityId);
}
