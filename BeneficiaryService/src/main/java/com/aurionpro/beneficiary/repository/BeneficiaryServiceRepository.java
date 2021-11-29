package com.aurionpro.beneficiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aurionpro.beneficiary.valueobject.BeneficiaryBO;


@Repository
public interface BeneficiaryServiceRepository extends JpaRepository<BeneficiaryBO,Long>{
	/**
	 * TODO: Pravin: Group case to be handled
	 */
	@Query("SELECT bene FROM BeneficiaryBO bene WHERE bene.beneficiaryCode = :beneficiaryCode and bene.corporateId = :corporateId")
	 public List<BeneficiaryBO> findBeneForCorporate(@Param("beneficiaryCode") String beneficiaryCode,@Param("corporateId") Long corporateId);
	
}
