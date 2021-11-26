/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponseListing.
 */
@JsonInclude(Include.NON_NULL)
public class ResponseListing extends BaseResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4131710980600289649L;

	/** The entity name. */
	private String entityName;

	/** The headers. */
	private List<ListHeader> headers;

	/** The data list. */
	private Collection<String[]> dataList;

	/** The filters. */
	private List<Filter> filters;

	/** The page number. */
	private Integer pageNumber;

	/** The total pages. */
	private Integer totalPages;

	/** The total records. */
	private Integer totalRecords;

	/** The access. */
	private List<String> access;

	/** The links. */
	private List<List<Link>> links;

	private Map<String, Object> enrichments;
	
	private List<Map<String,Object> > listCount;
	
	private String header;
	/** The total Pending Count. *//*
	private Integer totalPendingCount;
	
	*//** The total Authorised Count. *//*
	private Integer totalAuthCount;
	
	*//** The total Rejected Count. *//*
	private Integer totalRejectedCount;
	
	*//** The total Disable Count. *//*
	private Integer totalDisableCount;
	
	*//** The total Draft Count. *//*
	private Integer totalDraftCount;
*/
	/** The total Pending Count. *//*
	private Integer totalPendingCount;
	
	*//** The total Authorised Count. *//*
	private Integer totalAuthCount;
	
	*//** The total Rejected Count. *//*
	private Integer totalRejectedCount;
	
	*//** The total Disable Count. *//*
	private Integer totalDisableCount;
	
	*//** The total Draft Count. *//*
	private Integer totalDraftCount;
*/
	/**
	 * Gets the page number.
	 *
	 * @return the page number
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * Sets the page number.
	 *
	 * @param pageNumber
	 *            the new page number
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * Gets the total pages.
	 *
	 * @return the total pages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * Sets the total pages.
	 *
	 * @param totalPages
	 *            the new total pages
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * Gets the entity name.
	 *
	 * @return the entity name
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * Sets the entity name.
	 *
	 * @param entityName
	 *            the new entity name
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * Gets the data list.
	 *
	 * @return the data list
	 */
	public Collection<String[]> getDataList() {
		return dataList;
	}

	/**
	 * Sets the data list.
	 *
	 * @param dataList
	 *            the new data list
	 */
	public void setDataList(Collection<String[]> dataList) {
		this.dataList = dataList;
	}

	/**
	 * Gets the filters.
	 *
	 * @return the filters
	 */
	public List<Filter> getFilters() {
		return filters;
	}

	/**
	 * Sets the filters.
	 *
	 * @param filters
	 *            the new filters
	 */
	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public List<ListHeader> getHeaders() {
		return headers;
	}

	/**
	 * Sets the headers.
	 *
	 * @param headers
	 *            the new headers
	 */
	public void setHeaders(List<ListHeader> headers) {
		this.headers = headers;
	}

	/**
	 * Gets the total records.
	 *
	 * @return the total records
	 */
	public Integer getTotalRecords() {
		return totalRecords;
	}

	/**
	 * Sets the total records.
	 *
	 * @param totalRecords
	 *            the new total records
	 */
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * Gets the access.
	 *
	 * @return the access
	 */
	public List<String> getAccess() {
		return access;
	}

	/**
	 * Sets the access.
	 *
	 * @param access
	 *            the new access
	 */
	public void setAccess(List<String> access) {
		this.access = access;
	}

	/**
	 * Gets the links.
	 *
	 * @return the links
	 */
	public List<List<Link>> getLinks() {
		return links;
	}

	/**
	 * Sets the links.
	 *
	 * @param links
	 *            the new links
	 */
	public void setLinks(List<List<Link>> links) {
		this.links = links;
	}

	public Map<String, Object> getEnrichments() {
		return enrichments;
	}

	public void setEnrichments(Map<String, Object> enrichments) {
		this.enrichments = enrichments;
	}
	
	/*public Integer getTotalPendingCount() {
		return totalPendingCount;
	}

	public void setTotalPendingCount(Integer totalPendingCount) {
		this.totalPendingCount = totalPendingCount;
	}

	public Integer getTotalAuthCount() {
		return totalAuthCount;
	}

	public void setTotalAuthCount(Integer totalAuthCount) {
		this.totalAuthCount = totalAuthCount;
	}

	public Integer getTotalRejectedCount() {
		return totalRejectedCount;
	}

	public void setTotalRejectedCount(Integer totalRejectedCount) {
		this.totalRejectedCount = totalRejectedCount;
	}

	public Integer getTotalDisableCount() {
		return totalDisableCount;
	}

	public void setTotalDisableCount(Integer totalDisableCount) {
		this.totalDisableCount = totalDisableCount;
	}

	public Integer getTotalDraftCount() {
		return totalDraftCount;
	}

	public void setTotalDraftCount(Integer totalDraftCount) {
		this.totalDraftCount = totalDraftCount;
	}
	*/
	public List<Map<String,Object> > getListCount() {
		return listCount;
	}

	public void setListCount(List<Map<String,Object> > listCount) {
		this.listCount = listCount;
	}
	
	
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public String getEntityIdentifier() {
		return ""; 
	}

	
}
