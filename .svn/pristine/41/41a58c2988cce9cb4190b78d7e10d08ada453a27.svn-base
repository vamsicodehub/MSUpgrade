/*
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.baserequest.Filter;
import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;



// TODO: Auto-generated Javadoc
/**
 * The Class MinimumFilterValidator.
 */
public class MinimumFilterValidator extends AbstractFieldValidator {
	
	/** The fields. */
	private final List<String> fields;
	
	/**
	 * Instantiates a new minimum filter validator.
	 *
	 * @param addtionalData the addtional data
	 */
	public MinimumFilterValidator(String addtionalData){
		
		fields = Arrays.asList(addtionalData.split(","));
		
	}

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {

		List<String> errorList = new LinkedList<String>();
		@SuppressWarnings("unchecked")
		List<Filter> filters = (List<Filter>)obj;
		
		if (null == filters || ! isMinimumCriteriaPresent(filters,fields)) {
			errorList.add("MSG_KEY_CRITERIA_IS_MANDATORY");
		}
		
		if (nextFieldValidator != null && errorList.isEmpty()) {
			errorList.addAll(nextFieldValidator.validate(obj));
		}
		return errorList;
	}

	/**
	 * Checks if is minimum criteria present.
	 *
	 * @param filters the filters
	 * @param fields the fields
	 * @return true, if is minimum criteria present
	 */
	private boolean isMinimumCriteriaPresent(List<Filter> filters,
			List<String> fields) {

		for (Filter filter : filters) {
			if (fields.contains(filter.getName()))
				return true;
		}
		return false;

	}

}
