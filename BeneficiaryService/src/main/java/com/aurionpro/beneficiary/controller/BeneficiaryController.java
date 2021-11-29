package com.aurionpro.beneficiary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.beneficiary.baserequest.BaseRequestMap;
import com.aurionpro.beneficiary.baserequest.BaseRequestResponse;
import com.aurionpro.beneficiary.baserequest.BaseResponseMap;
import com.aurionpro.beneficiary.requestobject.Beneficiary;
import com.aurionpro.beneficiary.service.BeneficiaryService;


@RestController
@RequestMapping("/beneficiaryService")
public class BeneficiaryController {
	
	protected final String CREATE = "/private/create";
	protected final String UPDATE = "/private/update";
	protected final String DELETE = "/private/delete";
	protected final String DISABLE = "/private/disable";
	protected final String ENABLE = "/private/enable";
	protected final String VIEW = "/private/view";
	protected final String AUTHORIZE = "/private/authorize";
	

	@Autowired
	private BeneficiaryService benefeciaryService;
	
	@PostMapping(CREATE)
	public BaseResponseMap addBene(
			@RequestBody Beneficiary beneDetails,
			HttpServletRequest request) throws Exception {
		
		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(favouriteDetail, getClass().getCanonicalName(),"addFavourite");
		BaseResponseMap response=benefeciaryService.create(beneDetails);
		return response;
	}
	
	
	@PostMapping(UPDATE)
	public BaseResponseMap updateBene(
			@RequestBody Beneficiary beneDetails,
			HttpServletRequest request) throws Exception {
		
		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(favouriteDetail, getClass().getCanonicalName(),"addFavourite");
		BaseResponseMap response=benefeciaryService.update(beneDetails);
		return response;
	}
	
	@PostMapping(DELETE)
	public BaseResponseMap deleteBene(
			@RequestBody BaseRequestMap beneDetails,
			HttpServletRequest request) throws Exception {
		
		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(request,MakerCheckerController.class.getCanonicalName(), "delete");
		BaseResponseMap response=benefeciaryService.delete(beneDetails);
		return response;
	}
	
	@PostMapping(DISABLE)
	public BaseResponseMap disable(@RequestBody BaseRequestMap baseRequestMap,HttpServletRequest httpRequest) throws Exception {

		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(baseRequestMap,MakerCheckerController.class.getCanonicalName(), "disable");
		BaseResponseMap response=benefeciaryService.disable(baseRequestMap);
		return response;

	}
	
	@PostMapping(ENABLE)
	public BaseResponseMap enable(@RequestBody BaseRequestMap baseRequestMap,HttpServletRequest httpRequest) throws Exception {

		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(baseRequestMap,MakerCheckerController.class.getCanonicalName(), "disable");
		BaseResponseMap response=benefeciaryService.enable(baseRequestMap);
		return response;

	}
	
	@PostMapping(VIEW)
	public BaseRequestResponse view(@RequestBody BaseRequestMap request,HttpServletRequest httpRequest) throws Exception {
		//ValidatorUtils.validate(request,MakerCheckerController.class.getCanonicalName(), "view");
		BaseRequestResponse response=benefeciaryService.view(request);
		return response;
	}
	
	@PostMapping(AUTHORIZE)
	public BaseResponseMap authorize(@RequestBody BaseRequestMap requestMap, HttpServletRequest httpRequest) throws Exception {
	
		/**
		 * TODO: Pravin to check 3FA 
		 */
	/*	UserDetails userDetails = (UserDetails) ApplicationCache.getAttribute(requestMap.getSecurityId(),ApplicationCacheContstants.USER_DETAILS);
		if (this instanceof Enable2FA && (AuthenticationType.HARDTOKEN.name().equals(userDetails.getSelectedAuthType()) || AuthenticationType.SOFTTOKEN.name().equals(userDetails.getSelectedAuthType()))) {
			requestMap.getClientDetails().getEnrichmentMap().put("TokenType", TokenType.AUTHORIZATION.name());
			requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "Y");
		} else {
			requestMap.getDataMap().put(RestConstants.VALIDATE_TOKEN, "N");
		}
		*/

		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(requestMap,MakerCheckerController.class.getCanonicalName(), "authorize");

		return benefeciaryService.authorize(requestMap);
	}

	
}
