package com.aurionpro.beneficiary.enums;

public enum DispatchMode {
	
	EMAIL {
		@Override
		public String toString() {
			return "Email";
		} 
	},
	MAIL {
		@Override
		public String toString() {
			return "Mail";
		} 
	},
	COURIER {
		@Override
		public String toString() {
			return "Courier";
		} 
	},
	COUNTERCOLLECT {
		@Override
		public String toString() {
			return "Counter Collect";
		} 
	};
}


