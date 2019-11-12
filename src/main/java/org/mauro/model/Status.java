package org.mauro.model;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;

import java.time.ZonedDateTime;
import java.util.List;

@Value
@Builder
public final class Status {
	private final String value;
}
