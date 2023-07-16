package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.UserAuthority;
import com.springsecurity.entity.UserAuthorityId;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, UserAuthorityId> {
	
}
