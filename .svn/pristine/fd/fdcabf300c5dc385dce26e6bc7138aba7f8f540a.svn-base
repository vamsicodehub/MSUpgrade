/*
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.baserequest.Filter;
import com.aurionpro.generic.constants.FilterConstants;
import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class BeneficiaryFilterCustomValidator.
 */
public class BeneficiaryFilterCustomValidator extends AbstractFieldValidator {

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {

		List<String> errorList = new LinkedList<String>();

		@SuppressWarnings("unchecked")
		List<Filter> filters = (List<Filter>) obj;

		if (null == filters || !isPaymentMethodAvailable(filters)) {
			errorList.add("MSG_KEY_PAYMENT_METHOD_ID_MANADATORY");
		}

		if (nextFieldValidator != null && errorList.isEmpty()) {
			errorList.addAll(nextFieldValidator.validate(obj));
		}
		return errorList;
	}
	
	/**
	 * Checks if is payment method available.
	 *
	 * @param filters the filters
	 * @return true, if is payment method available
	 */
	private boolean isPaymentMethodAvailable(List<Filter> filters) {
		for (Filter filter : filters) {
			if (filter.getName().equals(FilterConstants.PAYMENTMETHODID))
				return true;
		}
		return false;
	}

}
