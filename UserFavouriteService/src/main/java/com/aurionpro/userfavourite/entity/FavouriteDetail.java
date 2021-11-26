/**
 * 
 */
package com.aurionpro.userfavourite.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class FavouriteDetail.
 *
 * @author Pravin.Devade
 */
@JsonInclude(Include.NON_NULL)
public class FavouriteDetail extends BaseRequestResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3510224932835144660L;

	/** The id. */
	private String id;
	/** The module name. */
	private String moduleName;

	/** The type. */
	private String favouriteType;

	/** The cash pro product id. */
	private String cashProProductId;

	/** The favourite detail. */
	private String favouriteDetail;

	/** The user id. */
	private String userId;

	/** The modified by. */
	private String modifiedBy;

	/** The modified on. */
	private Date modifiedOn;
	
	/** The modified on. */
	private String favouriteName;

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
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the module name.
	 *
	 * @return the module name
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * Sets the module name.
	 *
	 * @param moduleName
	 *            the new module name
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * Gets the favourite detail.
	 *
	 * @return the favourite detail
	 */
	public String getFavouriteDetail() {
		return favouriteDetail;
	}

	/**
	 * Sets the favourite detail.
	 *
	 * @param favouriteDetail
	 *            the new favourite detail
	 */
	public void setFavouriteDetail(String favouriteDetail) {
		this.favouriteDetail = favouriteDetail;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy
	 *            the new modified by
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Gets the modified on.
	 *
	 * @return the modified on
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * Sets the modified on.
	 *
	 * @param modifiedOn
	 *            the new modified on
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * Gets the favourite type.
	 *
	 * @return the favourite type
	 */
	public String getFavouriteType() {
		return favouriteType;
	}

	/**
	 * Sets the favourite type.
	 *
	 * @param favouriteType
	 *            the new favourite type
	 */
	public void setFavouriteType(String favouriteType) {
		this.favouriteType = favouriteType;
	}

	/**
	 * Gets the cash pro product id.
	 *
	 * @return the cash pro product id
	 */
	public String getCashProProductId() {
		return cashProProductId;
	}

	/**
	 * Sets the cash pro product id.
	 *
	 * @param cashProProductId
	 *            the new cash pro product id
	 */
	public void setCashProProductId(String cashProProductId) {
		this.cashProProductId = cashProProductId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFavouriteName() {
		return favouriteName;
	}

	public void setFavouriteName(String favouriteName) {
		this.favouriteName = favouriteName;
	}

	@Override
	public String getEntityIdentifier() {
		return "Favourite Name : "+getFavouriteName();
	}
	
	@Override
	public String getEntity() {
		return "FAVOURITE";
	}
}
