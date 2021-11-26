package com.aurionpro.beneficiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aurionpro.beneficiary.valueobject.PaymentMethodBO;

@Repository
public interface PaymentMethodServiceRepository extends JpaRepository<PaymentMethodBO,Long>{
	
	 @Query("SELECT payment FROM PaymentMethodBO payment WHERE payment.isApplicable = 'Y'"
		  		+ " and payment.lastAction not in ('save','create','create Rejected','enable','enable Rejected','disable Authorized')")
	  public List<PaymentMethodBO> findApplicablePaymentMethods();
	 
	 
	 @Query("SELECT payment FROM PaymentMethodBO payment WHERE payment.isApplicable = 'Y' and payment.isDefaultMapping = 'Y' "
		  		+ " and payment.lastAction not in ('save','create','create Rejected','enable','enable Rejected','disable Authorized')")
	  public List<PaymentMethodBO> findDefaultMappingPaymentMethods();

	 
}
