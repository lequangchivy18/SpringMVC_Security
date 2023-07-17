package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springsecurity.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam(name = "userId") String userId) {
		
		if("".equals(userId)) {
			return "/";
		}
		userService.deleteById(userId);
		return "redirect:/login";
	}
}
