package com.springsecurity.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;

import com.springsecurity.service.UserService;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.inMemoryAuthentication()
//		.withUser("vyvy")
//		.password("$2a$10$4Nsu40ZX9MgETi54iP0uPe0RytkIl/He2Mhqa4l/RzDCkuT.P1LTG")
//		.roles("admin");
//
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CookieClearingLogoutHandler cookies = new CookieClearingLogoutHandler("JSESSIONID");
		http
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login").loginProcessingUrl("/process-login")
			.defaultSuccessUrl("/hello", true)
			.usernameParameter("username")
            .passwordParameter("password")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/logout")
			.addLogoutHandler(cookies)
	        .permitAll()
	        .and()
		.httpBasic();
	}
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
	
}
