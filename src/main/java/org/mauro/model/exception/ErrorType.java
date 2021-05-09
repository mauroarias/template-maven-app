package org.mauro.model.exception;

import lombok.Getter;

@Getter
public enum ErrorType {
	UNKNOWN_ERROR(0),
	BAD_ARGUMENTS(1),
	NOT_FOUND(2);

	final int errorNumber;

	ErrorType(final int errorNumber) {
		this.errorNumber = errorNumber;
	}
}