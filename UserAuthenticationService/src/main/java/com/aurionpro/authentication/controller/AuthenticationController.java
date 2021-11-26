package com.aurionpro.authentication.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.authentication.entity.JWTResponse;
import com.aurionpro.authentication.entity.TokenDetails;
import com.aurionpro.authentication.service.JwtTokenUtil;


@RestController
@RequestMapping(value="/authenticationServices", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	
	private final String LOGIN_USER_BASIC_AUTH = "/public/login/basicAuthentication";
	
	
	@PostMapping(value=LOGIN_USER_BASIC_AUTH,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAuthenticationToken(HttpServletRequest httpRequest) throws Exception {
		
		logger.info("AuthenticationController >> createAuthenticationToken starts ");
		
		/**
		 * Load user details here
		 */
		
		final TokenDetails userDetails = new TokenDetails();
		userDetails.setCorporateCode("555");
		userDetails.setUserName("Pravin");
		userDetails.setGeneratedSecretKey("abcd");
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		JWTResponse response = new JWTResponse();
		response.setJwtToken(token);
		
		logger.info("AuthenticationController >> createAuthenticationToken ends ");
		return new ResponseEntity<JWTResponse>(response, HttpStatus.OK);
	}

	
}
