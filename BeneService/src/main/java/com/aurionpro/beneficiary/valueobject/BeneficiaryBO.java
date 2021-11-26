/*
 * 
 * 
 * Copyright (c) 2006 aurionPro Solutions Ltd.
 * Unit no. 404, 4th Floor, Winchester Building Hiranandani Garden ,
 * Powai, Mumbai - 400076.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * aurionPro Solutions Ltd. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with aurionPro Solutions Ltd.
 */
package com.aurionpro.beneficiary.valueobject;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aurionpro.generic.utils.FieldNameUtil;
import com.aurionpro.generic.basevalueobject.MasterBO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



/**
 * 
 */
@Entity
@Table(name="BMBENEFICIARY")
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryBO extends MasterBO {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bene_seq")
    @SequenceGenerator(name = "bene_seq", sequenceName="SQ_BMBENEFICIARY",allocationSize=1)
    @Column(name = "id")
	protected Long id;
	
	
	/**
	 * Extra
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy="beneficiaryId", cascade = CascadeType.ALL,orphanRemoval=true )
	private Set<BeneficiaryPaymentMethodMapBO>  beneficiaryPaymentMethods = new HashSet<BeneficiaryPaymentMethodMapBO>();

	@Column(name = "REQUESTBY")
	private String requestBy;

	@Column(name = "CORPORATEID")
	private Long corporateId;

	@Column(name = "BENEFICIARYCODE")
	private String beneficiaryCode;

	@Column(name = "BENEFICIARYNAME")
	private String beneficiaryName;

	@Column(name = "ADDRESS1")
	private String address1;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "ADDRESS3")
	private String address3;

	@Column(name = "COUNTRYID")
	private Long countryId;

	@Column(name = "PINCODE")
	private String pinCode;

	@Column(name = "STATEID")
	private Long stateId;

	@Column(name = "PHONENO")
	private String phoneNo;

	@Column(name = "LOCATIONID")
	private Long locationId;

	@Column(name = "FAXNO")
	private String faxNo;

	@Column(name = "CITY")
	private String city;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ACCOUNTNO")
	private String accountNo;

	@Column(name = "ACCOUNTBRANCHID")
	private Long accountBranchId;

	@Transient
	private String countryName;

	@Transient
	private String stateName;

	@Transient
	private String locationName;

	@Transient
	private String corporateName;

	@Transient
	private String accountBranchName;

	// added by Megha
	
	@Column(name = "CORPORATEUSERID")
	private Long corporateUserId;
	
	
	@Column(name = "BENEFICIARYTYPE")
	private String beneficiaryType;
	
	@Transient
	private String corporateUser;

	// added by rahul
	
	@Column(name = "PAYEENAME")
	private String payeeName;

	
	@Column(name = "OVERALLLIMIT")
	private Double overallLimit;
	
	
	@Column(name = "ADHOCLIMIT")
	private Double adhocLimit;
	
	
	@Column(name = "ADHOCLIMITAPPLICABLEFROM")
	private Date adhocLimitApplicableFrom;
	
	
	@Column(name = "ADHOCLIMITAPPLICABLETILL")
	private Date adhocLimitApplicableTill;

	
	@Column(name = "GROUPID")
	private Long groupId;
	
	@Transient
	private String groupCode;
	
	@Transient
	private String groupName;

	@Transient
	private boolean newBene;
	

	/**
	 * TODO : Pravin overridden base bo property full solution need to find
	 */
	@Column(name = "ENRICHMENTS")
	private String enrichments;

	/**
	 * @return the corporateUser
	 */
	public String getCorporateUser() {
		if (this.getCorporateUserId() != null)
			return FieldNameUtil.getCorporateUserId(this.getCorporateUserId());
		else
			return null;
	}

	public String getCorporateName() {
		return FieldNameUtil.getCorporateName(getCorporateId());
	}

	public String getCountryName() {
		return FieldNameUtil.getGeographyName(getCountryId());
	}

	public String getLocationName() {
		return FieldNameUtil.getLocationName(getLocationId());
	}

	public String getStateName() {
		return FieldNameUtil.getGeographyName(getStateId());
	}

	public String getAccountBranchName() {
		return FieldNameUtil.getBankBranchName(getAccountBranchId());
	}


	/**
	 * @return Returns the accountBranchId.
	 */
	public Long getAccountBranchId() {
		return (Long) getPropertyObject("accountBranchId", accountBranchId);
	}

	/**
	 * @param accountBranchId
	 *            The accountBranchId to set.
	 */
	public void setAccountBranchId(Long accountBranchId) {
		if (isSetDirectValue())
			this.accountBranchId = accountBranchId;
		else
			setProperty("accountBranchId", accountBranchId);
	}

	/**
	 * @return Returns the accountNo.
	 */
	public String getAccountNo() {
		return (String) getPropertyObject("accountNo", accountNo);
	}

	/**
	 * @param accountNo
	 *            The accountNo to set.
	 */
	public void setAccountNo(String accountNo) {
		if (isSetDirectValue())
			this.accountNo = accountNo;
		else
			setProperty("accountNo", accountNo);
	}

	/**
	 * @return Returns the address1.
	 */
	public String getAddress1() {
		return (String) getPropertyObject("address1", address1);
	}

	/**
	 * @param address1
	 *            The address1 to set.
	 */
	public void setAddress1(String address1) {
		if (isSetDirectValue())
			this.address1 = address1;
		else
			setProperty("address1", address1);
	}

	/**
	 * @return Returns the address2.
	 */
	public String getAddress2() {
		return (String) getPropertyObject("address2", address2);
	}

	/**
	 * @param address2
	 *            The address2 to set.
	 */
	public void setAddress2(String address2) {
		if (isSetDirectValue())
			this.address2 = address2;
		else
			setProperty("address2", address2);
	}

	/**
	 * @return Returns the address3.
	 */
	public String getAddress3() {
		return (String) getPropertyObject("address3", address3);
	}

	/**
	 * @param address3
	 *            The address3 to set.
	 */
	public void setAddress3(String address3) {
		if (isSetDirectValue())
			this.address3 = address3;
		else
			setProperty("address3", address3);
	}

	public String getBeneficiaryCode() {
		return beneficiaryCode;
	}

	public void setBeneficiaryCode(String beneficiaryCode) {
		this.beneficiaryCode = beneficiaryCode;
	}

	/**
	 * @return Returns the beneficiaryName.
	 */
	public String getBeneficiaryName() {
		return (String) getPropertyObject("beneficiaryName", beneficiaryName);
	}

	/**
	 * @param beneficiaryName
	 *            The beneficiaryName to set.
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		if (isSetDirectValue())
			this.beneficiaryName = beneficiaryName;
		else
			setProperty("beneficiaryName", beneficiaryName);
	}

	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return (String) getPropertyObject("city", city);
	}

	/**
	 * @param city
	 *            The city to set.
	 */
	public void setCity(String city) {
		if (isSetDirectValue())
			this.city = city;
		else
			setProperty("city", city);
	}

	/**
	 * @return Returns the corporateId.
	 */
	public Long getCorporateId() {
		return (Long) getPropertyObject("corporateId", corporateId);
	}

	/**
	 * @param corporateId
	 *            The corporateId to set.
	 */
	public void setCorporateId(Long corporateId) {
		if (isSetDirectValue())
			this.corporateId = corporateId;
		else
			setProperty("corporateId", corporateId);
	}

	/**
	 * @return Returns the countryId.
	 */
	public Long getCountryId() {
		return (Long) getPropertyObject("countryId", countryId);
	}

	/**
	 * @param countryId
	 *            The countryId to set.
	 */
	public void setCountryId(Long countryId) {
		if (isSetDirectValue())
			this.countryId = countryId;
		else
			setProperty("countryId", countryId);
	}

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return (String) getPropertyObject("email", email);
	}

	/**
	 * @param email
	 *            The email to set.
	 */
	public void setEmail(String email) {
		String email1 = email;
		if (email != null) {
			if (email.contains(";")) {
				email1 = email.replace(";", ",");
			}
		}
		if (isSetDirectValue())

			this.email = email1;

		else
			setProperty("email", email1);
	}

	/**
	 * @return Returns the faxNo.
	 */
	public String getFaxNo() {
		return (String) getPropertyObject("faxNo", faxNo);
	}

	/**
	 * @param faxNo
	 *            The faxNo to set.
	 */
	public void setFaxNo(String faxNo) {
		if (isSetDirectValue())
			this.faxNo = faxNo;
		else
			setProperty("faxNo", faxNo);
	}

	/**
	 * @return Returns the locationId.
	 */
	public Long getLocationId() {
		return (Long) getPropertyObject("locationId", locationId);
	}

	/**
	 * @param locationId
	 *            The locationId to set.
	 */
	public void setLocationId(Long locationId) {
		if (isSetDirectValue())
			this.locationId = locationId;
		else
			setProperty("locationId", locationId);
	}

	/**
	 * @return Returns the phoneNo.
	 */
	public String getPhoneNo() {
		return (String) getPropertyObject("phoneNo", phoneNo);
	}

	/**
	 * @param phoneNo
	 *            The phoneNo to set.
	 */
	public void setPhoneNo(String phoneNo) {
		String phoneNo1 = phoneNo;
		if (phoneNo != null) {
			if (phoneNo.contains(";")) {
				phoneNo1 = phoneNo.replace(";", ",");
			}
		}
		if (isSetDirectValue())
			this.phoneNo = phoneNo1;
		else
			setProperty("phoneNo", phoneNo1);
	}

	/**
	 * @return Returns the pinCode.
	 */
	public String getPinCode() {
		return (String) getPropertyObject("pinCode", pinCode);
	}

	/**
	 * @param pinCode
	 *            The pinCode to set.
	 */
	public void setPinCode(String pinCode) {
		if (isSetDirectValue())
			this.pinCode = pinCode;
		else
			setProperty("pinCode", pinCode);
	}

	/**
	 * @return Returns the stateId.
	 */
	public Long getStateId() {
		return (Long) getPropertyObject("stateId", stateId);
	}

	/**
	 * @param stateId
	 *            The stateId to set.
	 */
	public void setStateId(Long stateId) {
		if (isSetDirectValue())
			this.stateId = stateId;
		else
			setProperty("stateId", stateId);
	}

	/**
	 * @return the requestBy
	 */
	public String getRequestBy() {
		return requestBy;
	}

	/**
	 * @param requestBy
	 *            the requestBy to set
	 */
	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	@Override
	public String getEntityIdentifier() {
		return getBeneficiaryCode();
	}

	/**
	 * @param payeeName
	 */
	public void setPayeeName(String payeeName) {
		if (isSetDirectValue())
			this.payeeName = payeeName;
		else
			setProperty("payeeName", payeeName);
	}

	public String getPayeeName() {
		return (String) getPropertyObject("payeeName", payeeName);
	}

	/**
	 * @return the overallLimit
	 */
	public Double getOverallLimit() {
		return (Double) getPropertyObject("overallLimit", overallLimit);
	}

	/**
	 * @param overallLimit
	 *            the overallLimit to set
	 */
	public void setOverallLimit(Double overallLimit) {
		if (null == overallLimit) {
			overallLimit = 0.00;
		}
		if (isSetDirectValue())
			this.overallLimit = overallLimit;
		else
			setProperty("overallLimit", overallLimit);
	}

	/**
	 * @return the adhocLimit
	 */
	public Double getAdhocLimit() {
		return (Double) getPropertyObject("adhocLimit", adhocLimit);
	}

	/**
	 * @param adhocLimit
	 *            the adhocLimit to set
	 */
	public void setAdhocLimit(Double adhocLimit) {
		if (isSetDirectValue())
			this.adhocLimit = adhocLimit;
		else
			setProperty("adhocLimit", adhocLimit);
	}

	/**
	 * @return the adhocLimitApplicableFrom
	 */
	public Date getAdhocLimitApplicableFrom() {
		return (Date) getPropertyObject("adhocLimitApplicableFrom",
				adhocLimitApplicableFrom);
	}

	/**
	 * @param adhocLimitApplicableFrom
	 *            the adhocLimitApplicableFrom to set
	 */
	public void setAdhocLimitApplicableFrom(Date adhocLimitApplicableFrom) {
		if (isSetDirectValue())
			this.adhocLimitApplicableFrom = adhocLimitApplicableFrom;
		else
			setProperty("adhocLimitApplicableFrom", adhocLimitApplicableFrom);
	}

	/**
	 * @return the adhocLimitApplicableTill
	 */
	public Date getAdhocLimitApplicableTill() {
		return (Date) getPropertyObject("adhocLimitApplicableTill",
				adhocLimitApplicableTill);
	}

	/**
	 * @param adhocLimitApplicableTill
	 *            the adhocLimitApplicableTill to set
	 */
	public void setAdhocLimitApplicableTill(Date adhocLimitApplicableTill) {
		if (isSetDirectValue())
			this.adhocLimitApplicableTill = adhocLimitApplicableTill;
		else
			setProperty("adhocLimitApplicableTill", adhocLimitApplicableTill);
	}

	/**
	 * @return the corporateUserId
	 */
	public Long getCorporateUserId() {
		return (Long) getPropertyObject("corporateUserId", corporateUserId);
	}

	/**
	 * @param corporateUserId
	 *            the corporateUserId to set
	 */
	public void setCorporateUserId(Long corporateUserId) {
		if (isSetDirectValue())
			this.corporateUserId = corporateUserId;
		else
			setProperty("corporateUserId", corporateUserId);
	}

	/**
	 * @return the beneficiaryType
	 */
	public String getBeneficiaryType() {
		return (String) getPropertyObject("beneficiaryType", beneficiaryType);
	}

	/**
	 * @param beneficiaryType
	 *            the beneficiaryType to set
	 */
	public void setBeneficiaryType(String beneficiaryType) {
		if (isSetDirectValue())
			this.beneficiaryType = beneficiaryType;
		else
			setProperty("beneficiaryType", beneficiaryType);
	}

	public Long getGroupId() {
		return (Long) getPropertyObject("groupId", groupId);
	}

	public void setGroupId(Long groupId) {
		if (isSetDirectValue())
			this.groupId = groupId;
		else
			setProperty("groupId", groupId);
	}

	public String getGroupCode() {
		return FieldNameUtil.getGroupCode(this.getGroupId());
	}

	public String getGroupName() {
		return FieldNameUtil.getGroupName(this.getGroupId());
	}

	public boolean isNewBene() {
		return newBene;
	}

	public void setNewBene(boolean newBene) {
		this.newBene = newBene;
	}

	public Set<BeneficiaryPaymentMethodMapBO> getBeneficiaryPaymentMethods() {
		return beneficiaryPaymentMethods;
	}

	public void setBeneficiaryPaymentMethods(Set<BeneficiaryPaymentMethodMapBO> beneficiaryPaymentMethods) {
		this.beneficiaryPaymentMethods = beneficiaryPaymentMethods;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnrichments() {
		return enrichments;
	}

	public void setEnrichments(String enrichments) {
		this.enrichments = enrichments;
	}
	
	
}
