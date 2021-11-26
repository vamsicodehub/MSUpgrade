/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseResponseMap.
 */
@JsonInclude(Include.NON_NULL)
public class BaseResponseMap extends BaseResponse  {
	
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1694687815289526821L;
	
	/** The data map. */
	private Map<String,Object> dataMap ;
	
	/** The data map. */
	private String entityIdentifier ="" ;
	
	/** The data map. */
	private String entity  = "";

	/**
	 * Gets the data map.
	 *
	 * @return the data map
	 */
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	/**
	 * Sets the data map.
	 *
	 * @param dataMap the data map
	 */
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getEntityIdentifier() {
		return entityIdentifier;
	}

	public void setEntityIdentifier(String entityIdentifier) {
		this.entityIdentifier = entityIdentifier;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	
	
}
