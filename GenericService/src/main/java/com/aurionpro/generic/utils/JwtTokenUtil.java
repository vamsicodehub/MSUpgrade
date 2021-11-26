package com.aurionpro.generic.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aurionpro.generic.baserequest.TokenDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtTokenUtil {

	private static Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

	public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 60 * 5;//5hrs

	private static String secret;
	private static Properties properties;
	
	static 
	{
		/**
		 * TODO:to be made configurable
		 */
		secret = "1234567890123456";
	}

	//retrieve username from jwt token
	public String getSubjectFromToken(String token) throws Exception{
		try {
			return getClaimFromToken(token, Claims::getSubject);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Invalid Authorization Token");
		}
	}

	public String getIssuerFromToken(String token) throws Exception{
		try {
			return getClaimFromToken(token, Claims::getIssuer);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Invalid Authorization Token");
		}
	}
	
	public String getClaimFromToken(String token,String property) throws Exception{
		Claims claims=null;
		try
		{
			claims = getAllClaimsFromToken(token);
			return (String) claims.get(property);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Invalid Authorization Token");
		}
	}
	
	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
    //for retrieveing any information from token we will need the secret key
	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	//check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	//generate token for user
	public String generateToken(TokenDetails userDetails) {
		
		Map<String, Object> claims = new HashMap<>();
		claims.put("corporateId", userDetails.getCorporateId());
		claims.put("userName", userDetails.getUserName());
		claims.put("generatedKey", userDetails.getGeneratedSecretKey());
		return doGenerateToken(claims, "USERTOKEN","AURIONPRO");
	}

	//while creating the token -
	//1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
	//2. Sign the JWT using the HS512 algorithm and secret key.
	//3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	//   compaction of the JWT to a URL-safe string 
	private String doGenerateToken(Map<String, Object> claims, String subject, String issuer) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setIssuer(issuer)
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact(); //Compact makes the token URL Compactable
	}

	//validate token
	//in my user details username is the loginId, passwd is activesessionId
	public Boolean validateToken(String token, TokenDetails userDetails) throws Exception{
		
		final String subject = getSubjectFromToken(token);
		final String issuer = getIssuerFromToken(token);
		
		if(subject==null || !subject.equalsIgnoreCase("USERTOKEN") || issuer==null || !issuer.equalsIgnoreCase("AURIONPRO"))
			return false;
		
		final String corporateId = getClaimFromToken(token, "corporateId");
		final String userName = getClaimFromToken(token, "userName");
		final String generatedKey = getClaimFromToken(token, "generatedKey");
		
		return (userName.equals(userDetails.getUserName()) && generatedKey.equals(userDetails.getGeneratedSecretKey()) 
				&& corporateId.equals(userDetails.getCorporateId())&& !isTokenExpired(token));
	}


}
