package com.aurionpro.generic.exceptions;

// extended customise remote exception  by Sachin Gore 30 Dec 2013 
public class BaseException extends RemoteException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4280639685838168970L;

	public BaseException() {
		super();
	}

	public BaseException(String arg0) {
		super(arg0);
	}

	public BaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BaseException(Throwable arg0) {
		super(arg0.getMessage(), arg0);
	}

}
