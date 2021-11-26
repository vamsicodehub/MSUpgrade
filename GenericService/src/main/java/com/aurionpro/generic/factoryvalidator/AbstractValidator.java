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
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



// TODO: Auto-generated Javadoc
/**
 * The Class AbstractValidator.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 17-07-2015
 */
public abstract class AbstractValidator implements Validator {

	/** The validator map. */
	protected Map<String, Map<String, AbstractFieldValidator>> validatorMap = new HashMap<String, Map<String, AbstractFieldValidator>>();
	
	/** The display key map. */
	protected Map<String, Map<String, String>> displayKeyMap = new HashMap<String, Map<String, String>>();
	
	/** The method map. */
	protected Map<String, Method> methodMap = new HashMap<String, Method>();
	

	/**
	 * Instantiates a new abstract validator.
	 */
	public AbstractValidator(InputStream stream) {
		
		Document validatorDoc;
		try {
			Method[] declaredMethods = getClass().getDeclaredMethods();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			validatorDoc = dBuilder.parse(stream);
			validatorDoc.getDocumentElement().normalize();
			NodeList validatorList = validatorDoc
					.getElementsByTagName("validator");
			Map<String, Class<?>> validationClassMap = new HashMap<String, Class<?>>();
			for (int i = 0; i < validatorList.getLength(); i++) {
				Node validatorNode = validatorList.item(i);
				if (validatorNode.getNodeType() == Node.ELEMENT_NODE) {
					Element validatorElement = (Element) validatorNode;
					String validatorName = validatorElement
							.getAttribute("name");
					NodeList fieldList = validatorElement
							.getElementsByTagName("field");
					Map<String, String> internalDispalyMap = new HashMap<String, String>();
					Map<String, AbstractFieldValidator> internalValidatorMap = new HashMap<String, AbstractFieldValidator>();
					for (int j = 0; j < fieldList.getLength(); j++) {
						Node fieldNode = fieldList.item(j);
						if (fieldNode.getNodeType() == Node.ELEMENT_NODE) {
							Element fieldElement = (Element) fieldNode;
							String field_name = fieldElement
									.getAttribute("name");
							String display_key = fieldElement
									.getAttribute("displayKey");
							internalDispalyMap.put(field_name, display_key);
							NodeList validatorClassList = fieldElement
									.getElementsByTagName("validatorClass");
							AbstractFieldValidator currentFieldValidator = null;
							AbstractFieldValidator baseFieldValidator = null;
							for (int k = 0; k < validatorClassList.getLength(); k++) {
								Node validatorClass = validatorClassList
										.item(k);
								if (validatorClass.getNodeType() == Node.ELEMENT_NODE) {
									Element validatorClassElement = (Element) validatorClass;
									String class_name = validatorClassElement
											.getAttribute("name");
									String additionalData = validatorClassElement
											.getAttribute("additionalData");
									Class<?> c = null;
									AbstractFieldValidator interfaceType = null;
									try {
										c = validationClassMap.get(class_name);
										if (c == null) {
											c = Class.forName(class_name);
											validationClassMap.put(class_name,
													c);
										}
										if (null != additionalData
												&& additionalData.length() > 0) {

											@SuppressWarnings("rawtypes")
											Constructor constructor = Class
													.forName(class_name)
													.getConstructor(
															String.class);
											interfaceType = (AbstractFieldValidator) constructor
													.newInstance(additionalData);
										} else {
											interfaceType = (AbstractFieldValidator) c
													.newInstance();
										}
									} catch (ClassNotFoundException e) {
										e.printStackTrace();
									} catch (InstantiationException e) {
										e.printStackTrace();
									} catch (IllegalAccessException e) {
										e.printStackTrace();
									} catch (Exception e) {
										e.printStackTrace();
									}
									if (null != interfaceType) {
										if (baseFieldValidator == null) {
											baseFieldValidator = interfaceType;
											currentFieldValidator = baseFieldValidator;
										} else {
											currentFieldValidator
													.setNextValidator(interfaceType);
											currentFieldValidator = interfaceType;
										}
									}
								}
							}
							internalValidatorMap.put(field_name,
									baseFieldValidator);
						}
					}
					displayKeyMap.put(validatorName, internalDispalyMap);
					validatorMap.put(validatorName, internalValidatorMap);
					for (String methodName : validatorMap.keySet()) {
						for (Method method : declaredMethods) {
							if (method.getName().equalsIgnoreCase(methodName)) {
								methodMap.put(methodName, method);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != stream) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Validate field.
	 *
	 * @param validatorName the validator name
	 * @param fieldName the field name
	 * @param fieldValue the field value
	 * @return the list
	 */
	protected final List<String> validateField(String validatorName,
			String fieldName, Object fieldValue) {
		List<String> errors = new LinkedList<String>();
		String nameKey = getDispalyKey(validatorName, fieldName);
		List<String> errorList = validatorMap.get(validatorName).get(fieldName)
				.validate(fieldValue);
		for (String error : errorList) {
			errors.add(nameKey + " : " + error);
		}
		return errors;
	}

	/**
	 * Gets the dispaly key.
	 *
	 * @param validatorName the validator name
	 * @param fieldName the field name
	 * @return the dispaly key
	 */
	protected final String getDispalyKey(String validatorName, String fieldName) {
		return displayKeyMap.get(validatorName).get(fieldName);
	}

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.rest.validator.factoryvalidator.Validator#validate(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> validate(String validatorName, Object obj) {
		List<String> returnList = null;
		Method method = methodMap.get(validatorName);
		if (null != method) {
			try {
				returnList = (List<String>) method.invoke(this, new Object[] {
						validatorName, obj });
			} catch (Exception e) {
				/* expected handled exception */
				e.printStackTrace();
				
			}
		}
		return returnList;
	}

}
