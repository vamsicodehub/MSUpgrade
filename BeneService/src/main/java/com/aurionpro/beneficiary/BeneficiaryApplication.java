package com.aurionpro.beneficiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author Pravin.Devade
 */

@EnableDiscoveryClient
@SpringBootApplication
public class BeneficiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiaryApplication.class, args);
	}

}
