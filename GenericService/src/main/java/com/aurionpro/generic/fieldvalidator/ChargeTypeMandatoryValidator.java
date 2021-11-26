/*
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.generic.baserequest.Filter;
import com.aurionpro.generic.constants.FilterConstants;
import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;



// TODO: Auto-generated Javadoc
/**
 * The Class ChargeTypeMandatoryValidator.
 */
public class ChargeTypeMandatoryValidator extends AbstractFieldValidator {

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {
		// TODO Auto-generated method stub
		List<String> errorList = new ArrayList<String>();
		List<Filter> filters = (List<Filter>) obj;
		boolean isChargeFilterFound = false;
		if (null != filters) {
			for (Filter filter : filters) {
				if (filter.getName().equals(FilterConstants.CHARGE)) {
					isChargeFilterFound = true;
					break;
				}
			}
		}
		if(!isChargeFilterFound){
			errorList.add("MSG_KEY_CHARGETYPE_IS_MADATORY");
		}
		if (isChargeFilterFound && null != nextFieldValidator) {
			errorList.addAll(nextFieldValidator.validate(obj));
		}
		return errorList;
	}

}
