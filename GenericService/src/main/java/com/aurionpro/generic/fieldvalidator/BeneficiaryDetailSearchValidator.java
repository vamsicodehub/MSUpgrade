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
 * The Class BeneficiaryDetailSearchValidator.
 */
public class BeneficiaryDetailSearchValidator extends AbstractFieldValidator {

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {

		List<String> errorList = new LinkedList<String>();

		@SuppressWarnings("unchecked")
		List<Filter> filters = (List<Filter>) obj;
		boolean isPaymentMethodIdPresent = false;
		boolean isBeneFiciaryIdPresent = false;
		for (Filter filter : filters) {

			/**
			 * TODO:Pravin to take from constants
			 */
			if (filter.getName().equals(FilterConstants.PAYMENTMETHODID)) {
				isPaymentMethodIdPresent = true;
			}

			if (filter.getName().equals(FilterConstants.BENEFICIARYID)) {
				isBeneFiciaryIdPresent = true;
			}

		}
		
		if (null == filters || !isPaymentMethodIdPresent) {
			errorList.add("MSG_KEY_PAYMENT_METHOD_ID_MANADATORY");
		}
		
		if (null == filters || !isBeneFiciaryIdPresent) {
			errorList.add("MSG_KEY_BENEFICIARY_ID_MANADATORY");
		}

		if (nextFieldValidator != null && errorList.isEmpty()) {
			errorList.addAll(nextFieldValidator.validate(obj));
		}

		return errorList;
		// TODO Auto-generated method stub return null;
	}
}
