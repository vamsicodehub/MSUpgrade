package com.aurionpro.beneficiary.utils;

import java.io.IOException;
import java.math.BigDecimal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonBigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException {
		String amount = arg0.getText();
		if(amount==null || amount.isEmpty())
			return null;
		amount = amount.replace(",", "");
		return new BigDecimal(amount);
	}

}
