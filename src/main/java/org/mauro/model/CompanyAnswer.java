package org.mauro.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class CompanyAnswer {
    private UUID id;
    private String name;
    private String address;
    private ZonedDateTime created;
    private Set<User> users;

    @Data
    public static class User {
        private String name;
        private Integer age;
        private String address;
        private ZonedDateTime created;
        private ZonedDateTime modified;
        private Boolean status;
    }
}
