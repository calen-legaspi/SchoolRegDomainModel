package com.orangeandbronze.schoolreg.domain;

public class MissingPrerequisitesException extends RuntimeException {


	MissingPrerequisitesException(String message) {
		super(message);
	}

	MissingPrerequisitesException(Throwable cause) {
		super(cause);
	}

	MissingPrerequisitesException(String message, Throwable cause) {
		super(message, cause);
	}

	MissingPrerequisitesException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
