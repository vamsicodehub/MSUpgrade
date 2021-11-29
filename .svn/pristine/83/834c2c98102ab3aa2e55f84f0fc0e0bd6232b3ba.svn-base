/**
 * 
 */
package com.aurionpro.generic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author abhishek.ramkumar
 *
 */
@Target(value = { ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductType {

	public enum PRODUCT {
		
		COMMONS {
			@Override
			public String toString() {
				return "1";
			}
			
		},
		PAYPRO {
			@Override
			public String toString() {
				return "2";
			}

		},
		COLLECTPRO {

			@Override
			public String toString() {
				return "3";
			}

		}
		,
		PDC {

			@Override
			public String toString() {
				return "4";
			}

		},
		LMS {

			@Override
			public String toString() {
				return "5";
			}

		},
		FSCM {

			@Override
			public String toString() {
				return "6";
			}

		},
		VIRTUALACCOUNT {

			@Override
			public String toString() {
				return "10";
			}

		},
		TRADE {

			@Override
			public String toString() {
				return "11";
			}

		}
	}

	PRODUCT product() default PRODUCT.COMMONS;
}
