package com.springsecurity.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	// principal means username
	@RequestMapping("/")
	public String index(Authentication auth) {

		String username = auth.getPrincipal().toString();

		System.out.println("Username is " + username);

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		authorities.forEach(o -> {
			System.out.println(o.toString());
		});

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

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	public String error() {
		return "access_denied";
	}
}
