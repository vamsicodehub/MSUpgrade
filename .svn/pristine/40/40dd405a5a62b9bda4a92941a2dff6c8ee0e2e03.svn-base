/*
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.baserequest.BaseRequestMap;
import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;



// TODO: Auto-generated Javadoc
/**
 * The Class TokenValidator.
 */
public class TokenValidator extends AbstractFieldValidator {

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	
	/**
	 * TODO: Pravin to check
	 */
	@Override
	public List<String> validate(Object obj) {

		List<String> errors = new LinkedList<String>();

	/*	if (null == obj) {
			errors.add("MSGKEY_VALIDATOR_MANDATORY");
		} else {
			if(obj instanceof BaseRequestMap){
				BaseRequestMap request = (BaseRequestMap) obj;
				if ((ApplicationCache.getAttribute(request.getSecurityId(),
						ApplicationCacheContstants.ENABLE_2FA).equals(
						AuthenticationType.HARDTOKEN)
						|| ApplicationCache.getAttribute(request.getSecurityId(),
								ApplicationCacheContstants.ENABLE_2FA).equals(
								AuthenticationType.SOFTTOKEN)) && request.getDataMap().get(FilterConstants.TOKENNO)!=null){
					
					errors.add("MSGKEY_VALIDATOR_MANDATORY");
				}
			}

		}
		if (nextFieldValidator != null && errors.isEmpty()) {
			errors.addAll(nextFieldValidator.validate(obj));
		}*/
		return errors;
	}
}
