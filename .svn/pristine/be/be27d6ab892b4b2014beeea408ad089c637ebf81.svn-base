/*
 * 
 */
package com.aurionpro.generic.controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurionpro.generic.annotations.BaseInterceptor;
import com.aurionpro.generic.annotations.UserActivityInterceptor;
import com.aurionpro.generic.base.service.BaseMakerCheckerWrapperService;
import com.aurionpro.generic.baserequest.BaseRequestMap;
import com.aurionpro.generic.baserequest.BaseRequestResponse;
import com.aurionpro.generic.baserequest.BaseResponseMap;
import com.aurionpro.generic.baserequest.NextAuthorizerRequest;
import com.aurionpro.generic.baserequest.NextAuthorizerResponse;
import com.aurionpro.generic.baserequest.RequestListing;
import com.aurionpro.generic.baserequest.ResponseListing;
import com.aurionpro.generic.constants.RestConstants;
import com.aurionpro.generic.exceptions.BaseException;
import com.aurionpro.generic.vlaidator.util.ValidatorUtils;


// TODO: Auto-generated Javadoc
/**
 * The Class MakerCheckerController.
 */
@Controller("com.aurionpro.cashpro.rest.controller.MakerCheckerController")
public abstract class MakerCheckerController {

	/** The Constant GET_PENDING_LIST. */
	protected final String GET_PENDING_LIST = "/private/getPendingList";

	/** The Constant GET_AUTHORIZED_LIST. */
	protected final String GET_AUTHORIZED_LIST = "/private/getAuthorizedList";

	/** The Constant GET_REJECTED_LIST. */
	protected final String GET_REJECTED_LIST = "/private/getRejectedList";

	/** The Constant AUTHORIZE. */
	protected final String AUTHORIZE = "/private/authorize";

	/** The Constant REJECT. */
	protected final String REJECT = "/private/reject";

	/** The acceptreject. */
	protected final String ACCEPTREJECT = "/private/acceptReject";

	/** The create. */
	protected final String CREATE = "/private/create";

	/** The delete. */
	protected final String DELETE = "/private/delete";

	/** The update. */
	protected final String UPDATE = "/private/update";

	/** The view. */
	protected final String VIEW = "/private/view";

	/** The Constant GET_NEXT_AUTHORIZERS. */
	protected final String GET_NEXT_AUTHORIZERS = "/private/getNextAuthorizers";

	/** The Constant ENABLE. */
	private final String ENABLE = "/private/enable";
	/** The Constant GET_DISABLED_LIST. */
	private final String GET_DISABLED_LIST = "/private/getDisabledList";
	/** The Constant DISABLE. */
	private final String DISABLE = "/private/disable";
	
	/** The Constant GET_ALL_COUNT. */
	protected final String GET_ALL_COUNT = "/private/getAllCount";
	
	private final String ENTITYKEY = "MAKERCHECKER";
	
	protected final String VERIFY = "/private/verify";
	
	protected final String DECLINE = "/private/decline";
	
	protected final String GET_AUTHORIZER_TO_SELECT = "/private/getAuthorizerToSelect";
	
	protected final String SET_AUTHORIZER_TO_SELECT = "/private/setAuthorizerToSelect";

	/**
	 * Gets the service.
	 *
	 * @return the service
	 * @throws BeansException
	 *             the beans exception
	 * @throws RemoteException
	 *             the remote exception
	 * @throws Exception
	 *             the exception
	 */
	public abstract BaseMakerCheckerWrapperService getService()
			throws BeansException, RemoteException, Exception;

	
	protected String getActionPath() {
		return null;
	}
	
	/**
	 * Creates the.
	 *
	 * @param baseRequestResponse
	 *            the base request response
	 * @param httpRequest
	 *            the http request
	 * @return the base response map
	 * @throws RemoteException
	 *             the remote exception
	 * @throws BaseException
	 *             the base exception
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = CREATE, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Create")
	@ResponseBody
	public BaseResponseMap create(@RequestBody BaseRequestResponse baseRequestResponse,HttpServletRequest httpRequest) throws RemoteException,BaseException, Exception {

		ValidatorUtils.validate(baseRequestResponse, getClass().getCanonicalName(), "create");

		BaseResponseMap create = getService().create(baseRequestResponse);
		create.setEntity(baseRequestResponse.getEntity());
		create.setEntityIdentifier(baseRequestResponse.getEntityIdentifier());
		return create;
	}

	/**
	 * Update.
	 *
	 * @param baseRequestResponse
	 *            the base request response
	 * @param httpRequest
	 *            the http request
	 * @return the base response map
	 * @throws RemoteException
	 *             the remote exception
	 * @throws BaseException
	 *             the base exception
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = UPDATE, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Update")
	@ResponseBody
	/*
	 * public BaseResponseMap update(
	 * 
	 * @RequestBody T baseRequestResponse, HttpServletRequest httpRequest)
	 * throws RemoteException, BaseException, Exception {
	 */
	public BaseResponseMap update(@RequestBody BaseRequestResponse baseRequestResponse,HttpServletRequest httpRequest) throws RemoteException,BaseException, Exception {
		ValidatorUtils.validate(baseRequestResponse, getClass().getCanonicalName(), "update");

		BaseResponseMap update = getService().update(baseRequestResponse);
		update.setEntity(baseRequestResponse.getEntity());
		update.setEntityIdentifier(baseRequestResponse.getEntityIdentifier());
		return update;
	}

	/**
	 * View.
	 *
	 * @param request
	 *            the request
	 * @param httpRequest
	 *            the http request
	 * @return the base request response
	 * @throws Exception
	 *             the exception
	 */
	/*
	 * @RequestMapping(value = VIEW, method = RequestMethod.POST)
	 * 
	 * @BaseInterceptor
	 * 
	 * @ResponseBody public T view(@RequestBody BaseRequestMap request,
	 * HttpServletRequest httpRequest) throws Exception {
	 * ValidatorUtils.validate(request,
	 * MakerCheckerController.class.getCanonicalName(), "view");
	 * 
	 * return (T) getService().view(request); }
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = VIEW, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "View")
	@ResponseBody
	public BaseRequestResponse view(@RequestBody BaseRequestMap request,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(request,MakerCheckerController.class.getCanonicalName(), "view");

		return (BaseRequestResponse) getService().view(request);
	}

	/**
	 * Delete.
	 *
	 * @param request
	 *            the request
	 * @param httpRequest
	 *            the http request
	 * @return the base request response
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = DELETE, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Delete")
	@ResponseBody
	public BaseResponseMap delete(@RequestBody BaseRequestMap request,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(request,MakerCheckerController.class.getCanonicalName(), "delete");

		return getService().delete(request);
	}

	/**
	 * Gets the pending list.
	 *
	 * @param listingRequest
	 *            the listing request
	 * @param httpRequest
	 *            the http request
	 * @return the pending list
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = GET_PENDING_LIST, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Pending List View")
	@ResponseBody
	public ResponseListing getPendingList(@RequestBody RequestListing listingRequest,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(listingRequest,MakerCheckerController.class.getCanonicalName(),"listingPageValidator");

		List<String> access = getAccess(listingRequest.getEntityName(),listingRequest.getSecurityId());
		listingRequest.setAccess(access);

		ResponseListing pendingList = getService().getPendingList(listingRequest);

		pendingList.setAccess(access);
		setAdditionFieldsInResponse(listingRequest, httpRequest, pendingList);

		return pendingList;
	}

	protected void setAdditionFieldsInResponse(RequestListing listingRequest,	HttpServletRequest httpRequest, ResponseListing responseListing) {
		/**
		 *todo: Pravin to check 
		 */
		/*
		if (this instanceof Enable2FA) {
			Map<String, Object> enrichments = new HashMap<String, Object>();
			UserDetails attribute = (UserDetails) ApplicationCache.getAttribute(listingRequest.getSecurityId(),ApplicationCacheContstants.USER_DETAILS);
			enrichments.put("selectedAuthType", attribute.getSelectedAuthType());
			responseListing.setEnrichments(enrichments);
		}
	*/}

	/**
	 * Gets the authorized list.
	 *
	 * @param listingRequest
	 *            the listing request
	 * @param httpRequest
	 *            the http request
	 * @return the authorized list
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = GET_AUTHORIZED_LIST, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Authorized List View")
	@ResponseBody
	public ResponseListing getAuthorizedList(@RequestBody RequestListing listingRequest,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(listingRequest,MakerCheckerController.class.getCanonicalName(),"listingPageValidator");

		List<String> access = getAccess(listingRequest.getEntityName(),listingRequest.getSecurityId());
		listingRequest.setAccess(access);

		ResponseListing authorizedList = getService().getAuthorizedList(listingRequest);

		authorizedList.setAccess(access);
		setAdditionFieldsInResponse(listingRequest, httpRequest, authorizedList);

		return authorizedList;
	}

	/**
	 * Gets the rejected list.
	 *
	 * @param listingRequest
	 *            the listing request
	 * @param httpRequest
	 *            the http request
	 * @return the rejected list
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = GET_REJECTED_LIST, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Rejected List View")
	@ResponseBody
	public ResponseListing getRejectedList(@RequestBody RequestListing listingRequest,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(listingRequest,MakerCheckerController.class.getCanonicalName(),"listingPageValidator");
		List<String> access = getAccess(listingRequest.getEntityName(),listingRequest.getSecurityId());
		listingRequest.setAccess(access);

		ResponseListing rejectedList = getService().getRejectedList(listingRequest);

		rejectedList.setAccess(access);
		setAdditionFieldsInResponse(listingRequest, httpRequest, rejectedList);

		return rejectedList;
	}

	/**
	 * VERIFY.
	 *
	 * @param requestMap
	 *            the request map
	 * @param httpRequest
	 *            the http request
	 * @return the base response map
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = VERIFY, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Verify")
	@ResponseBody
	public BaseResponseMap verify(@RequestBody BaseRequestMap requestMap, HttpServletRequest httpRequest) throws Exception {
		
		/**
		 *	TODO:Pravin to check this
		 */
		
		/*UserDetails userDetails = (UserDetails) ApplicationCache.getAttribute(requestMap.getSecurityId(),ApplicationCacheContstants.USER_DETAILS);
		if (this instanceof Enable2FA && (AuthenticationType.HARDTOKEN.name().equals(userDetails.getSelectedAuthType()) || AuthenticationType.SOFTTOKEN.name().equals(userDetails.getSelectedAuthType()))) {
			requestMap.getClientDetails().getEnrichmentMap().put("TokenType", TokenType.AUTHORIZATION.name());
			requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "Y");
		} else {
			requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "N");
		}*/
		ValidatorUtils.validate(requestMap,MakerCheckerController.class.getCanonicalName(), "verify");

		return getService().verify(requestMap);
	}

	@RequestMapping(value = DECLINE, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "decline")
	@ResponseBody
	public BaseResponseMap decline(@RequestBody BaseRequestMap requestMap, HttpServletRequest httpRequest) throws Exception {
		
			requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "N");
		ValidatorUtils.validate(requestMap,MakerCheckerController.class.getCanonicalName(), "decline");
		return getService().decline(requestMap);
	}

	
	/**
	 * Authorize.
	 *
	 * @param requestMap
	 *            the request map
	 * @param httpRequest
	 *            the http request
	 * @return the base response map
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = AUTHORIZE, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Authorize")
	@ResponseBody
	public BaseResponseMap authorize(@RequestBody BaseRequestMap requestMap, HttpServletRequest httpRequest) throws Exception {
		
		/**
		 * TODO :Pravin to check this
		 */
		
		/*UserDetails userDetails = (UserDetails) ApplicationCache.getAttribute(requestMap.getSecurityId(),ApplicationCacheContstants.USER_DETAILS);
		if (this instanceof Enable2FA && (AuthenticationType.HARDTOKEN.name().equals(userDetails.getSelectedAuthType()) || AuthenticationType.SOFTTOKEN.name().equals(userDetails.getSelectedAuthType()))) {
			requestMap.getClientDetails().getEnrichmentMap().put("TokenType", TokenType.AUTHORIZATION.name());
			requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "Y");
		} else {
			requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "N");
		}*/
		ValidatorUtils.validate(requestMap,MakerCheckerController.class.getCanonicalName(), "authorize");

		return getService().authorize(requestMap);
	}

	/**
	 * Reject.
	 *
	 * @param requestMap
	 *            the request map
	 * @param httpRequest
	 *            the http request
	 * @return the base response map
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = REJECT, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Reject")
	@ResponseBody
	public BaseResponseMap reject(@RequestBody BaseRequestMap requestMap,HttpServletRequest httpRequest) throws Exception {

		/*
		 * if (this instanceof Enable2FA) {
		 * requestMap.getClientDetails().getEnrichmentMap() .put("TokenType",
		 * TokenType.AUTHORIZATION.name());
		 * requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "Y");
		 * 
		 * if (requestMap.getClientDetails().getSource().equals(Source.MOBILE))
		 * { requestMap.getDataMap().put("tokenNo", "123"); } } else {
		 * requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "N"); }
		 */

		requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "N");

		ValidatorUtils.validate(requestMap,MakerCheckerController.class.getCanonicalName(), "reject");

		return getService().reject(requestMap);
	}

	/**
	 * Accept reject.
	 *
	 * @param requestMap
	 *            the request map
	 * @param httpRequest
	 *            the http request
	 * @return the base response map
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = ACCEPTREJECT, method = RequestMethod.POST)
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Accept Reject")
	@BaseInterceptor
	@ResponseBody
	public BaseResponseMap acceptReject(@RequestBody BaseRequestMap requestMap,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(requestMap,MakerCheckerController.class.getCanonicalName(),"acceptReject");

		return getService().acceptReject(requestMap);
	}

	/**
	 * Gets the next authorizers.
	 *
	 * @param listingRequest
	 *            the listing request
	 * @param httpRequest
	 *            the http request
	 * @return the next authorizers
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = GET_NEXT_AUTHORIZERS, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Next Authorizers View")
	@ResponseBody
	public NextAuthorizerResponse getNextAuthorizers(@RequestBody NextAuthorizerRequest listingRequest,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(listingRequest,MakerCheckerController.class.getCanonicalName(),"getNextAuthorizers");

		return getService().getNextAuthorizers(listingRequest);
	}

	@RequestMapping(value = ENABLE, method = RequestMethod.POST)
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Enable")
	@BaseInterceptor
	@ResponseBody
	public BaseResponseMap enable(@RequestBody BaseRequestMap baseRequestMap,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(baseRequestMap,MakerCheckerController.class.getCanonicalName(), "enable");

		return getService().enable(baseRequestMap);

	}

	/**
	 * Gets the pending list.
	 *
	 * @param baseRequestMap
	 *            the base request map
	 * @param httpRequest
	 *            the http request
	 * @return the pending list
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = DISABLE, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Disable")
	@ResponseBody
	public BaseResponseMap disable(@RequestBody BaseRequestMap baseRequestMap,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(baseRequestMap,MakerCheckerController.class.getCanonicalName(), "disable");

		return getService().disable(baseRequestMap);

	}

	/**
	 * Gets the disabled list.
	 *
	 * @param listingRequest
	 *            the listing request
	 * @param httpRequest
	 *            the http request
	 * @return the disabled list
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = GET_DISABLED_LIST, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Disable List View")
	@ResponseBody
	public ResponseListing getDisabledList(@RequestBody RequestListing listingRequest,HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(listingRequest,MakerCheckerController.class.getCanonicalName(),"listingPageValidator");
		List<String> access = getAccess(listingRequest.getEntityName(),listingRequest.getSecurityId());
		listingRequest.setAccess(access);
		ResponseListing disabledList = getService().getDisabledList(listingRequest);
		disabledList.setAccess(access);
		setAdditionFieldsInResponse(listingRequest, httpRequest, disabledList);
		return disabledList;
	}

	/**
	 * Gets all count.
	 *
	 * @param listingRequest
	 *            the listing request
	 * @param httpRequest
	 *            the http request
	 * @return the disabled list
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = GET_ALL_COUNT, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "Get All Count")
	@ResponseBody
	public ResponseListing getAllCount(@RequestBody RequestListing listingRequest,HttpServletRequest httpRequest) throws Exception {

		/*ValidatorUtils.validate(listingRequest,MakerCheckerController.class.getCanonicalName(),"listingPageValidator");*/
		List<String> access = getAccess(listingRequest.getEntityName(),listingRequest.getSecurityId());
		listingRequest.setAccess(access);
		ResponseListing allCountList = getService().getAllCount(listingRequest);
		allCountList.setAccess(access);
		setAdditionFieldsInResponse(listingRequest, httpRequest, allCountList);
		return allCountList;
	}
	
	@RequestMapping(value = GET_AUTHORIZER_TO_SELECT, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "GET AUTHORIZER TO SELECT")
	@ResponseBody
	public BaseResponseMap getAuthorizerToSelect(@RequestBody BaseRequestMap baseRequestMap, HttpServletRequest httpRequest) throws Exception {
		
		ValidatorUtils.validate(baseRequestMap,MakerCheckerController.class.getCanonicalName(),"getAuthorizerToSelect");
		if(null == getActionPath()) {
			throw new Exception("getActionPath Not override");
		}
		baseRequestMap.getDataMap().put("entityName", getActionPath());
		BaseResponseMap response = new BaseResponseMap();
		response = getService().getAuthorizerToSelect(baseRequestMap);
		Map<String, Object> reqDataMap = baseRequestMap.getDataMap();
		if(reqDataMap.get("debitAccountId")!=null && !"".equals(reqDataMap.get("debitAccountId")) && !"null".equals(reqDataMap.get("debitAccountId"))){
			baseRequestMap.getDataMap().put("usersMatrix", response.getDataMap().get("usersMatrix"));
		    BaseResponseMap res = getService().checkAccountWiseAccessForUsers(baseRequestMap);
			response.getDataMap().put("usersMatrix", res.getDataMap().get("usersMatrix"));
		}
		return response;
	}
	
	@RequestMapping(value = SET_AUTHORIZER_TO_SELECT, method = RequestMethod.POST)
	@BaseInterceptor
	@UserActivityInterceptor (Entity = ENTITYKEY , Operation = "SET AUTHORIZER TO SELECT")
	@ResponseBody
	public BaseResponseMap setAuthorizerToSelect(@RequestBody BaseRequestMap baseRequestMap, HttpServletRequest httpRequest) throws Exception {

		ValidatorUtils.validate(baseRequestMap,MakerCheckerController.class.getCanonicalName(),"setAuthorizerToSelect");

		return getService().setAuthorizerToSelect(baseRequestMap);
	}
	
	
	/**
	 *TODO: Pravin to check this
	 * */
	protected List<String> getAccess(String entityName, String securityId) {
		
		return null;
		/*

		Map<String, Map<String, List<String>>> accessMap = (Map<String, Map<String, List<String>>>) ApplicationCache.getAttribute(securityId,ApplicationCacheContstants.MENU_ACCESS_MAP);

		if (getClass().isAnnotationPresent(ProductType.class)) {

			ProductType annotation = getClass().getAnnotation(ProductType.class);

			PRODUCT product = annotation.product();
			String productIdValue = EncryptUtils.encryptId(Long.parseLong(product.toString()));
			Map<String, List<String>> map = accessMap.get(productIdValue);

			return map.get(entityName);
		}

		return null;
	*/}
	
}
