package com.aurionpro.cashpro.commons.security;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aurionpro.cashpro.commons.plugin.ProductKey;
import com.aurionpro.cashpro.commons.security.authorization.AuthorizationMatrix;



public class Ticket implements Serializable {
	private static final long serialVersionUID = -5380607104599263507L;
	
	
	//private static final String ENRICHMENT_ROOT_ELEMENT = "enrichments";

	//private static final String ENRICHMENT_ATTRIB_VALUE = "value";

	//private static final String ENRICHMENT_ATTRIB_NAME = "name";

	//private static final String ENRICHMENT_ELEMENT = "enrichment";
	
	// Id Column
	private String userId;

	private String loginId;
	
	private String loginName;
	
	private Boolean isAdminUser;
	
	private Boolean isEmulateCorporate = false;
	
	private Boolean isGroupAdminUser = false;
	
	private String additionalInfo;
	
	//private Document additionalInfoXML;
	
	private String profileName;

	
	private String profileId;

	private String clientIP;
	
	private Set<String> accessibleOuIds = new LinkedHashSet<String>();

	private Set<String> accessibleCashProProductIds = new LinkedHashSet<String>();

	private String currentCashProProductId;// = SecurityUtils.encryptId(1L);
	// private String ouId;
	// private String ouName;
	
	

	private Long guId = System.currentTimeMillis();

	private String applicationDate; // = DateUtils.toString(DateUtils.now()) ;

	private String userKey;

	private ProductKey productKey;

	private String loginOUId;

	private String loginOUName;

	private String currentOUId;

	private String currentOUName;

	private String userType;
	private String authenticationRequiredAt; 
	
	private String lastLogin;
	private Boolean hubUser;
	
	private String costCenterCode;
	
	// Added by Deep Upadhye for Group User
	private Boolean isGroupUser = false;
	private String groupId;

	private Boolean isGroupTransactional = false;

	private Boolean forGroup = false;
	
	private Boolean extendedTicket = false;
	
	/**
	 * TODO : Pravin to check this
	 */
	//private UserDTO userDTO;
	
	private String serialNo;
	
	private Integer category;
	
	
	private AuthorizationMatrix authorizationMatrix;
	private String sessionId;
	private Date lastAccessTime;
	private Map<String, String> enrichmentMap = new HashMap<String, String>();
	
	private boolean isAllAccountMapped;
	
	private String productName;
	
	private String isVerifier;
	
	private String baseCurrencyCode;
	private String baseCurrencyId;
	private String baseCountryCode;
	private String baseCountryId;
	private String languageSelected;
	
	private Map<String,String> isGroupUserVerifier = new HashMap<String,String>();
	
	private Map<String, VerificationDetail> veriDetailMap = new HashMap<String, VerificationDetail>();
	private Set<String> accessiblePaymentMethodIds = new LinkedHashSet<String>();
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getCurrentOUName() {
		return currentOUName;
	}

	public void setCurrentOUName(String currentOUName) {
		this.currentOUName = currentOUName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginOUName() {
		return loginOUName;
	}

	public void setLoginOUName(String loginOUName) {
		this.loginOUName = loginOUName;
	}

	public String getClientIP() {
		return clientIP;
	}

	public String getCurrentOUId() {
		return currentOUId;
	}

	public void setCurrentOUId(String currentOUId) {
		this.currentOUId = currentOUId;
	}

	public String getLoginOUId() {
		return loginOUId;
	}

	public void setLoginOUId(String loginOUId) {
		this.loginOUId = loginOUId;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	/**
	 * @return Returns the additionalInfo.
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	/**
	 * @param additionalInfo
	 *            The additionalInfo to set.
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	/**
	 * @return Returns the loginId.
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            The loginId to set.
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	// public String getOuId() {
	// return ouId;
	// }
	// public void setOuId(String ouId) {
	// this.ouId = ouId;
	// }
	public Set<String> getAccessibleCashProProductIds() {
		return accessibleCashProProductIds;
	}

	public void setAccessibleCashProProductIds(
			Set<String> accessibleCashProProductIds) {
		this.accessibleCashProProductIds = accessibleCashProProductIds;
	}

	public String getCurrentCashProProductId() {
		return currentCashProProductId;
	}

	public void setCurrentCashProProductId(String currentCashProProductId) {
		this.currentCashProProductId = currentCashProProductId;
	}

	public Set<String> getAccessibleOuIds() {
		return accessibleOuIds;
	}

	public void setAccessibleOuIds(Set<String> accessibleOuIds) {
		this.accessibleOuIds = accessibleOuIds;
	}

	public Boolean getIsAdminUser() {
		return isAdminUser;
	}

	public void setIsAdminUser(Boolean isAdminUser) {
		this.isAdminUser = isAdminUser;
	}

	public Boolean getIsEmulateCorporate() {
		return isEmulateCorporate;
	}

	public void setIsEmulateCorporate(Boolean isEmulateCorporate) {
		this.isEmulateCorporate = isEmulateCorporate;
	}
	
	public Boolean getIsGroupAdminUser() {
		return isGroupAdminUser;
	}

	public void setIsGroupAdminUser(Boolean isGroupAdminUser) {
		this.isGroupAdminUser = isGroupAdminUser;
	}

	// public String getOuName() {
	// return ouName;
	// }
	// public void setOuName(String ouName) {
	// this.ouName = ouName;
	// }
	/**
	 * @return Returns the applicationDate.
	 */
	public String getApplicationDate() {
		return applicationDate;
	}

	/**
	 * @param applicationDate
	 *            The applicationDate to set.
	 */
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getUserKey() {
		return userKey;
	}

	// public void setUserKey(String userKey) {
	// this.userKey = userKey;
	// }

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (this.getClass() != o.getClass())
			return false;

		Ticket other = (Ticket) o;
		String h2hTicekt = getEnrichment("CORPORATETIKECT");
		if("Y".equalsIgnoreCase(h2hTicekt)) {
			if (loginId != null && other.currentOUId != null){
				return ((this.loginId + this.currentOUId).equals(other.loginId+other.currentOUId) && this.guId
						.equals(other.guId));
			}
		}
		else {
			if (loginId != null){
				return (this.loginId.equals(other.loginId) && this.guId
						.equals(other.guId));
			}
		}

		return true;
		// return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		int result = 17;
		String h2hTicekt = getEnrichment("CORPORATETIKECT");
		if("Y".equalsIgnoreCase(h2hTicekt)) {
			result = 30 * ((loginId != null && currentOUId !=  null) ? (loginId + currentOUId).hashCode() : 0) + result;
		}
		else {
			result = 31 * ((loginId != null) ? loginId.hashCode() : 0) + result;
		}
		// result = 31 * ouId.hashCode() + result;
		return result;
		// return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * @return Returns the productKey.
	 */
	public ProductKey getProductKey() {
		return productKey;
	}

	/**
	 * @param key
	 *            The productKey to set.
	 */
	public void setProductKey(ProductKey key) {
		this.productKey = key;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthenticationRequiredAt() {
		return authenticationRequiredAt;
	}

	public void setAuthenticationRequiredAt(String authenticationRequiredAt) {
		this.authenticationRequiredAt = authenticationRequiredAt;
	}

	public String getEnrichment(String name) {
		/*try{
			
			Element enrichmentElement = getEnrichmentElement(name);
	
			if (enrichmentElement == null)
				return null;
	
			return enrichmentElement.attributeValue(ENRICHMENT_ATTRIB_VALUE);
		}finally{
			additionalInfoXML = null;
		}*/
		return enrichmentMap.get(name);
	}
	
	public void setEnrichment(String name, String value) {
		enrichmentMap.put(name, value);
		/*
		
		if (additionalInfoXML == null)
			additionalInfoXML = createEnrichment();
		
		Element enrichmentElement = getEnrichmentElement(name);
		if (enrichmentElement == null) {
			if (value != null)
				addEnrichment(name, value);
		} else {
			if (value != null)
				replaceEnrichmentValue(enrichmentElement, value);
			else
				removeEnrichment(enrichmentElement);
		}

		additionalInfo = additionalInfoXML.asXML();
		additionalInfoXML = null;
	*/}
	
	/*private Document createEnrichment() {
		Document document = DocumentFactory.getInstance().createDocument();
		if ( additionalInfo == null || additionalInfo.equals(" ") || additionalInfo == "" )
			document.addElement(ENRICHMENT_ROOT_ELEMENT);
		return document;
	}
	
	private void addEnrichment(String name, String value) {
		Element enrichment = additionalInfoXML.getRootElement().addElement(
				ENRICHMENT_ELEMENT);
		enrichment.addAttribute(ENRICHMENT_ATTRIB_NAME, name);
		enrichment.addAttribute(ENRICHMENT_ATTRIB_VALUE, value);
	}
	
	private void removeEnrichment(Element enrichmentElement) {
		additionalInfoXML.getRootElement().remove(enrichmentElement);
	}

	private void replaceEnrichmentValue(Element enrichmentElement, String value) {
		enrichmentElement.attribute(ENRICHMENT_ATTRIB_VALUE).setValue(value);
	}
	
	private Element getEnrichmentElement(String name) {
		
		if(additionalInfo == null)
			return null;
		
		try {
			additionalInfoXML = DocumentHelper.parseText(additionalInfo);
		} catch (DocumentException e) {
			//
		}
		
		if (additionalInfoXML == null) {
			return null;
		}

		Element rootElement = additionalInfoXML.getRootElement();
		List<Element> elements = rootElement.elements(ENRICHMENT_ELEMENT);
		for (Element element : elements) {
			String enrichmentName = element.attribute(ENRICHMENT_ATTRIB_NAME)
					.getValue();
			if (enrichmentName.equals(name))
				return element;
		}
		return null;
	}*/

	public Boolean getHubUser() {
		return hubUser;
	}

	public void setHubUser(Boolean hubUser) {
		this.hubUser = hubUser;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	
	public Boolean getIsGroupUser() {
		return isGroupUser;
	}

	public void setIsGroupUser(Boolean isGroupUser) {
		this.isGroupUser = isGroupUser;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupUserId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	/**
	 * @return the isGroupTransactional
	 */
	public Boolean getIsGroupTransactional() {
		return isGroupTransactional;
	}

	/**
	 * @param isGroupTransactional the isGroupTransactional to set
	 */
	public void setIsGroupTransactional(Boolean isGroupTransactional) {
		this.isGroupTransactional = isGroupTransactional;
	}


	/**
	 * @return the forGroup
	 */
	public Boolean isForGroup() {
		return forGroup;
	}

	/**
	 * @param forGroup the forGroup to set
	 */
	public void setForGroup(Boolean forGroup) {
		this.forGroup = forGroup;
	}

	public Boolean getExtendedTicket() {
		return extendedTicket;
	}

	public void setExtendedTicket(Boolean extendedTicket) {
		this.extendedTicket = extendedTicket;
	}

/*	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}*/

	public String getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(String costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	/**
	 * @return the authorizationMatrix
	 */
	public AuthorizationMatrix getAuthorizationMatrix() {
		return authorizationMatrix;
	}

	/**
	 * @param authorizationMatrix the authorizationMatrix to set
	 */
	public void setAuthorizationMatrix(AuthorizationMatrix authorizationMatrix) {
		this.authorizationMatrix = authorizationMatrix;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the lastAccessTime
	 */
	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	/**
	 * @param lastAccessTime the lastAccessTime to set
	 */
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public boolean isAllAccountMapped() {
		return isAllAccountMapped;
	}

	public void setAllAccountMapped(boolean isAllAccountMapped) {
		this.isAllAccountMapped = isAllAccountMapped;
	}

	public String getIsVerifier() {
		return isVerifier;
	}

	public void setIsVerifier(String isVerifier) {
		this.isVerifier = isVerifier;
	}

	public Map<String,String> getIsGroupUserVerifier() {
		return isGroupUserVerifier;
	}

	public void setIsGroupUserVerifier(Map<String,String> isGroupUserVerifier) {
		this.isGroupUserVerifier = isGroupUserVerifier;
	}

	public String getBaseCurrencyCode() {
		return baseCurrencyCode;
	}

	public void setBaseCurrencyCode(String baseCurrencyCode) {
		this.baseCurrencyCode = baseCurrencyCode;
	}

	public String getBaseCurrencyId() {
		return baseCurrencyId;
	}

	public void setBaseCurrencyId(String baseCurrencyId) {
		this.baseCurrencyId = baseCurrencyId;
	}

	public String getBaseCountryCode() {
		return baseCountryCode;
	}

	public void setBaseCountryCode(String baseCountryCode) {
		this.baseCountryCode = baseCountryCode;
	}

	public String getBaseCountryId() {
		return baseCountryId;
	}

	public void setBaseCountryId(String baseCountryId) {
		this.baseCountryId = baseCountryId;
	}

	public String getLanguageSelected() {
		return languageSelected;
	}

	public void setLanguageSelected(String languageSelected) {
		this.languageSelected = languageSelected;
	}

	public Map<String, VerificationDetail> getVeriDetailMap() {
		return veriDetailMap;
	}

	public void setVeriDetailMap(Map<String, VerificationDetail> veriDetailMap) {
		this.veriDetailMap = veriDetailMap;
	}

	public Set<String> getAccessiblePaymentMethodIds() {
		return accessiblePaymentMethodIds;
	}

	public void setAccessiblePaymentMethodIds(Set<String> accessiblePaymentMethodIds) {
		this.accessiblePaymentMethodIds = accessiblePaymentMethodIds;
	}
	
}