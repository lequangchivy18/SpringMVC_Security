package com.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springsecurity.entity.User;
import com.springsecurity.service.UserService;

@Controller
public class HelloController {

	@Autowired
	private UserService userService;

//	@ModelAttribute(name = "users")
//	public List<User> getAllUser() {
//		return userService.findAll();
//	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		List<User> users = userService.findAll();
		userService.findAll().forEach(o->{
			System.out.println(o.toString());
		});
		model.addAttribute("users",users);
		return "hello";
	}
}
