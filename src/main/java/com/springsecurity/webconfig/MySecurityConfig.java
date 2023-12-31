package com.springsecurity.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;

import com.springsecurity.service.UserService;

import static org.springframework.security.config.Customizer.withDefaults;

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
            .authorizeHttpRequests(requests -> requests
                    .antMatchers("/signup").permitAll()
                    .antMatchers("/hello").hasAuthority("USER")
                    .antMatchers("/admin").hasAuthority("ADMIN")
                    .anyRequest().authenticated())
            .formLogin(login -> login
                    .loginPage("/login").loginProcessingUrl("/process-login")
                    .defaultSuccessUrl("/", true)
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll())
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .addLogoutHandler(cookies)
                    .permitAll())
            .exceptionHandling(handling -> handling.accessDeniedPage("/access_denied"))
            .httpBasic(withDefaults());
	}
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
	
}
