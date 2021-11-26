package com.aurionpro.beneficiary.validator;

import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.aurionpro.beneficiary.requestobject.Beneficiary;
import com.aurionpro.beneficiary.requestobject.BeneficiaryPaymentMethodMap;
import com.aurionpro.generic.enums.PaymentMethod;
import com.aurionpro.generic.factoryvalidator.AbstractValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class BeneficiaryValidator.
 * 
 * @author fardeen.shaikh
 */
public final class BeneficiaryValidator extends AbstractValidator {
	
	

	public BeneficiaryValidator(InputStream stream) {
		super(stream);
	}

	/** The instance. */
	private static BeneficiaryValidator instance;

	/**
	 * Instantiates a new beneficiary validator.
	 */

	/**
	 * Gets the single instance of BeneficiaryValidator.
	 *
	 * @return single instance of BeneficiaryValidator
	 */
	public static BeneficiaryValidator getInstance() {
		if (instance == null) {
			synchronized (BeneficiaryValidator.class) {
				if (instance == null) {
					ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
					InputStream stream = classLoader.getResourceAsStream("BeneficiaryValidator.xml");
					instance = new BeneficiaryValidator(stream);
				}
			}
		}
		return instance;
	}

	private String keyDelimeter="__";
	private Set<String> uniqueKeysMap=new HashSet<String>(); 
	
	/**
	 * Creates the.
	 *
	 * @param validatorName
	 *            the validator name
	 * @param obj
	 *            the obj
	 * @return the list
	 */
	public List<String> create(String validatorName, Object obj) {
		Beneficiary details = (Beneficiary) obj;
		List<String> errors = new LinkedList<String>();
		
		uniqueKeysMap.clear();
		
		errors.addAll(validateField(validatorName, "beneficiaryType",details.getBeneficiaryType()));
		errors.addAll(validateField(validatorName, "beneficiaryCode",details.getBeneficiaryCode()));
		errors.addAll(validateField(validatorName, "beneficiaryName",details.getBeneficiaryName()));
		errors.addAll(validateField(validatorName, "address1",details.getAddress1()));
		Set<String> keySet = details.getBenePaymentMethodMapGroup().keySet();
		for (String key : keySet) {
			List<BeneficiaryPaymentMethodMap> list = details.getBenePaymentMethodMapGroup().get(key);
			if (list != null && !list.isEmpty()) {
				String keyToCheck=null,errorMessage=null;
				for (BeneficiaryPaymentMethodMap methodMap : list) {
					//errors.addAll(validateField(validatorName, "beneficiaryId",methodMap.getBeneficiaryId()));
					errors.addAll(validateField(validatorName,"paymentMethodId", methodMap.getPaymentMethodId()));
					errors.addAll(validateField(validatorName,"paymentMethodCode",methodMap.getPaymentMethodCode()));
					errors.addAll(validateField(validatorName, "effectiveFrom",methodMap.getEffectiveFrom()));
					
					
					if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP1.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP3.name())
							// Changed by Vijay for CBFT - Pension 25/09/2020 starts
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP23.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP5.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP17.name())
							// Changed by Vijay for CBFT - Pension 25/09/2020 starts
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP24.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP18.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP19.name())) {
						
						String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
							(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
								(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
						
						
						keyToCheck=methodMap.getPaymentMethodCode()+keyDelimeter+details.getBeneficiaryCode()+keyDelimeter+accountNo;
						
						/**
						 * TODO:Pravin to check on this
						 */
						//errorMessage= ResourcesProperty.getDyanamicMessage(RestConstant.BENE_DUPLICATE_DATA_MSG_KEY1, details.getBeneficiaryCode(), methodMap.getPaymentMethodName(),accountNo);
						errorMessage="Duplicate record of Beneficiary Code and Payment Method and Account No";
						
					} else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.PP6.name())
							||methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.PP8.name())
							||methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.PP10.name())) {
						
						keyToCheck=methodMap.getPaymentMethodCode()+keyDelimeter+details.getBeneficiaryCode();
						
						/**
						 * TODO:Pravin to check on this
						 */
						//errorMessage=ResourcesProperty.getDyanamicMessage(RestConstants.BENE_DUPLICATE_DATA_MSG_KEY2, details.getBeneficiaryCode() ,methodMap.getPaymentMethodName());
						errorMessage="Duplicate record of Beneficiary Code and Payment Method";
					} 
					
					if(uniqueKeysMap.contains(keyToCheck)){
						errors.add(errorMessage);
						return errors;
					}else{
						uniqueKeysMap.add(keyToCheck);
					}
					
					validatePaymentMethodField(validatorName, errors, methodMap);
				}
			}
		}
		return errors;
	}

	private void validatePaymentMethodField(String validatorName, List<String> errors, BeneficiaryPaymentMethodMap methodMap) {
		
		if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP1.name())) {
			errors.addAll(validateField(validatorName, "accountNo",methodMap.getAccountNo()));
		} else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP9.name())) {
			errors.addAll(validateField(validatorName, "paymentChannel",methodMap.getPaymentChannel()));
			if (null != methodMap.getPaymentChannel()) {
				if (methodMap.getPaymentChannel().equals("IFT") || methodMap.getPaymentChannel().equals("EFI")) {
					errors.addAll(validateField(validatorName, "accountNo",methodMap.getAccountNo()));
				}
				if (methodMap.getPaymentChannel().equals("EFD")) {
					if (null == methodMap.getiBanNo()) {
						errors.addAll(validateField(validatorName,"cardPayment", methodMap.getCardPayment()));
					} else {
						errors.addAll(validateField(validatorName, "iBanNo",methodMap.getiBanNo()));
					}
				}
			}
		}

		else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP10.name()) || methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP5.name())) {

			String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
				(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
					(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
			
			errors.addAll(validateField(validatorName, "accountNo",accountNo));
			errors.addAll(validateField(validatorName, "beneficiaryBank",methodMap.getBeneficiaryBank()));
			errors.addAll(validateField(validatorName, "address1",methodMap.getAddress1()));

		} else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP3.name())) {
			errors.addAll(validateField(validatorName, "beneficiaryBank",methodMap.getBeneficiaryBank()));
			String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
					(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
						(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
			errors.addAll(validateField(validatorName, "accountNo",accountNo));
			// Changed by Vijay for CBFT - Pension 25/09/2020 starts
		} else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP23.name())) {
			errors.addAll(validateField(validatorName, "beneficiaryBank",methodMap.getBeneficiaryBank()));
			String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
					(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
						(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
			errors.addAll(validateField(validatorName, "accountNo",accountNo));
		}else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP17.name())) {
			errors.addAll(validateField(validatorName, "beneficiaryBank",methodMap.getBeneficiaryBank()));
			
			String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
				(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
					(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
			
			errors.addAll(validateField(validatorName, "accountNo",accountNo));
		} else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP24.name())) {
			errors.addAll(validateField(validatorName, "beneficiaryBank",methodMap.getBeneficiaryBank()));
			
			String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
				(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
					(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
			
			errors.addAll(validateField(validatorName, "accountNo",accountNo));
		} else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP18.name())) {
			errors.addAll(validateField(validatorName, "beneficiaryBank",methodMap.getBeneficiaryBank()));
			
			String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
				(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
					(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
			
			errors.addAll(validateField(validatorName, "accountNo",accountNo));
		} 
		 else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP19.name())) {
				errors.addAll(validateField(validatorName, "beneficiaryBank",methodMap.getBeneficiaryBank()));
				
				String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
					(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
						(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
				
				errors.addAll(validateField(validatorName, "accountNo",accountNo));
			} 
		errors.addAll(validateField(validatorName, "effectiveFrom",methodMap.getEffectiveFrom()));

	}

	/**
	 * Update.
	 *
	 * @param validatorName
	 *            the validator name
	 * @param obj
	 *            the obj
	 * @return the list
	 */
	public List<String> update(String validatorName, Object obj) {
		Beneficiary details = (Beneficiary) obj;
		List<String> errors = new LinkedList<String>();
		
		uniqueKeysMap.clear();
		
		errors.addAll(validateField(validatorName, "id", details.getId()));
		errors.addAll(validateField(validatorName, "version",details.getVersion()));
		errors.addAll(validateField(validatorName, "lastAction",details.getLastAction()));
		errors.addAll(validateField(validatorName, "beneficiaryType",details.getBeneficiaryType()));
		errors.addAll(validateField(validatorName, "beneficiaryCode",details.getBeneficiaryCode()));
		errors.addAll(validateField(validatorName, "beneficiaryName",details.getBeneficiaryName()));
		Set<String> keySet = details.getBenePaymentMethodMapGroup().keySet();
		for (String key : keySet) {
			List<BeneficiaryPaymentMethodMap> list = details
					.getBenePaymentMethodMapGroup().get(key);
			if (list != null && !list.isEmpty()) {
				String keyToCheck=null,errorMessage=null;
				for (BeneficiaryPaymentMethodMap methodMap : list) {
					errors.addAll(validateField(validatorName, "beneficiaryId",methodMap.getBeneficiaryId()));
					errors.addAll(validateField(validatorName,"paymentMethodId", methodMap.getPaymentMethodId()));
					errors.addAll(validateField(validatorName,"paymentMethodCode",methodMap.getPaymentMethodCode()));
					errors.addAll(validateField(validatorName, "id",methodMap.getId()));
					errors.addAll(validateField(validatorName, "version",methodMap.getVersion()));
					errors.addAll(validateField(validatorName, "lastAction",methodMap.getLastAction()));
					errors.addAll(validateField(validatorName, "effectiveFrom",methodMap.getEffectiveFrom()));
					
					
					if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP1.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP3.name())
							// Changed by Vijay for CBFT - Pension 25/09/2020 starts
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP23.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP5.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP17.name())
							// Changed by Vijay for CBFT - Pension 25/09/2020 starts
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP24.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP18.name())
							|| methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.EP19.name())) {
						
						String accountNo=methodMap.getAccountNo()!=null && !methodMap.getAccountNo().equals("") ? methodMap.getAccountNo() : 
							(methodMap.getiBanNo()!=null && !methodMap.getiBanNo().equals("") ? methodMap.getiBanNo() : 
								(methodMap.getCardPayment()!=null && !methodMap.getCardPayment().equals("") ? methodMap.getCardPayment() : null));
						
						
						
						keyToCheck=methodMap.getPaymentMethodCode()+keyDelimeter+details.getBeneficiaryCode()+keyDelimeter+accountNo;
						
						/**
						 * TODO:Pravin to check on this
						 */
						//errorMessage=ResourcesProperty.getDyanamicMessage(RestConstants.BENE_DUPLICATE_DATA_MSG_KEY1, details.getBeneficiaryCode(), methodMap.getPaymentMethodName(),accountNo);
						errorMessage="Duplicate record of Beneficiary Code and Payment Method and Account No";
						
					} else if (methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.PP6.name())
							||methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.PP8.name())
							||methodMap.getPaymentMethodCode().equalsIgnoreCase(PaymentMethod.PP10.name())) {
						
						keyToCheck=methodMap.getPaymentMethodCode()+keyDelimeter+details.getBeneficiaryCode();
						
						/**
						 * TODO:Pravin to check on this
						 */
						//errorMessage=ResourcesProperty.getDyanamicMessage(RestConstants.BENE_DUPLICATE_DATA_MSG_KEY2, details.getBeneficiaryCode() ,methodMap.getPaymentMethodName());
						errorMessage="Duplicate record of Beneficiary Code and Payment Method";
						
					} 
					
					if(uniqueKeysMap.contains(keyToCheck)){
						errors.add(errorMessage);
						break;
					}else{
						uniqueKeysMap.add(keyToCheck);
					}
					
					validatePaymentMethodField(validatorName, errors, methodMap);
				}
			}
		}
		return errors;
	}
}
