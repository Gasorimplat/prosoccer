package com.prosoccer.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class DocumentPasswordAuthenticationToken extends AbstractAuthenticationToken {

	private final Object principal;
	private Object credentials;

	public DocumentPasswordAuthenticationToken(Object principal, Object credentials) {
		super((Collection)null);
		this.principal = principal;
		this.credentials = credentials;
		this.setAuthenticated(false);
	}

	public DocumentPasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return this.credentials;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
}
