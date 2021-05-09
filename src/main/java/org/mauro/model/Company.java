package org.mauro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class Company {
    @JsonIgnoreProperties(allowGetters = true)
    private Integer id;
    private String name;
    private int age;
    private String address;
    private String real;
}
