package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springsecurity.service.UserService;

@Controller
public class HelloController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		return "hello";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}
}
