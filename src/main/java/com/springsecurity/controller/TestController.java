package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/hello/{yourname}")
	public String helloName(@PathVariable("yourname") String youname) {
		return "Good afternoon " + youname;
	}
}
