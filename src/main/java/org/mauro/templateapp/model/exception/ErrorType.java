package org.mauro.templateapp.model.exception;

import lombok.Getter;

@Getter
public enum ErrorType {
	UNKNOWN_ERROR(0),
	BAD_ARGUMENTS(1);

	final int errorNumber;

	ErrorType(final int errorNumber) {
		this.errorNumber = errorNumber;
	}
}