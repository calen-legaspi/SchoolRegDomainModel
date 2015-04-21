package com.orangeandbronze.schoolreg.domain;

public class EnlistmentConflictException extends RuntimeException {


	EnlistmentConflictException(String message) {
		super(message);
	}

	EnlistmentConflictException(Throwable cause) {
		super(cause);
	}

	EnlistmentConflictException(String message, Throwable cause) {
		super(message, cause);
	}

	EnlistmentConflictException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
