/*
 * 
 */
package com.aurionpro.generic.assembler;

import java.text.DecimalFormat;

import com.aurionpro.cashpro.commons.security.Ticket;
import com.aurionpro.generic.baserequest.BaseDetails;
import com.aurionpro.generic.baserequest.MakerChecker;
import com.aurionpro.generic.basevalueobject.BaseBO;
import com.aurionpro.generic.basevalueobject.MakerCheckerBO;
import com.aurionpro.generic.basevalueobject.MasterBO;
import com.aurionpro.generic.encryption.EncryptUtils;
import com.aurionpro.generic.encryption.RemoteException;
import com.aurionpro.generic.exceptions.BaseException;
import com.aurionpro.generic.utils.DateUtils;


// TODO: Auto-generated Javadoc
/**
 * The Class MakerCheckerDetailsAssembler.
 */
public class MakerCheckerDetailsAssembler extends BaseDetailsAssembler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aurionpro.cashpro.commons.rest.assembler.BaseDetailsAssembler#assembleDTO
	 * (com.aurionpro.cashpro.commons.dto.BaseDTO,
	 * com.aurionpro.cashpro.rest.base.BaseDetails)
	 */
	@Override
	public MakerCheckerBO assemble(Ticket ticket,BaseBO bo, BaseDetails details)
			throws BaseException, RemoteException {
		// TODO Auto-generated method stub
		BaseBO baseAssemble = super.assemble(ticket,bo, details);		

		MakerChecker makerCheckerDetails = (MakerChecker) details;
		MakerCheckerBO makerCheckerBO;
		
		if(baseAssemble instanceof MasterBO){		
			MasterBO masterBO = (MasterBO) baseAssemble;
			masterBO.setEnabled(makerCheckerDetails.isEnabled());
			masterBO.setActive(makerCheckerDetails.isActive());
			masterBO.setEffectiveFrom(makerCheckerDetails.getEffectiveFrom());
			masterBO.setEffectiveTill(makerCheckerDetails.getEffectiveTill());
			makerCheckerBO = (MakerCheckerBO) masterBO;
		}
		else
			makerCheckerBO = (MakerCheckerBO) baseAssemble;
		
		/**
		 * TODO: Pravin check how to set below data need to take it from either cache/ticket
		 */
	
		makerCheckerBO.setModifiedBy(makerCheckerDetails.getModifiedBy());
		makerCheckerBO.setModifiedSysOn(makerCheckerDetails.getModifiedSysOn());
		makerCheckerBO.setModifiedAtOUId(EncryptUtils.decryptId(makerCheckerDetails.getModifiedAtOUId()));
		makerCheckerBO.setLastAction(makerCheckerDetails.getLastAction());
		makerCheckerBO.setModifiedOn(DateUtils.applicationDateWithServerTime(makerCheckerDetails.getModifiedOn()));
		makerCheckerBO.setCheckedBy(makerCheckerDetails.getCheckedBy());
		
		/**
		 * TODO:Pravin Check commented
		 */
		//makerCheckerBO.setCheckerName(makerCheckerDetails.getCheckerName());
		makerCheckerBO.setCheckedOn(makerCheckerDetails.getCheckedOn());
		makerCheckerBO.setCheckedSysOn(makerCheckerDetails.getCheckedSysOn());
		makerCheckerBO.setRejectReason(makerCheckerDetails.getRejectReason());
		makerCheckerBO.setCallMakerCheckerStrategy(makerCheckerDetails.getCallMakerCheckerStrategy());
		makerCheckerBO.setEntityIdentifier(makerCheckerDetails.getEntityIdentifier());
		
		
		/**
		 * TODO:Pravin to check
		 */
		
		/*if(makerCheckerDTO.isApplicableForVerifier()){
			String productName = ApplicationContext.getInstance().getModuleName();
			String product = Product.valueOf(productName.toUpperCase()).toString();
			Map<String, VerificationDetail> verifierDetail = ticket.getVeriDetailMap();
			VerificationDetail detail = verifierDetail.get(product.toUpperCase());
			if(detail!=null && detail.getVerifierRequired()){
				makerCheckerDTO.setVerified(false);
				makerCheckerDTO.setVerifyAuthLevel(detail.getVerLevel());
				makerCheckerDTO.setNoVerifiedBy(0l);
				makerCheckerDTO.setNoVerifierRequired(detail.getNoOfVerifiers());
			}
		}*/
		
		return makerCheckerBO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aurionpro.cashpro.commons.rest.assembler.BaseDetailsAssembler#
	 * assembleDetails(com.aurionpro.cashpro.commons.dto.BaseDTO,
	 * com.aurionpro.cashpro.rest.base.BaseDetails)
	 */
	@Override
	public void assembleDetails(BaseBO bo, BaseDetails details)
			throws BaseException, RemoteException {
		
		super.assembleDetails(bo, details);
		
		MakerChecker makerCheckerDetails = (MakerChecker) details;
		if(bo instanceof MasterBO){		
			MasterBO masterBO = (MasterBO) bo;
			makerCheckerDetails.setEnabled(masterBO.getEnabled());
			makerCheckerDetails.setActive(masterBO.getActive());
			makerCheckerDetails.setEffectiveFrom(masterBO.getEffectiveFrom());
			makerCheckerDetails.setEffectiveTill(masterBO.getEffectiveTill());
		}


		MakerCheckerBO makerCheckerBO = (MakerCheckerBO) bo;
		makerCheckerDetails.setModifiedBy(makerCheckerBO.getModifiedBy());
		makerCheckerDetails.setMakerName(makerCheckerBO.getMakerName());

		makerCheckerDetails.setModifiedSysOn(makerCheckerBO.getModifiedSysOn());
		makerCheckerDetails.setModifiedAtOUId(EncryptUtils.encryptId(makerCheckerBO.getModifiedAtOUId()));
		makerCheckerDetails.setLastAction(makerCheckerBO.getLastAction());
		makerCheckerDetails.setAuthorized(makerCheckerBO.isAuthorized());
		makerCheckerDetails.setModifiedOn(makerCheckerBO.getModifiedOn());
		makerCheckerDetails.setCheckedBy(makerCheckerBO.getCheckedBy());
		makerCheckerDetails.setCheckerName(makerCheckerBO.getCheckerName());
		makerCheckerDetails.setCheckedOn(makerCheckerBO.getCheckedOn());
		makerCheckerDetails.setCheckedSysOn(makerCheckerBO.getCheckedSysOn());
		makerCheckerDetails.setRejectReason(makerCheckerBO.getRejectReason());
		makerCheckerDetails.setMakerChannel(makerCheckerBO.getMakerChannel());
		makerCheckerDetails.setCheckerChannel(makerCheckerBO.getCheckerChannel());
		
		/**
		 * TODO:Pravin check commented
		 */
	/*	if (!makerCheckerBO.isAuthorized()) {
			String authorizationLevel = makerCheckerBO.getValueForEnrichment("AUTHORIZATIONLEVEL");
				if (null != authorizationLevel && ("B".equalsIgnoreCase(authorizationLevel)
						|| "T".equalsIgnoreCase(authorizationLevel))) {
					makerCheckerDetails.setIsViewAuthorizer(true);
				}
				makerCheckerDetails.setIsAuthorizeReject(true);
			}
		
		if(makerCheckerBO.isApplicableForVerifier()){
			makerCheckerDetails.setVerifiedBy(makerCheckerDTO
					.getValueForEnrichment("PARTIALLYVERIFIED"));
			makerCheckerDetails.setVerifiedOn(DateUtils.toDateWithTime(makerCheckerDTO
					.getValueForEnrichment("verifiedOn")));
		}*/

	}
	
	public static String getformattedAmount(Double amount) {
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		return df.format(amount);
	}


}
