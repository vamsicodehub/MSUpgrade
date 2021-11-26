/*
 * 
 */
package com.aurionpro.generic.baserequest;

import java.util.List;
// TODO: Auto-generated Javadoc
//

/**
 * The Class BaseLookUpResponse.
 */
// @JsonInclude(Include.NON_NULL)
public class BaseLookUpResponse extends BaseResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5436978529204556517L;

	/** The data list. */
	private List<DataList> dataList;

	/**
	 * Gets the data list.
	 *
	 * @return the data list
	 */
	public List<DataList> getDataList() {
		return dataList;
	}

	/**
	 * Sets the data list.
	 *
	 * @param dataList
	 *            the new data list
	 */
	public void setDataList(List<DataList> dataList) {
		this.dataList = dataList;
	}
	
	public String getEntityIdentifier() {
		if(getDataList() != null && getDataList().size() ==1){
			String displayName = getDataList().get(0).getDisplayName();
			return ""+displayName;
		}else{
			return "";
		}
	}
	
}
