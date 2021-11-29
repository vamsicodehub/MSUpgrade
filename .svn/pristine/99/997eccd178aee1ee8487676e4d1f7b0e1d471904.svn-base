/*
 * 
 */
package com.aurionpro.beneficiary.assembler;

import com.aurionpro.beneficiary.encryption.RemoteException;
import com.aurionpro.beneficiary.exceptions.BaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Assembler.
 *
 * @param <TDTO> the generic type
 * @param <TDETAIL> the generic type
 */
public interface Assembler<TBO, TDETAIL> {

     /**
      * Assemble dto.
      *
      * @param dto the dto
      * @param details the details
      * @param ticket the ticket
      * @throws BaseException the base exception
      * @throws RemoteException the remote exception
      */
     TBO assemble(TBO tbo, TDETAIL details) throws BaseException,RemoteException;

     /**
      * Assemble details.
      *
      * @param dto the dto
      * @param details the details
      * @param ticket the ticket
      * @throws BaseException the base exception
      * @throws RemoteException the remote exception
      */
     void assembleDetails(TBO tbo, TDETAIL details) throws BaseException,RemoteException;
}
