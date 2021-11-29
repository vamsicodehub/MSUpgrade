package com.aurionpro.beneficiary.assembler;

import com.aurionpro.beneficiary.baserequest.BaseDetails;
import com.aurionpro.beneficiary.basevalueobject.BaseBO;
import com.aurionpro.beneficiary.encryption.EncryptUtils;
import com.aurionpro.beneficiary.encryption.RemoteException;
import com.aurionpro.beneficiary.enums.BeneficiaryType;
import com.aurionpro.beneficiary.enums.RequestBy;
import com.aurionpro.beneficiary.exceptions.BaseException;
import com.aurionpro.beneficiary.requestobject.Beneficiary;
import com.aurionpro.beneficiary.valueobject.BeneficiaryBO;

// TODO: Auto-generated Javadoc
/**
 * The Class BeneficiaryAssembler.
 * 
 * @author fardeen.shaikh
 */
public class BeneficiaryAssembler extends MakerCheckerDetailsAssembler {

	/** The instance. */
	private static BeneficiaryAssembler instance;

	/**
	 * Gets the single instance of BeneficiaryAssembler.
	 *
	 * @return single instance of BeneficiaryAssembler
	 */
	public static BeneficiaryAssembler getInstance() {
		if (null == instance) {
			synchronized (BeneficiaryAssembler.class) {
				if (null == instance) {
					instance = new BeneficiaryAssembler();
				}
			}
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aurionpro.cashpro.commons.rest.assembler.MasterAssembler#assembleDTO
	 * (com.aurionpro.cashpro.commons.dto.BaseDTO,
	 * com.aurionpro.cashpro.rest.base.BaseDetails,
	 * com.aurionpro.cashpro.commons.security.Ticket)
	 */
	@Override
	public BeneficiaryBO assemble(BaseBO bo, BaseDetails details) throws BaseException, RemoteException {
		
		bo=super.assemble(bo, details);
		
		BeneficiaryBO beneficiaryBO = (BeneficiaryBO) bo;
		Beneficiary beneficiaryDetails = (Beneficiary) details;
		
		if (!"".equals(details.getId()) && details.getId() != null) {
			beneficiaryBO.setId(EncryptUtils.decryptId(details.getId()));
		} else {
			beneficiaryBO.setId(0L);
		}
		
		/**
		 * TODO: Pravin check dependency
		 */
		beneficiaryBO.setCorporateUserId(100071L);
		beneficiaryBO.setCorporateId(100071L);
		
		
		if (beneficiaryDetails.getBeneficiaryType().equalsIgnoreCase(BeneficiaryType.GENERIC.name())) {
			beneficiaryBO.setBeneficiaryType(BeneficiaryType.GENERIC.name());
		} else if (beneficiaryDetails.getBeneficiaryType().equalsIgnoreCase(BeneficiaryType.USERWISE.name())) {
			beneficiaryBO.setBeneficiaryType(BeneficiaryType.USERWISE.name());
		}
		
		beneficiaryBO.setBeneficiaryCode(beneficiaryDetails.getBeneficiaryCode());
		beneficiaryBO.setBeneficiaryName(beneficiaryDetails.getBeneficiaryName());
		/*if (null == beneficiaryDetails.getPayeeName() || "".equalsIgnoreCase(beneficiaryDetails.getPayeeName())) {
			beneficiaryDTO.setPayeeName(beneficiaryDetails.getBeneficiaryName());
		} else {*/
		beneficiaryBO.setPayeeName(beneficiaryDetails.getPayeeName());
		/*}*/
		beneficiaryBO.setAddress1(beneficiaryDetails.getAddress1());
		beneficiaryBO.setAddress2(beneficiaryDetails.getAddress2());
		beneficiaryBO.setAddress3(beneficiaryDetails.getAddress3());
		beneficiaryBO.setPinCode(beneficiaryDetails.getPinCode());
		beneficiaryBO.setEmail(beneficiaryDetails.getEmail());
		beneficiaryBO.setFaxNo(beneficiaryDetails.getFaxNo());
		beneficiaryBO.setPhoneNo(beneficiaryDetails.getPhoneNo());
		beneficiaryBO.setAdhocLimit(0.0);
		
		/**
		 * TODO: Pravin to check dependency
		 */
		beneficiaryBO.setOverallLimit(0.0);
		
		beneficiaryBO.setRequestBy(RequestBy.CORPORATE.name());
		
		/*if (ticket.getUserType().equals(RequestBy.CORPORATE.name())) {
			beneficiaryDTO.setRequestBy(RequestBy.CORPORATE);
		} else {
			beneficiaryDTO.setRequestBy(RequestBy.BANK);
		}*/
		return beneficiaryBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aurionpro.cashpro.commons.rest.assembler.MasterAssembler#assembleDetails
	 * (com.aurionpro.cashpro.commons.dto.BaseDTO,
	 * com.aurionpro.cashpro.rest.base.BaseDetails,
	 * com.aurionpro.cashpro.commons.security.Ticket)
	 */
	@Override
	public void assembleDetails(BaseBO bo, BaseDetails details)
			throws BaseException, RemoteException {
		super.assembleDetails(bo, details);
		BeneficiaryBO beneficiaryBO = (BeneficiaryBO) bo;
		
		details.setId(EncryptUtils.encryptId(beneficiaryBO.getId()));
		Beneficiary beneficiaryDetails = (Beneficiary) details;
		beneficiaryDetails.setBeneficiaryType(beneficiaryBO.getBeneficiaryType());
		beneficiaryDetails.setBeneficiaryCode(beneficiaryBO.getBeneficiaryCode());
		beneficiaryDetails.setBeneficiaryName(beneficiaryBO.getBeneficiaryName());
		beneficiaryDetails.setPayeeName(beneficiaryBO.getPayeeName());
		beneficiaryDetails.setAddress1(beneficiaryBO.getAddress1());
		beneficiaryDetails.setAddress2(beneficiaryBO.getAddress2());
		beneficiaryDetails.setAddress3(beneficiaryBO.getAddress3());
		if(null!=beneficiaryBO.getPinCode() && "-".equalsIgnoreCase(beneficiaryBO.getPinCode()))
			beneficiaryDetails.setPinCode("");
		else{
			beneficiaryDetails.setPinCode(beneficiaryBO.getPinCode());
		}
		beneficiaryDetails.setEmail(beneficiaryBO.getEmail());
		
		if(null!=beneficiaryBO.getPhoneNo() && "-".equalsIgnoreCase(beneficiaryBO.getPhoneNo()))
			beneficiaryDetails.setPhoneNo("");
		else{
			beneficiaryDetails.setPhoneNo(beneficiaryBO.getPhoneNo());
		}
		if(null!=beneficiaryBO.getFaxNo() && "-".equalsIgnoreCase(beneficiaryBO.getFaxNo()))
			beneficiaryDetails.setFaxNo("");
		else{
			beneficiaryDetails.setFaxNo(beneficiaryBO.getFaxNo());
		}
		
		
	}
}
