package com.aurionpro.authentication.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String USERNAME = "User";
	private final String PASSWORD = "Password";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("Filter called####");
		if (checkCredentials(request, response)) {
				chain.doFilter(request, response);
		}else
		{
			throw new UnsupportedJwtException("Incorrect Credentials");
		}
		
	}
	
	
	private boolean checkCredentials(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		
		String user =request.getHeader(USERNAME);
		if (user == null || !user.equalsIgnoreCase("Pravin"))
			return false;
		
		String password =request.getHeader(PASSWORD);
		if (password == null || !password.equalsIgnoreCase("test1234"))
			return false;
		
		return true;
	}
	
}
