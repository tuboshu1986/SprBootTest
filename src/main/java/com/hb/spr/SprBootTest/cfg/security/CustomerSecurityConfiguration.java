package com.hb.spr.SprBootTest.cfg.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hb.spr.SprBootTest.service.UserService;

@Configuration
@EnableWebSecurity
public class CustomerSecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(CustomerSecurityConfiguration.class);
	@Autowired
	private UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug(">>>>验证配置");
		http
		.authorizeRequests()
		.antMatchers("/security/**").permitAll()
		.antMatchers("/pub/**").permitAll()
		.antMatchers("/plugin/**").permitAll()
		.antMatchers("/user/**").permitAll()
		//.antMatchers("/**").access("hasRole('READER')")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
		.loginPage("/security/loginPage")
		.failureUrl("/security/loginPage?error=true")
		.loginProcessingUrl("/login")
		.successForwardUrl("/security/index")
		.failureForwardUrl("/security/loginPage")
		.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		logger.debug(">>>>查询用户信息配置");
		auth.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username)
				throws UsernameNotFoundException {
				logger.debug(">>>>查询用户信息:" + username);
				return (UserDetails) userService.findOneByName(username);
			}
		}).passwordEncoder(new BCryptPasswordEncoder());
	}
}
