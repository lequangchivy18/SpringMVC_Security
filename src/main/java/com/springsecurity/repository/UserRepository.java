package com.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByUsername(String username);

	@Modifying
	@Query("UPDATE User u SET u.password = :newPassword WHERE u.username = :username")
	void changePassword(@Param("username") String username, @Param("newPassword") String newPassword);
	
	
}
