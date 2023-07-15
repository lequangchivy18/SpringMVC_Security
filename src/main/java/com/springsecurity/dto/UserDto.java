package com.springsecurity.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {
	@NotBlank(message = "Hãy nhập username")
	private String username;
	@NotBlank(message = "Hãy nhập password")
	private String password;

	public UserDto() {
		super();
	}

	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
