package com.aurionpro.cashpro.commons.security.authorization;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*import com.aurionpro.cashpro.commons.security.dto.EntityDTO;
import com.aurionpro.cashpro.commons.security.dto.OperationDTO;
*/
public class AuthorizationMatrix implements Serializable {
	private static final long serialVersionUID = 6906918902901587921L;
	
//	SV:27-12-2007 EntityDTOs and OperationDTOs have been removed from the Matrix as it makes the session 
//	object heavy and poses a limitation on online users on the server, gives out of memory exception.
//	To optimize this the ApplicationContext in Service layer and AuthorizationMatrixManager in Web layer
//	now have a map of entities and operations per product, all the calls are routed to this instead of AuthorizationMatrix itself.
	
	/*private List<EntityDTO> entities;
	private List<OperationDTO> operations;*/
	private Map authorizations;
	
	private Map<String,String> parentChildMap = new HashMap<String, String>();
	
	public AuthorizationMatrix() {
		super();
	}

	

	public Map getAuthorizations() {
		return authorizations;
	}



	public void setAuthorizations(Map authorizations) {
		this.authorizations = authorizations;
	}


/*
	public List<EntityDTO> getEntities() {
		return entities;
	}

	public void setEntities(List<EntityDTO> entities) {
		this.entities = entities;
	}

	public List<OperationDTO> getOperations() {
		return operations;
	}

	public void setOperations(List<OperationDTO> operations) {
		this.operations = operations;
	}*/
	
	public Map<String, String> getParentChildMap() {
		return parentChildMap;
	}

	public void setParentChildMap(Map<String, String> parentChildMap) {
		this.parentChildMap = parentChildMap;
	}
}
