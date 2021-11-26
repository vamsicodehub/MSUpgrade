package com.aurionpro.beneficiary.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.beneficiary.requestobject.Beneficiary;
import com.aurionpro.beneficiary.service.BeneficiaryServiceImpl;
import com.aurionpro.beneficiary.validator.BeneficiaryValidator;
import com.aurionpro.cashpro.commons.security.Ticket;
import com.aurionpro.generic.baserequest.BaseRequestMap;
import com.aurionpro.generic.baserequest.BaseRequestResponse;
import com.aurionpro.generic.baserequest.BaseResponseMap;
import com.aurionpro.generic.constants.ApplicationCacheContstants;
import com.aurionpro.generic.exceptions.ValidationException;
import com.aurionpro.generic.utils.FieldNameUtil;



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
	
	private final String SECURITYID = "security";

	@Autowired
	private BeneficiaryServiceImpl benefeciaryService;
	
	@PostMapping(CREATE)
	public BaseResponseMap create(
			@RequestBody Beneficiary beneDetails,
			HttpServletRequest request) throws Exception {
		
		Ticket ticket=validateRequestData("create", beneDetails,request);
		BaseResponseMap response=benefeciaryService.create(ticket,beneDetails);
		return response;
	}
	
	
	@PostMapping(UPDATE)
	public BaseResponseMap update(
			@RequestBody Beneficiary beneDetails,
			HttpServletRequest request) throws Exception {
		
	
		Ticket ticket=validateRequestData("update", beneDetails,request);
		BaseResponseMap response=benefeciaryService.update(ticket,beneDetails);
		return response;
	}
	
	@PostMapping(DELETE)
	public BaseResponseMap delete(
			@RequestBody BaseRequestMap beneDetails,
			HttpServletRequest request) throws Exception {
		
		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(request,MakerCheckerController.class.getCanonicalName(), "delete");
		Ticket ticket=getTicket(request);
		BaseResponseMap response=benefeciaryService.delete(ticket,beneDetails);
		return response;
	}
	
	@PostMapping(DISABLE)
	public BaseResponseMap disable(@RequestBody BaseRequestMap baseRequestMap,HttpServletRequest request) throws Exception {

		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(baseRequestMap,MakerCheckerController.class.getCanonicalName(), "disable");
		Ticket ticket=getTicket(request);
		BaseResponseMap response=benefeciaryService.disable(ticket,baseRequestMap);
		return response;

	}
	
	@PostMapping(ENABLE)
	public BaseResponseMap enable(@RequestBody BaseRequestMap baseRequestMap,HttpServletRequest request) throws Exception {

		/**
		 * TODO : Pravin to check how to add this
		 */
		//ValidatorUtils.validate(baseRequestMap,MakerCheckerController.class.getCanonicalName(), "disable");
		Ticket ticket=getTicket(request);
		BaseResponseMap response=benefeciaryService.enable(ticket,baseRequestMap);
		return response;

	}
	
	@PostMapping(VIEW)
	public BaseRequestResponse view(@RequestBody BaseRequestMap baseRequestMap,HttpServletRequest request) throws Exception {
		//ValidatorUtils.validate(request,MakerCheckerController.class.getCanonicalName(), "view");
		Ticket ticket=getTicket(request);
		BaseRequestResponse response=benefeciaryService.view(ticket,baseRequestMap);
		return response;
	}
	
	@PostMapping(AUTHORIZE)
	public BaseResponseMap authorize(@RequestBody BaseRequestMap requestMap, HttpServletRequest request) throws Exception {
	
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

		Ticket ticket=getTicket(request);
		return benefeciaryService.authorize(ticket,requestMap);
	}
	
	public Ticket validateRequestData(String method, BaseRequestResponse baseRequestResponse,HttpServletRequest request) throws Exception
	{
		List<String> errors =BeneficiaryValidator.getInstance().validate(method, baseRequestResponse);
		if (errors != null && !errors.isEmpty()) {
			throw new ValidationException(errors);
		}
		
		Ticket ticket =getTicket(request);
		return ticket;
	}
	
	
	public Ticket getTicket(HttpServletRequest request) throws Exception{
		List<String> errors=new ArrayList<>();
		String security = request.getHeader(SECURITYID);
		Ticket ticket = (Ticket) FieldNameUtil.getObjectFromCache("Micro-"+security, ApplicationCacheContstants.TICKET);
		
		if(ticket==null)
		{
			errors.add("Ticket Not Found");
			throw new ValidationException(errors);
		}
		
		return ticket;
	}

	
}
