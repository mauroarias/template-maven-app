package org.mauro.repository.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyDto implements Serializable {

    private String name;
    private Integer age;
    private String address;
    private String real;
}