/*
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.baserequest.Filter;
import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;



// TODO: Auto-generated Javadoc
/**
 * The Class FilterValidator.
 */
public class FilterValidator extends AbstractFieldValidator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator
	 * #validate(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> validate(Object obj) {
		List<String> errorList = new LinkedList<String>();
		List<Filter> filters = (List<Filter>) obj;

		if (null != filters && !filters.isEmpty()) {
			for (Filter filter : filters) {
				if ((isEmpty(filter.getName()))
						|| (isEmpty(filter.getType()))
						|| (isEmpty((String) filter.getValue()))
						|| (!checkFilterType(filter.getType()))) {

					errorList.add("MSGKEY_VALIDATOR_FILTER_VALIDATION");
				}
			}
		}

		if (nextFieldValidator != null && errorList.isEmpty()) {
			errorList.addAll(nextFieldValidator.validate(obj));
		}

		return errorList;
	}

	/**
	 * Check filter type.
	 *
	 * @param type
	 *            the type
	 * @return true, if successful
	 */
	private boolean checkFilterType(String type) {
		return ((type.equals(Date.class.getSimpleName())
				|| type.equals(String.class.getSimpleName())
				|| type.equals(Double.class.getSimpleName()) || type
					.equals(Integer.class.getSimpleName()) ||  type
					.equals("Amount")));
	}
	
	/**
	 * TODO:Pravin to check
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return !(null != s && s.trim().length() > 0);
	}

}
