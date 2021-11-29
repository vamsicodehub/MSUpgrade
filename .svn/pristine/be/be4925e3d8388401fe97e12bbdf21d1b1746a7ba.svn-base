/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.util.Date;

import com.aurionpro.generic.utils.JsonDateDeserializer;
import com.aurionpro.generic.utils.JsonDateSerializer;
import com.aurionpro.generic.utils.JsonDateSerializerWithTimeStamp;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

// TODO: Auto-generated Javadoc
/**
 * The Class MakerCheckerDetails.
 */
// TODO: Auto-generated Javadoc
/**
 * The Class MakerCheckerDetails.
 */
@JsonInclude(Include.NON_NULL)
public class MakerChecker extends BaseDetails {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9027894480027892386L;

	/** The authorized. */
	private boolean authorized;
	
	protected Boolean callMakerCheckerStrategy=true;
	
	private String entityIdentifier;

	/** The last action. */
	private String lastAction;

	/** The reject reason. */
	private String rejectReason;

	/** The modified at ou id. */
	private String modifiedAtOUId;

	/** The modified by. */
	private String modifiedBy;

	/** The checked by. */
	private String checkedBy;

	/** The enabled. */
	private boolean enabled = true;

	/** The active. */
	private boolean active = true;

	/** The effective from. */
	@JsonSerialize(using = JsonDateSerializer.class, include = JsonSerialize.Inclusion.NON_NULL)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date effectiveFrom;

	/** The effective till. */
	@JsonSerialize(using = JsonDateSerializer.class, include = JsonSerialize.Inclusion.NON_NULL)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date effectiveTill;

	/** The modified on. */
	@JsonSerialize(using = JsonDateSerializerWithTimeStamp.class, include = JsonSerialize.Inclusion.NON_NULL)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date modifiedOn;

	/** The modified sys on. */
	@JsonSerialize(using = JsonDateSerializerWithTimeStamp.class, include = JsonSerialize.Inclusion.NON_NULL)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date modifiedSysOn;

	/** The checked on. */
	@JsonSerialize(using = JsonDateSerializerWithTimeStamp.class, include = JsonSerialize.Inclusion.NON_NULL)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date checkedOn;

	/** The checked sys on. */
	@JsonSerialize(using = JsonDateSerializerWithTimeStamp.class, include = JsonSerialize.Inclusion.NON_NULL)
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date checkedSysOn;

	/** The maker name. */
	private String makerName;

	/** The checker name. */
	private String checkerName;
	
	private String makerChannel;
	
	private String checkerChannel;
	
	private Boolean isAuthorizeReject = false;
	
	private Boolean isViewAuthorizer = false;
	
	protected String verifiedBy;
	
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializerWithTimeStamp.class, include = JsonSerialize.Inclusion.NON_NULL)
	protected Date verifiedOn;

	/**
	 * Gets the authorized.
	 *
	 * @return the authorized
	 */
	public boolean getAuthorized() {
		return authorized;
	}

	/**
	 * Sets the authorized.
	 *
	 * @param authorized
	 *            the new authorized
	 */
	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	/**
	 * Gets the last action.
	 *
	 * @return the last action
	 */
	public String getLastAction() {
		return lastAction;
	}

	/**
	 * Sets the last action.
	 *
	 * @param lastAction
	 *            the new last action
	 */
	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}

	/**
	 * Gets the reject reason.
	 *
	 * @return the reject reason
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	/**
	 * Sets the reject reason.
	 *
	 * @param rejectReason
	 *            the new reject reason
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	/**
	 * Gets the modified at ou id.
	 *
	 * @return the modified at ou id
	 */
	public String getModifiedAtOUId() {
		return modifiedAtOUId;
	}

	/**
	 * Sets the modified at ou id.
	 *
	 * @param modifiedAtOUId
	 *            the new modified at ou id
	 */
	public void setModifiedAtOUId(String modifiedAtOUId) {
		this.modifiedAtOUId = modifiedAtOUId;
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
	 * Gets the checked by.
	 *
	 * @return the checked by
	 */
	public String getCheckedBy() {
		return checkedBy;
	}

	/**
	 * Sets the checked by.
	 *
	 * @param checkedBy
	 *            the new checked by
	 */
	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}

	/**
	 * Gets the maker name.
	 *
	 * @return the maker name
	 */
	public String getMakerName() {
		return makerName;
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
	 * Gets the modified sys on.
	 *
	 * @return the modified sys on
	 */
	public Date getModifiedSysOn() {
		return modifiedSysOn;
	}

	/**
	 * Sets the modified sys on.
	 *
	 * @param modifiedSysOn
	 *            the new modified sys on
	 */
	public void setModifiedSysOn(Date modifiedSysOn) {
		this.modifiedSysOn = modifiedSysOn;
	}

	/**
	 * Gets the checked on.
	 *
	 * @return the checked on
	 */
	public Date getCheckedOn() {
		return checkedOn;
	}

	/**
	 * Sets the checked on.
	 *
	 * @param checkedOn
	 *            the new checked on
	 */
	public void setCheckedOn(Date checkedOn) {
		this.checkedOn = checkedOn;
	}

	/**
	 * Gets the checked sys on.
	 *
	 * @return the checked sys on
	 */
	public Date getCheckedSysOn() {
		return checkedSysOn;
	}

	/**
	 * Sets the checked sys on.
	 *
	 * @param checkedSysOn
	 *            the new checked sys on
	 */
	public void setCheckedSysOn(Date checkedSysOn) {
		this.checkedSysOn = checkedSysOn;
	}

	/**
	 * Sets the maker name.
	 *
	 * @param makerName
	 *            the new maker name
	 */
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	/**
	 * Gets the checker name.
	 *
	 * @return the checker name
	 */
	public String getCheckerName() {
		return checkerName;
	}

	/**
	 * Sets the checker name.
	 *
	 * @param checkerName
	 *            the new checker name
	 */
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public Date getEffectiveTill() {
		return effectiveTill;
	}

	public void setEffectiveTill(Date effectiveTill) {
		this.effectiveTill = effectiveTill;
	}

	public Boolean getIsAuthorizeReject() {
		return isAuthorizeReject;
	}

	public void setIsAuthorizeReject(Boolean isAuthorizeReject) {
		this.isAuthorizeReject = isAuthorizeReject;
	}

	public Boolean getIsViewAuthorizer() {
		return isViewAuthorizer;
	}

	public void setIsViewAuthorizer(Boolean isViewAuthorizer) {
		this.isViewAuthorizer = isViewAuthorizer;
	}

	public Boolean getCallMakerCheckerStrategy() {
		return callMakerCheckerStrategy;
	}

	public void setCallMakerCheckerStrategy(Boolean callMakerCheckerStrategy) {
		this.callMakerCheckerStrategy = callMakerCheckerStrategy;
	}

	public String getEntityIdentifier() {
		return entityIdentifier;
	}

	public void setEntityIdentifier(String entityIdentifier) {
		this.entityIdentifier = entityIdentifier;
	}

	public String getMakerChannel() {
		return makerChannel;
	}

	public void setMakerChannel(String makerChannel) {
		this.makerChannel = makerChannel;
	}

	public String getCheckerChannel() {
		return checkerChannel;
	}

	public void setCheckerChannel(String checkerChannel) {
		this.checkerChannel = checkerChannel;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public Date getVerifiedOn() {
		return verifiedOn;
	}

	public void setVerifiedOn(Date verifiedOn) {
		this.verifiedOn = verifiedOn;
	}

}
