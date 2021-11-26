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
package com.aurionpro.generic.factoryvalidator;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface Validator.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 17-07-2015
 */

public interface Validator {

	 /**
 	 * Validate.
 	 *
 	 * @param validatorName the validator name
 	 * @param obj the obj
 	 * @return the list
 	 */
 	List<String> validate(String validatorName,Object obj);
}
