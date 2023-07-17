package com.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.springsecurity.entity.Authority;
import com.springsecurity.entity.User;
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

		// Cách 1
		List<Authority> authorities = new ArrayList<>();

		Authority authority1 = new Authority((long) 2, "USER");

		authorities.add(authority1);

		userDto.setPassword(encodedPassword);
		User user = new User(userDto.getUsername(), userDto.getPassword(), authorities);

		// Cách 2
//		UserAuthorityId userAuthorityId = new UserAuthorityId(userDto.getUsername(), (long) 2);
//		UserAuthority userAuthority = new UserAuthority(userAuthorityId);	
//		userAuthorityService.save(userAuthority, userAuthorityId);

		userService.save(user);

		return "redirect:/login";
	}
}
