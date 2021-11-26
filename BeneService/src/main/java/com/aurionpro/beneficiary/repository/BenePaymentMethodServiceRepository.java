package com.aurionpro.beneficiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aurionpro.beneficiary.valueobject.BeneficiaryPaymentMethodMapBO;


@Repository
public interface BenePaymentMethodServiceRepository extends JpaRepository<BeneficiaryPaymentMethodMapBO,Long>{
	
}
