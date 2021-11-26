package com.aurionpro.generic.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.aurionpro.generic.baserequest.GenericFilterAttributes;
import com.aurionpro.generic.exceptions.BaseException;


// TODO: Auto-generated Javadoc
/**
 * The Class HeaderReader.
 */
public class GenericFilterReader {
	
	
	
	/**
	 * Gets the header data.
	 *
	 * @param pathToXML the path to xml
	 * @return the header data
	 * @throws BaseException the base exception
	 */
	public Map<String, List<GenericFilterAttributes>> getGenericFilterData(final String pathToXML) throws BaseException {
		SAXParser saxParser = null;
		GenericFilterSaxParser handler = new GenericFilterSaxParser();
		InputStream in = null;
		SAXParserFactory saxParserFactory = null;
		try {
			saxParserFactory = SAXParserFactory.newInstance();
			saxParser = saxParserFactory.newSAXParser();
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathToXML);
			saxParser.parse(in, handler);
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
			throw new BaseException(e);
		} catch (SAXException e) {
			e.printStackTrace();
			throw new BaseException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BaseException(e);
		} finally {
			if (null != in) {	
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new BaseException(e);
				}
			}
		}
		return handler.getMap();
	}
}
