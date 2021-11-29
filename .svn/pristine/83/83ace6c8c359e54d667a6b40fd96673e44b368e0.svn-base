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
package com.aurionpro.userfavourite.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequest implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 633803774531673531L;

	/** The version details. */
	/*private VersionDetails versionDetails;

	*//** The client details. *//*
	private ClientDetails clientDetails;*/


	private String sessionId;
	private Object ticket;	
	private String securityId;

	/*
	 * To identify the page from where the request originated. Specifications
	 * will be set accordingly
	 */
	private String pageFrom;	
	private Map<String, Object> sessionMap = new HashMap<String, Object>();



}
