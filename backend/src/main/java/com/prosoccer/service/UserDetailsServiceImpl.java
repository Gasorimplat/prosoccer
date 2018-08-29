package com.prosoccer.service;

import com.prosoccer.model.Jugador;
import com.prosoccer.repository.JugadorRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserDetailsServiceImpl implements UserDetailsService {

	private JugadorRepository jugadorRepository;

	public UserDetailsServiceImpl(JugadorRepository jugadorRepository) {
		this.jugadorRepository = jugadorRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String documento) throws UsernameNotFoundException {
		Jugador user = jugadorRepository.findByUsername(documento);
		if(user == null) throw new UsernameNotFoundException(documento);

		return new User(user.getUsername(), user.getPassword(), Collections.<GrantedAuthority>emptyList());
	}
}
