package com.aurionpro.cashpro.commons.security;

import java.io.Serializable;

public class VerificationDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9154309819812998L;

	private Boolean verifierRequired = false;

	private Long noOfVerifiers = 0l;

	private String verLevel = "B";

	public Boolean getVerifierRequired() {
		return verifierRequired;
	}

	public void setVerifierRequired(Boolean verifierRequired) {
		this.verifierRequired = verifierRequired;
	}

	public Long getNoOfVerifiers() {
		return noOfVerifiers;
	}

	public void setNoOfVerifiers(Long noOfVerifiers) {
		this.noOfVerifiers = noOfVerifiers;
	}

	public String getVerLevel() {
		return verLevel;
	}

	public void setVerLevel(String verLevel) {
		this.verLevel = verLevel;
	}
}
