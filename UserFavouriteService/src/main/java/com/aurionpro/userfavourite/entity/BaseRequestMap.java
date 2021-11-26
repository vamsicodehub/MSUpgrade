/*
 * 
 */
package com.aurionpro.userfavourite.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseRequestMap.
 */

@AllArgsConstructor
@NoArgsConstructor
public class BaseRequestMap extends BaseRequest {

	private static final long serialVersionUID = 566824891581277410L;
	private List<Filter> filters;
	private Map<String, Object> dataMap;

}
