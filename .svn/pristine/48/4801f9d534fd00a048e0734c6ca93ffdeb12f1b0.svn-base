package com.aurionpro.userfavourite.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aurionpro.userfavourite.entity.TokenDetails;
import com.aurionpro.userfavourite.service.JwtTokenUtil;

import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	private final String Authorization = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String USERNAME = "User";
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
	/*	if (checkJWTToken(request, response)) {
			final String header = request.getHeader(Authorization);
			final String user = request.getHeader(USERNAME);
			
			final TokenDetails userDetails = new TokenDetails();
			userDetails.setCorporateCode("555");
			userDetails.setUserName(user);
			userDetails.setGeneratedSecretKey("abcd");
			
			final String token = header.split(" ")[1].trim();
			
			if (token!=null && userDetails!=null && jwtTokenUtil.validateToken(token, userDetails)) {
					chain.doFilter(request, response);
			} else {
				throw new UnsupportedJwtException("JWT Token Not Found in Header");
			}
		}*/
		chain.doFilter(request, response);
		
	}
	
	
	private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(Authorization);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			throw new UnsupportedJwtException("Invalid Header Details");
		return true;
	}
	
}
