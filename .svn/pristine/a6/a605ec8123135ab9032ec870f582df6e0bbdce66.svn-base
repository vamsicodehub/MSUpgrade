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
package com.aurionpro.generic.fieldvalidator;

import java.util.LinkedList;
import java.util.List;

import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;



// TODO: Auto-generated Javadoc
/**
 * The Class MandatoryValidator.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 17-07-2015
 */
public class MandatoryValidator extends AbstractFieldValidator {

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator#validate(java.lang.Object)
	 */
	@Override
	public List<String> validate(Object obj) {
		List<String> errors = new LinkedList<String>();
		if (null == obj) {
			errors.add("Validator Mandatory");
		} else {
			if (obj instanceof List && ((List) obj).isEmpty()) {
				errors.add("Validator Mandatory");
			} else if (obj.toString().trim().length() == 0) {
				errors.add("Validator Mandatory");
			}
		}
		if (nextFieldValidator != null && errors.isEmpty()) {
			errors.addAll(nextFieldValidator.validate(obj));
		}
		return errors;
	}

}
