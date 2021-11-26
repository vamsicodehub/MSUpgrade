/**
 * Copyright 2015-2016 aurionpro solutions, .  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is not free software; you cannot redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  aurionpro solutions designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 * <p>
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * <p>
 * Please contact aurionpro solutions, public ltd., visit www.aurionprosolutions.com if you need additional information or
 * have any questions.
 */
package com.aurionpro.generic.exceptions;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurionpro.generic.baserequest.BaseResponse;
import com.aurionpro.generic.baserequest.ResponseStatus;
import com.aurionpro.generic.enums.ResponseStatusType;
import com.aurionpro.generic.validator.BusinessValidationError;



// TODO: Auto-generated Javadoc
/**
 * All the Exceptions are handled by GlobalExceptionController which is a module
 * of spring project named Spring ExceptionHandler kindly refer
 * further details
 * 
 **/
@ControllerAdvice
public class GlobalExceptionController {


	/**
	 * Handle all exception.
	 *
	 * @param ex
	 *            the ex
	 * @return the base response
	 */
	@ExceptionHandler({ Exception.class })
	public @ResponseBody BaseResponse handleAllException(Exception ex) {

		String exceptionMsg = getExceptionMsg(ex);
		BaseResponse response = new BaseResponse();
		if (ex instanceof ValidationException) {
			response = ValidationExceptionResponse(ex);
		}else if (ex instanceof BusinessValidationException) {
			response = BuisnessValidationExceptionResponse((BusinessValidationException) ex);
		} 
		
		
		response.getResponseStatus().setStatus("1");
		response.getResponseStatus().setMessage(exceptionMsg);
 		ex.printStackTrace();
		return response;
	}
	
	private String getExceptionMsg(Exception ex) {
		Throwable cause = ex.getCause();

		while (cause != null) {
			if (null == cause.getCause()) {
				break;
			}
			cause = cause.getCause();
		}
		return null != cause ? (null != cause.getMessage() ? cause.getMessage()
				: cause.toString()) : ex.getMessage();
	}
	
	
	private BaseResponse BuisnessValidationExceptionResponse(Exception ex) {

		BaseResponse response = new BaseResponse();
		BusinessValidationException validation = (BusinessValidationException) ex;
		List<BusinessValidationError> buisnessErrors = validation.getErrors();
		List<String> errors = new LinkedList<String>();

		for (BusinessValidationError error : buisnessErrors) {
			List<String> messageValues = error.getMessageValues();
			String message = error.getMessageKey();
			if (messageValues != null && !messageValues.isEmpty()) {
				String formattedMessage = MessageFormat.format(message,
						messageValues.toArray());
				errors.add(formattedMessage);
			} else {
				errors.add(message);
			}
		}
		ResponseStatus details = new ResponseStatus();
		details.setErrorList(errors);
		details.setStatus(ResponseStatusType.FAIL.toString());
		response.setResponseStatus(details);
		return response;

	}
	
	
	private BaseResponse ValidationExceptionResponse(Exception ex) {
		ValidationException validationException = (ValidationException) ex;
		List<String> errors = validationException.getErrors();
		BaseResponse response = new BaseResponse();
		ResponseStatus details = new ResponseStatus();
		details.setErrorList(errors);
		details.setStatus(ResponseStatusType.FAIL.toString());
		response.setResponseStatus(details);
		return response;
	}

	
}