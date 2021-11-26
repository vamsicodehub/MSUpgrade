/*
 * 
 */
package com.aurionpro.generic.vlaidator.util;

import java.util.List;

import com.aurionpro.generic.baserequest.Request;
import com.aurionpro.generic.exceptions.ValidationException;
import com.aurionpro.generic.factoryvalidator.Validator;
import com.aurionpro.generic.factoryvalidator.ValidatorFactory;


// TODO: Auto-generated Javadoc
/**
 * The Class ValidatorUtils.
 */
public final class ValidatorUtils {

	/**
	 * Instantiates a new validator utils.
	 */
	private ValidatorUtils() {
	}

	/**
	 * Validate.
	 *
	 * @param request the request
	 * @param validatorName the validator name
	 * @throws ValidationException the validation exception
	 */
	public static void validate(Request request, String validatorName)
			throws ValidationException {

		Validator validator = ValidatorFactory.findValidator(
				validatorName);
		List<String> errors = validator.validate(null, request);
		if (errors != null && !errors.isEmpty()) {
			throw new ValidationException(errors);
		}
	}

	/**
	 * Validate.
	 *
	 * @param request the request
	 * @param controllerName the controller name
	 * @param methodName the method name
	 * @throws ValidationException the validation exception
	 */
	public static void validate(Object request, String controllerName,
			String methodName) throws ValidationException {

		Validator validator = ValidatorFactory.findValidator(
				controllerName);
		if(null!=validator){
		List<String> errors = validator.validate(methodName, request);
		if (errors != null && !errors.isEmpty()) {
			throw new ValidationException(errors);
		}
		}
	}

}
