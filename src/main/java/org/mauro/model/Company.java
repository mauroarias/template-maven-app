package org.mauro.model;

import lombok.Data;

import java.util.Set;

@Data
public class Company {
    private String name;
    private String address;
    private Set<User> users;
}
