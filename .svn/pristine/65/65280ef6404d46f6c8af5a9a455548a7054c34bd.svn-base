/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ListHeader.
 */
@JsonInclude(Include.NON_NULL)
public class ListHeader implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4538488538430356665L;

	/** The display name. */

	private String displayName;

	/** The type. */

	private String type;

	/** The method. */

	private String method;

	/** The is display. */

	private String isDisplay;
	
	/** Method Name for getting field for Masking*/
	private String methodName;
	
	/** Type of Masking "PREFIX" or "SUFFIX" for getting field for Masking*/
	private String maskingType;
	
	
	/** Masking Character to be displayed for Masked String*/
	private String maskingChar;
	
	/**No of characters to be shown unmasked */
	private String showUnMaskCharLength;
	
	/**Is Masking Required */
	private String isMakingRequired;

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the method.
	 *
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Sets the method.
	 *
	 * @param method
	 *            the new method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * Gets the checks if is display.
	 *
	 * @return the checks if is display
	 */
	public String getIsDisplay() {
		return isDisplay;
	}

	/**
	 * Sets the checks if is display.
	 *
	 * @param isDisplay
	 *            the new checks if is display
	 */
	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}
	

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMaskingType() {
		return maskingType;
	}

	public void setMaskingType(String maskingType) {
		this.maskingType = maskingType;
	}

	public String getMaskingChar() {
		return maskingChar;
	}

	public void setMaskingChar(String maskingChar) {
		this.maskingChar = maskingChar;
	}

	public String getShowUnMaskCharLength() {
		return showUnMaskCharLength;
	}

	public void setShowUnMaskCharLength(String showUnMaskCharLength) {
		this.showUnMaskCharLength = showUnMaskCharLength;
	}
	
	public String getIsMakingRequired() {
		return isMakingRequired;
	}

	public void setIsMakingRequired(String isMakingRequired) {
		this.isMakingRequired = isMakingRequired;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListHeader other = (ListHeader) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		return true;
	}

}