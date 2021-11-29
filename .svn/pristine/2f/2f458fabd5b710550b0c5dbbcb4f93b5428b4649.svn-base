package com.aurionpro.beneficiary.valueobject;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.aurionpro.beneficiary.enums.DispatchMode;
import com.aurionpro.beneficiary.enums.DispatchTo;
import com.aurionpro.generic.basevalueobject.MasterBO;
import com.aurionpro.generic.utils.FieldNameUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BMBENEPAYMETHODMAP")
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryPaymentMethodMapBO extends MasterBO {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="benemap_seq")
    @SequenceGenerator(name = "benemap_seq", sequenceName="SQ_BMBENEPAYMETHODMAP",allocationSize=1)
    @Column(name = "id")
	protected Long id;
	
	@Column(name = "REQUESTBY")
	private String requestBy;

	@Column(name = "CORPORATEID")
	private Long corporateId;

	@Column(name = "PAYMENTMETHODID")
	private Long paymentMethodId;

	/**
	 * alter
	 */
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BENEFICIARYID")
	private BeneficiaryBO beneficiaryId;

	@Transient
	private String corporateName;

	@Transient
	private String paymentMethodCode;
	
	@Transient
	private String paymentMethodName;

	@Transient
	private String beneficiaryName;

	@Column(name="DISPATCHTO")
	private DispatchTo dispatchTo;

	@Column(name="INSTRUMENTDISPATCHMODE")
	private DispatchMode instrumentDispatchMode;

	
	@Column(name="BENEDISPATCHMODE")
	private String beneDispatchMode;
	
	@Transient
	private String beneDispatchModeName;

	
	@Column(name="DEFAULTPAYMENTMETHOD")
	@Type(type="yes_no")
	private Boolean defaultPaymentMethod;

	// ECS fields
	@Column(name="BANKSORTCODE")
	private String bankSortCode;

	
	@Column(name="BANKID")
	private String bankName; // New
	
	@Transient
	private Long bankId; // New

	@Column(name="BRANCHSORTCODE")
	private String branchSortCode;

	
	@Column(name="BRANCHID")
	private String branchName; // New

	
	@Column(name="ACCOUNTTYPEID")
	private Long accountTypeId;

	@Transient
	private String accountTypeName;

	@Column(name = "ACCOUNTNO")
	private String accountNo;
	// added by pasha
	
	@Transient
	private String accountName;
	
	
	// New Fields.
	
	@Column(name = "SWIFTCODE")
	private String swiftCode;

	
	@Column(name = "ADDRESS1")
	private String address1;

	@Column(name = "ADDRESS2")
	private String address2;

	@Column(name = "ADDRESS3")
	private String address3;

	
	@Transient
	private Long stateId;

	@Transient
	private Long locationId;
	
	@Transient
	private Long countryId;

	// New Fields as per Interface required.

	
	@Column(name = "STATEID")
	private String stateName;

	
	@Column(name = "LOCATIONID")
	private String locationName;
	
	
	@Column(name = "COUNTRYID")
	private String countryName;
	
	
	@Column(name = "PAYMENTTYPE")
	private String paymentType;
	
	
	
	//Changes for Intermediary Bank Details (10-July-2011)
	@Column(name = "BANKINTERMEDIARY")
	private String intermediaryBank;
	
	@Column(name="BRANCHINTERMEDIARY")
	private String intermediaryBranch;
	
	
	@Column(name="BICCODEINTERMEDIARY")
	private String intermediaryBankBicCode;
	
	@Column(name="BANKADD1INTERMEDIARY")
	private String intermediaryBankAdd1;
	
	@Column(name="BANKADD2INTERMEDIARY")
	private String intermediaryBankAdd2;
	
	@Column(name="BANKADD3INTERMEDIARY")
	private String intermediaryBankAdd3;
	
	@Column(name="BANKSORTCODEINTERMEDIARY")
	private String intermediarySortCode;
	
	
	
	@Column(name="GROUPID")
	private Long groupId;
	
	@Transient
	private String groupName;

	// SHIFT fields

	// bankSortCode;
	// bankName; // New
	// branchSortCode;
	// branchName; // New
	// accountTypeId;
	// accountTypeName;
	// accountNo;
	/*
	 * private Integer messageType; // from general table private String
	 * messageTypeName; // from general table just display not need to add in
	 * database private String messageNo; // getting from general table based on
	 * messageType. private String userName;
	 */

	// RTGS fields.
	// FT
	@Transient
	private Long branchId;

	@Transient
	private String accountBranchName;
	
	//For CORR FT
	@Transient
	private String corrbankName;
	
	@Transient
	private String corrbankBranchName;
	
	
	@Column(name="BENEFICIARYLIMIT")
	private Double beneficiaryLimit;
	
	// Added by Deep Upadhye for CR015 - BANK	
	@Column(name="CORPORATEUSERID")
	private Long corporateUserId;
	
	
	@Column(name="BENEFICIARYTYPE")
	private String beneficiaryType;
	
	@Transient
	private String payeeName;
	
	//For SLIPS and CEFTS
	@Column(name="BANKCODE")
	private String bankCode;
	
	
	@Column(name="BRANCHCODE")
	private String branchCode;
	
	@Transient
	private String email;
	
	@Transient
	private String phone;
	
	@OneToMany(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id")
	private Set<BeneficiaryCashPayoutMapBO>  beneficiaryCashPayoutset = new LinkedHashSet <BeneficiaryCashPayoutMapBO>();
	
	/**
	 * @return the beneficiaryLimit
	 */
	public Double getBeneficiaryLimit() {
		return (Double) getPropertyObject("beneficiaryLimit",beneficiaryLimit);
	}

	/**
	 * @param beneficiaryLimit the beneficiaryLimit to set
	 */
	public void setBeneficiaryLimit(Double beneficiaryLimit) {
		setProperty("beneficiaryLimit", beneficiaryLimit);
	}


//	@Child(PaymentMethodAddiDetailsBO.class)
//	private Set<PaymentMethodAddiDetailsBO>  paymentMethodAddiDetailsSet = new LinkedHashSet <PaymentMethodAddiDetailsBO>();


	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public BeneficiaryBO getBeneficiaryId() {
		return (BeneficiaryBO) getPropertyObject("beneficiaryId",beneficiaryId);
	}

	public void setBeneficiaryId(BeneficiaryBO beneficiaryId) {/*
		if(isOriginalVal)
			this.beneficiaryId = beneficiaryId;
		else
			setProperty("beneficiaryId", beneficiaryId);
	*/
		this.beneficiaryId = beneficiaryId;
	}

	public Long getCorporateId() {
		return (Long) getPropertyObject("corporateId",corporateId);
	}

	public void setCorporateId(Long corporateId) {
		if(isOriginalVal)
			this.corporateId = corporateId;
		else
			setProperty("corporateId", corporateId);
	}

	public Long getPaymentMethodId() {
		return (Long) getPropertyObject("paymentMethodId",paymentMethodId);
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		if(isOriginalVal)
			this.paymentMethodId =paymentMethodId;
		else
			setProperty("paymentMethodId", paymentMethodId);
	}

	public Long getAccountTypeId() {
		return (Long) getPropertyObject("accountTypeId",accountTypeId);
	}

	public void setAccountTypeId(Long accountTypeId) {
		if(isOriginalVal)
			this.accountTypeId = accountTypeId;
		else
			setProperty("accountTypeId", accountTypeId);
	}

	public String getBankSortCode() {
		return (String) getPropertyObject("bankSortCode",bankSortCode);
	}

	public void setBankSortCode(String bankSortCode) {
		if(isOriginalVal)
			this.bankSortCode = bankSortCode;
		else
			setProperty("bankSortCode", bankSortCode);
	}

	public String getBranchSortCode() {
		return (String) getPropertyObject("branchSortCode",branchSortCode);
	}

	public void setBranchSortCode(String branchSortCode) {
		if(isOriginalVal)
			this.branchSortCode = branchSortCode;
		else
			setProperty("branchSortCode", branchSortCode);
	}

	public String getAccountNo() {
		return (String) getPropertyObject("accountNo",accountNo);
	}

	public void setAccountNo(String accountNo) {
		if(isOriginalVal)
			this.accountNo = accountNo;
		else
			setProperty("accountNo", accountNo);
	}

	public String getBeneDispatchMode() {
		return (String) getPropertyObject("beneDispatchMode",beneDispatchMode);

	}

	public void setBeneDispatchMode(String beneDispatchMode) {
		if(isOriginalVal)
			this.beneDispatchMode = beneDispatchMode;
		else
			setProperty("beneDispatchMode", beneDispatchMode);
	}

	public DispatchTo getDispatchTo() {

		return (DispatchTo) getPropertyObject("dispatchTo",dispatchTo);
	}

	public void setDispatchTo(DispatchTo dispatchTo) {
		if(isOriginalVal)
			this.dispatchTo = dispatchTo;
		else
			setProperty("dispatchTo", dispatchTo);
	}

	public DispatchMode getInstrumentDispatchMode() {

		return (DispatchMode) getPropertyObject("instrumentDispatchMode",instrumentDispatchMode);
	}

	public void setInstrumentDispatchMode(DispatchMode instrumentDispatchMode) {
		if(isOriginalVal)
			this.instrumentDispatchMode = instrumentDispatchMode;
		else
			setProperty("instrumentDispatchMode", instrumentDispatchMode);
	}

	public String getBeneficiaryName() {
		return FieldNameUtil.getBeneficiaryName(getBeneficiaryId().getId());
	}

	
	public String getEmail() {
		return FieldNameUtil.getBeneficiaryEmail(getBeneficiaryId().getId());
	}
	

	public String getPhone() {
		return FieldNameUtil.getBeneficiaryPhone(getBeneficiaryId().getId());
	}

	public String getCorporateName() {
		return FieldNameUtil.getCorporateName(getCorporateId());
	}

	public String getPaymentMethodName() {
		return FieldNameUtil.getPaymentMethodName(getPaymentMethodId());
	}

	public String getAccountTypeName() {
		return null;//FieldNameUtil.getAccountTypeName(this.getAccountTypeId());
	}

	public Boolean getDefaultPaymentMethod() {
		return (Boolean) getPropertyObject("defaultPaymentMethod",defaultPaymentMethod);
	}

	public void setDefaultPaymentMethod(Boolean defaultPaymentMethod) {
		if(isOriginalVal)
			this.defaultPaymentMethod = defaultPaymentMethod;
		else
			setProperty("defaultPaymentMethod", defaultPaymentMethod);
	}

	public Long getBranchId() {
		return (Long) getPropertyObject("branchId",branchId);
	}

	public void setBranchId(Long branchId) {
		if(isOriginalVal)
			this.branchId = branchId;
		else
			setProperty("branchId", branchId);
	}

	public String getAccountBranchName() {
		return null;//FieldNameUtil.getBankBranchName(getBranchId());
	}

	public String getPaymentMethodCode() {
		return FieldNameUtil.getPaymentMethodCode(getPaymentMethodId());
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return (String) getPropertyObject("address1",address1);
	}

	/**
	 * @param address1
	 *            the address1 to set
	 */
	public void setAddress1(String address1) {
		if(isOriginalVal)
			this.address1 = address1;
		else
			setProperty("address1", address1);
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return (String) getPropertyObject("address2",address2);
	}

	/**
	 * @param address2
	 *            the address2 to set
	 */
	public void setAddress2(String address2) {
		if(isOriginalVal)
			this.address2 = address2;
		else
			setProperty("address2", address2);
	}

	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return (String) getPropertyObject("address3",address3);
	}

	/**
	 * @param address3
	 *            the address3 to set
	 */
	public void setAddress3(String address3) {
		if(isOriginalVal)
			this.address3 = address3;
		else
		setProperty("address3", address3);
	}

	/**
	 * @return the locationId
	 */
	public Long getLocationId() {
		return (Long)getPropertyObject("locationId",locationId);
	}

	/**
	 * @param locationId
	 *            the locationId to set
	 */
	public void setLocationId(Long locationId) {
		if(isOriginalVal)
			this.locationId = locationId;
		else
		setProperty("locationId", locationId);
	}

	/**
	 * @return the stateId
	 */
	public Long getStateId() {
		return (Long)getPropertyObject("stateId",stateId);
	}

	/**
	 * @param stateId
	 *            the stateId to set
	 */
	public void setStateId(Long stateId) {
		if(isOriginalVal)
			this.stateId = stateId;
		else
			
		setProperty("stateId", stateId);
	}

	/**
	 * @return the swiftCode
	 */
	public String getSwiftCode() {
		return (String) getPropertyObject("swiftCode",swiftCode);
	}

	/**
	 * @param swiftCode
	 *            the swiftCode to set
	 */
	public void setSwiftCode(String swiftCode) {
		if(isOriginalVal)
			this.swiftCode = swiftCode;
		else
			setProperty("swiftCode", swiftCode);
	}

	
	/**
	 * @return the countryId
	 */
	public Long getCountryId() {
		return (Long) getPropertyObject("countryId",countryId);
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		if(isOriginalVal)
			this.countryId = countryId;
		else
		setProperty("countryId", countryId);
	}

	
	/**
	 * @return the bankId
	 */
	public Long getBankId() {
		return (Long) getPropertyObject("bankId",bankId);
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		if(isOriginalVal)
			this.bankId = bankId;
		else
		setProperty("bankId" , bankId);
	}

	/**
	 * @return the corrbankBranchName
	 */
	public String getCorrbankBranchName() {
		return FieldNameUtil.getOtherBankName(this.getBranchId());
	}

	/**
	 * @return the corrbankName
	 */
	public String getCorrbankName() {
		return FieldNameUtil.getOtherBankName(this.getBankId());
	}


	@Override
	public String getEntityIdentifier() {
		// TODO Auto-generated method stub
		return "BeneficiaryName: "+getBeneficiaryName()+" BeneficiaryCode: "+FieldNameUtil.getBeneficiaryCode(getBeneficiaryId().getId());
	}

	public Set<BeneficiaryCashPayoutMapBO> getBeneficiaryCashPayoutset() {
		return beneficiaryCashPayoutset;
	}

	public void setBeneficiaryCashPayoutset(
			Set<BeneficiaryCashPayoutMapBO> beneficiaryCashPayoutset) {
		this.beneficiaryCashPayoutset = beneficiaryCashPayoutset;
	}
	
	

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return (String) getPropertyObject("stateName",stateName);
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		if(isOriginalVal)
			this.stateName = stateName;
		else
		setProperty("stateName", stateName);
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return (String) getPropertyObject("locationName",locationName);
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		if(isOriginalVal)
			this.locationName = locationName;
		else
		setProperty("locationName", locationName);
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return (String) getPropertyObject("countryName",countryName);
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		if(isOriginalVal)
			this.countryName = countryName;
		else
		setProperty("countryName", countryName);
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return (String) getPropertyObject("bankName",bankName);
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		if(isOriginalVal)
			this.bankName = bankName;
		else
		setProperty("bankName", bankName);
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return (String) getPropertyObject("branchName",branchName);
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		if(isOriginalVal)
			this.branchName = branchName;
		else
		setProperty("branchName", branchName);
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return (String) getPropertyObject("paymentType",paymentType);
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		if(isOriginalVal)
			this.paymentType = paymentType;
		else
		setProperty("paymentType", paymentType);
	}
	
	
	
	//Changes for Intermediary Bank Details (10-July-2011)
	public String getIntermediaryBank() {
		return (String) getPropertyObject("intermediaryBank",intermediaryBank);
	}
	public void setIntermediaryBank(String intermediaryBank) {
		if(isOriginalVal)
			this.intermediaryBank = intermediaryBank;
		else
		setProperty("intermediaryBank", intermediaryBank);
	}

	public String getIntermediaryBranch() {
		return (String) getPropertyObject("intermediaryBranch",intermediaryBranch);
	}

	public void setIntermediaryBranch(String intermediaryBranch) {
		if(isOriginalVal)
			this.intermediaryBranch = intermediaryBranch;
		else
			setProperty("intermediaryBranch", intermediaryBranch);
	}

	public String getIntermediaryBankBicCode() {
		return (String) getPropertyObject("intermediaryBankBicCode",intermediaryBankBicCode);
	}

	public void setIntermediaryBankBicCode(String intermediaryBankBicCode) {
		if(isOriginalVal)
			this.intermediaryBankBicCode =intermediaryBankBicCode;
		else
		setProperty("intermediaryBankBicCode", intermediaryBankBicCode);
	}

	public String getIntermediaryBankAdd1() {
		return (String) getPropertyObject("intermediaryBankAdd1",intermediaryBankAdd1);
	}

	public void setIntermediaryBankAdd1(String intermediaryBankAdd1) {
		if(isOriginalVal)
			this.intermediaryBankAdd1 = intermediaryBankAdd1;
		else
		setProperty("intermediaryBankAdd1", intermediaryBankAdd1);
	}

	public String getIntermediaryBankAdd2() {
		return (String) getPropertyObject("intermediaryBankAdd2",intermediaryBankAdd2);
	}

	public void setIntermediaryBankAdd2(String intermediaryBankAdd2) {
		if(isOriginalVal)
			this.intermediaryBankAdd2 = intermediaryBankAdd2;
		else
		setProperty("intermediaryBankAdd2", intermediaryBankAdd2);
	}

	public String getIntermediaryBankAdd3() {
		return (String) getPropertyObject("intermediaryBankAdd3",intermediaryBankAdd3);
	}

	public void setIntermediaryBankAdd3(String intermediaryBankAdd3) {
		if(isOriginalVal)
			this.intermediaryBankAdd3 = intermediaryBankAdd3;
		else
		setProperty("intermediaryBankAdd3", intermediaryBankAdd3);
	}
	
	
	public String getIntermediarySortCode() {
		return (String) getPropertyObject("intermediarySortCode",intermediarySortCode);
	}

	public void setIntermediarySortCode(String intermediarySortCode) {
		if(isOriginalVal)
			this.intermediarySortCode = intermediarySortCode;
		else
			setProperty("intermediarySortCode", intermediarySortCode);
	}

	
	/**
	 * @return the corporateUserId
	 */
	public Long getCorporateUserId() {
		return corporateUserId;
	}

	/**
	 * @param corporateUserId the corporateUserId to set
	 */
	public void setCorporateUserId(Long corporateUserId) {
		this.corporateUserId = corporateUserId;
	}

	/**
	 * @return the beneficiaryType
	 */
	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	/**
	 * @param beneficiaryType the beneficiaryType to set
	 */
	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public String getPayeeName() {
		return FieldNameUtil.getPayeeName(getBeneficiaryId().getId());
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	
	public String getAccountName() {
		String enrichment = this.getEnrichment("AccountTypeLabel");
		if("AccountNo".equalsIgnoreCase(enrichment)){
			return "A/C No-"+this.accountNo;
		}
		/*else if("Credit Card / Salary Card Payment".equalsIgnoreCase(enrichment)){
			return "CC/SC-"+this.accountNo;
		}
		else if("IBAN".equalsIgnoreCase(enrichment)){
			return "IBAN-"+this.accountNo;
		}*/
		else{
			return this.accountNo;
		}	
	}

	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return (Long) getPropertyObject("groupId",groupId);
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Long groupId) {
		if(isOriginalVal)
			this.groupId = groupId;
		else
			setProperty("groupId",groupId);
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return FieldNameUtil.getGroupName(this.getGroupId());
	}
	
	public String getBankCode() {
		return (String) getPropertyObject("bankCode",bankCode);
	}

	public void setBankCode(String bankCode) {
		if(isOriginalVal)
			this.bankCode = bankCode;
		else
			setProperty("bankCode", bankCode);
	}
	
	
	public String getBranchCode() {
		return (String) getPropertyObject("branchCode",branchCode);
	}

	public void setBranchCode(String branchCode) {
		if(isOriginalVal)
			this.branchCode = branchCode;
		else
			setProperty("branchCode", branchCode);
	}
	
	
	

	public String getBeneDispatchModeName() {
		if(null!= this.getBeneDispatchMode() && this.getBeneDispatchMode() !=""){
			String[] modes = this.getBeneDispatchMode().split(",");
			StringBuffer dispatchModes = new StringBuffer();
			for(String dispatchModeCode : modes){
				switch(dispatchModeCode.charAt(0)){
					case 'E' :  
							   dispatchModes.append("Email,");
							   break;
					case 'C' :	
							   dispatchModes.append("Courier,");
							   break;
					case 'M' :
							   dispatchModes.append("Mail,");
							   break;
					case 'S' :
						       dispatchModes.append("SMS,");
						       break;		
					case 'F' :
						       dispatchModes.append("Fax");
						       break;
						
				}
			}
			if(dispatchModes.toString().endsWith(","))
				dispatchModes.deleteCharAt(dispatchModes.length()-1);
			this.beneDispatchModeName = dispatchModes.toString();
			return beneDispatchModeName;
		}
		return null;
		//return beneDispatchModeName;
	}

	public void setBeneDispatchModeName(String beneDispatchModeName) {
		this.beneDispatchModeName = beneDispatchModeName;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
