package com.springsecurity.dto;

import javax.validation.constraints.NotBlank;

public class ChangePasswordDto {
	@NotBlank(message = "Hãy nhập password")
	private String oldPassword;
	
	@NotBlank(message = "Hãy nhập password")
	private String newPassword;
	
	@NotBlank(message = "Hãy nhập password")
	private String confirmPassword;

	public ChangePasswordDto() {
		super();
	}

	public ChangePasswordDto(String oldPassword, String newPassword, String confirmPassword) {
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
