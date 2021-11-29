/**
 * 
 */
package com.aurionpro.generic.basevalueobject;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.aurionpro.generic.basevalueobject.MakerCheckerBO.Modification;
import com.aurionpro.generic.enums.Source;
import com.aurionpro.generic.exceptions.BaseException;
import com.aurionpro.generic.utils.DateUtils;
import com.aurionpro.generic.utils.FieldNameUtil;

@MappedSuperclass
public abstract class MakerCheckerBO extends BaseBO implements Auditable {

	

	public enum ReadValue {
		ORIGINAL, MODIFIED
	}

	public enum Modification {
		DIRECT, PENDINGAUTHORIZATION
	}

	/**
	 * Indicates if the record needs to be authorized or not
	 */
	@Column(name="AUTHORIZED")
	@Type(type="yes_no")
	private boolean authorized; // Indicates that the entry is authorized

	/**
	 * The Last Action performed on the record. Valid values include
	 * add/edit/delete/authorized/rejected/acceptreject Derived classes can
	 * extend list of values
	 */
	@Column(name="LASTACTION")
	private String lastAction; // unknown/add/edit/delete/authorized/rejected/acceptreject

	/**
	 * The reason for rejection of changes. Valid only for lastAction=rejected
	 */
	@Column(name="REJECTREASON")
	private String rejectReason;

	/**
	 * Indicates the Org Unit id where the change was done
	 */
	@Column(name="MODIFIEDATOU")
	private Long modifiedAtOUId;


	/**
	 * The user who has made the modification
	 */
	@Column(name="MODIFIEDBY")
	private String modifiedBy;

	/**
	 * The user that has authorized the changes
	 */
	
	@Column(name="CHECKEDBY")
	private String checkedBy;

	/**
	 * The application date on which the user has modified the record
	 */
	@Column(name="MODIFIEDON")
	private Date modifiedOn;

	/**
	 * The system date when the record was last modified
	 */
	@Column(name="MODIFIEDSYSON")
	private Date modifiedSysOn;

	/**
	 * The application date on which the record was last autorized
	 */
	@Column(name="CHECKEDON")
	private Date checkedOn;

	/**
	 * The system date when the record was authorized
	 */
	@Column(name="CHECKEDSYSON")
	private Date checkedSysOn;

	/**
	 * Field (in XML) that keeps information about the changes made to the
	 * record. XML that reflect the changes made to object
	 */
	
	@Column(name="CHANGEINFO")
	private String changeInfo;

	/**
	 * Indicates if the get methods should return original authorized values (1)
	 * or latest modified values (2) For Last action "add" queryMode is ignored
	 */
	@Transient
	private ReadValue readValue = ReadValue.MODIFIED;

	/**
	 * Setting updateMode to Direct (1) ignores the maker/checker and changes
	 * are directly made to the fields. Setting updateMode to Authorize (2) will
	 * not change the fields (and hold changes in changeInfo) till the record is
	 * authorized.
	 */
	@Transient
	private Modification modification = Modification.PENDINGAUTHORIZATION;

	@Transient
	private BOPropertyChangeManager propertyChangeManager = new BOPropertyChangeManager(this);

//	private BOPropertyChangeManager propertyChangeManager = createBOPropertyChangeManager();
//	ApplicationContext.getInstance().getProperty("BOPropertyChangeManager") new BOPropertyChangeManager(
//	this);

	@Transient
	private String makerName;
	
	@Transient
	private String checkerName;
	
	@Transient
	private String makerChannel;
	
	@Transient
	private String checkerChannel;
	// Upload
	
	/**
	 * TODO: to check how to handle in childs, thats why made it as a transient for time being
	 */
	@Transient
	private Long uploadBatchId;
	
	@Transient
	private String entityIdentifier;
	
	@Transient
	private String authorizationLevel;
	
	@Transient
	private String trnType = null; // added by rohit
	
	@Transient
	private String requestByTemp;
	
	@Transient
	private String moduleTypeTemp; 
	
	@Transient
	List<AuthorizationMatrixBO> authorizationMatrixBOs;
	
	@Transient
	private Map<String, String> authorizationRulesTemp;
	
	@Transient
	public boolean isOriginalVal = false;
	
	@Transient
	public boolean isModifyDirectVal = false;
	
	@Transient
	public boolean callMakerCheckerStrategy = true;
	
	@Transient
	private String cancelReason;
	
	@Transient
	private Long noVerifiedBy;
	
	@Transient
	private Long noVerifierRequired;
	
	@Transient
	private String verifyAuthLevel;
	
	@Transient
	private boolean verified =true;

	public MakerCheckerBO() {
		super();
	}

	/*private BOPropertyChangeManager createBOPropertyChangeManager() {
		String BOPropertyChangeManagerClassName = ApplicationContext.getInstance().getProperty("BOPropertyChangeManager");
		if(BOPropertyChangeManagerClassName != null && BOPropertyChangeManagerClassName.length() > 0){
			try {
				Class clazz = Class.forName(BOPropertyChangeManagerClassName);
				Constructor constructor = clazz.getConstructor(MakerCheckerBO.class);
				return (BOPropertyChangeManager) constructor.newInstance(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new BOPropertyChangeManager(this);
	}*/
	
	public boolean isOrginalValue() {
		if(!isOriginalVal)
			if(ReadValue.ORIGINAL == getReadValue())
				return true;
		
		return isOriginalVal;
	}
	
	public boolean isSetDirectValue() {
		return isModifyDirectVal;
	}
	

	public Long getUploadBatchId() {
		return uploadBatchId;
	}

	public void setUploadBatchId(Long uploadBatchId) {
		this.uploadBatchId = uploadBatchId;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public String getChangeInfo() {
		return changeInfo;
	}

	public void setChangeInfo(String changeInfo) {
		this.changeInfo = changeInfo;
	}

	public String getCheckedBy() {
		return (String)getPropertyObject("checkedBy",checkedBy);
	}

	public void setCheckedBy(String checkedBy) {
		if(isSetDirectValue()) // if condition added by rohit
			this.checkedBy = checkedBy;
		else
			setProperty("checkedBy",checkedBy);
	}

	public Date getCheckedOn() {
		return (Date)getPropertyObject("checkedOn",checkedOn);
	}

	public void setCheckedOn(Date checkedOn) {
		if(isSetDirectValue()) // if condition added by rohit
			this.checkedOn = checkedOn;
		else
			setProperty("checkedOn",checkedOn);
	}

	public Date getCheckedSysOn() {
		return checkedSysOn;
	}

	public void setCheckedSysOn(Date checkedSysOn) {
		this.checkedSysOn = checkedSysOn;
	}

	public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}

	public Long getModifiedAtOUId() {
		return modifiedAtOUId;
	}

	public void setModifiedAtOUId(Long modifiedAtOUId) {
		this.modifiedAtOUId = modifiedAtOUId;
	}
	

	public String getModifiedBy() {
//		return modifiedBy;
		return (String)getPropertyObject("modifiedBy",modifiedBy);
	}

	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
		if(isSetDirectValue()) // if condition added by rohit
			this.modifiedBy = modifiedBy;
		else
			setProperty("modifiedBy",modifiedBy); 
	}

	public Date getModifiedOn() {
//		return modifiedOn;
		return (Date)getPropertyObject("modifiedOn",modifiedOn);
	}

	public void setModifiedOn(Date modifiedOn) {
//		this.modifiedOn = modifiedOn;
		if(isSetDirectValue())// if condition added by rohit
			this.modifiedOn = modifiedOn;
		else
			setProperty("modifiedOn",modifiedOn);
	}

	public Date getModifiedSysOn() {
		return modifiedSysOn;

	}

	public void setModifiedSysOn(Date modifiedSysOn) {
		this.modifiedSysOn = modifiedSysOn;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public ReadValue getReadValue() {
		return readValue;
	}

	public void setReadValue(ReadValue readValue) {
		this.readValue = readValue;
	}

	public Modification getModification() {
		return modification;
	}

	public void setModification(Modification modification) {
		this.modification = modification; // variable name change by rohit
	}

	public String getCheckerName() {
		return FieldNameUtil.getLoginFullName(getCheckedBy(), getModifiedAtOUId());
	}

	public String getMakerName() {
		return FieldNameUtil.getLoginFullName(getModifiedBy(), getModifiedAtOUId());
	}

	public void applyChanges() {
		// Copy from xml to fields
		propertyChangeManager.applyChanges();

		setChangeInfo(null);
	}

	public void cancelChanges() {
		setChangeInfo(null);
	}

	protected String getProperty(final String propertyName) {
		try {
			return propertyChangeManager.getProperty(propertyName);
		} catch (Exception e) {
			/*syslog.error(null, null, "Could Not Get [" + propertyName
					+ "] Property" + e.getMessage());*/
		}
		return null;
	}

	protected Object getPropertyObject(final String propertyName) {
		try {
			return propertyChangeManager.getPropertyObject(propertyName);
		} catch (Exception e) {
			/*syslog.error(null, null, "Could Not Get [" + propertyName
					+ "] Property" + e.getMessage());*/
		}
		return null;
	}
	
	protected Object getPropertyObject(final String propertyName, Object propertyValue) {
		try {
			if(isOrginalValue())
				return propertyValue;
			else if(this.getChangeInfo() == null) {
				return propertyValue;
			}else
				return getPropertyObject(propertyName);
			
		} catch (Exception e) {
			/*syslog.error(null, null, "Could Not Get [" + propertyName
					+ "] Property" + e.getMessage());*/
		}
		return null;
	}

	protected void setProperty(final String propertyName, final String value) {

		try {
			propertyChangeManager.setProperty(propertyName, value);
		} catch (Exception e) {
//			System.out.println("1:"+e.getMessage());
//			syslog.error(null, null, "Could Not Set [" + propertyName
//					+ "] Property");
		}
	}

	protected void setProperty(final String propertyName, final Object value) {

		String propertyValue = null;
		if(value != null) {

			propertyValue = value.toString();

			if(value instanceof Enum ) {
				propertyValue = ((Enum) value).name();
			}
			else if(value instanceof Date){
				if("modifiedOn".equalsIgnoreCase(propertyName) || "checkedOn".equalsIgnoreCase(propertyName))
					propertyValue = DateUtils.toDateWithTime((Date)value);
				else
					propertyValue = DateUtils.toString((Date)value);
			}
		}

		try {
			propertyChangeManager.setProperty(propertyName, propertyValue);
		} catch (Exception e) {
			System.out.println("1:"+e.getMessage());
//			syslog.error(null, null, "Could Not Set [" + propertyName
//					+ "] Property");
		}
	}
	
	
	/**
	 * TODO: Pravin 
	 */

/*	public MakerCheckerAbstractFactory getMakerCheckerFactory(UserDetails details, BaseBO baseBO, 
																CommandOperation operation, List<String> idsListForMatrix) throws BaseException {
		return MakerCheckerStrategyCreator.getInstance().getMakerCheckerFactory(details, baseBO,operation, idsListForMatrix);
	}*/

	
	/*public ActivityLogRecord getAudit() {
		return activityLogRecord;
	}*/

	public String getEntityIdentifier() {
		return entityIdentifier;
	}
	
	public void setEntityIdentifier(String entityIdentifier) {
		this.entityIdentifier = entityIdentifier;
	}
	
	public String getAuthorizationLevel() {
		return authorizationLevel;
	}

	public void setAuthorizationLevel(String authorizationLevel) {
		this.authorizationLevel = authorizationLevel;
	}

	public String getRequestByTemp() {
		return requestByTemp;
	}

	public void setRequestByTemp(String requestByTemp) {
		this.requestByTemp = requestByTemp;
	}
	
	public Map<String, String> getAuthorizationRulesTemp() {
		return authorizationRulesTemp;
	}

	public void setAuthorizationRulesTemp(Map<String, String> authorizationRulesTemp) {
		this.authorizationRulesTemp = authorizationRulesTemp;
	}

	public String getModuleTypeTemp() {
		return moduleTypeTemp;
	}

	public void setModuleTypeTemp(String moduleTypeTemp) {
		this.moduleTypeTemp = moduleTypeTemp;
	}

	/**
	 * This method provides the Amount imformation when a transaction is being authorized, this is useful in case of multi level maker checker.
	 * It is the responsibility of the derived class TransactionBO/RequestBO to provide the implementation
	 * @return
	 * @throws BaseException 
	 */
	public Double getAmountForAuthorization() throws BaseException{
		/**
		 * TODO:Pravin
		 */
		throw new BaseException("Please provide implementation in derived class for Transaction Amount");
	}
	
	public String getAmountForBatchAuthorization() throws BaseException{
		throw new BaseException("Please provide implementation in derived class for Transaction Amount");
	}

	public List<AuthorizationMatrixBO> getAuthorizationMatrixBOs() {
		return authorizationMatrixBOs;
	}

	public void setAuthorizationMatrixBOs(
			List<AuthorizationMatrixBO> authorizationMatrixBOs) {
		this.authorizationMatrixBOs = authorizationMatrixBOs;
	}
	
	// below new methods added by rohit
	public boolean isCallMakerCheckerStrategy() {
		return callMakerCheckerStrategy;
	}

	public void setCallMakerCheckerStrategy(boolean callMakerCheckerStrategy) {
		this.callMakerCheckerStrategy = callMakerCheckerStrategy;
	}
	
	public String getTrnType() {
		return trnType;
	}

	public void setTrnType(String trnType) {
		this.trnType = trnType;
	}

	
	protected String getProperty(final String propertyName,final String value) {
		try {
			if(this.isOriginalVal){
				return value;
			}else{
				return propertyChangeManager.getProperty(propertyName);
			}
		} catch (Exception e) {
//			syslog.error(null, null, "Could Not Get [" + propertyName
//					+ "] Property" + e.getMessage());
		}
		return null;
	}

	
		public String getMakerChannel() {
		
		if(null!= makerChannel){
			if(Source.H2HAPI.name().equalsIgnoreCase(makerChannel)||
					Source.H2HUTILITY.name().equalsIgnoreCase(makerChannel)){
				return Source.H2H.name();
			}
		}
		return makerChannel;
	}

	public void setMakerChannel(String makerChannel) {
		this.makerChannel = makerChannel;
	}

	public String getCheckerChannel() {
		return checkerChannel;
	}

	public void setCheckerChannel(String checkerChannel) {
		this.checkerChannel = checkerChannel;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Long getNoVerifiedBy() {
		return noVerifiedBy;
	}

	public void setNoVerifiedBy(Long noVerifiedBy) {
		this.noVerifiedBy = noVerifiedBy;
	}

	public Long getNoVerifierRequired() {
		return noVerifierRequired;
	}

	public void setNoVerifierRequired(Long noVerifierRequired) {
		this.noVerifierRequired = noVerifierRequired;
	}

	public String getVerifyAuthLevel() {
		return verifyAuthLevel;
	}

	public void setVerifyAuthLevel(String verifyAuthLevel) {
		this.verifyAuthLevel = verifyAuthLevel;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	
	
}
