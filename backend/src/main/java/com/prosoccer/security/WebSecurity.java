package com.prosoccer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		AuthenticationManager authenticationManager = authenticationManagerBean();
		http.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
				.anyRequest().authenticated()
				.and()//.csrf().disable();
				.addFilter(new JWTAuthenticationFilter(authenticationManager))
				.addFilter(new JWTAuthorizationFilter(authenticationManager));
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
		authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
		//TODO: setear password encrypter
	}

}
