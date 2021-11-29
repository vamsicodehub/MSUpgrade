package com.aurionpro.beneficiary.assembler;

import com.aurionpro.beneficiary.baserequest.BaseDetails;
import com.aurionpro.beneficiary.basevalueobject.BaseBO;
import com.aurionpro.beneficiary.encryption.EncryptUtils;
import com.aurionpro.beneficiary.encryption.RemoteException;
import com.aurionpro.beneficiary.enums.DispatchMode;
import com.aurionpro.beneficiary.enums.DispatchTo;
import com.aurionpro.beneficiary.enums.PaymentMethod;
import com.aurionpro.beneficiary.enums.RequestBy;
import com.aurionpro.beneficiary.exceptions.BaseException;
import com.aurionpro.beneficiary.requestobject.BeneficiaryPaymentMethodMap;
import com.aurionpro.beneficiary.valueobject.BeneficiaryPaymentMethodMapBO;

// TODO: Auto-generated Javadoc
/**
 * The Class BeneficiaryPaymentMethodMapAssembler.
 * 
 * @author fardeen.shaikh
 */
public class BeneficiaryPaymentMethodMapAssembler extends MakerCheckerDetailsAssembler {

	/** The instance. */
	private static BeneficiaryPaymentMethodMapAssembler instance;

	/**
	 * Gets the single instance of BeneficiaryPaymentMethodMapAssembler.
	 *
	 * @return single instance of BeneficiaryPaymentMethodMapAssembler
	 */
	public static BeneficiaryPaymentMethodMapAssembler getInstance() {
		if (null == instance) {
			synchronized (BeneficiaryPaymentMethodMapAssembler.class) {
				if (null == instance) {
					instance = new BeneficiaryPaymentMethodMapAssembler();
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
	public BeneficiaryPaymentMethodMapBO assemble(BaseBO bo, BaseDetails details) throws BaseException, RemoteException {
		
		bo = super.assemble(bo, details);
		
		BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO = (BeneficiaryPaymentMethodMapBO) bo;
		
		/**
		 * TODO:Pravin need to be checked
		 */
		if (!"".equals(details.getId()) && details.getId() != null) {
			beneficiaryPaymentMethodMapBO.setId(EncryptUtils.decryptId(details.getId()));
		} else {
			beneficiaryPaymentMethodMapBO.setId(0L);
		}
		
		BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails = (BeneficiaryPaymentMethodMap) details;
		
		/**
		 * TODO: Pravin Ticket dependency
		 */
		beneficiaryPaymentMethodMapBO.setCorporateId(100071L);
		beneficiaryPaymentMethodMapBO.setRequestBy(RequestBy.CORPORATE.name());
		beneficiaryPaymentMethodMapBO.setCorporateUserId(100071L);
		
	/*	if (ticket.getUserType().equals(RequestBy.CORPORATE.name())) {
			beneficiaryPaymentMethodMapDTO.setRequestBy(RequestBy.CORPORATE);
		} else {
			beneficiaryPaymentMethodMapDTO.setRequestBy(RequestBy.BANK);
		}*/
		
		
		
		/**
		 * TODO: Pravin check the requirement
		 */

		//beneficiaryPaymentMethodMapBO.setCorporateName(FieldNameUtil.getCorporateName(EncryptUtils.decryptId(EncryptUtils.getId(ticket.getCurrentOUId()))));
		
		/**
		 * TODO: Pravin check to be handled automatically
		 */
		//beneficiaryPaymentMethodMapBO.setBeneficiaryId(EncryptUtils.decryptId(beneficiaryPaymentMethodMapDetails.getBeneficiaryId()));
		
		/**
		 * TODO: Pravin check the requirement
		 */

		//beneficiaryPaymentMethodMapBO.setBeneficiaryName(beneficiaryPaymentMethodMapDetails.getBeneficiaryName());
		
		beneficiaryPaymentMethodMapBO.setPayeeName(beneficiaryPaymentMethodMapDetails.getPayeeName());
		beneficiaryPaymentMethodMapBO.setPaymentMethodId(EncryptUtils.decryptId(beneficiaryPaymentMethodMapDetails.getPaymentMethodId()));
		
		/**
		 * TODO: Pravin check the requirement
		 */
		//beneficiaryPaymentMethodMapBO.setPaymentMethodName(beneficiaryPaymentMethodMapDetails.getPaymentMethodName());
		beneficiaryPaymentMethodMapBO.setDefaultPaymentMethod(false);
	
		beneficiaryPaymentMethodMapBO.setBeneficiaryLimit(0.0);
		if (beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.PP6.name()) 
				|| beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.PP7.name())
				|| beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.PP8.name())
				|| beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.PP10.name())
				|| beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.PP11.name())) {
			assembleDtoForPaperPayment(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		} else if (beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP14.name())) {
			assembleDtoForEP14(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		} else if (beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP1.name())) {
			assembleDtoForEP1(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		} else if (beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP3.name())) {
			assembleDtoForEP3(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		} else if (beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP17.name()) || beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP18.name())) {
			assembleDtoForEP17(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		} else if (beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP10.name()) || beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP5.name())) {
			assembleDtoForEP5(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		} else if (beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP9.name())) {
			assembleDtoForEP9(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		} else if (beneficiaryPaymentMethodMapDetails.getPaymentMethodCode().equals(PaymentMethod.EP19.name())) {
			assembleDtoForEP19(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		}
		
		beneficiaryPaymentMethodMapBO.setLocationName(beneficiaryPaymentMethodMapDetails.getLocationName());
		beneficiaryPaymentMethodMapBO.setStateName(beneficiaryPaymentMethodMapDetails.getStateName());
		beneficiaryPaymentMethodMapBO.setCountryName(beneficiaryPaymentMethodMapDetails.getCountryName());
		beneficiaryPaymentMethodMapBO.setEffectiveFrom(beneficiaryPaymentMethodMapDetails.getEffectiveFrom());
		beneficiaryPaymentMethodMapBO.setEffectiveTill(beneficiaryPaymentMethodMapDetails.getEffectiveTill());
		beneficiaryPaymentMethodMapBO.setSwiftCode(beneficiaryPaymentMethodMapDetails.getBicCode());
		return beneficiaryPaymentMethodMapBO;
	}

	private void assembleDtoForEP19(BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,
			BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO) {
		
		if (null != beneficiaryPaymentMethodMapDetails.getiBanNo()) {
			beneficiaryPaymentMethodMapBO.setEnrichment("AccountTypeLabel","IBAN");
			beneficiaryPaymentMethodMapBO.setAccountNo(beneficiaryPaymentMethodMapDetails.getiBanNo());
		}
		
		beneficiaryPaymentMethodMapBO.setBankCode(beneficiaryPaymentMethodMapDetails.getBankCode());
		beneficiaryPaymentMethodMapBO.setBranchCode(beneficiaryPaymentMethodMapDetails.getBranchCode());
		beneficiaryPaymentMethodMapBO.setBankName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBank());
		beneficiaryPaymentMethodMapBO.setBranchName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBankBranch());
		beneficiaryPaymentMethodMapBO.setAddress1(beneficiaryPaymentMethodMapDetails.getAddress1());
		beneficiaryPaymentMethodMapBO.setAddress2(beneficiaryPaymentMethodMapDetails.getAddress2());
		beneficiaryPaymentMethodMapBO.setAddress3(beneficiaryPaymentMethodMapDetails.getAddress3());
		beneficiaryPaymentMethodMapBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());
		
	}

	public void assembleDtoForPaperPayment(
			BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,
			BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO) {

		if (null != beneficiaryPaymentMethodMapDetails.getDispatchTo()) {
			if (beneficiaryPaymentMethodMapDetails.getDispatchTo().equalsIgnoreCase(DispatchTo.BENEFICIARY.name())) {
				beneficiaryPaymentMethodMapBO.setDispatchTo(DispatchTo.BENEFICIARY);
			}
			if (beneficiaryPaymentMethodMapDetails.getDispatchTo().equalsIgnoreCase(DispatchTo.CORPORATE.name())) {
				beneficiaryPaymentMethodMapBO.setDispatchTo(DispatchTo.CORPORATE);
			}
		}
		if (null != beneficiaryPaymentMethodMapDetails.getInstrumentDispatchMode()) {
			if (beneficiaryPaymentMethodMapDetails.getInstrumentDispatchMode().equalsIgnoreCase(DispatchMode.MAIL.name())) {
				beneficiaryPaymentMethodMapBO.setInstrumentDispatchMode(DispatchMode.MAIL);
			}
			if (beneficiaryPaymentMethodMapDetails.getInstrumentDispatchMode().equalsIgnoreCase(DispatchMode.COURIER.name())) {
				beneficiaryPaymentMethodMapBO.setInstrumentDispatchMode(DispatchMode.COURIER);
			}
			if (beneficiaryPaymentMethodMapDetails.getInstrumentDispatchMode().equalsIgnoreCase(DispatchMode.COUNTERCOLLECT.name())) {
				beneficiaryPaymentMethodMapBO.setInstrumentDispatchMode(DispatchMode.COUNTERCOLLECT);
			}
		}
		beneficiaryPaymentMethodMapBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());

	}

	public void assembleDtoForEP14(BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO) {

		beneficiaryPaymentMethodMapBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());

	}

	public void assembleDtoForEP1(
			BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,
			BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMaBO) {

		if (null != beneficiaryPaymentMethodMapDetails.getAccountNo()) {
			beneficiaryPaymentMethodMaBO.setAccountNo(beneficiaryPaymentMethodMapDetails.getAccountNo());
		}
		beneficiaryPaymentMethodMaBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());
	}

	public void assembleDtoForEP3(BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO) {
		
		if(null != beneficiaryPaymentMethodMapDetails.getBicCode()){
			beneficiaryPaymentMethodMapBO.setSwiftCode(beneficiaryPaymentMethodMapDetails.getBicCode());
		}
		if (null != beneficiaryPaymentMethodMapDetails.getiBanNo()) {
			beneficiaryPaymentMethodMapBO.setEnrichment("AccountTypeLabel","IBAN");
			beneficiaryPaymentMethodMapBO.setAccountNo(beneficiaryPaymentMethodMapDetails.getiBanNo());
		}
		if (null != beneficiaryPaymentMethodMapDetails.getCardPayment()) {
			beneficiaryPaymentMethodMapBO.setEnrichment("AccountTypeLabel","Credit Card / Salary Card Payment");
			beneficiaryPaymentMethodMapBO.setAccountNo(beneficiaryPaymentMethodMapDetails.getCardPayment());
		}
		beneficiaryPaymentMethodMapBO.setBankCode(beneficiaryPaymentMethodMapDetails.getBankCode());
		beneficiaryPaymentMethodMapBO.setBankSortCode(beneficiaryPaymentMethodMapDetails.getBankSortCode());
		beneficiaryPaymentMethodMapBO.setBankName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBank());
		beneficiaryPaymentMethodMapBO.setBranchName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBankBranch());
		beneficiaryPaymentMethodMapBO.setAddress1(beneficiaryPaymentMethodMapDetails.getAddress1());
		beneficiaryPaymentMethodMapBO.setAddress2(beneficiaryPaymentMethodMapDetails.getAddress2());
		beneficiaryPaymentMethodMapBO.setAddress3(beneficiaryPaymentMethodMapDetails.getAddress3());
		beneficiaryPaymentMethodMapBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());

	}

	public void assembleDtoForEP17(BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO) {

		if (null != beneficiaryPaymentMethodMapDetails.getiBanNo()) {
			beneficiaryPaymentMethodMapBO.setEnrichment("AccountTypeLabel","IBAN");
			beneficiaryPaymentMethodMapBO.setAccountNo(beneficiaryPaymentMethodMapDetails.getiBanNo());
		}
		if(beneficiaryPaymentMethodMapDetails.getBankCode() == null){
			System.out.println("Bank Code is null");
		}
		if(beneficiaryPaymentMethodMapDetails.getBankCode() != null && "".equalsIgnoreCase(beneficiaryPaymentMethodMapDetails.getBankCode())){
			System.out.println("Bank Code is Blank");
		}
		
		if(beneficiaryPaymentMethodMapDetails.getBranchCode() == null){
			System.out.println("Branch Code is null");
		}
		if(beneficiaryPaymentMethodMapDetails.getBranchCode() != null && "".equalsIgnoreCase(beneficiaryPaymentMethodMapDetails.getBranchCode())){
			System.out.println("Branch Code is Blank");
		}
		beneficiaryPaymentMethodMapBO.setBankCode(beneficiaryPaymentMethodMapDetails.getBankCode());
		beneficiaryPaymentMethodMapBO.setBranchCode(beneficiaryPaymentMethodMapDetails.getBranchCode());
		beneficiaryPaymentMethodMapBO.setBankName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBank());
		beneficiaryPaymentMethodMapBO.setBranchName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBankBranch());
		beneficiaryPaymentMethodMapBO.setAddress1(beneficiaryPaymentMethodMapDetails.getAddress1());
		beneficiaryPaymentMethodMapBO.setAddress2(beneficiaryPaymentMethodMapDetails.getAddress2());
		beneficiaryPaymentMethodMapBO.setAddress3(beneficiaryPaymentMethodMapDetails.getAddress3());
		beneficiaryPaymentMethodMapBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());
	}

	public void assembleDtoForEP5(BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO) {

		if (null != beneficiaryPaymentMethodMapDetails.getBicCode()) {
			beneficiaryPaymentMethodMapBO.setSwiftCode(beneficiaryPaymentMethodMapDetails.getBicCode());
		}
		beneficiaryPaymentMethodMapBO.setBankCode(beneficiaryPaymentMethodMapDetails.getBankCode());
		beneficiaryPaymentMethodMapBO.setBankName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBank());
		beneficiaryPaymentMethodMapBO.setBranchName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBankBranch());
		beneficiaryPaymentMethodMapBO.setAddress1(beneficiaryPaymentMethodMapDetails.getAddress1());
		beneficiaryPaymentMethodMapBO.setAddress2(beneficiaryPaymentMethodMapDetails.getAddress2());
		beneficiaryPaymentMethodMapBO.setAddress3(beneficiaryPaymentMethodMapDetails.getAddress3());
		beneficiaryPaymentMethodMapBO.setBankSortCode(beneficiaryPaymentMethodMapDetails.getBankSortCode());
		
		if (null != beneficiaryPaymentMethodMapDetails.getAccountNo()) {
			beneficiaryPaymentMethodMapBO.setAccountNo(beneficiaryPaymentMethodMapDetails.getAccountNo());
		}
		
		beneficiaryPaymentMethodMapBO.setIntermediaryBankBicCode(beneficiaryPaymentMethodMapDetails.getIntermediaryBankBicCode());
		beneficiaryPaymentMethodMapBO.setIntermediarySortCode(beneficiaryPaymentMethodMapDetails.getIntermediarySortCode());
		beneficiaryPaymentMethodMapBO.setIntermediaryBank(beneficiaryPaymentMethodMapDetails.getIntermediaryBankName());
		beneficiaryPaymentMethodMapBO.setIntermediaryBranch(beneficiaryPaymentMethodMapDetails.getIntermediaryBranchName());
		beneficiaryPaymentMethodMapBO.setIntermediaryBankAdd1(beneficiaryPaymentMethodMapDetails.getIntermediaryBankAddress1());
		beneficiaryPaymentMethodMapBO.setIntermediaryBankAdd2(beneficiaryPaymentMethodMapDetails.getIntermediaryBankAddress2());
		beneficiaryPaymentMethodMapBO.setIntermediaryBankAdd3(beneficiaryPaymentMethodMapDetails.getIntermediaryBankAddress3());
		beneficiaryPaymentMethodMapBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());

	}

	public void assembleDtoForEP9(
			BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,
			BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO) {

		if (null != beneficiaryPaymentMethodMapDetails.getPaymentChannel()) {
			if (beneficiaryPaymentMethodMapDetails.getPaymentChannel().equals(
					"IFT")) {
				beneficiaryPaymentMethodMapBO.setPaymentType(PaymentMethod.EP1.name());
				if (null != beneficiaryPaymentMethodMapDetails.getAccountNo()) {
					beneficiaryPaymentMethodMapBO.setAccountNo(beneficiaryPaymentMethodMapDetails
									.getAccountNo());
				}
				beneficiaryPaymentMethodMapBO
						.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails
								.getBeneDispatchMode());

			}
			if (beneficiaryPaymentMethodMapDetails.getPaymentChannel().equals(
					"EFD")) {
				beneficiaryPaymentMethodMapBO.setPaymentType(PaymentMethod.EP3
						.name());

				if (null != beneficiaryPaymentMethodMapDetails.getiBanNo()) {
					beneficiaryPaymentMethodMapBO.setEnrichment(
							"AccountTypeLabel", "IBAN");
					beneficiaryPaymentMethodMapBO
							.setAccountNo(beneficiaryPaymentMethodMapDetails
									.getiBanNo());
				}
				if (null != beneficiaryPaymentMethodMapDetails.getCardPayment()) {
					beneficiaryPaymentMethodMapBO.setEnrichment(
							"AccountTypeLabel",
							"Credit Card / Salary Card Payment");
					beneficiaryPaymentMethodMapBO
							.setAccountNo(beneficiaryPaymentMethodMapDetails
									.getCardPayment());
				}

				if (null != beneficiaryPaymentMethodMapDetails.getRoutingCode()) {
					beneficiaryPaymentMethodMapBO.setSwiftCode(beneficiaryPaymentMethodMapDetails.getRoutingCode());
				}
				beneficiaryPaymentMethodMapBO.setBankName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBank());
				beneficiaryPaymentMethodMapBO.setBranchName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBankBranch());
				beneficiaryPaymentMethodMapBO.setAddress1(beneficiaryPaymentMethodMapDetails.getAddress1());
				beneficiaryPaymentMethodMapBO.setAddress2(beneficiaryPaymentMethodMapDetails.getAddress2());
				beneficiaryPaymentMethodMapBO.setAddress3(beneficiaryPaymentMethodMapDetails.getAddress3());
				beneficiaryPaymentMethodMapBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());

			}
			if (beneficiaryPaymentMethodMapDetails.getPaymentChannel().equals(
					"EFI")) {
				beneficiaryPaymentMethodMapBO.setPaymentType(PaymentMethod.EP5
						.name());
				if (null != beneficiaryPaymentMethodMapDetails.getAccountNo()) {
					beneficiaryPaymentMethodMapBO
							.setAccountNo(beneficiaryPaymentMethodMapDetails
									.getAccountNo());
				}
				if (null != beneficiaryPaymentMethodMapDetails.getBicCode()) {
					beneficiaryPaymentMethodMapBO
							.setSwiftCode(beneficiaryPaymentMethodMapDetails
									.getBicCode());
				}
				beneficiaryPaymentMethodMapBO
						.setBankName(beneficiaryPaymentMethodMapDetails
								.getBeneficiaryBank());
				beneficiaryPaymentMethodMapBO.setBranchName(beneficiaryPaymentMethodMapDetails.getBeneficiaryBankBranch());
				beneficiaryPaymentMethodMapBO.setAddress1(beneficiaryPaymentMethodMapDetails.getAddress1());
				beneficiaryPaymentMethodMapBO.setAddress2(beneficiaryPaymentMethodMapDetails.getAddress2());
				
				beneficiaryPaymentMethodMapBO.setAddress3(beneficiaryPaymentMethodMapDetails.getAddress3());
				
				beneficiaryPaymentMethodMapBO.setBankSortCode(beneficiaryPaymentMethodMapDetails.getBankSortCode());
				beneficiaryPaymentMethodMapBO.setIntermediaryBankBicCode(beneficiaryPaymentMethodMapDetails.getIntermediaryBankBicCode());
				beneficiaryPaymentMethodMapBO.setIntermediarySortCode(beneficiaryPaymentMethodMapDetails.getIntermediarySortCode());
				beneficiaryPaymentMethodMapBO.setIntermediaryBank(beneficiaryPaymentMethodMapDetails.getIntermediaryBankName());
				beneficiaryPaymentMethodMapBO.setIntermediaryBranch(beneficiaryPaymentMethodMapDetails.getIntermediaryBranchName());
				beneficiaryPaymentMethodMapBO.setIntermediaryBankAdd1(beneficiaryPaymentMethodMapDetails.getIntermediaryBankAddress1());
				beneficiaryPaymentMethodMapBO.setIntermediaryBankAdd2(beneficiaryPaymentMethodMapDetails.getIntermediaryBankAddress2());
				beneficiaryPaymentMethodMapBO.setIntermediaryBankAdd3(beneficiaryPaymentMethodMapDetails.getIntermediaryBankAddress3());
				beneficiaryPaymentMethodMapBO.setBeneDispatchMode(beneficiaryPaymentMethodMapDetails.getBeneDispatchMode());

			}
		}

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
	public void assembleDetails(BaseBO dto, BaseDetails details)
			throws BaseException, RemoteException {
		super.assembleDetails(dto, details);
		BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO = (BeneficiaryPaymentMethodMapBO) dto;
		BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails = (BeneficiaryPaymentMethodMap) details;
		
		/**
		 * TODO:Pravin THis need to be checked
		 */
		beneficiaryPaymentMethodMapDetails.setId(EncryptUtils.encryptId(beneficiaryPaymentMethodMapBO.getId()));
		
		beneficiaryPaymentMethodMapDetails.setResponseStatus(null);
		beneficiaryPaymentMethodMapDetails.setIsLoggable(null);
		beneficiaryPaymentMethodMapDetails.setCorporateName(beneficiaryPaymentMethodMapBO.getCorporateName());
		beneficiaryPaymentMethodMapDetails.setBeneficiaryName(beneficiaryPaymentMethodMapBO.getBeneficiaryName());
		beneficiaryPaymentMethodMapDetails.setPayeeName(beneficiaryPaymentMethodMapBO.getPayeeName());
		beneficiaryPaymentMethodMapDetails.setPaymentMethodName(beneficiaryPaymentMethodMapBO.getPaymentMethodName());
		beneficiaryPaymentMethodMapDetails.setBeneficiaryId(EncryptUtils.encryptId(beneficiaryPaymentMethodMapBO.getBeneficiaryId().getId()));
		beneficiaryPaymentMethodMapDetails.setPaymentMethodId(EncryptUtils.encryptId(beneficiaryPaymentMethodMapBO.getPaymentMethodId()));
		beneficiaryPaymentMethodMapDetails.setPaymentMethodCode(beneficiaryPaymentMethodMapBO.getPaymentMethodCode());
		
		if (beneficiaryPaymentMethodMapBO.getPaymentMethodCode().equals(PaymentMethod.EP1.name())) {
			beneficiaryPaymentMethodMapDetails.setAccountNo(beneficiaryPaymentMethodMapBO.getAccountNo());
		}
		if (beneficiaryPaymentMethodMapBO.getPaymentMethodCode().equals(PaymentMethod.EP3.name())) {
			
			beneficiaryPaymentMethodMapDetails.setBicCode(beneficiaryPaymentMethodMapBO.getSwiftCode());
			//if (null != beneficiaryPaymentMethodMapDTO.getEnrichment("AccountTypeLabel") && "IBAN".equalsIgnoreCase(beneficiaryPaymentMethodMapDTO.getEnrichment("AccountTypeLabel"))) {
				beneficiaryPaymentMethodMapDetails.setiBanNo(beneficiaryPaymentMethodMapBO.getAccountNo());
			//}
			if (null != beneficiaryPaymentMethodMapBO.getEnrichment("AccountTypeLabel")&& "Credit Card / Salary Card Payment".equalsIgnoreCase(beneficiaryPaymentMethodMapBO.getEnrichment("AccountTypeLabel"))) {
				beneficiaryPaymentMethodMapDetails.setCardPayment(beneficiaryPaymentMethodMapBO.getAccountNo());
			}
			beneficiaryPaymentMethodMapDetails.setBankCode(beneficiaryPaymentMethodMapBO.getBankCode());
			beneficiaryPaymentMethodMapDetails.setBicCode(beneficiaryPaymentMethodMapBO.getSwiftCode());
			beneficiaryPaymentMethodMapDetails.setBankSortCode(beneficiaryPaymentMethodMapBO.getBankSortCode());
			beneficiaryPaymentMethodMapDetails.setBeneficiaryBank(beneficiaryPaymentMethodMapBO.getBankName());
			beneficiaryPaymentMethodMapDetails.setBeneficiaryBankBranch(beneficiaryPaymentMethodMapBO.getBranchName());
			beneficiaryPaymentMethodMapDetails.setAddress1(beneficiaryPaymentMethodMapBO.getAddress1());
			beneficiaryPaymentMethodMapDetails.setAddress2(beneficiaryPaymentMethodMapBO.getAddress2());
			beneficiaryPaymentMethodMapDetails.setAddress3(beneficiaryPaymentMethodMapBO.getAddress3());
		}
		
		if( beneficiaryPaymentMethodMapBO.getPaymentMethodCode().equals(PaymentMethod.EP17.name()) || beneficiaryPaymentMethodMapBO.getPaymentMethodCode().equals(PaymentMethod.EP18.name())|| beneficiaryPaymentMethodMapBO.getPaymentMethodCode().equals(PaymentMethod.EP19.name())){
			//if (null != beneficiaryPaymentMethodMapDTO.getEnrichment("AccountTypeLabel") && "IBAN".equalsIgnoreCase(beneficiaryPaymentMethodMapDTO.getEnrichment("AccountTypeLabel"))) {
				beneficiaryPaymentMethodMapDetails.setiBanNo(beneficiaryPaymentMethodMapBO.getAccountNo());
			//}
			if (null != beneficiaryPaymentMethodMapBO.getEnrichment("AccountTypeLabel")&& "Credit Card / Salary Card Payment".equalsIgnoreCase(beneficiaryPaymentMethodMapBO.getEnrichment("AccountTypeLabel"))) {
				beneficiaryPaymentMethodMapDetails.setCardPayment(beneficiaryPaymentMethodMapBO.getAccountNo());
			}
			beneficiaryPaymentMethodMapDetails.setBranchCode(beneficiaryPaymentMethodMapBO.getBranchCode());
			beneficiaryPaymentMethodMapDetails.setBankCode(beneficiaryPaymentMethodMapBO.getBankCode());
			beneficiaryPaymentMethodMapDetails.setBicCode(beneficiaryPaymentMethodMapBO.getSwiftCode());
			beneficiaryPaymentMethodMapDetails.setBankSortCode(beneficiaryPaymentMethodMapBO.getBankSortCode());
			beneficiaryPaymentMethodMapDetails.setBeneficiaryBank(beneficiaryPaymentMethodMapBO.getBankName());
			beneficiaryPaymentMethodMapDetails.setBeneficiaryBankBranch(beneficiaryPaymentMethodMapBO.getBranchName());
			beneficiaryPaymentMethodMapDetails.setAddress1(beneficiaryPaymentMethodMapBO.getAddress1());
			beneficiaryPaymentMethodMapDetails.setAddress2(beneficiaryPaymentMethodMapBO.getAddress2());
			beneficiaryPaymentMethodMapDetails.setAddress3(beneficiaryPaymentMethodMapBO.getAddress3());
		}
		
		if (beneficiaryPaymentMethodMapBO.getPaymentMethodCode().equals(PaymentMethod.EP5.name()) || beneficiaryPaymentMethodMapBO.getPaymentMethodCode().equals(PaymentMethod.EP10.name()) ) {
			beneficiaryPaymentMethodMapDetails.setBankCode(beneficiaryPaymentMethodMapBO.getBankCode());
			beneficiaryPaymentMethodMapDetails.setBicCode(beneficiaryPaymentMethodMapBO.getSwiftCode());
			beneficiaryPaymentMethodMapDetails.setBankSortCode(beneficiaryPaymentMethodMapBO.getBankSortCode());
			beneficiaryPaymentMethodMapDetails.setAccountNo(beneficiaryPaymentMethodMapBO.getAccountNo());
			beneficiaryPaymentMethodMapDetails.setBeneficiaryBank(beneficiaryPaymentMethodMapBO.getBankName());
			beneficiaryPaymentMethodMapDetails.setBeneficiaryBankBranch(beneficiaryPaymentMethodMapBO.getBranchName());
			beneficiaryPaymentMethodMapDetails.setAddress1(beneficiaryPaymentMethodMapBO.getAddress1());
			beneficiaryPaymentMethodMapDetails.setAddress2(beneficiaryPaymentMethodMapBO.getAddress2());
			beneficiaryPaymentMethodMapDetails.setAddress3(beneficiaryPaymentMethodMapBO.getAddress3());
			setIntermediaryBankDetails(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		}
		if (beneficiaryPaymentMethodMapBO.getPaymentMethodCode().equals(PaymentMethod.EP9.name())) {
			if (null != beneficiaryPaymentMethodMapBO.getPaymentType()) {
				if (beneficiaryPaymentMethodMapBO.getPaymentType().equals(PaymentMethod.EP1.name())) {
					beneficiaryPaymentMethodMapDetails.setPaymentChannel("IFT");
					beneficiaryPaymentMethodMapDetails.setAccountNo(beneficiaryPaymentMethodMapBO.getAccountNo());
				}
				if (beneficiaryPaymentMethodMapBO.getPaymentType().equals(PaymentMethod.EP3.name())) {
					beneficiaryPaymentMethodMapDetails.setPaymentChannel("EFD");
					if (null != beneficiaryPaymentMethodMapBO.getEnrichment("AccountTypeLabel") && "IBAN".equalsIgnoreCase(beneficiaryPaymentMethodMapBO.getEnrichment("AccountTypeLabel"))) {

						beneficiaryPaymentMethodMapDetails.setiBanNo(beneficiaryPaymentMethodMapBO.getAccountNo());
					}
					if (null != beneficiaryPaymentMethodMapBO.getEnrichment("AccountTypeLabel") && "Credit Card / Salary Card Payment".equalsIgnoreCase(beneficiaryPaymentMethodMapBO.getEnrichment("AccountTypeLabel"))) {

						beneficiaryPaymentMethodMapDetails.setCardPayment(beneficiaryPaymentMethodMapBO.getAccountNo());
					}
				}
				if (beneficiaryPaymentMethodMapBO.getPaymentType().equals(PaymentMethod.EP5.name())) {
					beneficiaryPaymentMethodMapDetails.setPaymentChannel("EFI");
					beneficiaryPaymentMethodMapDetails.setAccountNo(beneficiaryPaymentMethodMapBO.getAccountNo());
				}
			}

			beneficiaryPaymentMethodMapDetails.setBicCode(beneficiaryPaymentMethodMapBO.getSwiftCode());
			beneficiaryPaymentMethodMapDetails.setRoutingCode(beneficiaryPaymentMethodMapBO.getSwiftCode());
			beneficiaryPaymentMethodMapDetails.setBeneficiaryBank(beneficiaryPaymentMethodMapBO.getBankName());
			beneficiaryPaymentMethodMapDetails.setBeneficiaryBankBranch(beneficiaryPaymentMethodMapBO.getBranchName());
			beneficiaryPaymentMethodMapDetails.setAddress1(beneficiaryPaymentMethodMapBO.getAddress1());
			beneficiaryPaymentMethodMapDetails.setAddress2(beneficiaryPaymentMethodMapBO.getAddress2());
			beneficiaryPaymentMethodMapDetails.setAddress3(beneficiaryPaymentMethodMapBO.getAddress3());
			beneficiaryPaymentMethodMapDetails.setBankSortCode(beneficiaryPaymentMethodMapBO.getBankSortCode());
			setIntermediaryBankDetails(beneficiaryPaymentMethodMapDetails,beneficiaryPaymentMethodMapBO);
		}
		if (null != beneficiaryPaymentMethodMapBO.getDispatchTo()) {
			beneficiaryPaymentMethodMapDetails.setDispatchTo(beneficiaryPaymentMethodMapBO.getDispatchTo().name());
		}
		if (null != beneficiaryPaymentMethodMapBO.getInstrumentDispatchMode()) {
			beneficiaryPaymentMethodMapDetails.setInstrumentDispatchMode(beneficiaryPaymentMethodMapBO.getInstrumentDispatchMode().name());
		}
		
		beneficiaryPaymentMethodMapDetails.setEffectiveFrom(beneficiaryPaymentMethodMapBO.getEffectiveFrom());
		beneficiaryPaymentMethodMapDetails.setEffectiveTill(beneficiaryPaymentMethodMapBO.getEffectiveTill());
		beneficiaryPaymentMethodMapDetails.setBeneDispatchMode(beneficiaryPaymentMethodMapBO.getBeneDispatchMode());
	}

	/**
	 * Sets the intermediary bank details.
	 *
	 * @param beneficiaryPaymentMethodMapDetails
	 *            the beneficiary payment method map details
	 * @param beneficiaryPaymentMethodMapDTO
	 *            the beneficiary payment method map dto
	 */
	private void setIntermediaryBankDetails(
			BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMapDetails,
			BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO) {
		beneficiaryPaymentMethodMapDetails
				.setIntermediaryBankBicCode(beneficiaryPaymentMethodMapBO
						.getIntermediaryBankBicCode());
		beneficiaryPaymentMethodMapDetails
				.setIntermediarySortCode(beneficiaryPaymentMethodMapBO
						.getIntermediarySortCode());
		beneficiaryPaymentMethodMapDetails
				.setIntermediaryBankName(beneficiaryPaymentMethodMapBO
						.getIntermediaryBank());
		beneficiaryPaymentMethodMapDetails
				.setIntermediaryBranchName(beneficiaryPaymentMethodMapBO
						.getIntermediaryBranch());
		beneficiaryPaymentMethodMapDetails
				.setIntermediaryBankAddress1(beneficiaryPaymentMethodMapBO
						.getIntermediaryBankAdd1());
		beneficiaryPaymentMethodMapDetails
				.setIntermediaryBankAddress2(beneficiaryPaymentMethodMapBO
						.getIntermediaryBankAdd2());
	}
}
