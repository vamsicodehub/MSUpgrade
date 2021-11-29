package com.aurionpro.beneficiary.datavalidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurionpro.beneficiary.basevalueobject.MakerCheckerBO.Modification;
import com.aurionpro.beneficiary.encryption.EncryptUtils;
import com.aurionpro.beneficiary.encryption.RemoteException;
import com.aurionpro.beneficiary.enums.AuthenticationType;
import com.aurionpro.beneficiary.enums.PaymentMethod;
import com.aurionpro.beneficiary.exceptions.BaseException;
import com.aurionpro.beneficiary.exceptions.BusinessValidationException;
import com.aurionpro.beneficiary.repository.BeneficiaryServiceRepository;
import com.aurionpro.beneficiary.repository.PaymentMethodServiceRepository;
import com.aurionpro.beneficiary.requestobject.Beneficiary;
import com.aurionpro.beneficiary.requestobject.BeneficiaryPaymentMethodMap;
import com.aurionpro.beneficiary.utils.DateUtils;
import com.aurionpro.beneficiary.validator.BusinessValidationError;
import com.aurionpro.beneficiary.valueobject.BeneficiaryBO;
import com.aurionpro.beneficiary.valueobject.BeneficiaryPaymentMethodMapBO;
import com.aurionpro.beneficiary.valueobject.PaymentMethodBO;

@Component
public class BeneficiaryUtils {
	
	@Autowired
	private BeneficiaryServiceRepository beneficiaryRepository;
	@Autowired
	private PaymentMethodServiceRepository paymentMethodServiceRepository;

	public void checkBeneficiaryNameLength(String beneficiaryName, String payMethodId)  throws BusinessValidationException{
		
		Boolean flag=false;
		/**
		 * TODO: Pravin this needs to be taken from Param cache may be
		 */
		String allowedLength = "35";
		Integer allowableLimit=0;
		String errorMessageKey="";
		List<String> errorValues=new ArrayList<String>();
		if(allowedLength != null && !"".equals(allowedLength)){
			 allowableLimit = Integer.valueOf(allowedLength);
		}
		
		List<PaymentMethodBO> methodBOList = paymentMethodServiceRepository.findApplicablePaymentMethods();
		for (PaymentMethodBO methodBO : methodBOList) {
				if(methodBO.getId().equals(EncryptUtils.decryptId(payMethodId))){
					if(methodBO.getPrinting().equals(false) && beneficiaryName.length() > allowableLimit)
						flag =  true;
				}
			}
		
		List<BusinessValidationError> errors = new ArrayList<BusinessValidationError>();
		if(flag){
			errorValues.add(beneficiaryName);
			errorMessageKey = "Maximum Length allowed in Beneficiary Name for Electronic payment method is " + allowedLength + " characters";
			BusinessValidationError businessValidationError=new BusinessValidationError();
			businessValidationError.setMessageKey(errorMessageKey);
			businessValidationError.setMessageValues(errorValues);
			errors.add(businessValidationError);
			throw new BusinessValidationException(errors);
		}
	}



public void isBeneficiaryAlreadyExists(Beneficiary beneficiary,boolean isForUpdate) throws BusinessValidationException{
	
	List<BusinessValidationError> errors = new ArrayList<BusinessValidationError>();
	List<BeneficiaryBO> beneList = null;
	
	/**
	 * TODO : Pravin Corporate Id dependency on ticket
	 */
	beneList =  beneficiaryRepository.findBeneForCorporate(beneficiary.getBeneficiaryCode(), 100071L);
	
	if(beneList!=null && beneList != null && !beneList.isEmpty()){
		
		BeneficiaryBO beneficiaryBO=beneList.get(0);
		if(isForUpdate && beneficiary.getId()!=null && beneficiary.getId().equals(EncryptUtils.encryptId(beneficiaryBO.getId()))){
			return;
		}
		String errorMessageKey="";
		List<String> errorValues=new ArrayList<String>();
		
		if(beneficiaryBO.getLastAction()!=null){
			if(beneficiaryBO.getLastAction().equals("create Authorized") || beneficiaryBO.getLastAction().equals("update Authorized")){
				errorMessageKey="Beneficiary with code "+ beneficiary.getBeneficiaryCode() + " already exists";
			}else if(beneficiaryBO.getLastAction().equals("disable Authorized")){
				errorMessageKey="Beneficiary with code "+ beneficiary.getBeneficiaryCode() + " already exists and is disabled";
			}else if(beneficiaryBO.getLastAction().endsWith(" Rejected")){
				errorMessageKey="Beneficiary with code "+ beneficiary.getBeneficiaryCode() +" already exists and is rejected";
			}else {
				errorMessageKey="Beneficiary with code "+ beneficiary.getBeneficiaryCode() + " already exists and is pending for authorization";
			}
		}else{
			errorMessageKey="Beneficiary with code "+ beneficiary.getBeneficiaryCode() + " already exists";
		}
		errorValues.add(beneficiaryBO.getBeneficiaryCode());
		BusinessValidationError businessValidationError=new BusinessValidationError();
		businessValidationError.setMessageKey(errorMessageKey);
		businessValidationError.setMessageValues(errorValues);
		errors.add(businessValidationError);
		throw new BusinessValidationException(errors);
	}
}


public void checkForDuplicateData(Beneficiary details, BeneficiaryPaymentMethodMap paymentMethodDetails,boolean isUpdate) throws BusinessValidationException{
	
	boolean throwBusinessException=false;
	String errorMessageKey="";
	List<String> errorValues=null;
	if (paymentMethodDetails.getPaymentMethodCode().equals(PaymentMethod.PP6.name()) || paymentMethodDetails.getPaymentMethodCode().equals(PaymentMethod.PP8.name()) || paymentMethodDetails.getPaymentMethodCode().equals(PaymentMethod.PP10.name())){
		if(isUpdate){
			String paymentMethodDTOId= paymentMethodDetails.getId();
			if(paymentMethodDTOId==null || "null".equals(paymentMethodDTOId) || paymentMethodDTOId.equals("0")){
				throwBusinessException=isBenePaymentmapExists(details.getBeneficiaryCode(), null, paymentMethodDetails.getPaymentMethodId(),false,null);
			}else{
				throwBusinessException=isBenePaymentmapExists(details.getBeneficiaryCode(), null, paymentMethodDetails.getPaymentMethodId(),true,paymentMethodDTOId);
			}
		}else{
			throwBusinessException=isBenePaymentmapExists(details.getBeneficiaryCode(), null, paymentMethodDetails.getPaymentMethodId(),false,null);
		}
		
		errorMessageKey="Duplicate record of Beneficiary Code :"+ details.getBeneficiaryCode() +" and Payment Method :" + paymentMethodDetails.getPaymentMethodName();
		errorValues=new ArrayList<String>();
		errorValues.add(details.getBeneficiaryCode());
		errorValues.add(paymentMethodDetails.getPaymentMethodName());
	}else{
		String accountNo=paymentMethodDetails.getAccountNo()!=null && !paymentMethodDetails.getAccountNo().equals("") ? paymentMethodDetails.getAccountNo() : 
			(paymentMethodDetails.getiBanNo()!=null && !paymentMethodDetails.getiBanNo().equals("") ? paymentMethodDetails.getiBanNo() : 
				(paymentMethodDetails.getCardPayment()!=null && !paymentMethodDetails.getCardPayment().equals("") ? paymentMethodDetails.getCardPayment() : null));
		
		if(isUpdate){
			String paymentMethodDTOId= paymentMethodDetails.getId();
			if(paymentMethodDTOId==null || "null".equals(paymentMethodDTOId) || paymentMethodDTOId.equals("0")){
				throwBusinessException=isBenePaymentmapExists(details.getBeneficiaryCode(), accountNo, paymentMethodDetails.getPaymentMethodId(),false,null);
			}else{
				throwBusinessException=isBenePaymentmapExists(details.getBeneficiaryCode(), accountNo, paymentMethodDetails.getPaymentMethodId(),true,paymentMethodDTOId);
			}
		}else{
			throwBusinessException=isBenePaymentmapExists(details.getBeneficiaryCode(), accountNo, paymentMethodDetails.getPaymentMethodId(),false,null);
		}
		
		errorMessageKey="Duplicate record of Beneficiary Code : " +details.getBeneficiaryCode()+" , Payment Method :"+ paymentMethodDetails.getPaymentMethodName() + " and Account No :" + paymentMethodDetails.getAccountNo();
		errorValues=new ArrayList<String>();
		errorValues.add(details.getBeneficiaryCode());
		errorValues.add(paymentMethodDetails.getPaymentMethodName());
		errorValues.add(accountNo);
	}
	if(throwBusinessException){
		List<BusinessValidationError> errors = new ArrayList<BusinessValidationError>();
		BusinessValidationError businessValidationError=new BusinessValidationError();
		businessValidationError.setMessageKey(errorMessageKey);
		businessValidationError.setMessageValues(errorValues);
		errors.add(businessValidationError);
		throw new BusinessValidationException(errors);
	}
}


private boolean isBenePaymentmapExists(String beneCode,String accountNo,String paymentMethodId,boolean isUpdate,String detailsId){
		try {
				
			BeneficiaryBO beneBO=null;
			
				/**
				 * TODO: Pravin to check group case
				 */
				List<BeneficiaryBO> findBeneForCorporate = beneficiaryRepository.findBeneForCorporate(beneCode, 100071L);
				if(findBeneForCorporate!=null && findBeneForCorporate.size()>0)
					beneBO=findBeneForCorporate.get(0);
				else
					return false;
			
			Set<BeneficiaryPaymentMethodMapBO> beneficiaryPaymentMethods= beneBO.getBeneficiaryPaymentMethods();
			if(beneficiaryPaymentMethods==null  ||  beneficiaryPaymentMethods.isEmpty())
				return false;
			
			for(BeneficiaryPaymentMethodMapBO benePayBO:beneficiaryPaymentMethods)
				{
					if(EncryptUtils.encryptId(benePayBO.getPaymentMethodId()).equalsIgnoreCase(paymentMethodId))
						return !isUpdate;
				}
			
			return isUpdate;
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
			return false;
}



public void beneAccountNoValidator(String beneAccountNo,PaymentMethod paymentMethodCode)
		throws BusinessValidationException, RemoteException {
	
	List<BusinessValidationError> errors = new ArrayList<BusinessValidationError>();
	if (PaymentMethod.EP17.toString().equalsIgnoreCase(paymentMethodCode.toString())
			|| PaymentMethod.EP3.toString().equalsIgnoreCase(paymentMethodCode.toString())
			|| PaymentMethod.EP19.toString().equalsIgnoreCase(paymentMethodCode.toString())) {
		
		/**
		 * TODO:Pravin to be taken from param key 9001
		 * TODO:Pravin to be taken from param key 9000
		 */
		Integer accountMaxLength = 20;
		Integer accountMinLength = 5;
		
		if (beneAccountNo != null) {
			if (beneAccountNo.length() > accountMaxLength || beneAccountNo.length() < accountMinLength) {
				BusinessValidationError businessValidationError = new BusinessValidationError();
				businessValidationError.setMessageKey("Invalid beneficiary account number");
				errors.add(businessValidationError);
			}
		}
	} else if (PaymentMethod.EP1.toString().equalsIgnoreCase(paymentMethodCode.toString())) {
		
		/**
		 * TODO:Pravin to be taken from param key 9003
		 */
		Integer accountMaxLength = 20;
		Integer accountMinLength = 5;
		
		if (beneAccountNo != null) {
			if (beneAccountNo.length() > accountMaxLength || beneAccountNo.length() < accountMinLength) {
				BusinessValidationError businessValidationError = new BusinessValidationError();
				businessValidationError.setMessageKey("Invalid beneficiary account number");
				errors.add(businessValidationError);
			}
			
		/**
		 * TODO : Pravin to check interface call for IFT	
		 */
		/*	String interfacerunning = ApplicationContext.getInstance().getProperty("interfacerunning");
			InterfaceMappingService interfaceMappingService = ((PayProServiceFactory) ApplicationContext.getInstance()
					.getServiceFactoryGenerator().getRemoteServiceFactory()).getInterfaceMappingService();
			AccountBalanceDTO balanceDTO = new AccountBalanceDTO();
			balanceDTO.setAccountNumber(beneAccountNo);
			if(null!=interfacerunning && "true".equalsIgnoreCase(interfacerunning)) {
				try {
					AccountBalanceDTO accountDTO = interfaceMappingService.onlineBalanceCheck(ticket, balanceDTO);
					if("99".equalsIgnoreCase(accountDTO.getResponseCode()) && errors.size()==0){
						BusinessValidationError businessValidationError = new BusinessValidationError();
						businessValidationError.setMessageKey(RestConstants.BENE_ACCNO_VALIDATION);
						errors.add(businessValidationError);
					}
				} catch (Exception e) {
					if(errors.size()==0){
						BusinessValidationError businessValidationError = new BusinessValidationError();
						businessValidationError.setMessageKey(RestConstants.CONNECTION_REFUSED);
						errors.add(businessValidationError);
					}
				}
			}*/
		}
	}
	if (errors.size() > 0)
		throw new BusinessValidationException(errors);
}



	public BeneficiaryBO enableDisable(BeneficiaryBO beneBO, boolean enable)
			throws BusinessValidationException, RemoteException {
		
		Set<BeneficiaryPaymentMethodMapBO> beneficiaryPaymentMethods = beneBO.getBeneficiaryPaymentMethods();
		Set<BeneficiaryPaymentMethodMapBO> updatedPaymentMethods = new LinkedHashSet <BeneficiaryPaymentMethodMapBO>();
		for (BeneficiaryPaymentMethodMapBO  benePayBO:beneficiaryPaymentMethods) {
				/**
				 * TODO:Pravin to check approach
				 */
				benePayBO.setEnableDisableMethodProperties(enable, isMasterSelfAuthorizer());
				updatedPaymentMethods.add(benePayBO);
			}
		
			/**
			 * TODO:Pravin to check approach
			 */
			beneBO.setEnableDisableMethodProperties(enable,isMasterSelfAuthorizer());
			beneBO.setBeneficiaryPaymentMethods(updatedPaymentMethods);
			
			beneficiaryRepository.save(beneBO);
			return beneBO;
	}
	

	
	public boolean isMasterSelfAuthorizer() {
		
		return false;
		/**
		 * TODo:Pravin Ticket dependency
		 */
		/*
		if(UserType.CORPORATE.name().equals(ticket.getUserType()) && "S".equals(ticket.getEnrichment(Constants.USERAUTHTYPE))) {
			if( null != ticket.getEnrichment("MASTERSELFAUTH")  && 	ticket.getEnrichment("MASTERSELFAUTH").equalsIgnoreCase("Y"))
				return true;
		}
		return false;
	*/}
	
	
}

