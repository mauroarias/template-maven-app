package org.mauro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.ZonedDateTime;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
public class User {
    private String name;
    private int age;
    private String address;
    @JsonProperty(access = READ_ONLY)
    private ZonedDateTime created;
    @JsonProperty(access = READ_ONLY)
    private ZonedDateTime modified;
    @JsonProperty(access = READ_ONLY)
    private Boolean status;
}

