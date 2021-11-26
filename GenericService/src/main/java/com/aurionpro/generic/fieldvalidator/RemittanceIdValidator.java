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
 * The Class RemittanceIdValidator.
 */
public class RemittanceIdValidator extends AbstractFieldValidator {

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {
		List<String> errorList=new ArrayList<String>();;
		
	@SuppressWarnings("unchecked")
	List<Filter> filters=(List<Filter>) obj;
	boolean isRemittanceIdPresent=false;
	
	if(null!=filters){	
	for(Filter filter:filters){
		if(filter.getName().equals(FilterConstants.REMITTANCEID)){
			isRemittanceIdPresent=true;
		}
	}
	}
	
	if(!isRemittanceIdPresent)
	errorList.add("MSG_KEY_REMITTANCE_ID_IS_MADATORY");
	
	if (isRemittanceIdPresent && nextFieldValidator != null ) {
		errorList.addAll(nextFieldValidator.validate(obj));
	}
		return errorList;
	}
	
	
	}


