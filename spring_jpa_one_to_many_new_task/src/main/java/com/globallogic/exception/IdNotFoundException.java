package com.globallogic.exception;

public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public IdNotFoundException() {
		super();
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
