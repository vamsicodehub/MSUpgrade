package com.aurionpro.generic.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.aurionpro.generic.baserequest.DataMapAttributes;
import com.aurionpro.generic.baserequest.FilterAttributes;
import com.aurionpro.generic.baserequest.GenericFilterAttributes;
import com.aurionpro.generic.baserequest.GenericUrlDataAttributes;



public class GenericFilterSaxParser extends DefaultHandler {

	/** The entity name. */
	private String entityName;

	/** The header attributes list. */
	private List<GenericFilterAttributes> headerAttributesList;

	/** The map. */
	private Map<String, List<GenericFilterAttributes>> map = new HashMap<String, List<GenericFilterAttributes>>();

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Map<String, List<GenericFilterAttributes>> getMap() {
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
	
		if ("entity".equalsIgnoreCase(qName)) {
			entityName = attributes.getValue("name");
			headerAttributesList = new LinkedList<GenericFilterAttributes>();
		}
		if ("field".equalsIgnoreCase(qName)) {
			
			GenericFilterAttributes headerAttribute = new GenericFilterAttributes();
			headerAttribute.setDisplayName(attributes.getValue("displayName"));
			headerAttribute.setName(attributes.getValue("name"));
			headerAttribute.setType(attributes.getValue("type"));
			headerAttribute.setFieldType(attributes.getValue("fieldType"));
			headerAttribute.setMandatory(Boolean.parseBoolean(attributes.getValue("mandatory")));
			headerAttribute.setUrl(attributes.getValue("url"));
			headerAttribute.setRangeFilter(Boolean.parseBoolean(attributes.getValue("rangeFilter")));
			headerAttribute.setBasedOn(attributes.getValue("basedOn"));
			headerAttribute.setFieldFor(attributes.getValue("fieldFor"));
			headerAttribute.setMaxLength(attributes.getValue("maxLength"));
			headerAttribute.setMinLength(attributes.getValue("minLength"));
			headerAttribute.setSearchResultIndexes(attributes.getValue("searchResultIndexes"));
			headerAttributesList.add(headerAttribute);

		}
		
		if ("urlData".equalsIgnoreCase(qName)) {
			GenericUrlDataAttributes genericUrlDataAttributes= new GenericUrlDataAttributes();
			genericUrlDataAttributes.setPageNumber(attributes.getValue("pageNumber"));
			genericUrlDataAttributes.setSearchType(attributes.getValue("searchType"));
			// Get Latest Inserted Record
			GenericFilterAttributes genericFilterAttributes = headerAttributesList.get(headerAttributesList.size()-1);
			genericFilterAttributes.setUrlData(genericUrlDataAttributes);
		}
		
		if ("filters".equalsIgnoreCase(qName)) {
			List<FilterAttributes>  filterAttributes = new ArrayList<FilterAttributes>();
			GenericFilterAttributes genericFilterAttributes = headerAttributesList.get(headerAttributesList.size()-1);
			GenericUrlDataAttributes genericUrlDataAttributes = genericFilterAttributes.getUrlData();
			genericUrlDataAttributes.setFilters(filterAttributes);
		}
		
		if ("filter".equalsIgnoreCase(qName)) {
			
			FilterAttributes filter = new FilterAttributes();
			filter.setName(attributes.getValue("name"));
			filter.setDisplayName(attributes.getValue("displayName"));
			filter.setType(attributes.getValue("type"));
			filter.setValue(attributes.getValue("value"));
			GenericFilterAttributes genericFilterAttributes = headerAttributesList.get(headerAttributesList.size()-1);
		    genericFilterAttributes.getUrlData().getFilters().add(filter);
		}
		
        if ("dataMap".equalsIgnoreCase(qName)) {
        	DataMapAttributes dataMapAttributes = new DataMapAttributes();
			dataMapAttributes.setMode(attributes.getValue("mode"));
			dataMapAttributes.setGetSelectFor(attributes.getValue("getSelectFor"));
			GenericFilterAttributes genericFilterAttributes = headerAttributesList.get(headerAttributesList.size()-1);
			genericFilterAttributes.getUrlData().setDataMap(dataMapAttributes);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("entity".equalsIgnoreCase(qName)) {
			map.put(entityName, headerAttributesList);
		}
	}
}