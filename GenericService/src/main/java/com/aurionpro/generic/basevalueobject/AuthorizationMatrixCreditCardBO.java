package com.aurionpro.generic.basevalueobject;


/**
 * 
 * @author Kuntan Sutar
 *
 */
public class AuthorizationMatrixCreditCardBO extends ChildMakerCheckerBO {

	private Long mstId;
	private Long corporateCreditCardId;
	private String cardNumber;
	private Long corporateId;

	@Parent(AuthorizationMatrixBO.class)
	private AuthorizationMatrixBO parentBO;

	public AuthorizationMatrixCreditCardBO() {
		super();
	}

	


	/**
	 * @return the mstId
	 */
	public Long getMstId() {
		return (Long) getPropertyObject("mstId");
	}

	/**
	 * @param mstId
	 *            the mstId to set
	 */
	public void setMstId(Long mstId) {
		setProperty("mstId", mstId);
	}

	/**
	 * @return the corporateCreditCardId
	 */
	public Long getCorporateCreditCardId() {
		return (Long) getPropertyObject("corporateCreditCardId");
	}

	/**
	 * @param corporateCreditCardId
	 *            the corporateAccountId to set
	 */
	public void setCorporateCreditCardId(Long corporateCreditCardId) {
		setProperty("corporateCreditCardId", corporateCreditCardId);
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return (String) getPropertyObject("cardNumber");
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		setProperty("cardNumber", cardNumber);
	}

	/**
	 * @return the corporateId
	 */
	public Long getCorporateId() {
		return (Long) getPropertyObject("corporateId");
	}

	/**
	 * @param corporateId
	 *            the corporateId to set
	 */
	public void setCorporateId(Long corporateId) {
		setProperty("corporateId", corporateId);
	}

	/**
	 * @return the parentBO
	 */
	public AuthorizationMatrixBO getParentBO() {
		return parentBO;
	}

	/**
	 * @param parentBO
	 *            the parentBO to set
	 */
	public void setParentBO(AuthorizationMatrixBO parentBO) {
		this.parentBO = parentBO;
	}

}
