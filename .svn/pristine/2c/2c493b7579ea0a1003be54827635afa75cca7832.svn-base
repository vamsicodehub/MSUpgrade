package com.aurionpro.generic.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aurionpro.cashpro.commons.utils.CacheDetails;
import com.aurionpro.generic.cache.DefaultDistributedCache;
import com.aurionpro.generic.cache.DistributableCache;



public class FieldNameUtil {
	
	private static List<String> keepAliveKeysList;
	/**
	 * TODO: Pravin Need to check usage 
	 */
	private static final String keepAliveKeys = "AUTHORIZATIONRULESBANK";
	private static final Integer cacheTime = 10;
	
	
	public static Object getObjectFromCache(String serviceName, Object id) {

		if (id == null)
			return null;

		DistributableCache cache = DefaultDistributedCache.getInstance();
		Map<String, CacheDetails> serviceCache = cache.get(serviceName);

		if (serviceCache != null) {
			try {
				return serviceCache.get(id.toString()).objectValue;
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	
	public static void setObjectFromCache(String serviceName, Object id, Object value) {
		if (id == null)
			return;

		if (keepAliveKeysList == null) {
			keepAliveKeysList = new ArrayList<String>();
			if (keepAliveKeys != null && keepAliveKeys.trim().length() > 0) {
				String[] keys = keepAliveKeys.split(",");
				for (String key : keys) {
					keepAliveKeysList.add(key);
				}
			}
		}

		DistributableCache cache = DefaultDistributedCache.getInstance();

		if (value == null) {
			cache.removeFromCache(serviceName, id.toString());
			return;
		}

		Date ttl = new Date();

		Calendar inputCal = Calendar.getInstance();
		inputCal.setTime(ttl);
		inputCal.add(Calendar.MINUTE, cacheTime);
		ttl = inputCal.getTime();

		CacheDetails cacheDetails = new CacheDetails();
		cacheDetails.objectValue = value;
		cacheDetails.expiryTime = ttl;
		cacheDetails.keepAlive = keepAliveKeysList.contains(serviceName);
		String cacheKey = null;
		if (id != null) {
			if (id instanceof String)
				cacheKey = (String) id;
			else
				cacheKey = id.toString();
		}
		if (value != null && value.getClass().isPrimitive()) {
			StringBuilder builder = new StringBuilder();
			builder.append("CacheDetail");
			builder.append(serviceName);
			builder.append("||");
			builder.append(id.toString());
			builder.append("||");
			builder.append(value.toString());
			System.out.println(builder.toString());
		}

		Map<String, CacheDetails> serviceCache = new HashMap<String, CacheDetails>();

		serviceCache = new HashMap<String, CacheDetails>();
		serviceCache.put(cacheKey, cacheDetails);
		cache.put(serviceName, serviceCache);
		
	}
	
	
	
	
	

	public static String getLoginFullName(String loginId, Long ouId) {
		
		return "tovin maker";
		/*
		if (loginId == null)
			return loginId;

		if (Constan.SYSTEM_USE.equalsIgnoreCase(loginId))
			return loginId;

		if (ouId < Constants.corporateMainId) {

			String fullName = getNameForIdFromCache("BankUserService", loginId + ":" + ouId);
			if (fullName == null) {
				String specification = "login = " + loginId;
				fullName = NameForIDUtil.getNameForIdWithSpec("BankUserService", true, "getLoginFullName",
						specification);
				if (fullName == null)
					fullName = loginId;
				setNameForIdFromCache("BankUserService", loginId + ":" + ouId, fullName);

			}
			return fullName;
		} else {

			String fullName = getNameForIdFromCache("CorporateUserService", loginId + ":" + ouId);
			if (fullName == null) {
				String specification = "login = " + loginId + " and corporateId = " + EncryptUtils.encryptId(ouId);
				fullName = NameForIDUtil.getNameForIdWithSpec("CorporateUserService", true, "getLoginFullName",
						specification);
				if (fullName == null)
					fullName = loginId;
				setNameForIdFromCache("CorporateUserService", loginId + ":" + ouId, fullName);
			}
			return fullName;
		}
	*/
		}

	public static String getCorporateUserId(Long userId) {

		String loginId = getNameForIdFromCache("CorporateUserId", userId);
		
		/**
		 * TODO: Pravin to check this
		 */
		/*if (loginId == null) {
			loginId = NameForIDUtil.getNameForId("CorporateUserService", true, "getLogin", userId);
			setNameForIdFromCache("CorporateUserId", userId, loginId);
		}*/
		return loginId;
	}

	public static String getBankUserLoginId(Long userId) {

		String loginId = getNameForIdFromCache("BankUserLoginId", userId);
		
		/**
		 * TODO: Pravin to check this
		 */
		/*if (loginId == null) {
			loginId = NameForIDUtil.getNameForId("BankUserService", true, "getLogin", userId);
			setNameForIdFromCache("BankUserLoginId", userId, loginId);
		}*/
		return loginId;
	}

	public static String getProfileName(Long id) {
		
		if (id == null)
			return null;
		if (0 == id)
			return null;
		String profileName = getNameForIdFromCache("ProfileServiceProfileName", id);
		
		/**
		 * TODO: Pravin to check this
		 */
	/*	if (profileName == null) {
			profileName = NameForIDUtil.getNameForId("ProfileService", true, "getProfileName", id);
			setNameForIdFromCache("ProfileServiceProfileName", id, profileName);
		}*/
		
		return profileName;
	}

	public static String getCorporateName(Long corporateId) {

		if (corporateId == null)
			return null;
		if (0 == corporateId)
			return null;

		String corporateName = getNameForIdFromCache("CorporateMainService", corporateId);
		
		/**
		 * TODO:Pravin to check this
		 */
	/*	if (corporateName == null) {
			corporateName = NameForIDUtil.getNameForId("CorporateMainService", true, "getCorporateName", corporateId);
			setNameForIdFromCache("CorporateMainService", corporateId, corporateName);
		}*/
		
		return corporateName;
	
	}

	public static String getCorporateCode(Long id) {
		
		if (id == null)
			return null;
		if (0 == id)
			return null;

		String corporateCode = getNameForIdFromCache("CorporateMainServiceForCode", id);
		
		/**
		 * TODO:Pravin to check this
		 */
/*		if (corporateCode == null) {
			corporateCode = NameForIDUtil.getNameForId("CorporateMainService", true, "getCorporateCode", id);
			setNameForIdFromCache("CorporateMainServiceForCode", id, corporateCode);
		}*/
		
		return corporateCode;
	}

	public static String getPaymentMethodValue(Long id) {

		if (null != id && id.longValue() == 0)
			return "Unknown Payment Method";

		String paymentMethodValue = getNameForIdFromCache("PaymentMethodsService", id);
		
		/**
		 * TODO:Pravin to check this
		 */
/*		if (paymentMethodValue == null) {
			paymentMethodValue = NameForIDUtil.getNameForId("PaymentMethodService", false, "getPaymentMethodName", id);
			setNameForIdFromCache("PaymentMethodsService", id, paymentMethodValue);
		}*/
		
		return paymentMethodValue;
	}

	public static String getCurrencyCode(Long id) {
		
		if (id == null)
			return null;
		if (0 == id)
			return null;
		String currencyCode = getNameForIdFromCache("CurrencyServiceForCode", id);


		/**
		 * Pravin to check this
		 */
	/*	if (currencyCode == null) {
			currencyCode = NameForIDUtil.getNameForId("CurrencyService", true, "getCurrencyCode", id);
			setNameForIdFromCache("CurrencyServiceForCode", id, currencyCode);
		}*/

		return currencyCode;
	}

	public static String getGeographyName(Long id) {
		
		if (id == null)
			return null;
		if (0 == id)
			return null;

		String geographyName = getNameForIdFromCache("GeographyService", id);
		
		/**
		 * Pravin to check this
		 */
		/*if (geographyName == null) {
			geographyName = NameForIDUtil.getNameForId("GeographyService", true, "getGeographyName", id);
			setNameForIdFromCache("GeographyService", id, geographyName);
		}*/
		
		return geographyName;
	}

	public static String getLocationName(Long bicCode) {
		
		String locationName = getNameForIdFromCache("BicCodeLocationName", bicCode);
		
		/**
		 * Pravin to check this
		 */
		/*if (locationName == null) {
			String specification = " bicCode = " + bicCode;
			locationName = NameForIDUtil.getNameForIdBySpecifiation("BicCodeService", false, "getLocationName",
					specification);
			setNameForIdFromCache("BicCodeServiceName", bicCode, locationName);
		}*/
		return locationName;
	}

	public static String getBankBranchName(Long branchId) {

		if (branchId == null)
			return "";
		if (0 == branchId)
			return "";

		String bankBranchName = getNameForIdFromCache("BankBranchService", branchId);
	
		/**
		 * Pravin to check this
		 */
	/*	if (bankBranchName == null) {
			bankBranchName = NameForIDUtil.getNameForId("BankService", true, branchId, "getBranchNameForId");
			setNameForIdFromCache("BankBranchService", branchId, bankBranchName);
		}*/
		
		return bankBranchName;
	}

	public static String getGroupCode(Long id) {
		
		if (id == null)
			return null;
		else if (0 == id)
			return null;

		String groupCode = getNameForIdFromCache("CorporateGroupTemplateServiceCode", id);
		
		/**
		 * TODO:Pravin to check this
		 */
/*		if (groupCode == null) {
			groupCode = NameForIDUtil.getNameForId("CorporateGroupTemplateService", true, "getGroupCode", id);
			setNameForIdFromCache("CorporateGroupTemplateServiceCode", id, groupCode);
		}*/
		
		return groupCode;
	}

	public static String getGroupName(Long id) {
		
		if (id == null)
			return null;
		else if (0 == id)
			return null;

		String groupName = getNameForIdFromCache("CorporateGroupTemplateServiceName", id);
		
		/**
		 * TODO:Pravin to check this
		 */
	/*	if (groupName == null) {
			groupName = NameForIDUtil.getNameForId("CorporateGroupTemplateService", true, "getGroupName", id);
			setNameForIdFromCache("CorporateGroupTemplateServiceName", id, groupName);
		}*/
		
		return groupName;
	}

	
	/*Payments*/
	public static String getBeneficiaryName(Long id) {

		String beneficiaryName = getNameForIdFromCache("BeneficiaryServiceName", id);
		
		/**
		 * TODO:Pravin to check this
		 */
		/*if(beneficiaryName == null){
			beneficiaryName = NameForIDUtil.getNameForId("BeneficiaryService", false, "getBeneficiaryName", id);
			setNameForIdFromCache("BeneficiaryServiceName", id, beneficiaryName);
		}*/
		
		return beneficiaryName;
	}

	public static String getBeneficiaryEmail(Long id) {

		String beneficiaryEmail = getNameForIdFromCache("BeneficiaryServiceEmail", id);
		
		/**
		 * TODO:Pravin to check this
		 */
		/*if(beneficiaryEmail == null){
			beneficiaryEmail = NameForIDUtil.getNameForId("BeneficiaryService", false, "getEmail", id);
			setNameForIdFromCache("BeneficiaryServiceEmail", id, beneficiaryEmail);
		}*/
		return beneficiaryEmail;
	}

	public static String getBeneficiaryPhone(Long id) {

		String beneficiaryPhone = getNameForIdFromCache("BeneficiaryServicePhoneNo", id);
		
		/**
		 * TODO:Pravin to check this
		 */
		/*if(beneficiaryPhone == null){
			beneficiaryPhone = NameForIDUtil.getNameForId("BeneficiaryService", false, "getPhoneNo", id);
			setNameForIdFromCache("BeneficiaryServicePhoneNo", id, beneficiaryPhone);
		}*/
		
		return beneficiaryPhone;
	
	}

	public static String getPaymentMethodName(Long id) {
		
		if(null != id && id.longValue() == 0)
			return "Unknown Payment Method";
		
		String paymentMethodName = getNameForIdFromCache("PaymentMethodService", id);
		
		/**
		 * TODO:Pravin to check this
		 */
		/*if(paymentMethodName == null){
			paymentMethodName = NameForIDUtil.getNameForId("PaymentMethodService", false, "getPaymentMethodName", id);
			setNameForIdFromCache("PaymentMethodService", id, paymentMethodName);
		}*/
		
		return paymentMethodName;
	}

	public static String getPaymentMethodCode(Long id) {
		
		if(null != id && id.longValue() == 0)
			return "Unknown Payment Method";
		
		String paymentMethodCode = getNameForIdFromCache("PaymentMethodServiceCode", id);
		
	
		/**
		 * TODO:Pravin to check this
		 */
	/*	if(paymentMethodCode == null){
			paymentMethodCode = NameForIDUtil.getNameForId("PaymentMethodService", false, "getPaymentMethodCode", id);
			setNameForIdFromCache("PaymentMethodServiceCode", id, paymentMethodCode);
		}*/
		
		return paymentMethodCode;
	}

	public static String getOtherBankName(Long id) {
		
		if (id == null || 0L == id)
			return null;
		String otherBankName = getNameForIdFromCache("OtherBankService", id);
		
		/**
		 * TODO:Pravin to check this
		 */
		/*if (otherBankName == null) {
			otherBankName = NameForIDUtil.getNameForId("OtherBankService", true, "getOtherBankName", id);
			setNameForIdFromCache("OtherBankService", id, otherBankName);
		}*/
		
		return otherBankName;
	}

	public static String getBeneficiaryCode(Long id) {

		String beneficiaryCode = getNameForIdFromCache("BeneficiaryServiceCode", id);
		
		/**
		 * TODO:Pravin to check this
		 */
		/*if(beneficiaryCode == null){
			beneficiaryCode = NameForIDUtil.getNameForId("BeneficiaryService", false, "getBeneficiaryCode", id);
			setNameForIdFromCache("BeneficiaryServiceCode", id, beneficiaryCode);
		}*/
		
		return beneficiaryCode;
	}

	public static String getPayeeName(Long id) {
		
		if( id == null )
			return null;
		else if(0 == id)
			return null;
		
		String payeeName = getNameForIdFromCache("PayeeName", id);
	
		/**
		 * TODO:Pravin to check this
		 */
		/*if(payeeName == null){			
			payeeName = NameForIDUtil.getNameForId("BeneficiaryService", false, "getPayeeName", id);
			setNameForIdFromCache("PayeeName", id, payeeName);
		}*/
		
		return payeeName;
	}
	
	
	public static String getNameForIdFromCache(String serviceName, Object id) {
		String returnData=(String) getObjectFromCache(serviceName, id);
		
		if(returnData!=null)
			return returnData;
		else 
			return "temp data";
	}
	
	public static void setNameForIdFromCache(String serviceName, Object id, String value) {
		setObjectFromCache(serviceName, id, value);
	}
	
}
