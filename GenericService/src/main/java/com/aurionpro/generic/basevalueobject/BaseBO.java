/**
 * 
 */
package com.aurionpro.generic.basevalueobject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

@MappedSuperclass
public abstract class BaseBO implements Serializable{
	/**
	 * added by sachin 
	 * 26 Dec 2013
	 */
	private static final long serialVersionUID = 2567939336153310620L;

	private static final String ENRICHMENT_ROOT_ELEMENT = "enrichments";

	private static final String ENRICHMENT_ATTRIB_VALUE = "value";

	private static final String ENRICHMENT_ATTRIB_NAME = "name";

	private static final String ENRICHMENT_ELEMENT = "enrichment";

	
/*	@Transient
	protected Long id;*/

	
	/**
	 * TODO: Pravin to check what to do if not availabe in child tables
	 */
	@Transient
	private String enrichments;

	@Transient
	private transient Document enrichmentXML;

	@Transient
	private byte[] zippedEnrichmentXML;

	@Column(name = "VERSION")
	private Integer version = 1;
	
	@Transient
	private String baseModuleType;
	
	/**
	 * Added resendAlertId by MASK for ADCB_CR_Alerts Mapping,Resend Alerts & New Alerts To Check to Resend alerts
	 */
	@Transient
	private Long resendAlertId;
	
	/*public BaseBO() {
		setId(new Long(0));
	}*/
	


/*	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id != null)
		 this.id = id;
	}*/

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/*@Override
	public boolean equals(Object o) {
		if (this.id != null && this.id > 0) {
			return this.id.equals(((BaseBO) o).getId());
		} 
		
		*//**
		 * TODO:Pravin
		 *//*
		return this.id.equals(((BaseBO) o).getId());
		else {
			return EqualsBuilder.reflectionEquals(this.id, o);
		}
		//return EqualsBuilder.reflectionEquals(this.id, o);
	}

	@Override
	public int hashCode() {
		// Modified by Narasimha Reddy P on 13DEc2013 for performance changes from BANK
//		return HashCodeBuilder.reflectionHashCode(this.id);
		if(this.id != null && !"".equals(this.id))
			return id.intValue();
		else
			return 0;
		//return HashCodeBuilder.reflectionHashCode(this.id);
	}
*/
	
	public String getEnrichments() {
		return enrichments;
	}

	public void setEnrichments(String enrichments) {
		this.enrichments = enrichments;
	}

	public String getEnrichment(String name) {
		Element enrichmentElement = getEnrichmentElement(name);

		if (enrichmentElement == null)
			return null;

		return enrichmentElement.attributeValue(ENRICHMENT_ATTRIB_VALUE);
	}

	@SuppressWarnings("unchecked")
	private Element getEnrichmentElement(String name) {
		
		if(enrichments == null)
			return null;
		
		try {
			enrichmentXML = DocumentHelper.parseText(enrichments);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (enrichmentXML == null) {
			return null;
		}

		Element rootElement = enrichmentXML.getRootElement();
		List<Element> elements = rootElement.elements(ENRICHMENT_ELEMENT);
		for (Element element : elements) {
			String enrichmentName = element.attribute(ENRICHMENT_ATTRIB_NAME)
					.getValue();
			if (enrichmentName.equals(name))
				return element;
		}
		return null;
	}

	public void setEnrichment(String name, String value) {
		if (enrichmentXML == null)
			enrichmentXML = createEnrichment();

		Element enrichmentElement = getEnrichmentElement(name);
		if (enrichmentElement == null) {
			if (value != null)
				addEnrichment(name, value);
		} else {
			if (value != null)
				replaceEnrichmentValue(enrichmentElement, value);
			else
				removeEnrichment(enrichmentElement);
		}

		enrichments = enrichmentXML.asXML();
	}

	private void removeEnrichment(Element enrichmentElement) {
		enrichmentXML.getRootElement().remove(enrichmentElement);
	}

	private void replaceEnrichmentValue(Element enrichmentElement, String value) {
		enrichmentElement.attribute(ENRICHMENT_ATTRIB_VALUE).setValue(value);
	}

	private void addEnrichment(String name, String value) {
		Element enrichment = enrichmentXML.getRootElement().addElement(
				ENRICHMENT_ELEMENT);
		enrichment.addAttribute(ENRICHMENT_ATTRIB_NAME, name);
		enrichment.addAttribute(ENRICHMENT_ATTRIB_VALUE, value);
	}

	private Document createEnrichment() {
		Document document = DocumentFactory.getInstance().createDocument();
		if ( enrichments == null || enrichments.equals(" ") || enrichments == "" )
			document.addElement(ENRICHMENT_ROOT_ELEMENT);
		return document;
	}

/*	public String toString() {
		if(id != null)
			return id.toString();
		else
			return null;
	}*/

	/**
	 * 
	 * TODO:Pravin
	 */
/*	public void fromDTO(BaseDTO dto) {
		BODTOFiller.fillBO(this, dto);
	}
	
	public void fromDTOReflection(BaseDTO dto) {
		BODTOFiller.fillBO(this, dto);
	}

	public final BaseDTO toDTO() {
		BaseDTO dto = createDTO();
		BODTOFiller.fillDTO(dto, this);
		return dto;
	}
	
	public final BaseDTO toDTOAuthorizedAndPreviouslyAuthorized() {
		BaseDTO dto = createDTO();
		BODTOFiller.fillDTOAuthorizedAndPreviouslyAuthorized(dto, this);
		return dto;
	}
	
	public final BaseDTO toDTOWithOutChild() {
		BaseDTO dto = createDTO();
		BODTOFiller.fillDTOWithOutChild(dto, this);
		return dto;
	}
	
	//Rohit : Change code calling the data for without child.. as this is corrected code for not calling child object in filler
	public final BaseDTO toDTOWithOutChildAuthorizedAndPreviouslyAuthorized() {
		BaseDTO dto = createDTO();
		if(this instanceof MakerCheckerBO) {
			((MakerCheckerBO)this).setReadValue(ReadValue.ORIGINAL);
		}
		BODTOFiller.fillDTOWithOutChild(dto, this);
		return dto;
	}

	protected BaseBO getNameForID(Class clazz, Long id) {
		
		
		Session session = HibernateUtil.openSession();
		try
		{
			BaseDAO dao = new BaseDAO(session , clazz);
			 BaseBO bo = dao.findById(id);
			 if(bo instanceof MakerCheckerBO) 
				((MakerCheckerBO)bo).setReadValue(ReadValue.ORIGINAL);
			
			 return bo;
		}
		finally
		{
			HibernateUtil.closeSession();
		}
		
	}
	
	protected abstract BaseDTO createDTO();
*/
	public String getBaseModuleType() {
		return baseModuleType;
	}

	public void setBaseModuleType(String baseModuleType) {
		this.baseModuleType = baseModuleType;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		if (zippedEnrichmentXML == null) {
			makeZippedEnrichmentXML();
		}
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		unzipEnrichmentXML();
	}

	protected void makeZippedEnrichmentXML() throws IOException {
		GZIPOutputStream zip = null;
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
		zip = new GZIPOutputStream(baos);
		oos = new ObjectOutputStream(new BufferedOutputStream(zip));
		oos.writeObject(enrichmentXML);
		
		zippedEnrichmentXML = baos.toByteArray();
		}
		catch(Exception e){}
		finally {
			if(oos != null)
				oos.close();
			if(zip != null)
			zip.close();
			if(baos != null)
				baos.close();
		}
	}

	protected void unzipEnrichmentXML() throws IOException, ClassNotFoundException {
		
		GZIPInputStream zip = null;
		ObjectInputStream ois = null;
		ByteArrayInputStream bais = null;
		try{
		bais = new ByteArrayInputStream(zippedEnrichmentXML);
		zip = new GZIPInputStream(bais);
		ois = new ObjectInputStream(
				new BufferedInputStream(zip));
		enrichmentXML = (Document) ois.readObject();
		
		}
		catch(Exception e) {}
		finally {
			if(ois != null)
				ois.close();
			if(zip != null)
			zip.close();
			if(bais != null)
				bais.close();
		}
	}

	public Long getResendAlertId() {
		return resendAlertId;
	}

	public void setResendAlertId(Long resendAlertId) {
		this.resendAlertId = resendAlertId;
	}
	
}
