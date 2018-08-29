package com.prosoccer.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prosoccer.model.Jugador;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		try {
			Jugador creds = new ObjectMapper().readValue(req.getInputStream(), Jugador.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							creds.getUsername(),
							creds.getPassword(),
							new ArrayList<GrantedAuthority>())
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
											Authentication auth) throws IOException, ServletException {
		String token = Jwts.builder()
				.setSubject(((User) auth.getPrincipal()).getUsername())
				.setExpiration(new DateTime(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME).toDate())
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
				.compact();

		res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	}
}
