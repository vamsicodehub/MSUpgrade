package com.aurionpro.beneficiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Pravin.Devade
 */

@SpringBootApplication
public class BeneficiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiaryApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
