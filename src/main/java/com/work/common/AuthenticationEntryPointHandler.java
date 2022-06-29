package com.work.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {

	 private static final Logger logger = LoggerFactory.getLogger(AuthenticationEntryPointHandler.class);

	    public void commence(HttpServletRequest request, HttpServletResponse response,
	                         AuthenticationException authException) throws IOException {
	        logger.error("Unauthorized error: {}", authException.getMessage());
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	    }
}
