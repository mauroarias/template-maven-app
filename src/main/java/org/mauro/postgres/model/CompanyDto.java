package org.mauro.postgres.model;

import lombok.Data;
import org.mauro.postgres.jsonbType.Jsonb;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Jsonb(table = "company")
public class CompanyDto implements Serializable {

    private String name;
    private String address;
    private ZonedDateTime created;
    private Set<UserDto> users;
}
