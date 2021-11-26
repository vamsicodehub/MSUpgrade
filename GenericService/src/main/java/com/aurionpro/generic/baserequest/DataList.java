/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class DataList.
 */
//
@JsonInclude(Include.NON_NULL)
public class DataList implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 578542681203814570L;

	/** The id. */
	private String id;

	/** The display name. */
	private String displayName;

	/** The enrichments. */
	private Map<String, String> enrichments;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DataList other = (DataList) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the enrichments.
	 *
	 * @return the enrichments
	 */
	public Map<String, String> getEnrichments() {
		return enrichments;
	}

	/**
	 * Sets the enrichments.
	 *
	 * @param enrichments the enrichments
	 */
	public void setEnrichments(Map<String, String> enrichments) {
		this.enrichments = enrichments;
	}

}
