package com.fabtec.authentication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = -5045565922879097667L;

	public InvalidJwtAuthenticationException(String exception) {
		super(exception);		
	}
	
}
