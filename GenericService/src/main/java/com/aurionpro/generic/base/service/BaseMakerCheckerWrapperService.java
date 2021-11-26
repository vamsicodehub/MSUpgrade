/*
 * 
 */
package com.aurionpro.generic.base.service;

import com.aurionpro.generic.baserequest.BaseRequestMap;
import com.aurionpro.generic.baserequest.BaseRequestResponse;
import com.aurionpro.generic.baserequest.BaseResponseMap;
import com.aurionpro.generic.baserequest.NextAuthorizerRequest;
import com.aurionpro.generic.baserequest.NextAuthorizerResponse;
import com.aurionpro.generic.baserequest.RequestListing;
import com.aurionpro.generic.baserequest.ResponseListing;
import com.aurionpro.generic.exceptions.BaseException;
import com.aurionpro.generic.exceptions.BusinessValidationException;
import com.aurionpro.generic.exceptions.RemoteException;

// TODO: Auto-generated Javadoc
/**
 * The Interface MakerCheckerWrapperService.
 */
public interface BaseMakerCheckerWrapperService extends BaseWrapperService {

	/**
	 * Gets the pending list.
	 *
	 * @param requestList
	 *            the request list
	 * @return the pending list
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	ResponseListing getPendingList(RequestListing requestList)
			throws BaseException, RemoteException;

	/**
	 * Gets the next authorizers.
	 *
	 * @param requestList
	 *            the request list
	 * @return the next authorizers
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	NextAuthorizerResponse getNextAuthorizers(NextAuthorizerRequest requestList)
			throws BaseException, RemoteException;

	/**
	 * Gets the authorized list.
	 *
	 * @param requestList
	 *            the request list
	 * @return the authorized list
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	ResponseListing getAuthorizedList(RequestListing requestList)
			throws BaseException, RemoteException;

	/**
	 * Gets the rejected list.
	 *
	 * @param requestList
	 *            the request list
	 * @return the rejected list
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	ResponseListing getRejectedList(RequestListing requestList)
			throws BaseException, RemoteException;

	/**
	 * Authorize.
	 *
	 * @param requestMap
	 *            the request map
	 * @return the base response map
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	BaseResponseMap authorize(BaseRequestMap requestMap) throws BaseException,
			RemoteException;

	/**
	 * Reject.
	 *
	 * @param requestMap
	 *            the request map
	 * @return the base response map
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	BaseResponseMap reject(BaseRequestMap requestMap) throws BaseException,
			RemoteException;

	/**
	 * Accept reject.
	 *
	 * @param requestMap
	 *            the request map
	 * @return the base response map
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 * @throws Exception
	 *             the exception
	 */
	BaseResponseMap acceptReject(BaseRequestMap requestMap)
			throws BaseException, RemoteException, Exception;

	/**
	 * Creates the.
	 *
	 * @param baseResponseMap
	 *            the base response map
	 * @return the base response map
	 * @throws RemoteException
	 *             the remote exception
	 * @throws BusinessValidationException
	 *             the buisness validation exception
	 * @throws Exception
	 *             the exception
	 */
	BaseResponseMap create(BaseRequestResponse baseResponseMap)
			throws RemoteException, BusinessValidationException, Exception;

	/**
	 * Creates the.
	 *
	 * @param baseResponseMap
	 *            the base response map
	 * @return the base response map
	 * @throws RemoteException
	 *             the remote exception
	 * @throws BusinessValidationException
	 *             the buisness validation exception
	 * @throws Exception
	 *             the exception
	 */
	BaseResponseMap update(BaseRequestResponse baseResponseMap)
			throws RemoteException, BusinessValidationException, Exception;

	/**
	 * View.
	 *
	 * @param requestMap
	 *            the request map
	 * @return the single payment detail
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	BaseRequestResponse view(BaseRequestMap requestMap) throws BaseException,
			RemoteException;

	/**
	 * Delete.
	 *
	 * @param requestMap
	 *            the request map
	 * @return the base request response
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 * @throws Exception
	 *             the exception
	 */
	BaseResponseMap delete(BaseRequestMap requestMap) throws BaseException,
			RemoteException, Exception;

	/**
	 * Gets the disabled list.
	 *
	 * @param listingReqest
	 *            the listing reqest
	 * @return the disabled list
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	ResponseListing getDisabledList(RequestListing listingReqest)
			throws BaseException, RemoteException;

	/**
	 * Enable.
	 *
	 * @param requestMap
	 *            the request map
	 * @return the base response map
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 * @throws BusinessValidationException
	 *             the business validation exception
	 * @throws Exception
	 *             the exception
	 */
	BaseResponseMap enable(BaseRequestMap requestMap) throws BaseException,
			RemoteException, BusinessValidationException, Exception;

	/**
	 * Disable.
	 *
	 * @param requestMap
	 *            the request map
	 * @return the base response map
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 * @throws BusinessValidationException
	 *             the business validation exception
	 * @throws Exception
	 *             the exception
	 */
	BaseResponseMap disable(BaseRequestMap requestMap) throws BaseException,
			RemoteException, BusinessValidationException, Exception;

	BaseResponseMap viewErrors(BaseRequestMap request) throws Exception;

	
	/**
	 * Gets all count.
	 *
	 * @param listingReqest
	 *            the listing reqest
	 * @return the all count list
	 * @throws BaseException
	 *             the base exception
	 * @throws RemoteException
	 *             the remote exception
	 */
	ResponseListing getAllCount(RequestListing listingReqest)
			throws BaseException, RemoteException;

	BaseResponseMap verify(BaseRequestMap requestMap) throws BaseException, RemoteException;
	
	BaseResponseMap decline(BaseRequestMap requestMap) throws BaseException, RemoteException;
	
	BaseResponseMap getAuthorizerToSelect(BaseRequestMap baseRequestMap) throws RemoteException, Exception;

	BaseResponseMap setAuthorizerToSelect(BaseRequestMap baseRequestMap) throws RemoteException, Exception;
	
	public BaseResponseMap checkAccountWiseAccessForUsers(BaseRequestMap baseRequestMap) throws RemoteException, Exception;
}
