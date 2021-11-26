/*
 * 
 */
package com.aurionpro.generic.base.service;

import com.aurionpro.generic.baserequest.BaseRequestMap;
import com.aurionpro.generic.baserequest.GenericSearchResponse;
import com.aurionpro.generic.exceptions.RemoteException;



// TODO: Auto-generated Javadoc
/**
 * The Interface MakerCheckerWrapperService.
 */
public interface MakerCheckerWrapperService extends
		BaseMakerCheckerWrapperService {
	
	GenericSearchResponse getFilters(BaseRequestMap baseRequestMap) throws RemoteException;

}
