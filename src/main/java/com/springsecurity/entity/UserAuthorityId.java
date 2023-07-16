package com.springsecurity.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class UserAuthorityId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_id;
	private Long authority_id;

	public UserAuthorityId() {
		super();
	}

	public UserAuthorityId(String username_id, Long authority_id) {
		super();
		this.user_id = username_id;
		this.authority_id = authority_id;
	}

	public String getUsername_id() {
		return user_id;
	}

	public void setUsername_id(String username_id) {
		this.user_id = username_id;
	}

	public Long getAuthority_id() {
		return authority_id;
	}

	public void setAuthority_id(Long authority_id) {
		this.authority_id = authority_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authority_id, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAuthorityId other = (UserAuthorityId) obj;
		return Objects.equals(authority_id, other.authority_id) && Objects.equals(user_id, other.user_id);
	}

}
