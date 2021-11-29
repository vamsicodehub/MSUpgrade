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
 * The Class BranchIdValidator.
 */
public class BranchIdValidator extends AbstractFieldValidator {
	

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {
		
	@SuppressWarnings("unchecked")
	List<Filter> filters=(List<Filter>) obj;
	
	List<String> errors=new ArrayList<String>();
	
	boolean isBranchIdPresent=false;
	if(filters!=null){
	for(Filter filter:filters){
if(filter.getName().equals(FilterConstants.BRANCHID)){
	isBranchIdPresent=true;
}
	}
	}
	
	
	if(!isBranchIdPresent){
		errors.add("MSG_KEY_BRANCH_ID_IS_MANDATORY");
	}
	
	if (isBranchIdPresent && nextFieldValidator != null ) {
		errors.addAll(nextFieldValidator.validate(obj));
	}
		return errors;
	}

}
