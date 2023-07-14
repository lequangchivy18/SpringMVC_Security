package com.springsecurity.security;

import org.springframework.security.core.GrantedAuthority;

import com.springsecurity.entity.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Authority authority;

	public SecurityAuthority(Authority authority) {
		super();
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority.getAuthorityName().toString();
	}
}
