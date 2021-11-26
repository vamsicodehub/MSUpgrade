/*
 * 
 */
package com.aurionpro.generic.assembler;

import com.aurionpro.cashpro.commons.security.Ticket;
import com.aurionpro.generic.baserequest.BaseDetails;
import com.aurionpro.generic.basevalueobject.BaseBO;
import com.aurionpro.generic.encryption.EncryptUtils;
import com.aurionpro.generic.encryption.RemoteException;
import com.aurionpro.generic.exceptions.BaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseDetailsAssembler.
 */
public class BaseDetailsAssembler implements Assembler<BaseBO, BaseDetails> {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.aurionpro.cashpro.commons.rest.assembler.Assembler#assembleDTO(java
     * .lang.Object, java.lang.Object)
     */
    @Override
    public BaseBO assemble(Ticket ticket,BaseBO bo, BaseDetails details)
	    throws BaseException, RemoteException {		
    	
	   /* 	if (!"".equals(details.getId()) && details.getId() != null) {
	    		bo.setId(EncryptUtils.decryptId(details.getId()));
			} else {
				bo.setId(0L);
			}*/
			if (details.getVersion() != null) {
				bo.setVersion(details.getVersion());
			} else {
				bo.setVersion(0);
		}
			return bo;
 		}

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.aurionpro.cashpro.commons.rest.assembler.Assembler#assembleDetails
     * (java.lang.Object, java.lang.Object)
     */
    @Override
    public void assembleDetails(BaseBO bo, BaseDetails details)
	    throws BaseException, RemoteException {
	//details.setId(EncryptUtils.encryptId(bo.getId()));
	details.setVersion(bo.getVersion());

    }

}
