package com.aurionpro.generic.baserequest;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericUrlDataAttributes implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 578542681203814570L;

	private String pageNumber;
	private String searchType;
	
	/** The filters. */
	private List<FilterAttributes> filters;
	
	private DataMapAttributes dataMap;
	
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	 
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public List<FilterAttributes> getFilters() {
		return filters;
	}
	public void setFilters(List<FilterAttributes> filters) {
		this.filters = filters;
	}
	public DataMapAttributes getDataMap() {
		return dataMap;
	}
	public void setDataMap(DataMapAttributes dataMap) {
		this.dataMap = dataMap;
	}
	
}
