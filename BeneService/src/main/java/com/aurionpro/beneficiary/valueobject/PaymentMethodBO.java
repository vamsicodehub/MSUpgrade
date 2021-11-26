package com.aurionpro.beneficiary.valueobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.aurionpro.generic.basevalueobject.MasterBO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name="BMPAYMENTMETHOD")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodBO extends MasterBO {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payMethod_seq")
    @SequenceGenerator(name = "payMethod_seq", sequenceName="SQ_BMPAYMENTMETHOD",allocationSize=1)
    @Column(name = "id")
	protected Long id;
	
	@Transient
	private Long uploadBatchId;
	
	
	@Column(name = "PAYMENTMETHODCODE")
	private String paymentMethodCode;

	@Column(name = "PAYMENTMETHODNAME")
	private String paymentMethodName;
	
	@Column(name = "ISAPPLICABLE")
	@Type(type="yes_no")
	private Boolean isApplicable = false;
	
	@Column(name = "ISDEFAULTMAPPING")
	@Type(type="yes_no")
	private Boolean isDefaultMapping = false;
	
	@Column(name = "LIMITAMOUNT")
	private Double limitAmount = 0d;
	
	@Column(name = "MINIMUMLIMITAMOUNT")
	private Double minimumLimitAmount = 0d;
	
	@Column(name = "PRINTING")
	@Type(type="yes_no")
	private Boolean printing = false;
	
	@Column(name = "DEFAULTWORKFLOWID")
	private Long defaultWorkFlowId;
	
	@Column(name = "TRANSACTIONPOSTING")
	private String transactionPosting;
	
	@Column(name = "FUNDINGTYPE")
	private String fundingType; 
	
	@Column(name = "MANDATORYFIELDS")
	private String mandatoryFields; 
	
	
	@Column(name = "STP")
	@Type(type="yes_no")
	private Boolean stp = false;
	
//	@Child(PaymentMethodAddiDetailsBO.class)
//	private Set<PaymentMethodAddiDetailsBO> paymentMethodAddiDetails = new LinkedHashSet<PaymentMethodAddiDetailsBO>();
//	
	@Column(name = "CURRENCYCODES")
	private String currencyCodes;
	
	// added by Deep Upadhye for GAD 039
	@Column(name = "ALLOWOVERRIDE")
	@Type(type="yes_no")
	private Boolean allowOverride = true;
	
	
	@Column(name = "SUPPORTINGDOCREQ")
	@Type(type="yes_no")
	private Boolean supportingDocReq = true;
	


	public Boolean getIsDefaultMapping() {
		return isDefaultMapping;
	}

	public void setIsDefaultMapping(Boolean isDefaultMapping) {
		this.isDefaultMapping = isDefaultMapping;
	}

	public String getPaymentMethodCode() {
		return paymentMethodCode;
	}

	public void setPaymentMethodCode(String paymentMethodCode) {
		this.paymentMethodCode = paymentMethodCode;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	/*public Set<PaymentMethodAddiDetailsBO> getPaymentMethodAddiDetails() {
		return paymentMethodAddiDetails;
	}

	public void setPaymentMethodAddiDetails(
			Set<PaymentMethodAddiDetailsBO> paymentMethodAddiDetails) {
		this.paymentMethodAddiDetails = paymentMethodAddiDetails;
	}
	*/
	public Double getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(Double limitAmount) {
		this.limitAmount = limitAmount;
	}
	public Double getMinimumLimitAmount() {
		return minimumLimitAmount;
	}

	public void setMinimumLimitAmount(Double minimumlimitAmount) {
		this.minimumLimitAmount = minimumlimitAmount;
	}

	public Boolean getPrinting() {
		return printing;
	}

	public void setPrinting(Boolean isPrinting) {
		this.printing = isPrinting;
	}

	/**
	 * @return the defaultWorkFlowId
	 */
	public Long getDefaultWorkFlowId() {
		return defaultWorkFlowId;
	}

	/**
	 * @param defaultWorkFlowId the defaultWorkFlowId to set
	 */
	public void setDefaultWorkFlowId(Long defaultWorkFlowId) {
		this.defaultWorkFlowId = defaultWorkFlowId;
	}

	/**
	 * @return the fundingType
	 */
	public String getFundingType() {
		return fundingType;
	}

	/**
	 * @param fundingType the fundingType to set
	 */
	public void setFundingType(String fundingType) {
		this.fundingType = fundingType;
	}
	@Override

	public String getEntityIdentifier() {
		return getPaymentMethodCode();}

	/**
	 * @return the mandatoryFields
	 */
	public String getMandatoryFields() {
		return mandatoryFields;
	}

	/**
	 * @param mandatoryFields the mandatoryFields to set
	 */
	public void setMandatoryFields(String mandatoryFields) {
		this.mandatoryFields = mandatoryFields;
	}

	public String getTransactionPosting() {
		return transactionPosting;
	}

	public void setTransactionPosting(String transactionPosting) {
		this.transactionPosting = transactionPosting;
	}

	public Boolean getIsApplicable() {
		return isApplicable;
	}

	public void setIsApplicable(Boolean isApplicable) {
		this.isApplicable = isApplicable;
	}

	public String getCurrencyCodes() {
		return currencyCodes;
	}

	public void setCurrencyCodes(String currencyCodes) {
		this.currencyCodes = currencyCodes;
	}

	/**
	 * @return the allowOverride
	 */
	public Boolean getAllowOverride() {
		return (Boolean)getPropertyObject("allowOverride");
	}

	/**
	 * @param allowOverride the allowOverride to set
	 */
	public void setAllowOverride(Boolean allowOverride) {
		setProperty("allowOverride",allowOverride);
	}
	
	public Boolean getSupportingDocReq() {
		return supportingDocReq;
	}

	public void setSupportingDocReq(Boolean supportingDocReq) {
		this.supportingDocReq = supportingDocReq;
	}

	public Boolean getStp() {
		return stp;
	}

	public void setStp(Boolean stp) {
		this.stp = stp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
