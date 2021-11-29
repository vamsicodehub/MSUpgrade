package com.aurionpro.beneficiary.basevalueobject;

import java.util.LinkedHashSet;
import java.util.Set;

import com.aurionpro.beneficiary.enums.AuthorizationMatrixType;
import com.aurionpro.beneficiary.enums.MatrixType;
import com.aurionpro.beneficiary.enums.RequestBy;
import com.aurionpro.beneficiary.utils.FieldNameUtil;
/**
 * 
 * @author hetal.karolia
 *
 */
public class AuthorizationMatrixBO extends ParentMasterBO {

	private String moduleTypeCode;
	private MatrixType matrixType;
	private Long corporateId;
	private String corporateName;
	private String corporateCode;
	private RequestBy requestBy;
	private Character authorizationMode = 'S';
	private String authorizationModeName;
	private Boolean allowSkip = false;
	private Character authLevel = 'B';
	private String authLevelName;
	private String moduleName = "";
	
	private Long 	paymentMethodId;
	private String 	paymentMethodValue;
	
	private Long currencyId;
	private String currencyCode;
	
	private Long groupId;
	private String subModuleTypeCode;
	
	private String forUserType;
	
	
	/* Added by Sarika for dashBoard*/
	private String type;
	
	private AuthorizationMatrixType authorizationMatrixType;
	
	@Child(AuthorizationMatrixSlabBO.class)
	private Set<AuthorizationMatrixSlabBO> authorizationSlabs = new LinkedHashSet<AuthorizationMatrixSlabBO>();
	
	@Child(AuthorizationMatrixAccountBO.class)
	private Set<AuthorizationMatrixAccountBO> authorizationMatrixAccounts = new LinkedHashSet<AuthorizationMatrixAccountBO>();
	
	@Child(AuthorizationMatrixCreditCardBO.class)
	private Set<AuthorizationMatrixCreditCardBO> authorizationMatrixCreditCards = new LinkedHashSet<AuthorizationMatrixCreditCardBO>();
	
	public AuthorizationMatrixBO(){
		super();
	}

	
	/**
	 * @return the corporateId
	 */
	public Long getCorporateId() {
		return (Long)getPropertyObject("corporateId");
	}

	/**
	 * @param corporateId the corporateId to set
	 */
	public void setCorporateId(Long corporateId) {
		setProperty("corporateId", corporateId);
	}

	/**
	 * @return the matrixType
	 */
	public MatrixType getMatrixType() {
		return (MatrixType)getPropertyObject("matrixType");
	}

	/**
	 * @param matrixType the matrixType to set
	 */
	public void setMatrixType(MatrixType matrixType) {
		setProperty("matrixType", matrixType);
	}

	/**
	 * @return the requestBy
	 */
	public RequestBy getRequestBy() {
		return requestBy;
	}

	/**
	 * @return the moduleTypeCode
	 */
	public String getModuleTypeCode() {
		return (String)getPropertyObject("moduleTypeCode");
	}
	
	/**
	 * @param moduleTypeCode the moduleTypeCode to set
	 */
	public void setModuleTypeCode(String moduleTypeCode) {
		setProperty("moduleTypeCode", moduleTypeCode);
	}
	
	/**
	 * @param requestBy the requestBy to set
	 */
	public void setRequestBy(RequestBy requestBy) {
		this.requestBy = requestBy;
	}
	
	/**
	 * @return the authorizationSlabs
	 */
	public Set<AuthorizationMatrixSlabBO> getAuthorizationSlabs() {
		return authorizationSlabs;
	}
	/**
	 * @param authorizationSlabs the authorizationSlabs to set
	 */
	public void setAuthorizationSlabs(
			Set<AuthorizationMatrixSlabBO> authorizationSlabs) {
		this.authorizationSlabs = authorizationSlabs;
	}
	/**
	 * @return the allowSkip
	 */
	public Boolean getAllowSkip() {
		return (Boolean)getPropertyObject("allowSkip");
	}
	/**
	 * @param allowSkip the allowSkip to set
	 */
	public void setAllowSkip(Boolean allowSkip) {
		setProperty("allowSkip", allowSkip);
	}
	/**
	 * @return the authLevel
	 */
	public Character getAuthLevel() {
		return (Character)getPropertyObject("authLevel");
	}
	/**
	 * @param authLevel the authLevel to set
	 */
	public void setAuthLevel(Character authLevel) {
		setProperty("authLevel", authLevel);
	}
	/**
	 * @return the authorizationMode
	 */
	public Character getAuthorizationMode() {
		return (Character)getPropertyObject("authorizationMode");
	}
	/**
	 * @param authorizationMode the authorizationMode to set
	 */
	public void setAuthorizationMode(Character authorizationMode) {
		setProperty("authorizationMode", authorizationMode);
	}
	
	@Override
	public String getEntityIdentifier() {
		return getModuleTypeCode();
	}
	
	public String getCorporateName() {
		
		if(getCorporateId() != null)
			return FieldNameUtil.getCorporateName(getCorporateId());
		else
			return null;
	}
	public String getCorporateCode() {
		
		if(getCorporateId() != null)
			return FieldNameUtil.getCorporateCode(getCorporateId());
		else
			return null;
	}
	/**
	 * @return the paymentMethodId
	 */
	public Long getPaymentMethodId() {
		return (Long)getPropertyObject("paymentMethodId");
	}
	/**
	 * @param paymentMethodId the paymentMethodId to set
	 */
	public void setPaymentMethodId(Long paymentMethodId) {
		setProperty("paymentMethodId",paymentMethodId);
	}
	/**
	 * @return the paymentMethodValue
	 */
	public String getPaymentMethodValue() {
		if(getPaymentMethodId() != null)
			return FieldNameUtil.getPaymentMethodValue(paymentMethodId);
		else
			return null;
	}
	
	public Long getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyCode() {
		if(getCurrencyId() != null)
			return FieldNameUtil.getCurrencyCode(currencyId);
		else
			return null;
	}
	
	/**
	 * @return the authorizationMatrixAccountBOs
	 */
	public Set<AuthorizationMatrixAccountBO> getAuthorizationMatrixAccounts() {
		return authorizationMatrixAccounts;
	}
	/**
	 * @param authorizationMatrixAccountBOs the authorizationMatrixAccountBOs to set
	 */
	public void setAuthorizationMatrixAccountBOs(
			Set<AuthorizationMatrixAccountBO> authorizationMatrixAccounts) {
		this.authorizationMatrixAccounts = authorizationMatrixAccounts;
	}
	public AuthorizationMatrixType getAuthorizationMatrixType() {
		return (AuthorizationMatrixType) getPropertyObject("authorizationMatrixType");
	}
	public void setAuthorizationMatrixType(
			AuthorizationMatrixType authorizationMatrixType) {	
		if(authorizationMatrixType == null)
			authorizationMatrixType = AuthorizationMatrixType.ALL;
		setProperty("authorizationMatrixType", authorizationMatrixType);
	}
	
	public void setCorporateCode(String corporateCode) {
		this.corporateCode = corporateCode;
	}
	public void setAuthorizationModeName(String authorizationModeName) {
		this.authorizationModeName = authorizationModeName;
	}
	public void setAuthLevelName(String authLevelName) {
		this.authLevelName = authLevelName;
	}
	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		
		/**
		 * TODO: heck the usage
		 */
		/*if(getModuleTypeCode() != null)
			return FieldNameUtil.getValueForKeyAndType(GeneralService.PAYMENTMETHODS, this.getModuleTypeCode());
		else*/
			return null;
	}
	
	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return (Long)getPropertyObject("groupId");
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Long groupId) {
		setProperty("groupId",groupId);
	}
	public String getType() {
		if(null != this.getGroupId() && !"".equals(this.getGroupId()))
			return "Group";
		else if(null != this.getCorporateId() && !"".equals(this.getCorporateId()))
			return "Corporate";
		else
			return "";
	}
	public String getAuthorizationModeName() {
		if(null != this.getAuthorizationMode() && !"".equals(this.getAuthorizationMode()) && this.getAuthorizationMode().equals('S')){
			authorizationModeName = "Sequential";
		}else if(null != this.getAuthorizationMode() && !"".equals(this.getAuthorizationMode()) && this.getAuthorizationMode().equals('P')){
			authorizationModeName = "Parallel";
		}else{
			return null;
		}
		return authorizationModeName;
	}
	public String getAuthLevelName() {
		if(null != this.getAuthLevel() && !"".equals(this.getAuthLevel()) && this.getAuthLevel().equals('B')){
			authLevelName = "Batch";
		}else if(null != this.getAuthLevel() && !"".equals(this.getAuthLevel()) && this.getAuthLevel().equals('T')){
			authLevelName = "Transaction";
		}else{
			return null;
		}
		return authLevelName;
	}
	public void setPaymentMethodValue(String paymentMethodValue) {
		this.paymentMethodValue = paymentMethodValue;
	}
	
	public String getSubModuleTypeCode() {
		return (String)getPropertyObject("subModuleTypeCode");

	}
	
	public void setSubModuleTypeCode(String subModuleTypeCode) {
		setProperty("subModuleTypeCode", subModuleTypeCode);
	}
	
	public String getForUserType() {
		return forUserType;
	}
	public void setForUserType(String forUserType) {
		this.forUserType = forUserType;
	}
	
	public Set<AuthorizationMatrixCreditCardBO> getAuthorizationMatrixCreditCards() {
		return authorizationMatrixCreditCards;
	}
	public void setAuthorizationMatrixCreditCards(Set<AuthorizationMatrixCreditCardBO> authorizationMatrixCreditCards) {
		this.authorizationMatrixCreditCards = authorizationMatrixCreditCards;
	}
}
