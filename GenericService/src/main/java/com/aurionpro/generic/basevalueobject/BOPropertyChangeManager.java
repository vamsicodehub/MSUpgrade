package com.aurionpro.generic.basevalueobject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.aurionpro.generic.basevalueobject.MakerCheckerBO.Modification;
import com.aurionpro.generic.basevalueobject.MakerCheckerBO.ReadValue;
import com.aurionpro.generic.utils.DateUtils;

public class  BOPropertyChangeManager implements Serializable{

	/**
	 * added by sachin 
	 * 26 Dec 2013
	 */
	private static final long serialVersionUID = 5697922527783137045L;

	private MakerCheckerBO makerCheckerBO;

	/**
	 * The XML Representation of the changes done to the object
	 */
	private Document changeInfoXML;
	private BOPropertyChangeManager(){
		super();
	}

	public BOPropertyChangeManager(MakerCheckerBO makerCheckerBO) {
		this.makerCheckerBO = makerCheckerBO;
	}

	@SuppressWarnings("unchecked")
	private Element getChangeInfoProperty(String name) {
		if (changeInfoXML == null) {
			changeInfoXML = createChangeInfoXML();
		}

		Element rootElement = changeInfoXML.getRootElement();
		List<Element> elements = rootElement.elements("property");
		for (Element element : elements) {
			String propertyName = element.attribute("name").getValue();
			if (propertyName.equals(name))
				return element;
		}
		return null;
	}

	private String getChangedInfo(String fieldName) {
		Element fieldElement = getChangeInfoProperty(fieldName);
		if (fieldElement == null)
			return null;

		return fieldElement.attributeValue("newvalue");
	}

	private Document createChangeInfoXML() {
		Document document = null;
		if (makerCheckerBO.getChangeInfo() == null) {
			document = DocumentFactory.getInstance().createDocument();
			document.addElement("changeinfo");
		} else {
			try {
				document = DocumentHelper.parseText(makerCheckerBO.getChangeInfo());
			} catch (DocumentException e) {
				document = DocumentFactory.getInstance().createDocument();
				document.addElement("changeinfo");
			}
		}
		return document;
	}

	private void setChangedInfo(String fieldName, String newValue)
	throws SecurityException, NoSuchFieldException,
	IllegalArgumentException, IllegalAccessException {
		if (changeInfoXML == null)
			changeInfoXML = createChangeInfoXML();

		Element propertyElement = getChangeInfoProperty(fieldName);
		if (propertyElement == null) {
			Field field = getField(fieldName);
			String oldValue = null;
			if (getFieldValue(field) != null)
				oldValue = convertObjectToString(getFieldValue(field));

			if (!valuesAreEqual(oldValue, newValue))
				addChangedValue(fieldName, oldValue, newValue);
		} else {
			replaceChangedValue(propertyElement, newValue);
		}
		makerCheckerBO.setChangeInfo(changeInfoXML.asXML());
//		if("modifiedBy".equals(fieldName)){
//			if(makerCheckerBO.getModification() == Modification.PENDINGAUTHORIZATION) {
//				makerCheckerBO.setModification(Modification.DIRECT);
//				makerCheckerBO.setModifiedBy(newValue);
//				makerCheckerBO.setModification(Modification.PENDINGAUTHORIZATION);
//			}
//		}
	}

	private boolean valuesAreEqual(String oldValue, String newValue) {
		if ((oldValue == null || "".equals(oldValue)) && ("".equals(newValue) || newValue == null))
			return true;

		if ("".equals(newValue) || newValue == null)
			return false;

		return newValue.equals(oldValue);
	}

	private void replaceChangedValue(Element propertyElement, String value) {
		if(propertyElement.attribute("newvalue")!=null)
		{
			propertyElement.attribute("newvalue").setValue(value);
		}
		else
		{
			propertyElement.addAttribute("newvalue", value);
		}
	}

	private void addChangedValue(String fieldName, String oldValue,
			String newValue) {
		Element property = changeInfoXML.getRootElement()
		.addElement("property");
		property.addAttribute("name", fieldName);
		property.addAttribute("newvalue", newValue);
		property.addAttribute("oldvalue", oldValue);
	}

	private Field getField(String fieldName) throws SecurityException,
	NoSuchFieldException {
		Class boClass = makerCheckerBO.getClass();
		Field field = null;
		// TODO: find a better way or live with it.
		// traversing thru fields of base classes upto 2 levels to locate bases
		// class fields being modified
		// currently modification was not working for base class fields , eg.
		// effectiveFrom from MasterBO
		try {
			field = boClass.getDeclaredField(fieldName);

		} catch (NoSuchFieldException e) {
			try {
				field = boClass.getSuperclass().getDeclaredField(fieldName);
			} catch (NoSuchFieldException e1) {
				try {
					field = boClass.getSuperclass().getSuperclass()
					.getDeclaredField(fieldName);
				} catch (NoSuchFieldException e2) {
					try{
						field = boClass.getSuperclass().getSuperclass().getSuperclass()
						.getDeclaredField(fieldName);
					}catch (NoSuchFieldException e3) {
						try {
						field = boClass.getSuperclass().getSuperclass().getSuperclass().getSuperclass()
						.getDeclaredField(fieldName);
						}catch(NoSuchFieldException e4) {
							field = boClass.getSuperclass().getSuperclass().getSuperclass().getSuperclass().getSuperclass()
									.getDeclaredField(fieldName);
						}
					}
				}
			}
		}

		field.setAccessible(true);
		return field;
	}

	private String convertObjectToString(Object obj) {
		if(obj != null) {
			if (obj instanceof Date)
				return DateUtils.toString((Date) obj);
	
			if (obj instanceof Enum)
				return ((Enum) obj).name();
			
			return obj.toString();
		}
		else
			return null;
	}

	protected <T> Object convertStringToObject(String value, Class<T> clazz) {
		// TODO: to find a way to convert to any data type , not to use the
		// current if else

		if(value == null)
			return null;
		try {

			if (clazz.getName().equals("java.lang.Long")) {
				return Long.parseLong(value);
			} else if (clazz.getName().equals("java.lang.Float")) {
				return Float.parseFloat(value);
			} else if (clazz.getName().equals("java.lang.Boolean")) {
				return Boolean.parseBoolean(value);
			} else if (clazz.getName().equals("java.lang.Integer")) {
				return Integer.parseInt(value);
			} else if (clazz.getName().equals("java.lang.Double")) {
				return Double.parseDouble(value);
			} else if (clazz.getName().equals("java.lang.Character")) {
				if(!value.equals(""))
					return new Character(value.charAt(0));
			}
			else if (clazz.isEnum()) {
				T[] enumConstants = clazz.getEnumConstants();
				for (int i = 0; i < enumConstants.length; i++) {
					String enumSimpleName = ((Enum)enumConstants[i]).name();
					if (enumSimpleName.equals(value))
						return enumConstants[i];
				}
				return null;
			}
			else if (clazz.getName().equals("java.util.Date")) {
				return DateUtils.toDateWithTime(value);
			}else if (clazz.getName().equals("java.math.BigDecimal")) {
				return new BigDecimal(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return clazz.cast(value);
	}

	private Object getFieldValue(Field field) throws IllegalArgumentException,
	IllegalAccessException {
		return field.get(makerCheckerBO);
	}

	private void setFieldValue(Field field, Object value)
	throws IllegalArgumentException, IllegalAccessException {
		field.set(makerCheckerBO, value);
	}

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.commons.bo.BOPropertyChangeManager#getProperty(java.lang.String)
	 */
	public final String getProperty(final String propertyName)
	throws SecurityException, NoSuchFieldException,
	IllegalArgumentException, IllegalAccessException {
		
		if (makerCheckerBO.getReadValue() == ReadValue.ORIGINAL) {
			Field field = getField(propertyName);
			return convertObjectToString(getFieldValue(field));
		} else {
			if (isPropertyChanged(propertyName))
				return getChangedInfo(propertyName);

			Field field = getField(propertyName);
			return convertObjectToString(getFieldValue(field));
		}
	}

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.commons.bo.BOPropertyChangeManager#getProperty(java.lang.String)
	 */
	public final Object getPropertyObject(final String propertyName)
	throws SecurityException, NoSuchFieldException,
	IllegalArgumentException, IllegalAccessException {
		
		Field field = getField(propertyName);
		if (makerCheckerBO.getReadValue() == ReadValue.ORIGINAL) {
			makerCheckerBO.isOriginalVal = true;
			return getFieldValue(field);
		}else if(makerCheckerBO.getChangeInfo() == null) {
			//makerCheckerBO.isOriginalVal = true;
			return getFieldValue(field);
		}else {
			if (isPropertyChanged(propertyName))
				return convertStringToObject(getChangedInfo(propertyName),field.getType());

			return getFieldValue(field);
		}
	}

	private boolean isPropertyChanged(String propertyName) {
		Element fieldElement = getChangeInfoProperty(propertyName);
		if (fieldElement == null)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.commons.bo.BOPropertyChangeManager#setProperty(java.lang.String, java.lang.String)
	 */
	public final void setProperty(final String propertyName, final String value)
	throws SecurityException, NoSuchFieldException,
	IllegalArgumentException, IllegalAccessException {
		
		/**
		 * TODO:Pravin need to check
		 */
		if (makerCheckerBO.getModification() == Modification.DIRECT   
				//|| makerCheckerBO.getId().equals(new Long(0)) 
				|| "create".equals(makerCheckerBO.getLastAction())
				|| "save".equals(makerCheckerBO.getLastAction())
				||  "create Rejected".equals(makerCheckerBO.getLastAction())) {
			
			makerCheckerBO.isModifyDirectVal = true;
			Field field = getField(propertyName);
			setFieldValue(field, convertStringToObject(value, field.getType()));
		} else
			setChangedInfo(propertyName, value);
		
	}

	/* (non-Javadoc)
	 * @see com.aurionpro.cashpro.commons.bo.BOPropertyChangeManager#applyChanges()
	 */
	public final void applyChanges() {
		// Class boClass = makerCheckerBO.getClass();

		HashMap<String, String> map = getChangeInfo();

		for (String keyname : map.keySet()) {
			try {
				Field field = getField(keyname);
				setFieldValue(field, convertStringToObject(map.get(keyname),
						field.getType()));
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private HashMap<String, String> getChangeInfo() {
		if (changeInfoXML == null) {
			changeInfoXML = createChangeInfoXML();
		}
		HashMap<String, String> map = new HashMap<String, String>();

		Element rootElement = changeInfoXML.getRootElement();
		ArrayList<Element> elements = (ArrayList<Element>) getElements(
				rootElement, "property");

		for (Element element : elements) {
			map.put(element.attributeValue("name"), element
					.attributeValue("newvalue"));

		}
		return map;
	}

	@SuppressWarnings("unchecked")
	private List<Element> getElements(Element anyElement, String tagName) {
		List<Element> elements = anyElement.elements(tagName);
		return elements;
	}

	/*Document getChangeInfoXML() {
		return changeInfoXML;
	}*/
}
