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
package com.aurionpro.beneficiary.baserequest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseResponse.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 22-07-2015
 */

@JsonInclude(Include.NON_NULL)
public class BaseResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1293886449436419830L;

	/** The is loggable. */
	protected Boolean isLoggable = false;

	/** The response status. */
	private ResponseStatus responseStatus = new ResponseStatus();

	/**
	 * Checks if is loggable.
	 *
	 * @return true, if is loggable
	 */
	public boolean isLoggable() {
		return isLoggable;
	}

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
	 * @param responseStatus the new response status
	 */
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	public String getEntityIdentifier() {
		return "";
	}

}
