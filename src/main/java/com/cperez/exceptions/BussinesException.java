package com.cperez.exceptions;

public class BussinesException extends Exception {

	private static final long serialVersionUID = 1L;

	public BussinesException() {
	}

	public BussinesException(String message) {
		super(message);
	}

	public BussinesException(String message, Throwable cause) {
		super(message, cause);
	}

	public BussinesException(Throwable cause) {
		super(cause);
	}

	public BussinesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
