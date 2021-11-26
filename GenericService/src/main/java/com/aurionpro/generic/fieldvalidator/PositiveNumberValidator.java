/*
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;


// TODO: Auto-generated Javadoc
/**
 * The Class PositiveNumberValidator.
 * @author fardeen.shaikh
 */
public class PositiveNumberValidator extends AbstractFieldValidator {


	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {
		List<String> errors = new LinkedList<String>();
		String temp = obj.toString();
		if (Integer.parseInt(temp) <= 0) {
			errors.add("MSGKEY_VALIDATOR_NUMBER_SHOULD_BE_GREATER_THAN_0");
		}
		if (nextFieldValidator != null && errors.isEmpty()) {
			errors.addAll(nextFieldValidator.validate(obj));
		}
		return errors;
	}
}
