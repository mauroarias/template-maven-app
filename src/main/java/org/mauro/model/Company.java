package org.mauro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
public class Company {
    @JsonProperty(access = READ_ONLY)
    private UUID id;
    @JsonProperty(access = READ_ONLY)
    private ZonedDateTime created;
    private String name;
    private String address;
    private Set<User> users;
}


