/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseRequestMap.
 */

@AllArgsConstructor
@NoArgsConstructor
public class BaseRequestMap extends BaseRequest {

	private static final long serialVersionUID = 566824891581277410L;
	private List<Filter> filters;
	private Map<String, Object> dataMap;
	
	public List<Filter> getFilters() {
		return filters;
	}
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	

}
