package com.aurionpro.generic.basevalueobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;

import com.aurionpro.cashpro.commons.security.Ticket;
import com.aurionpro.generic.basevalueobject.MakerCheckerBO.Modification;
import com.aurionpro.generic.constants.Constants;
import com.aurionpro.generic.encryption.EncryptUtils;
import com.aurionpro.generic.enums.UserType;
import com.aurionpro.generic.exceptions.AuthorizeException;
import com.aurionpro.generic.utils.DateUtils;

@MappedSuperclass
public abstract class MasterBO extends MakerCheckerBO {
	
	@Column(name="ENABLED")
	@Type(type="yes_no")
	private Boolean enabled = true;

	@Column(name="ACTIVE")
	@Type(type="yes_no")
	private Boolean active = true;


	@Column(name="EFFECTIVEFROM")
	protected Date effectiveFrom;

	@Column(name="EFFECTIVETILL")
	protected Date effectiveTill;

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getEffectiveFrom() {
		return (Date)getPropertyObject("effectiveFrom",effectiveFrom);
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		if(isSetDirectValue())
			this.effectiveFrom = effectiveFrom;
		else
			setProperty("effectiveFrom", effectiveFrom);
	}

	public Date getEffectiveTill() {
		return (Date)getPropertyObject("effectiveTill", effectiveTill);
	}

	public void setEffectiveTill(Date effectiveTill) {
		if(isSetDirectValue())
			this.effectiveTill = effectiveTill;
		else
			setProperty("effectiveTill", effectiveTill);
	}

	public Boolean getEnabled() {
		return (Boolean)getPropertyObject("enabled", enabled);
	}

	public void setEnabled(Boolean enabled) {
		if(isSetDirectValue())
			this.enabled = enabled;
		else
			setProperty("enabled", enabled);
	}

	public MasterBO() {
		super();
	}
	
	
	
	
	/**
	 * TODO : Pravin need to check on this
	 */
	public void setUpdateMethodProperties(Ticket ticket) 
	{
		boolean selfAuthorization=isMasterSelfAuthorizer(ticket);
		if(!selfAuthorization)
		{
			this.setAuthorized(false);
			if(this.getLastAction()!=null && (this.getLastAction().equals("create") || this.getLastAction().equals("create Rejected")))
				this.setLastAction("create");
			else
				this.setLastAction("update");
		}
		else
		{
			this.setAuthorized(true);
			if(this.getLastAction()!=null && (this.getLastAction().equals("create") || this.getLastAction().equals("create Rejected")))
				this.setLastAction("create Authorized");
			else
				this.setLastAction("update Authorized");
		}
		
		this.setRejectReason(null);
		this.setModifiedBy(ticket.getLoginId());
		this.setModifiedAtOUId(EncryptUtils.decryptId(ticket.getCurrentOUId()));
		
		/**
		 * TODO:Pravin This need to be checked
		 */
		/*if(null == beneBO.getMakerChannel()){
			beneBO.setMakerChannel(maker.getChannel());
		}*/
		
		this.setModifiedOn(DateUtils.applicationDateWithServerTime(DateUtils.now())); /*--> no need to set modified On as it is preset as a part of maker checker fields from UI*/
		this.setModifiedSysOn(DateUtils.now());
	}
	

	/**
	 * TODO : Pravin need to check on this
	 */
	public void setEnableDisableMethodProperties(Ticket ticket,boolean enable) 
	{	
		boolean selfAuthorization=isMasterSelfAuthorizer(ticket);
		this.setEnabled(enable);
		this.setModifiedBy(ticket.getLoginId());
		this.setModifiedAtOUId(EncryptUtils.decryptId(ticket.getCurrentOUId()));
		this.setModification(Modification.DIRECT);
		if(enable && !selfAuthorization)
		{
			this.setLastAction("enable");
			this.setAuthorized(false);
		}
		else if(!enable && !selfAuthorization)
		{
			this.setLastAction("disable");
			this.setAuthorized(false);
		}
		else if(enable && selfAuthorization)
		{
			this.setLastAction("enable Authorized");
			this.setAuthorized(true);
		}
		else if(!enable && selfAuthorization)
		{
			this.setLastAction("disable Authorized");
			this.setAuthorized(true);
		}
	}
	
	
	public void setCreateMethodProperties(Ticket ticket) 
	{	
	boolean selfAuthorization=isMasterSelfAuthorizer(ticket);	
	if(selfAuthorization)
	{
		this.setModifiedBy(ticket.getLoginId());
		this.setModifiedSysOn(DateUtils.now());
		this.setModifiedAtOUId(EncryptUtils.decryptId(ticket.getCurrentOUId()));
		this.setLastAction("create Authorized");
		this.setAuthorized(true);
		
		/**
		 * TODO: Pravin check how to set below data need to take it from either cache/ticket
		 */
		this.setModifiedOn(DateUtils.applicationDateWithServerTime(DateUtils.now()));
		this.setCheckedBy(ticket.getLoginId());
		this.setCheckedOn(DateUtils.applicationDateWithServerTime(DateUtils.now()));
		this.setCheckedSysOn(DateUtils.applicationDateWithServerTime(DateUtils.now()));
		/**
		 * TODO:Pravin Check commented
		 */
		/*
		 * makerCheckerBO.setCheckerName(makerCheckerDetails.getCheckerName());
		 * this.setCallMakerCheckerStrategy(makerCheckerDetails.getCallMakerCheckerStrategy());
		this.setEntityIdentifier(makerCheckerDetails.getEntityIdentifier());*/
	}else
	{

		this.setLastAction("create");
		this.setModifiedBy(ticket.getLoginId());
		this.setModifiedSysOn(DateUtils.now());
		this.setModifiedAtOUId(EncryptUtils.decryptId(ticket.getCurrentOUId()));
		this.setAuthorized(false);
		this.setModifiedOn(DateUtils.applicationDateWithServerTime(DateUtils.now()));
		/**
		 * TODO:Pravin Check commented
		 */
		/*makerCheckerBO.setCheckerName(makerCheckerDetails.getCheckerName());
		this.setRejectReason(makerCheckerDetails.getRejectReason());
		this.setCallMakerCheckerStrategy(makerCheckerDetails.getCallMakerCheckerStrategy());
		this.setEntityIdentifier(makerCheckerDetails.getEntityIdentifier());
*/	
	}

	}
	
	
	public void setAuthorizeMethodProperties(Ticket ticket) throws AuthorizeException{
		
		/*this.setModification(Modification.DIRECT);
		this.setChangeInfo(null);
		*/
		if(this.isAuthorized())  
			throw new AuthorizeException("Record is already Authorized");
		
		this.setCheckedBy(ticket.getLoginId());
		this.setCheckedOn(DateUtils.applicationDateWithServerTime(DateUtils.now()));
		this.setCheckedSysOn(DateUtils.now());
		this.setCheckerChannel("web");
		
		/**
		 * TODO: Pravin to check
		 */
		/*Boolean checkLastActionForRejected = true;
		
		String lastAction = this.getLastAction();
		
		if("delete Rejected".equals(lastAction) || "enable Rejected".equals(lastAction) ||
				"disable Rejected".equals(lastAction) || "disable".equals(lastAction) ||
				"enable".equals(lastAction)) {
					checkLastActionForRejected = false;
		}*/
		
		boolean callProcess = !"T".equalsIgnoreCase(this.getAuthorizationLevel());
		this.setLastAction(this.getLastAction() + " Authorized");
		
		if(callProcess)
			this.applyChanges();
		
		this.setAuthorized(true);
	}
	
	
	public boolean isMasterSelfAuthorizer(Ticket ticket) 
	{
		/*if(UserType.CORPORATE.name().equals(ticket.getUserType()) && "S".equals(ticket.getEnrichment(Constants.USERAUTHTYPE))) {
			if( null != ticket.getEnrichment("MASTERSELFAUTH")  && 	ticket.getEnrichment("MASTERSELFAUTH").equalsIgnoreCase("Y"))
				return true;
		}*/
		return false;
	
	}

}
