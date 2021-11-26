/**
 * 
 */
package com.aurionpro.generic.fieldvalidator;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;

import com.aurionpro.generic.encryption.RemoteException;
import com.aurionpro.generic.factoryvalidator.AbstractFieldValidator;



// TODO: Auto-generated Javadoc
/**
 * The Class IPAddressValidator.
 *
 * @author bhanu.shukla
 */
public class IPAddressValidator extends AbstractFieldValidator {

	/**
	 * Instantiates a new IP address validator.
	 *
	 * @throws BeansException
	 *             the beans exception
	 * @throws RemoteException
	 *             the remote exception
	 * @throws Exception
	 *             the exception
	 */
	public IPAddressValidator() throws BeansException, RemoteException,
			Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aurionpro.cashpro.rest.validator.factoryvalidator.AbstractFieldValidator
	 * #validate(java.lang.Object)
	 */
	
	/**
	 * TODO:Pravin to check this
	 */
	@Override
	public List<String> validate(Object obj) {
		List<String> errorList = new LinkedList<String>();
		/*LoginRequest loginRequest = (LoginRequest) obj;
		Map<String, String> sessionDetailsMap = new LinkedHashMap<String, String>();
		fillSessionDetailsMap(loginRequest, sessionDetailsMap);
		String userId = ServiceConstants.LOGIN.equalsIgnoreCase(loginRequest
				.getRequestFrom()) ? loginRequest.getUserId()
				: Constants.SYSTEM;
		try {
			CorporateAuthenticationService authenticationService;
			authenticationService = ((RequestProcessor) ((RequestProcessorFactory) ApplicationContextUtil
					.getContext().getBean(ServiceConstants.REQUEST_FACTORY))
					.getRequestProcessor()).getCommonsFactory()
					.getCorporateAuthenticationService();
			
			if (!authenticationService.validateIPRestriction(sessionDetailsMap,
					userId)) {
				errorList.add(ServiceConstants.ACCESS_DENIED);
			}
		} catch (Exception e) {
			errorList.add(ServiceConstants.ACCESS_DENIED);
		}
		if (nextFieldValidator != null && errorList.isEmpty()) {
			errorList.addAll(nextFieldValidator.validate(obj));
		}*/
		return errorList;
	}

	/**
	 * Fill session details map.
	 *
	 * @param loginRequest
	 *            the login request
	 * @param sessionDetailsMap
	 *            the session details map
	 */
/*	private void fillSessionDetailsMap(LoginRequest loginRequest,
			Map<String, String> sessionDetailsMap) {

		sessionDetailsMap.put("tokenId", "" + loginRequest.getSecurityId());
		sessionDetailsMap.put("localIPAddress", loginRequest.getClientDetails()
				.getIpAddress());
		sessionDetailsMap.put("localHostName", loginRequest.getClientDetails()
				.getHostName());
		sessionDetailsMap.put("TokenType", TokenType.LOGIN.name());
		sessionDetailsMap.put("SessionId", loginRequest.getSecurityId());
	}*/
}
