/*
 * 
 */
package com.aurionpro.generic.baserequest;

import com.aurionpro.generic.baserequest.BaseRequestResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseDetails.
 */


public class BaseDetails extends BaseRequestResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7464097073997719971L;

	/** The id. */
	private String id;

	/** The version. */
	private Integer version;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version
	 *            the new version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public String getEntityIdentifier() {
		return "";
	}

}
