package com.rest.bibliorest.exception;

public class DataConflicException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataConflicException(String mex) {
		super(mex);
	}
}
