package com.springsecurity.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springsecurity.dto.ChangePasswordDto;
import com.springsecurity.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/deleteUser")
	@PreAuthorize("isAuthenticated()")
	public String deleteUser(@RequestParam(name = "userId") String userId) {
		
		if("".equals(userId)) {
			return "/";
		}
		userService.deleteById(userId);
		return "redirect:/login";
	}
	
	@GetMapping("/changePassword")
	public String showChangePassword(Model model) {
		
		model.addAttribute("changePass", new ChangePasswordDto());
		
		return "change_password";
	}
	
	@PostMapping("/savePassword")
	public String savePassword(@ModelAttribute(name = "changePass") @Valid ChangePasswordDto changePasswordDto, BindingResult result, Principal principal) {
		
		if(result.hasErrors()) {
			return "change_password";
		}
		//check the oll password
		String username = principal.getName();
		UserDetails userDetails = userService.loadUserByUsername(username);
		
		boolean matches = passwordEncoder.matches(changePasswordDto.getOldPassword(), userDetails.getPassword());
		
		if(!changePasswordDto.getNewPassword().equals(changePasswordDto.getConfirmPassword())) {
			return "redirect:/changePassword?notMatched";
		}
		
		if(matches) {
			String newPassword = passwordEncoder.encode(changePasswordDto.getNewPassword());
			userService.changePasswors(username, newPassword);
			return "redirect:/";
		}
		return "redirect:/changePassword?invalidPassword";
		
	}
	
}
