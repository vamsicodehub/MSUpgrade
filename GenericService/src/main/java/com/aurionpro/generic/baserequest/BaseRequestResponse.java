/**
 * Copyright 2015-2016 aurionpro solutions, .  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is not free software; you cannot redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  aurionpro solutions designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 * <p>
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * <p>
 * Please contact aurionpro solutions, public ltd., visit www.aurionprosolutions.com if you need additional information or
 * have any questions.
 */
package com.aurionpro.generic.baserequest;





/**
 * The Class BaseRequestResponse.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 22-07-2015
 */


public class BaseRequestResponse  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3331586363539111147L;

	/** The is loggable. */
	protected Boolean isLoggable = false;

/*	*//** The version details. *//*
	private VersionDetails versionDetails;

	*//** The client details. *//*
	private ClientDetails clientDetails;*/

	/** The session id. */
	private String sessionId;

	/** The ticket. */
	private Object ticket;

	/** The security id. */
	private String securityId;

	/** The response status. */
	private ResponseStatus responseStatus = new ResponseStatus();

	/** The page from. */
	private String pageFrom;

	/**
	 * Gets the page from.
	 *
	 * @return the page from
	 */
	public String getPageFrom() {
		return pageFrom;
	}

	/**
	 * Sets the page from.
	 *
	 * @param pageFrom
	 *            the new page from
	 */
	public void setPageFrom(String pageFrom) {
		this.pageFrom = pageFrom;
	}

	/**
	 * Gets the session id.
	 *
	 * @return the session id
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the session id.
	 *
	 * @param sessionId
	 *            the new session id
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Gets the ticket.
	 *
	 * @return the ticket
	 */
	public Object getTicket() {
		return ticket;
	}

	/**
	 * Sets the ticket.
	 *
	 * @param ticket
	 *            the new ticket
	 */
	public void setTicket(Object ticket) {
		this.ticket = ticket;
	}

	/**
	 * Gets the security id.
	 *
	 * @return the security id
	 */
	public String getSecurityId() {
		return securityId;
	}

	/**
	 * Sets the security id.
	 *
	 * @param securityId
	 *            the new security id
	 */
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	/**
	 * Gets the version details.
	 *
	 * @return the version details
	 */
/*	public VersionDetails getVersionDetails() {
		return versionDetails;
	}

	*//**
	 * Sets the version details.
	 *
	 * @param versionDetails
	 *            the new version details
	 *//*
	public void setVersionDetails(VersionDetails versionDetails) {
		this.versionDetails = versionDetails;
	}

	*//**
	 * Gets the client details.
	 *
	 * @return the client details
	 *//*
	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	*//**
	 * Sets the client details.
	 *
	 * @param clientDetails
	 *            the new client details
	 *//*
	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}*/

	/**
	 * Gets the response status.
	 *
	 * @return the response status
	 */
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	/**
	 * Sets the response status.
	 *
	 * @param responseStatus
	 *            the new response status
	 */
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * Gets the checks if is loggable.
	 *
	 * @return the checks if is loggable
	 */
	public Boolean getIsLoggable() {
		return isLoggable;
	}

	/**
	 * Sets the checks if is loggable.
	 *
	 * @param isLoggable
	 *            the new checks if is loggable
	 */
	public void setIsLoggable(Boolean isLoggable) {
		this.isLoggable = isLoggable;
	}
	
	public String getEntityIdentifier() {
		return "";
	}
	
	public String getEntity() {
		return "";
	}
	
	public void setEntity(String entity) {
	}

}
