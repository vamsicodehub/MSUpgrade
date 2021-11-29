package com.aurionpro.beneficiary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.beneficiary.assembler.BeneficiaryAssembler;
import com.aurionpro.beneficiary.assembler.BeneficiaryPaymentMethodMapAssembler;
import com.aurionpro.beneficiary.baserequest.BaseRequestMap;
import com.aurionpro.beneficiary.baserequest.BaseRequestResponse;
import com.aurionpro.beneficiary.baserequest.BaseResponseMap;
import com.aurionpro.beneficiary.basevalueobject.MakerCheckerBO.Modification;
import com.aurionpro.beneficiary.basevalueobject.MakerCheckerBO.ReadValue;
import com.aurionpro.beneficiary.datavalidator.BeneficiaryUtils;
import com.aurionpro.beneficiary.encryption.EncryptUtils;
import com.aurionpro.beneficiary.encryption.RemoteException;
import com.aurionpro.beneficiary.enums.DispatchMode;
import com.aurionpro.beneficiary.enums.DispatchTo;
import com.aurionpro.beneficiary.enums.PaymentMethod;
import com.aurionpro.beneficiary.enums.ResponseStatusType;
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


@Service
public class BeneficiaryService {


	@Autowired
	private BeneficiaryServiceRepository beneficiaryRepository;
	
	@Autowired
	private BeneficiaryUtils beneficiaryUtils;
	
	@Autowired
	private PaymentMethodServiceRepository paymentMethodServiceRepository;
	
	public BaseResponseMap create(Beneficiary beneDetails) throws BusinessValidationException,BaseException, RemoteException{
		
		beneficiaryUtils.isBeneficiaryAlreadyExists(beneDetails,false);
		
		BeneficiaryBO beneBO =new BeneficiaryBO();
		beneBO.setModification(Modification.DIRECT);
		BeneficiaryAssembler.getInstance().assemble(beneBO, beneDetails);
		
		Set<BeneficiaryPaymentMethodMapBO>  beneficiaryPaymentMethods = new LinkedHashSet <BeneficiaryPaymentMethodMapBO>();
		Map<String, List<BeneficiaryPaymentMethodMap>> benePaymentMethodMapGroup = beneDetails.getBenePaymentMethodMapGroup();
		
		for (String key : benePaymentMethodMapGroup.keySet()) {
			if (null != benePaymentMethodMapGroup.get(key)) {
				for (BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMap : benePaymentMethodMapGroup.get(key)) {
					BeneficiaryPaymentMethodMapBO paymentMethodMapBO = new BeneficiaryPaymentMethodMapBO();
					paymentMethodMapBO.setModification(Modification.DIRECT);
					BeneficiaryPaymentMethodMapAssembler.getInstance().assemble(paymentMethodMapBO,beneficiaryPaymentMethodMap);
					paymentMethodMapBO.setBeneficiaryType(beneBO.getBeneficiaryType());
					paymentMethodMapBO.setBeneficiaryId(beneBO);
					/**
					 * TODO : Pravin need to check on this
					 */
					paymentMethodMapBO.setCreateMethodProperties(beneficiaryUtils.isMasterSelfAuthorizer());
					
					beneficiaryPaymentMethods.add(paymentMethodMapBO);
					beneficiaryUtils.checkBeneficiaryNameLength(beneDetails.getBeneficiaryName(), beneficiaryPaymentMethodMap.getPaymentMethodId());
					beneficiaryUtils.checkForDuplicateData(beneDetails, beneficiaryPaymentMethodMap,false);
					
					if(beneficiaryPaymentMethodMap.getAccountNo()==null)
						beneficiaryUtils.beneAccountNoValidator(beneficiaryPaymentMethodMap.getiBanNo(),PaymentMethod.valueOf(beneficiaryPaymentMethodMap.getPaymentMethodCode()));
					else
						beneficiaryUtils.beneAccountNoValidator(beneficiaryPaymentMethodMap.getAccountNo(),PaymentMethod.valueOf(beneficiaryPaymentMethodMap.getPaymentMethodCode()));
				}
			}
		}
		
		beneBO.setBeneficiaryPaymentMethods(beneficiaryPaymentMethods);
		/**
		 * TODO : Pravin need to check on this
		 */
		beneBO.setCreateMethodProperties(beneficiaryUtils.isMasterSelfAuthorizer());
		BeneficiaryBO save = beneficiaryRepository.save(beneBO);
		
		BaseResponseMap returnMap = new BaseResponseMap();
		
		/**
		 * TODO:Pravin Added extra to check delete operation
		 */
		returnMap.setEntityIdentifier(EncryptUtils.encryptId(save.getId()));
		returnMap.getResponseStatus().setMessage("Bene Created Successfully");
		return returnMap;
	}

	
	public BaseResponseMap update(Beneficiary beneDetails) throws BusinessValidationException,BaseException, RemoteException
	{
		if(beneDetails.getBeneficiaryCode()!=null)
			beneDetails.setBeneficiaryCode(beneDetails.getBeneficiaryCode().toUpperCase());
		
		BeneficiaryBO beneBO = null;
		Optional<BeneficiaryBO> findById = beneficiaryRepository.findById(EncryptUtils.decryptId(beneDetails.getId()));
		if(findById.isPresent())
			beneBO=findById.get();
		
		Set<BeneficiaryPaymentMethodMapBO> databasePaymentMethods = beneBO.getBeneficiaryPaymentMethods();
		Map<Long, BeneficiaryPaymentMethodMapBO> dbPaymentsMap=new HashMap<>();
		
		for(BeneficiaryPaymentMethodMapBO dbPayment:databasePaymentMethods)
			dbPaymentsMap.put(dbPayment.getId(), dbPayment);
		
		/**
		 * This will be used if any of the parent property Beneficiary Level is being changed
		 */
		BeneficiaryAssembler.getInstance().assemble(beneBO, beneDetails);
		
		Set<BeneficiaryPaymentMethodMapBO>  beneficiaryPaymentMethods = new HashSet<BeneficiaryPaymentMethodMapBO>();
		Map<String, List<BeneficiaryPaymentMethodMap>> benePaymentMethodMapGroup = beneDetails.getBenePaymentMethodMapGroup();
		
		for (String key : benePaymentMethodMapGroup.keySet()) {
			if (null != benePaymentMethodMapGroup.get(key)) {
				for (BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMap : benePaymentMethodMapGroup.get(key)) {
					BeneficiaryPaymentMethodMapBO paymentMethodBO=null;
					
					if(dbPaymentsMap.get(EncryptUtils.decryptId(beneficiaryPaymentMethodMap.getId())) !=null)
						paymentMethodBO=dbPaymentsMap.get(EncryptUtils.decryptId(beneficiaryPaymentMethodMap.getId()));
					else
					{
						paymentMethodBO = new BeneficiaryPaymentMethodMapBO();
						paymentMethodBO.setModification(Modification.DIRECT);
					}
					
					BeneficiaryPaymentMethodMapAssembler.getInstance().assemble(paymentMethodBO,beneficiaryPaymentMethodMap);
					/*paymentMethodDTO.setEffectiveFrom(dto.getEffectiveFrom());
					paymentMethodDTO.setEffectiveTill(dto.getEffectiveTill());*/
					paymentMethodBO.setBeneficiaryType(beneBO.getBeneficiaryType());
					paymentMethodBO.setBeneficiaryId(beneBO);
					paymentMethodBO.setModifiedBy(beneBO.getModifiedBy());
					paymentMethodBO.setModifiedOn(beneBO.getModifiedOn());
					/**
					 *	This needs to be checked 
					 */
					paymentMethodBO.setUpdateMethodProperties(beneficiaryUtils.isMasterSelfAuthorizer());
					beneficiaryUtils.checkBeneficiaryNameLength(beneDetails.getBeneficiaryName(), beneficiaryPaymentMethodMap.getPaymentMethodId());
					beneficiaryUtils.checkForDuplicateData(beneDetails, beneficiaryPaymentMethodMap,true);
					
					beneficiaryPaymentMethods.add(paymentMethodBO);
					
					if(beneficiaryPaymentMethodMap.getAccountNo()==null)
						beneficiaryUtils.beneAccountNoValidator(beneficiaryPaymentMethodMap.getiBanNo(),PaymentMethod.valueOf(beneficiaryPaymentMethodMap.getPaymentMethodCode()));
					else
						beneficiaryUtils.beneAccountNoValidator(beneficiaryPaymentMethodMap.getAccountNo(),PaymentMethod.valueOf(beneficiaryPaymentMethodMap.getPaymentMethodCode()));
				}
			}
		}
		
		/**
		 *	This needs to be checked 
		 */
		beneBO.setUpdateMethodProperties(beneficiaryUtils.isMasterSelfAuthorizer());
		
		beneBO.getBeneficiaryPaymentMethods().clear();
		beneBO.getBeneficiaryPaymentMethods().addAll(beneficiaryPaymentMethods);
		
		beneficiaryRepository.save(beneBO);
		
		BaseResponseMap returnMap = new BaseResponseMap();
		returnMap.getResponseStatus().setMessage("Bene Updated Successfully");
		return returnMap;
	}
	
	
	public BaseResponseMap delete(BaseRequestMap requestMap) throws BusinessValidationException,BaseException, RemoteException,Exception{
		try{
			String encryptedId = (String)requestMap.getDataMap().get("id");
			if(encryptedId!=null)
				beneficiaryRepository.deleteById(EncryptUtils.decryptId(EncryptUtils.getId(encryptedId)));
			
			BaseResponseMap returnMap = new BaseResponseMap();
			returnMap.getResponseStatus().setMessage("Succesfully Deleted");
			returnMap.setEntity("BeneficiaryWithPaymentMethod");
			return returnMap;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}
	
	
	
	public BaseResponseMap disable(BaseRequestMap requestMap) throws BusinessValidationException,BaseException, RemoteException,Exception{
		try{
			String encryptedId = (String)requestMap.getDataMap().get("id");
			String errorMessageKey="";
			List<String> errorValues=new ArrayList<String>();
			List<BusinessValidationError> errors = new ArrayList<BusinessValidationError>();
			
			Boolean isSITransactionExistForBene=false;		
			
			/**
			 * TODO: Pravin to check how to find pending transaction other microservice or direct queries!
			 */
			Boolean isTransactionPendingForBene=false;
			
			BeneficiaryBO beneBO=new BeneficiaryBO();
			
			if(encryptedId!=null) {
				Optional<BeneficiaryBO> findById = beneficiaryRepository.findById(EncryptUtils.decryptId(EncryptUtils.getId(encryptedId)));
				if(findById.isPresent())
					beneBO=findById.get();
			}
			
			if(beneBO.getEnrichment("forSI") !=null && beneBO.getEnrichment("forSI").equalsIgnoreCase("Y")){
				isSITransactionExistForBene=true;
				errorMessageKey="First disable the SI and then do the required action on the Beneficiary.\";";		
			}
			else if(isTransactionPendingForBene){
				errorMessageKey="Transaction(s) Pending For Authorization For This Beneficiary. Please Authorize The Transaction(s) Before Disabling.";		
			}
			
			if(isSITransactionExistForBene || isTransactionPendingForBene){
				errorValues.add(beneBO.getBeneficiaryCode());
				BusinessValidationError businessValidationError=new BusinessValidationError();
				businessValidationError.setMessageKey(errorMessageKey);			
				businessValidationError.setMessageValues(errorValues);			
				errors.add(businessValidationError);
				throw new BusinessValidationException(errors);			
			}
			else{
				beneficiaryUtils.enableDisable(beneBO, false);
			}
			
			BaseResponseMap response = new BaseResponseMap();
			response.getResponseStatus().setMessage("Disabled Successfully");
			response.setEntityIdentifier(beneBO.getEntityIdentifier());		
			return response;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}
	
	public BaseResponseMap enable(BaseRequestMap requestMap) throws BusinessValidationException,BaseException, RemoteException,Exception{
		
		String encryptedId = (String)requestMap.getDataMap().get("id");
		BeneficiaryBO beneBO=new BeneficiaryBO();
		if(encryptedId!=null) {
			Optional<BeneficiaryBO> findById = beneficiaryRepository.findById(EncryptUtils.decryptId(EncryptUtils.getId(encryptedId)));
			if(findById.isPresent())
				beneBO=findById.get();
		}
		
		beneficiaryUtils.enableDisable(beneBO, true);
		
		BaseResponseMap response = new BaseResponseMap();
		response.getResponseStatus().setMessage("enabled Successfully");
		response.setEntityIdentifier(beneBO.getEntityIdentifier());		
		return response;
		}
	
	
		
	public BaseRequestResponse view(BaseRequestMap requestMap) throws BusinessValidationException,BaseException, RemoteException,Exception{
		String encryptedId = (String) requestMap.getDataMap().get("id");
		String listType = (String) requestMap.getDataMap().get("type");
		String mode = (String) requestMap.getDataMap().get("mode");
		BeneficiaryBO beneBO=null;
		if(encryptedId!=null) {
			Optional<BeneficiaryBO> findById = beneficiaryRepository.findById(EncryptUtils.decryptId(EncryptUtils.getId(encryptedId)));
			if(findById.isPresent())
				beneBO=findById.get();
			else
				throw new BaseException("No transaction found in specified period.");
		}
		
		Boolean readValue = true;
		if ("rejected".equals(listType)) {
			if (mode != null && mode.equals("viewchangeinfo")) {
				beneBO.setReadValue(ReadValue.MODIFIED);
			} else {
				readValue = false;
				beneBO.setReadValue(ReadValue.ORIGINAL);
			}
		} else {
			if (mode != null && mode.equals("viewchangeinfo")) {
				readValue = false;
				beneBO.setReadValue(ReadValue.ORIGINAL);
			} else {
				beneBO.setReadValue(ReadValue.MODIFIED);
			}
		}
		
		
		Beneficiary details = null;
		if (null != beneBO) {
			details = new Beneficiary();
			Set<BeneficiaryPaymentMethodMapBO> beneficiaryPaymentMethods = beneBO.getBeneficiaryPaymentMethods();
			Map<String, List<BeneficiaryPaymentMethodMap>> beneficiaryPaymentMethodMapGroup = new HashMap<String, List<BeneficiaryPaymentMethodMap>>();
			
			for (BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO : beneficiaryPaymentMethods) {
				
				List<BeneficiaryPaymentMethodMap> beneficiaryPaymentMethodMapList = beneficiaryPaymentMethodMapGroup.get(beneficiaryPaymentMethodMapBO.getPaymentMethodName().replace(" ", "_"));
				
				if (null == beneficiaryPaymentMethodMapList) {
					beneficiaryPaymentMethodMapList = new ArrayList<BeneficiaryPaymentMethodMap>();
				}
				BeneficiaryPaymentMethodMap beneficiaryPaymentMethodMap = new BeneficiaryPaymentMethodMap();
				BeneficiaryPaymentMethodMapAssembler.getInstance().assembleDetails(beneficiaryPaymentMethodMapBO,beneficiaryPaymentMethodMap);
				
				beneficiaryPaymentMethodMap.setModifiedAtOUId(null);
				beneficiaryPaymentMethodMap.setModifiedBy(null);
				beneficiaryPaymentMethodMap.setMakerName(null);
				beneficiaryPaymentMethodMap.setModifiedOn(null);
				beneficiaryPaymentMethodMap.setModifiedSysOn(null);
				beneficiaryPaymentMethodMap.setCheckedBy(null);
				beneficiaryPaymentMethodMap.setCheckedOn(null);
				beneficiaryPaymentMethodMap.setCheckedSysOn(null);
				beneficiaryPaymentMethodMap.setCheckerName(null);
				beneficiaryPaymentMethodMap.setBeneficiaryName(null);
				beneficiaryPaymentMethodMap.setPayeeName(null);
				
				if(!readValue){
					if(!(beneficiaryPaymentMethodMapBO.getLastAction().equalsIgnoreCase("create")||beneficiaryPaymentMethodMapBO.getLastAction().equalsIgnoreCase("create Rejected"))){
						beneficiaryPaymentMethodMapList.add(beneficiaryPaymentMethodMap);
					}
				}else{
					if(!(beneficiaryPaymentMethodMapBO.getLastAction().equalsIgnoreCase("delete")||beneficiaryPaymentMethodMapBO.getLastAction().equalsIgnoreCase("delete Rejected"))){
						beneficiaryPaymentMethodMapList.add(beneficiaryPaymentMethodMap);
					}
				}

				beneficiaryPaymentMethodMapGroup.put((beneficiaryPaymentMethodMapBO.getPaymentMethodName()).replace(" ", "_"),beneficiaryPaymentMethodMapList);
			}
			
			List<PaymentMethodBO> paymentMethods = paymentMethodServiceRepository.findApplicablePaymentMethods();
			for (PaymentMethodBO paymentMethod : paymentMethods) {
				if (!beneficiaryPaymentMethodMapGroup.containsKey((paymentMethod.getPaymentMethodName()).replace(" ", "_"))) {
					beneficiaryPaymentMethodMapGroup.put((paymentMethod.getPaymentMethodName()).replace(" ", "_"),new ArrayList<BeneficiaryPaymentMethodMap>());
				}
			}	
			
			BeneficiaryAssembler.getInstance().assembleDetails(beneBO,details);
			details.setBenePaymentMethodMapGroup(beneficiaryPaymentMethodMapGroup);
		} 
		return details;
	}
	
	
	public BaseResponseMap authorize(BaseRequestMap requestMap) throws BusinessValidationException,BaseException, RemoteException,Exception{
		
		
		boolean isAllTransactionAuthorized = true;
		List<String> ids = (List<String>) requestMap.getDataMap().get("ids");
		
		/**
		 * TODO : Pravin pending 2FA Handling
		 */
		/*if("Y".equals(requestMap.getDataMap().get("VALIDATE_TOKEN")))
		{
			Map<String, String> enrichMentMap=(Map<String, String>) requestMap.getClientDetails().getEnrichmentMap();
			String tokenNo=(String) requestMap.getDataMap().get("tokenNo");
			beneficiaryUtils.validateHardToken(enrichMentMap, tokenNo);
		}
*/		//Validate2FA(requestMap);
		
		for (String id : ids) {
			try {
				//beneficiaryUtils.isBeneficiaryAlreadyExists(beneficiary, isForUpdate);
				BeneficiaryBO  beneBO = null;
				Optional<BeneficiaryBO> findById = beneficiaryRepository.findById(EncryptUtils.decryptId(EncryptUtils.getId(id)));
				if(findById.isPresent())
					beneBO=findById.get();
				
				Set<BeneficiaryPaymentMethodMapBO> beneficiaryPaymentMethods = beneBO.getBeneficiaryPaymentMethods();
				Set<BeneficiaryPaymentMethodMapBO> updatedBeneficiaryPaymentMethods = new LinkedHashSet<>();
				for(BeneficiaryPaymentMethodMapBO benePaymentMethods:beneficiaryPaymentMethods) 
				{
					/**
					 * TODO: Pravin this needs to be checked
					 */
					benePaymentMethods.setAuthorizeMethodProperties();
					if(beneBO.getBeneficiaryType().equalsIgnoreCase("GENERIC") && benePaymentMethods.getBeneficiaryType().equalsIgnoreCase("USERWISE"))
						benePaymentMethods.setBeneficiaryType("GENERIC");
					
					updatedBeneficiaryPaymentMethods.add(benePaymentMethods);
				}
				
				List<PaymentMethodBO> defaultMappingPaymentMethods = paymentMethodServiceRepository.findDefaultMappingPaymentMethods();
				
				for (PaymentMethodBO methodDTO : defaultMappingPaymentMethods) {
					
					BeneficiaryPaymentMethodMapBO beneficiaryPaymentMethodMapBO = BeneficiaryPaymentMethodMapBO.class.newInstance();
					beneficiaryPaymentMethodMapBO.setModification(Modification.DIRECT);
					beneficiaryPaymentMethodMapBO.setRequestBy(beneBO.getRequestBy());
					beneficiaryPaymentMethodMapBO.setCorporateId(beneBO.getCorporateId());
					beneficiaryPaymentMethodMapBO.setPaymentMethodId(methodDTO.getId());
					beneficiaryPaymentMethodMapBO.setBeneficiaryId(beneBO);
					beneficiaryPaymentMethodMapBO.setDispatchTo(DispatchTo.BENEFICIARY);
					beneficiaryPaymentMethodMapBO.setInstrumentDispatchMode(DispatchMode.MAIL);
					beneficiaryPaymentMethodMapBO.setDefaultPaymentMethod(false);
					beneficiaryPaymentMethodMapBO.setEffectiveFrom(DateUtils.now());
					beneficiaryPaymentMethodMapBO.setBeneficiaryType(beneBO.getBeneficiaryType());
					
					if(beneBO.getCorporateUserId() != null)
						beneficiaryPaymentMethodMapBO.setCorporateUserId(beneBO.getCorporateUserId());
					beneficiaryPaymentMethodMapBO.setCreateMethodProperties(true);
					
					updatedBeneficiaryPaymentMethods.add(beneficiaryPaymentMethodMapBO);
					
				}
				
				
				/**
				 * TODO: Pravin this needs to be checked
				 */
				beneBO.setAuthorizeMethodProperties();
			//	beneBO.setBeneficiaryPaymentMethods(updatedBeneficiaryPaymentMethods);
				beneBO.getBeneficiaryPaymentMethods().clear();
				beneBO.getBeneficiaryPaymentMethods().addAll(updatedBeneficiaryPaymentMethods);
				
				beneficiaryRepository.save(beneBO);
				
			} catch (Exception e) {
				if (ids.size() > 1 && e.getMessage()!=null && !(e.getMessage().contains("signature") || e.getMessage().contains("Sign Rule"))) {
					isAllTransactionAuthorized = false;
				} else {
					throw new BaseException(e);
				}
			}
		}
		
		BaseResponseMap response = new BaseResponseMap();
		if (isAllTransactionAuthorized) {
			response.getResponseStatus().setMessage("Authorization Successful");
		} else {
			response.getResponseStatus().setMessage("Some of the records are not authorized.");
			response.getResponseStatus().setStatus(ResponseStatusType.FAIL.toString());
	

		}
		response.setEntity("BeneficiaryService");
		response.setEntityIdentifier("Beneficiary");
		return response;

		
	}

}
