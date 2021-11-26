/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.util.HashMap;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class NextAuthorizerResponse.
 */
public class NextAuthorizerResponse extends BaseResponse {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4930352083254676190L;

	/** The auth level. */
	private String authLevel;
	
	/** The authorization mode. */
	private String authorizationMode;
	
	/** The allow skip. */
	private String allowSkip;
	
	/** The map. */
	private HashMap customMap;
	
	/** The slab mst map. */
	private HashMap slabMstMap;
	
	/** The header list. */
	private List<ListHeader> headerList;
	
	/** The authorizer list. */
	private List<StringBuffer[]> nextAuthorizerDetail;

	/**
	 * Gets the auth level.
	 *
	 * @return the auth level
	 */
	public String getAuthLevel() {
		return authLevel;
	}

	/**
	 * Sets the auth level.
	 *
	 * @param authLevel the new auth level
	 */
	public void setAuthLevel(String authLevel) {
		this.authLevel = authLevel;
	}

	/**
	 * Gets the authorization mode.
	 *
	 * @return the authorization mode
	 */
	public String getAuthorizationMode() {
		return authorizationMode;
	}

	/**
	 * Sets the authorization mode.
	 *
	 * @param authorizationMode the new authorization mode
	 */
	public void setAuthorizationMode(String authorizationMode) {
		this.authorizationMode = authorizationMode;
	}

	/**
	 * Gets the allow skip.
	 *
	 * @return the allow skip
	 */
	public String getAllowSkip() {
		return allowSkip;
	}

	/**
	 * Sets the allow skip.
	 *
	 * @param allowSkip the new allow skip
	 */
	public void setAllowSkip(String allowSkip) {
		this.allowSkip = allowSkip;
	}


	/**
	 * Gets the slab mst map.
	 *
	 * @return the slab mst map
	 */
	public HashMap getSlabMstMap() {
		return slabMstMap;
	}

	/**
	 * Sets the slab mst map.
	 *
	 * @param slabMstMap the slab mst map
	 */
	public void setSlabMstMap(HashMap slabMstMap) {
		this.slabMstMap = slabMstMap;
	}

	/**
	 * Gets the custom map.
	 *
	 * @return the custom map
	 */
	public HashMap getCustomMap() {
		return customMap;
	}

	/**
	 * Sets the custom map.
	 *
	 * @param customMap the custom map
	 */
	public void setCustomMap(HashMap customMap) {
		this.customMap = customMap;
	}

	/**
	 * Gets the next authorizer detail.
	 *
	 * @return the next authorizer detail
	 */
	public List<StringBuffer[]> getNextAuthorizerDetail() {
		return nextAuthorizerDetail;
	}

	/**
	 * Sets the next authorizer detail.
	 *
	 * @param nextAuthorizerDetail the new next authorizer detail
	 */
	public void setNextAuthorizerDetail(List<StringBuffer[]> nextAuthorizerDetail) {
		this.nextAuthorizerDetail = nextAuthorizerDetail;
	}

	/**
	 * Gets the header list.
	 *
	 * @return the header list
	 */
	public List<ListHeader> getHeaderList() {
		return headerList;
	}

	/**
	 * Sets the header list.
	 *
	 * @param headerList the new header list
	 */
	public void setHeaderList(List<ListHeader> headerList) {
		this.headerList = headerList;
	}

	@Override
	public String getEntityIdentifier() {
		return "";
	}
	
	

}
