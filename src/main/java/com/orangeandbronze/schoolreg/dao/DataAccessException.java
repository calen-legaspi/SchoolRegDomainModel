package com.orangeandbronze.schoolreg.dao;

public class DataAccessException extends RuntimeException {

	DataAccessException(String message) {
		super(message);
	}

	DataAccessException(Throwable cause) {
		super(cause);
	}

	DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	DataAccessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
