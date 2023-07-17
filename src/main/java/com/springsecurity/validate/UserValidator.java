package com.springsecurity.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springsecurity.dto.UserDto;
import com.springsecurity.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UserDto.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDto userDto = (UserDto) target;

		
		if (userService.existById(userDto.getUsername())) {
			errors.rejectValue("username", null, "Username đã tồn tại");
		}
	}

}
