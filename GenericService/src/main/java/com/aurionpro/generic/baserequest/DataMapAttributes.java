/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.io.Serializable;

/**
 * The Class Filter.
 */
public class DataMapAttributes implements Serializable{


	private static final long serialVersionUID = 1L;

	private String mode;
	private String getSelectFor;
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getGetSelectFor() {
		return getSelectFor;
	}
	public void setGetSelectFor(String getSelectFor) {
		this.getSelectFor = getSelectFor;
	}
	
	
}
