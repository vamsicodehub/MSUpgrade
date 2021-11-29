package com.aurionpro.generic.basevalueobject;

import com.aurionpro.generic.encryption.EncryptUtils;
import com.aurionpro.generic.enums.MatrixType;
import com.aurionpro.generic.utils.FieldNameUtil;

/**
 * 
 * @author hetal.karolia
 *
 */
public class AuthorizationMatrixSlabDetBO extends ChildMakerCheckerBO  {
	
	private Long profile;
	private String profileName;
	private String users;
	private Long priority;
	private Long noOfAuthorizers;
	private Long authSlabId;
	private String userNames;
	
	@Parent(AuthorizationMatrixSlabBO.class)
	private AuthorizationMatrixSlabBO parentBO;
	


	public AuthorizationMatrixSlabDetBO() {
		super();
	}


	/**
	 * @return the priority
	 */
	public Long getPriority() {
		return (Long)getPropertyObject("priority");
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Long priority) {
		setProperty("priority", priority);
	}
	
	/**
	 * @return the authSlabId
	 */
	public Long getAuthSlabId() {
		return (Long)getPropertyObject("authSlabId");
	}

	/**
	 * @param authSlabId the authSlabId to set
	 */
	public void setAuthSlabId(Long authSlabId) {
		setProperty("authSlabId", authSlabId);
	}

	/**
	 * @return the noOfAuthorizers
	 */
	public Long getNoOfAuthorizers() {
		return (Long)getPropertyObject("noOfAuthorizers");
	}

	/**
	 * @param noOfAuthorizers the noOfAuthorizers to set
	 */
	public void setNoOfAuthorizers(Long noOfAuthorizers) {
		setProperty("noOfAuthorizers", noOfAuthorizers);
	}

	/**
	 * @return the parentBO
	 */
	public AuthorizationMatrixSlabBO getParentBO() {
		return parentBO;
	}

	/**
	 * @param parentBO the parentBO to set
	 */
	public void setParentBO(AuthorizationMatrixSlabBO parentBO) {
		this.parentBO = parentBO;
	}

	/**
	 * @return the profileId
	 */
	public Long getProfile() {
		return (Long)getPropertyObject("profile");
	}
	
	/**
	 * @param priority the priority to set
	 */
	public void setProfile(Long profile) {
		setProperty("profile", profile);
	}

	/**
	 * Decrypt UserIds
	 * @param userIds
	 * @return
	 */
	private String getDecryptedUserIds(String userIds) {
		String[] decryptedUserIds = userIds.split(",");
		StringBuffer decryptUserIds = new StringBuffer();
		for(String decyrptedUserId : decryptedUserIds){
			decryptUserIds.append(EncryptUtils.decryptId(decyrptedUserId)+",");
		}
		return decryptUserIds.toString().substring(0, decryptUserIds.length()-1);
	}

	/**
	 * Encrypt UserIds
	 * @return
	 */
	public String getEncryptedUserIds(){
		String decryptedUserIds = getUsers();
		
		String[] decyptedValues = decryptedUserIds.split(",");
		
		StringBuffer encryptedUserIds = new StringBuffer();
		for(String decyrptedUserId : decyptedValues){
			encryptedUserIds.append(EncryptUtils.encryptId(Long.parseLong(decyrptedUserId))+",");
		}
		return encryptedUserIds.toString().substring(0, encryptedUserIds.length()-1);
		
	}

	public String getUsers() {
		return (String)getPropertyObject("users");
	}

	public void setUsers(String users) {
		setProperty("users", users);
	}

	public String getUserNames() {
		String[] usersArray = this.getUsers().split(",");
		StringBuffer userNamesBuffer = new StringBuffer();
		for(int index = 0; index < usersArray.length; index++){
			if(index != (usersArray.length - 1)){
				if(!getParentBO().getParentBO().getMatrixType().equals(MatrixType.BANKMATRIX))
					userNamesBuffer.append(FieldNameUtil.getCorporateUserId(Long.valueOf(usersArray[index])) + ",");
				else	
					userNamesBuffer.append(FieldNameUtil.getBankUserLoginId(Long.valueOf(usersArray[index])) + ",");
			}else{
				if(!getParentBO().getParentBO().getMatrixType().equals(MatrixType.BANKMATRIX))
					userNamesBuffer.append(FieldNameUtil.getCorporateUserId(Long.valueOf(usersArray[index])));
				else
					userNamesBuffer.append(FieldNameUtil.getBankUserLoginId(Long.valueOf(usersArray[index])));
			}
		}
		userNames = userNamesBuffer.toString();
		return userNames;
	}

	public String getProfileName() {
		this.profileName = FieldNameUtil.getProfileName(this.getProfile());
		return profileName;
	}
	
	
	
}
