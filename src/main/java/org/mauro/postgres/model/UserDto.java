package org.mauro.postgres.model;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class UserDto implements Serializable {

    private String name;
    private Integer age;
    private String address;
    private ZonedDateTime created;
    private ZonedDateTime modified;
    private Boolean status;
}
