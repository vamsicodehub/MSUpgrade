package com.aurionpro.beneficiary.enums;

public enum BeneficiaryType {
	
	GENERIC{
		@Override
		public String toString() {
			return "Generic";
		}
	}, 
	USERWISE{
		@Override
		public String toString() {
			return "User Wise";
		}
	};

}


