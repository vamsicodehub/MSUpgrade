package com.aurionpro.generic.baserequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class GenericSearchResponse extends BaseRequestResponse implements Serializable {
	 
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 578542681203814570L;
		
		List<GenericFilterAttributes> genericFilterAttributes = new ArrayList<GenericFilterAttributes>();

		public List<GenericFilterAttributes> getGenericFilterAttributes() {
			return genericFilterAttributes;
		}

		public void setGenericFilterAttributes(List<GenericFilterAttributes> genericFilterAttributes) {
			this.genericFilterAttributes = genericFilterAttributes;
		}
		
		
		
}