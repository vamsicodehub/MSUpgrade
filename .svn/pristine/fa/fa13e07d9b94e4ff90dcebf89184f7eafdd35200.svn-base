package com.aurionpro.generic.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aurionpro.cashpro.commons.security.Ticket;
import com.aurionpro.generic.baserequest.BaseResponse;
import com.aurionpro.generic.baserequest.TokenDetails;
import com.aurionpro.generic.constants.ApplicationCacheContstants;
import com.aurionpro.generic.utils.FieldNameUtil;
import com.aurionpro.generic.utils.JwtTokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	private final String Authorization = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String USERNAME = "User";
	private final String SECURITYID = "security";
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		try {
			System.out.println("############################Filter is being called#############################################");
			if (checkJWTToken(request, response)) {
				
				final String header = request.getHeader(Authorization);
				String security = request.getHeader(SECURITYID);
				Ticket ticket=getTicket(request);
				
				final TokenDetails userDetails = new TokenDetails();
				userDetails.setCorporateId(ticket.getCurrentOUId());
				userDetails.setUserName(ticket.getLoginId());
				userDetails.setGeneratedSecretKey(security);
				
				final String token = header.split(" ")[1].trim();
				
				if (token!=null && userDetails!=null && jwtTokenUtil.validateToken(token, userDetails)) {
						chain.doFilter(request, response);
				} else {
					throw new UnsupportedJwtException("Invalid Authorization Token");
				}
			}
		} catch (Exception e) {
				e.printStackTrace();
				BaseResponse baseResponse = new BaseResponse(); 
				baseResponse.getResponseStatus().setStatus(""+HttpStatus.INTERNAL_SERVER_ERROR.value());
				baseResponse.getResponseStatus().setMessage(getExceptionMsg(e));
				response.getWriter().write(convertObjectToJson(baseResponse));
		}
	
	}
	
	
	private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(Authorization);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			throw new UnsupportedJwtException("Invalid Header Details");
		return true;
	}
	
	private Ticket getTicket(HttpServletRequest request) {
		String security = request.getHeader(SECURITYID);
		Ticket ticket = (Ticket) FieldNameUtil.getObjectFromCache("Micro-"+security, ApplicationCacheContstants.TICKET);
		if(ticket==null)
			throw new UnsupportedJwtException("Ticket Not Found");
		
		return ticket;
	}
	
	   public String convertObjectToJson(Object object) throws JsonProcessingException {
	        if (object == null) {
	            return null;
	        }
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.writeValueAsString(object);
	    }
	   
	   
		private String getExceptionMsg(Exception ex) {
			Throwable cause = ex.getCause();

			while (cause != null) {
				if (null == cause.getCause()) {
					break;
				}
				cause = cause.getCause();
			}
			return null != cause ? (null != cause.getMessage() ? cause.getMessage()
					: cause.toString()) : ex.getMessage();
		}
	
}
