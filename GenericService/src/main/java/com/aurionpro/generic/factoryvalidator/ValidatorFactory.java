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

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.aurionpro.generic.constants.RestConstants;


// TODO: Auto-generated Javadoc
/**
 * A factory for creating Validator objects.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 17-07-2015
 */
@SuppressWarnings("unchecked")
public class ValidatorFactory {

	/** The validator map. */
	private static Map<String, Validator> validatorMap = new HashMap<String, Validator>();

	static {
		InputStream stream = null;
		Document validatorDoc;
		try {
			/*
			 * Load the Validator.xml file present inside the src folder this
			 * xml file tells us what validators are needed to be applied on
			 * which objects <p> for eg: for login <validator modal=
			 * "com.aurionpro.cashpro.rest.request.commons.security.LoginRequest"
			 * validatorClass=
			 * "com.aurionpro.cashpro.rest.validator.modulevalidators.LoginValidator"
			 * /> LoginValidator will be used to validate its field <p> what
			 * fields to validate is present in the *.xml file i.e for login it
			 * will be LoginValidator.xml file
			 */
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			stream = classLoader.getResourceAsStream("Validator.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			validatorDoc = dBuilder.parse(stream);
			validatorDoc.getDocumentElement().normalize();
			NodeList validatorList = validatorDoc
					.getElementsByTagName("validator");

			for (int i = 0; i < validatorList.getLength(); i++) {
				Node validatorNode = validatorList.item(i);
				if (validatorNode.getNodeType() == Node.ELEMENT_NODE) {
					Element validatorElement = (Element) validatorNode;
					String name = validatorElement.getAttribute("name");
					String validatorClass = validatorElement
							.getAttribute("validatorClass");
					Class<AbstractValidator> c = null;
					Validator interfaceType = null;
					try {
						c = (Class<AbstractValidator>) Class
								.forName(validatorClass);
						Method m = c.getMethod("getInstance", new Class[] {});
						interfaceType = (Validator) m.invoke(null,
								new Object[] {});
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					validatorMap.put(name, interfaceType);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != stream) {
				try {
					stream.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * Instantiates a new validator factory.
	 */
	private ValidatorFactory() {

	}

	/**
	 * Inits the.
	 *
	 * @throws Exception the exception
	 */
	public static void init() throws Exception {
		if (validatorMap == null || validatorMap.size() == 0) {
			throw new Exception(RestConstants.MSGKEY_VALIDATION_FACTORY_NOT_CONFIGURED);
		}
	}

	/**
	 * Find validator.
	 *
	 * @param validatorName the validator name
	 * @return the validator
	 */
	public static Validator findValidator(String validatorName) {
		return validatorMap.get(validatorName);
	}
}
