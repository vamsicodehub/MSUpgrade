package com.aurionpro.beneficiary.basevalueobject;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * 
 * @author hetal.karolia
 *
 */
public class AuthorizationMatrixSlabBO extends ParentChildMakerCheckerBO {

	private Double slabStartAmount = 0d;
	private Double slabEndAmount = 0d;
	private Long authMatrixMstId;
	private Boolean authRequired = false;
	private Character authorizationMode = 'S';
	private Boolean allowSkip = false;
	private Character authLevel = 'B';
	
	//	 For Board Resolution
	private String signatories;
	
	/**
	 * 
	 */
	private String profileNames;
	
	@Parent(AuthorizationMatrixBO.class)
	private AuthorizationMatrixBO parentBO;
	
	
	@Child(AuthorizationMatrixSlabDetBO.class)
	private Set<AuthorizationMatrixSlabDetBO> slabDetails = new LinkedHashSet<AuthorizationMatrixSlabDetBO>();
	
	public AuthorizationMatrixSlabBO(){
		super();
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

	/**
	 * @return the slabDetails
	 */
	public Set<AuthorizationMatrixSlabDetBO> getSlabDetails() {
		return slabDetails;
	}
	/**
	 * @param slabDetails the slabDetails to set
	 */
	public void setSlabDetails(Set<AuthorizationMatrixSlabDetBO> slabDetails) {
		this.slabDetails = slabDetails;
	}
	/**
	 * @return the slabEndAmount
	 */
	public Double getSlabEndAmount() {
		return (Double)getPropertyObject("slabEndAmount");
	}

	/**
	 * @param slabEndAmount the slabEndAmount to set
	 */
	public void setSlabEndAmount(Double slabEndAmount) {
		setProperty("slabEndAmount", slabEndAmount);
	}

	/**
	 * @return the slabStartAmount
	 */
	public Double getSlabStartAmount() {
		return (Double)getPropertyObject("slabStartAmount");
	}

	/**
	 * @param slabStartAmount the slabStartAmount to set
	 */
	public void setSlabStartAmount(Double slabStartAmount) {
		setProperty("slabStartAmount", slabStartAmount);
	}
	/**
	 * @return the authMatrixMstId
	 */
	public Long getAuthMatrixMstId() {
		return (Long)getPropertyObject("authMatrixMstId");
	}
	/**
	 * @param authMatrixMstId the authMatrixMstId to set
	 */
	public void setAuthMatrixMstId(Long authMatrixMstId) {
		setProperty("authMatrixMstId", authMatrixMstId);
	}
	
	
	
	public String getSignatories() {
		StringBuffer signatoriesBuffer = new StringBuffer();
		Set<AuthorizationMatrixSlabDetBO> selectedSlabDetails = this.getSlabDetails();
		for(AuthorizationMatrixSlabDetBO slabDetBO : selectedSlabDetails){
			if(signatoriesBuffer.toString().endsWith("]")){
				signatoriesBuffer.append(" AND ");
			}
			signatoriesBuffer.append("[Profile ").append(slabDetBO.getProfileName() + "(");
			String users = slabDetBO.getUserNames();
			String[] userIds = users.split(",");
			for(int index = 0; index < userIds.length; index++){
				if(index == 0)
					signatoriesBuffer.append(userIds[index]);
				else
					signatoriesBuffer.append("," + userIds[index]);
			}
			signatoriesBuffer.append(")]");
		}
		return signatoriesBuffer.toString();
	}
	
	public Boolean getAuthRequired() {
		return (Boolean)getPropertyObject("authRequired");
	}
	public void setAuthRequired(Boolean authRequired) {
		setProperty("authRequired", authRequired);
	}
	/**
	 * @return the parentBO
	 */
	public AuthorizationMatrixBO getParentBO() {
		return parentBO;
	}
	/**
	 * @param parentBO the parentBO to set
	 */
	public void setParentBO(AuthorizationMatrixBO parentBO) {
		this.parentBO = parentBO;
	}
	/**
	 * @return the profileNames
	 */
	public String getProfileNames() {
		StringBuffer signatoriesBuffer = new StringBuffer();
		Set<AuthorizationMatrixSlabDetBO> selectedSlabDetails = this.getSlabDetails();
		//String oldProfileName="";
		for(AuthorizationMatrixSlabDetBO slabDetBO : selectedSlabDetails){
			//oldProfileName=slabDetBO.getProfileName();
			if(signatoriesBuffer.toString().endsWith("]")){
				signatoriesBuffer.append(" AND ");
			}
			signatoriesBuffer.append("[").append(slabDetBO.getProfileName() + "(");
			signatoriesBuffer.append(slabDetBO.getNoOfAuthorizers());
			signatoriesBuffer.append(")]");
		}
		return signatoriesBuffer.toString();
	}
	
}
