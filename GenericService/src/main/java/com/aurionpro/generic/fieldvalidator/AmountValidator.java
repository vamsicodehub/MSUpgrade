/*
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;


// TODO: Auto-generated Javadoc
/**
 * The Class AmountValidator.
 * @author fardeen.shaikh
 */
public class AmountValidator extends AbstractFieldValidator {
	
	/** The regex for validating amount. */
	private String regex = "[+-]?[0-9]{1,9}+([.][0-9]{1,9})?";

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {
		List<String> errors = new LinkedList<String>();
		String temp = obj.toString();
		if (!obj.toString().matches(regex)) {
			errors.add("MSGKEY_INVALID_AMOUNT");
		} else if (Double.parseDouble(temp) <= 0) {
			errors.add("MSGKEY_VALIDATOR_AMOUNT_SHOULD_BE_GREATER_THAN_0");
		}
		if (nextFieldValidator != null && errors.isEmpty()) {
			errors.addAll(nextFieldValidator.validate(obj));
		}
		return errors;
	}
}
