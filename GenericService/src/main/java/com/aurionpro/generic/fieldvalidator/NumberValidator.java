/*
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;


// TODO: Auto-generated Javadoc
/**
 * The Class NumberValidator.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 17-07-2015
 */
public class NumberValidator extends AbstractFieldValidator {
	
	/** The regex. */
	private String regex = "[+-]?[0-9]+";

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {
		List<String> errors = new LinkedList<String>();
		if (!obj.toString().matches(regex)) {
			errors.add("MSGKEY_VALIDATOR_NUMBER_ONLY");
		}
		if (nextFieldValidator != null && errors.isEmpty()) {
			errors.addAll(nextFieldValidator.validate(obj));
		}

		return errors;
	}

}
