package com.aurionpro.generic.encryption;


public class RemoteException extends Exception {/**
	 * 
	 */
	private static final long serialVersionUID = 2683292716407933082L;

//BaseException {
	/**
	 * 
	 */

	public RemoteException() {
		super();
	}

	public RemoteException(String arg0) {
		super(arg0);
	}

	public RemoteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RemoteException(Throwable arg0) {
		super(arg0.getMessage(), arg0);
		System.out.println("Calledddddddddd" + arg0);
	}

}
