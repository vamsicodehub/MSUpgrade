package com.aurionpro.cashpro.commons.plugin;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class ProductKey implements Serializable {
	private static final long serialVersionUID = 8977363114788326989L;
	
	private final String key;

	private final String productId;

	private final String clientHost;	
	
	public ProductKey(String key, String productId, String clientHost) {
		this.key = key;
		this.productId = productId;
		this.clientHost = clientHost;
	}

	public String getKey() {
		return key;
	}
	
	public String getClientHost() {
		return clientHost;
	}

	public String getProductId() {
		return productId;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(key);
		hashCodeBuilder.append(productId);
		hashCodeBuilder.append(clientHost);
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;

		if (obj.getClass() != this.getClass())
			return false;
		
		ProductKey other = (ProductKey)obj;

		return EqualsBuilder.reflectionEquals(this, other);
	}
}
