package com.springsecurity.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_authority")
public class UserAuthority {

	@EmbeddedId
	private UserAuthorityId authorityId;

	public UserAuthority() {
		super();
	}

	public UserAuthorityId getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(UserAuthorityId authorityId) {
		this.authorityId = authorityId;
	}

}
