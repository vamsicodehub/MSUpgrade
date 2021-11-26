/**
 * Copyright 2015-2016 aurionpro solutions, .  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is not free software; you cannot redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  aurionpro solutions designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 * <p>
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * <p>
 * Please contact aurionpro solutions, public ltd., visit www.aurionprosolutions.com if you need additional information or
 * have any questions.
 */
package com.aurionpro.generic.baserequest;

import java.io.Serializable;
import java.util.Map;

import com.aurionpro.generic.enums.Source;


// TODO: Auto-generated Javadoc
/**
 * The Class ClientDetails.
 *
 * @author abhishek.ramkumar
 * @version 0.1
 * @since 22-07-2015
 */
public class ClientDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5409443366628227316L;

	/** The device id. */
	private String deviceId;

	/** The ip address. */
	private String ipAddress;

	/** The host name. */
	private String hostName;
	
	/** The from mobile agent. */
	private String fromMobileAgent="false";
	
	/** The enrichment map. */
	private Map<String,String> enrichmentMap;

	/** The source. */
	private Source source;

	/**
	 * Gets the device id.
	 *
	 * @return the device id
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * Sets the device id.
	 *
	 * @param deviceId
	 *            the new device id
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * Gets the ip address.
	 *
	 * @return the ip address
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets the ip address.
	 *
	 * @param ipAddress
	 *            the new ip address
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source
	 *            the new source
	 */
	public void setSource(Source source) {
		this.source = source;
	}

	/**
	 * Gets the host name.
	 *
	 * @return the host name
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * Sets the host name.
	 *
	 * @param hostName
	 *            the new host name
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * Gets the from mobile agent.
	 *
	 * @return the from mobile agent
	 */
	public String getFromMobileAgent() {
		return fromMobileAgent;
	}

	/**
	 * Sets the from mobile agent.
	 *
	 * @param fromMobileAgent the new from mobile agent
	 */
	public void setFromMobileAgent(String fromMobileAgent) {
		this.fromMobileAgent = fromMobileAgent;
	}

	/**
	 * Gets the enrichment map.
	 *
	 * @return the enrichment map
	 */
	public Map<String, String> getEnrichmentMap() {
		return enrichmentMap;
	}

	/**
	 * Sets the enrichment map.
	 *
	 * @param enrichmentMap the enrichment map
	 */
	public void setEnrichmentMap(Map<String, String> enrichmentMap) {
		this.enrichmentMap = enrichmentMap;
	}

}
