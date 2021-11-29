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
package com.aurionpro.userfavourite.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurionpro.userfavourite.entity.BaseResponse;



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

	
}