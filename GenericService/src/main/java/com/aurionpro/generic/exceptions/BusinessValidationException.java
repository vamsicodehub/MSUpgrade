/*
 * 
 */
package com.aurionpro.generic.exceptions;

import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.validator.BusinessValidationError;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessValidationException.
 */
public class BusinessValidationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8194441588376595273L;
	
	/** The errors. */
	private List<BusinessValidationError> errors = new LinkedList<BusinessValidationError>();

	/**
	 * Instantiates a new business validation exception.
	 *
	 * @param errors the errors
	 */
	public BusinessValidationException(List<BusinessValidationError> errors) {
		this.errors = errors;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<BusinessValidationError> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(List<BusinessValidationError> errors) {
		this.errors = errors;
	}
}
