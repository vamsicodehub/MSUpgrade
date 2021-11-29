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
package com.aurionpro.generic.exceptions;

import java.util.LinkedList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * ValidationException is a user defnied Exception calss which contains all the
 * validation errors as form of a list @see List<String> errors in the class.
 *
 * @author Abhishek Ramkumar
 * @version 0.1
 * @since 17-07-2015
 */
public class ValidationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8086030695222453788L;

	/** The errors. */
	private List<String> errors = new LinkedList<String>();

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param errors the errors
	 */
	public ValidationException(List<String> errors) {
		this.errors = errors;
	}

	/**
	 * Adds the error.
	 *
	 * @param error the error
	 */
	public void addError(String error) {
		this.errors.add(error);
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
