package com.prosoccer.security;

import com.prosoccer.model.Jugador;
import com.prosoccer.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private JugadorRepository jugadorRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = String.valueOf(authentication.getName());
		String password = String.valueOf(authentication.getCredentials().toString());

		Jugador jugador = jugadorRepository.findByUsernameAndPassword(username, password);

		if (jugador != null) {
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			final UserDetails principal = new User(username, password, grantedAuths);
			final Authentication auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
			return auth;
		} else {
			throw new BadCredentialsException("Bad Credentials");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
