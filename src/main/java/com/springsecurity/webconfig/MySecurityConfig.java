package com.springsecurity.webconfig;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("vyvy")
		.password("{bcrypt}$2a$10$4Nsu40ZX9MgETi54iP0uPe0RytkIl/He2Mhqa4l/RzDCkuT.P1LTG")
		.roles("admin");

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/myCustomLogin").loginProcessingUrl("/login-process")
			.permitAll()
			.and()
		.logout()
	        .permitAll()
	        .and()
		.httpBasic();
	}
	
}
