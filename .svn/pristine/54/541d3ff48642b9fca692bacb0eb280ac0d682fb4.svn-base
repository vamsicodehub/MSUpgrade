package com.aurionpro.generic.basevalueobject;

import com.aurionpro.generic.utils.FieldNameUtil;

/**
 * 
 * @author Deep Upadhye
 *
 */
public class AuthorizationMatrixAccountBO extends ChildMakerCheckerBO {

	private Long mstId;
	private Long corporateAccountId;
	private String corporateAccountNo;
	private Long corporateId;
	private String corporateName;
	
	private Long groupId;

	@Parent(AuthorizationMatrixBO.class)
	private AuthorizationMatrixBO parentBO;

	public AuthorizationMatrixAccountBO() {
		super();
	}

	/**
	 * @return the mstId
	 */
	public Long getMstId() {
		return (Long) getPropertyObject("mstId");
	}

	/**
	 * @param mstId the mstId to set
	 */
	public void setMstId(Long mstId) {
		setProperty("mstId", mstId);
	}

	/**
	 * @return the corporateAccountId
	 */
	public Long getCorporateAccountId() {
		return (Long) getPropertyObject("corporateAccountId");
	}

	/**
	 * @param corporateAccountId the corporateAccountId to set
	 */
	public void setCorporateAccountId(Long corporateAccountId) {
		setProperty("corporateAccountId",corporateAccountId);
	}

	/**
	 * @return the corporateAccountNo
	 */
	public String getCorporateAccountNo() {
		return (String) getPropertyObject("corporateAccountNo");
	}

	/**
	 * @param corporateAccountNo the corporateAccountNo to set
	 */
	public void setCorporateAccountNo(String corporateAccountNo) {
		setProperty("corporateAccountNo",corporateAccountNo);
	}

	/**
	 * @return the corporateId
	 */
	public Long getCorporateId() {
		return (Long) getPropertyObject("corporateId");
	}

	/**
	 * @param corporateId the corporateId to set
	 */
	public void setCorporateId(Long corporateId) {
		setProperty("corporateId",corporateId);
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
	 * @return the corporateName
	 */
	public String getCorporateName() {
		return FieldNameUtil.getCorporateName(this.getCorporateId());
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

}
