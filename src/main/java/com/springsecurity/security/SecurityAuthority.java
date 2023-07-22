package com.springsecurity.security;

import org.springframework.security.core.GrantedAuthority;

import com.springsecurity.entity.Authority;


public class SecurityAuthority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Authority authority;

	public SecurityAuthority(Authority authority) {
		super();
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority.getAuthorityName().toString();
	}

	@Override
	public String toString() {
		return "SecurityAuthority [authority=" + authority + ", getAuthority()=" + getAuthority() + "]";
	}
	
	
}
