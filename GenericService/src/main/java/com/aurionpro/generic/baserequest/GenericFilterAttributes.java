package com.aurionpro.generic.baserequest;

import java.io.Serializable;

public class GenericFilterAttributes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String displayName;
	private String type;
	
	private String fieldType;
	private boolean mandatory;
	
	private String url;
	
	GenericUrlDataAttributes urlData;
	
	private boolean rangeFilter;
	private String  searchResultIndexes;
	
	private String basedOn = "";
	
	/** The is fieldFor Group or Corporate */
	private String fieldFor;
	
	private String maxLength;
	private String minLength;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GenericUrlDataAttributes getUrlData() {
		return urlData;
	}

	public void setUrlData(GenericUrlDataAttributes urlData) {
		this.urlData = urlData;
	}

	
	public boolean isRangeFilter() {
		return rangeFilter;
	}

	public void setRangeFilter(boolean rangeFilter) {
		this.rangeFilter = rangeFilter;
	}

	public String getSearchResultIndexes() {
		return searchResultIndexes;
	}

	public void setSearchResultIndexes(String searchResultIndexes) {
		this.searchResultIndexes = searchResultIndexes;
	}

	public String getBasedOn() {
		return basedOn;
	}

	public void setBasedOn(String basedOn) {
		this.basedOn = basedOn;
	}

	public String getFieldFor() {
		return fieldFor;
	}

	public void setFieldFor(String fieldFor) {
		this.fieldFor = fieldFor;
	}

	public String getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}

	public String getMinLength() {
		return minLength;
	}

	public void setMinLength(String minLength) {
		this.minLength = minLength;
	}
	


}