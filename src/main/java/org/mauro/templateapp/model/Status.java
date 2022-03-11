package org.mauro.templateapp.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public final class Status {
	private final String value;
}
