package com.aurionpro.beneficiary.baserequest;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDetails implements Serializable{

	private static final long serialVersionUID = -2355271915705901175L;
	private String corporateCode;
	private String userName;
	private String generatedSecretKey;
}
