package com.aurionpro.generic.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonBigDecimalSerializer  extends JsonSerializer<BigDecimal> {
	
	 @Override
	 public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException {

		 NumberFormat numberFormatter;
		 String amount;
		 value = value.setScale(2, BigDecimal.ROUND_HALF_UP);
		 numberFormatter = NumberFormat.getCurrencyInstance();
		 amount = numberFormatter.format(value);
		 amount =amount.substring(1);
		 jgen.writeString(amount);
	 }

}
