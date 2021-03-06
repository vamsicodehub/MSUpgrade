/*
 * 
 */
package com.aurionpro.beneficiary.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

// TODO: Auto-generated Javadoc
/**
 * The Class JsonDateSerializer.
 */
public class JsonDateSerializer extends JsonSerializer<Date>{
	
	/** The Constant DATEFORMAT. */
	private static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("dd-MMM-yyyy");

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)
	throws IOException, JsonProcessingException {
	 
	String formattedDate = DATEFORMAT.format(date);
	 
	gen.writeString(formattedDate);
	}
}
