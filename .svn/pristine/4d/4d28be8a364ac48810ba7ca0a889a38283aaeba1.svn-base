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

import java.io.Serializable;
import java.util.List;

import com.aurionpro.generic.enums.ResponseStatusType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponseStatus.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 22-07-2015
 */
// 
@JsonInclude(Include.NON_NULL)
public class ResponseStatus implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1640607920331175082L;

	/** The message. */
	private String message = "";

	/** The status. */
	private String status = ResponseStatusType.SUCCESS.toString();

	/** The error list. */
	private List<String> errorList;

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the error list.
	 *
	 * @return the error list
	 */
	public List<String> getErrorList() {
		return errorList;
	}

	/**
	 * Sets the error list.
	 *
	 * @param errorList
	 *            the new error list
	 */
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	/**
	 * Sets the wraning message.
	 *
	 * @param warning
	 *            the new wraning message
	 */
	public void setWraningMessage(String warning) {
		status = ResponseStatusType.WARNING.toString();
		message = warning;
	}

	/**
	 * Sets the info message.
	 *
	 * @param info
	 *            the new info message
	 */
	public void setInfoMessage(String info) {
		status = ResponseStatusType.INFO.toString();
		message = info;
	}

}
