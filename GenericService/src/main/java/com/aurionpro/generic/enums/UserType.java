package com.aurionpro.generic.enums;

public enum UserType {
	BANK{
		@Override
		public String toString() {
			return "BANK";
		}
	},
	CORPORATE{
		@Override
		public String toString() {
			return "CORPORATE";
		}
	},
	SYSTEM{
		@Override
		public String toString() {
			return "CORPORATE";
		}
	},
	GROUP{
		@Override
		public String toString() {
			return "GROUP";
		}
	};
}
