/*
 * 
 */
package com.aurionpro.generic.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


// TODO: Auto-generated Javadoc
/**
 * The Class JsonDateDeserializer.
 */
public class JsonDateDeserializer extends JsonDeserializer<Date>{

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	public Date deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
	     SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
	        String date = arg0.getText();
	        try {
	        	if(date!=null && !"".equals(date)){
	            return format.parse(date);
	        	}else{
	        		return null;
	        	}
	        	
	        } catch (ParseException e) {
	            throw new RuntimeException(e);
	        }

	}

	



}
