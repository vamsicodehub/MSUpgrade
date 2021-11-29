package com.aurionpro.beneficiary.enums;

public enum PaymentMethod {

	// APPLICABLE PAYMENT METHOD FOR BANK ONLY
	
	EP1{
		@Override
		public String toString() {
			return "EP1"; // IFT
		}
	}, 
	EP3{
		@Override
		public String toString() {
			return "EP3"; // NEFT >> EFD
		}
	},
	
	/* APPLICABLE
	 * BANK EFI
	 */
	EP5{
		@Override
		public String toString() {
			return "EP5"; // SWIFT >> EFI
		}
	},
	/* APPLICABLE
	 * BANK CST
	 */
	EP9{
		@Override
		public String toString() {
			return "EP9"; // CST
		}
	},
	/* APPLICABLE
	 * BANK 101
	 */
	EP10{
		@Override
		public String toString() {
			return "EP10"; // 101
		}
	},
	/* APPLICABLE
	 * BANK WPS
	 */
	EP11{
		@Override
		public String toString() {
			return "EP11"; // WPS
		}
	},
	
	/* APPLICABLE
	 * BANK EBP - BILL PAYMMENT
	 */
	EP13{
		@Override
		public String toString() {
			return "EP13"; // EBP
		}
	},
	/* APPLICABLE
	 * BCK
	 */
	PP6{
		@Override
		public String toString() {
			return "PP6"; // Demand Draft
		}
	},
	/* APPLICABLE	
	 * DDT
	 */
	PP7{
		@Override
		public String toString() {
			return "PP7"; // Cor DD
		}
	},
	/* APPLICABLE
	 * CCK
	 */
	PP8{
		@Override
		public String toString() {
			return "PP8"; // Customer Cheques
		}
	},
	
	/* APPLICABLE
	 * OCK
	 */
	PP10{
		@Override
		public String toString() {
			return "PP10";
		}
	},
	/* APPLICABLE
	 * DWP
	 */
	PP11{
		@Override
		public String toString() {
			return "PP11";
		}
	},
	
	// NOT APPLICABLE PAYMENT METHOD FOR BANK
	
	/* NOT APPLICABLE
	 * CASHPAYOUT
	 */
	EP8{
		@Override
		public String toString() {
			return "EP8"; //Cash payout
		}
	},
	/*	
	 * NOT APPLICABLE
	 *	Own Account Transfer 
	 */
	EP2{
		@Override
		public String toString() {
			return "EP2"; // Own Account Transfer
		}
	},
	/* NOT APPLICABLE
	 * RTGS
	 */
	EP4{
		@Override
		public String toString() {
			return "EP4"; // RTGS
		}
	},
	/*
	 *  NOT APPLICABLE
	 *  ECS  
	 */
	EP6{
		@Override
		public String toString() {
			return "EP6"; // ECS
		}
	},
	
	/*	NOT APPLICABLE
	 *  CORR FT 
	 */
	EP7{
		@Override
		public String toString() {
			return "EP7"; // CORR FT
		}
	},
	/* NOT APPLICABLE
	 * ONW   Out Of Network Payment
	 */
	PP9{
		@Override
		public String toString() {
			return "PP9"; //Out Of Network Payment
		}
	},
	/* 
	 * EP14=OWNACCOUNTTRANSFER
	 */
	EP14{
		@Override
		public String toString() {
			return "EP14"; 
		}
	},
	/*
	 *EP15=EBP 
	 */
	EP15{
		@Override
		public String toString(){
			return "EP15";
		}
	},
	
	/* 
	 * EP17=Central Bank Fund Transfer-CBFT
	 */
	EP17 {
		@Override
		public String toString() {
			return "EP17"; 
		}
	},
	/* 
	 * EP17=Central Bank Fund Transfer-CBFT
	 */
	EP18 {
		@Override
		public String toString() {
			return "EP18"; 
		}
	},EP19{
		@Override
		public String toString() {
			return "EP19"; 
		}
	},EP20{//sweep request
		@Override
		public String toString() {
			return "EP20"; 
		}
	},
	EP21{
		@Override
		public String toString() {
			return "EP21"; 
		}
	},
	EP22{// LPOPP
		@Override
		public String toString() {
			return "EP22"; 
		}
	}, 
	
	// Added by Vijay for CBFT - Pension on 25/09/2020
	EP23{
		@Override
		public String toString() {
			return "EP23"; // NEFT >> EFD
		}
	},
	/* 
	 * EP24=Central Bank Fund Transfer-CBFT
	 */
	EP24 {
		@Override
		public String toString() {
			return "EP24"; 
		}
	};
}
