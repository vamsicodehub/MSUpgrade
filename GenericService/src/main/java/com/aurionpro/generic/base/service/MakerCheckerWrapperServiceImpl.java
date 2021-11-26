/*
 * 
 */
package com.aurionpro.generic.base.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.aurionpro.generic.baserequest.BaseRequestMap;
import com.aurionpro.generic.baserequest.GenericFilterAttributes;
import com.aurionpro.generic.baserequest.GenericSearchResponse;
import com.aurionpro.generic.exceptions.RemoteException;
import com.aurionpro.generic.utils.GenericFilterReader;


// TODO: Auto-generated Javadoc
/**
 * The Interface MakerCheckerWrapperService.
 */
public abstract class MakerCheckerWrapperServiceImpl implements
		MakerCheckerWrapperService {
	
	@Override
	public GenericSearchResponse getFilters(BaseRequestMap baseRequestMap) throws RemoteException {
		GenericFilterReader filterReader = new GenericFilterReader();
		Map<String, List<GenericFilterAttributes>> filters=filterReader.getGenericFilterData("GenericPayproFilterResponse.xml");
		GenericSearchResponse filterResponse = new GenericSearchResponse();
		String entity = baseRequestMap.getDataMap().get("entityName").toString();
		
		/**
		 *TODO: Pravin to check dependency
		 */
		//Ticket ticket = (Ticket)baseRequestMap.getTicket();
		//String type = (ticket.getGroupId()!=null && !"".equals(ticket.getGroupId()))?"G":"C";
		
		String type ="C";
		
		List<GenericFilterAttributes> responseList = new LinkedList<GenericFilterAttributes>();
		for (GenericFilterAttributes attribute : filters.get(entity)) {
			if (attribute.getFieldFor()==null || (attribute.getFieldFor()!=null && type.equals(attribute.getFieldFor()))) {
				responseList.add(attribute);
			}
		}
		filterResponse.setGenericFilterAttributes(responseList);
		return filterResponse;
	}
	
}
