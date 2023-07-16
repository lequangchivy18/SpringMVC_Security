package com.springsecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springsecurity.dto.UserDto;
import com.springsecurity.entity.User;
import com.springsecurity.entity.UserAuthority;
import com.springsecurity.entity.UserAuthorityId;
import com.springsecurity.service.UserAuthorityService;
import com.springsecurity.service.UserService;
import com.springsecurity.validate.UserValidator;

@Controller
public class SignUpController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAuthorityService userAuthorityService;
	
	@Autowired
	private UserValidator userValidator;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/signup")
	public String showSignUpForm(Model model) {
		model.addAttribute("UserDto", new UserDto());
		return "signup";
	}

	@PostMapping("/signup")
	public String processSignUpForm(@ModelAttribute(name = "UserDto") @Valid UserDto userDto,
			BindingResult bindingResult) {
		
		userValidator.validate(userDto, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "signup";
		}

		String encodedPassword = passwordEncoder.encode(userDto.getPassword());

		userDto.setPassword(encodedPassword);
		User user = new User(userDto.getUsername(), userDto.getPassword(), null);

		UserAuthorityId userAuthorityId = new UserAuthorityId(userDto.getUsername(), (long) 2);
		UserAuthority userAuthority = new UserAuthority(userAuthorityId);
		
		userService.save(user);
		userAuthorityService.save(userAuthority, userAuthorityId);

		return "redirect:/login?success";
	}
}
