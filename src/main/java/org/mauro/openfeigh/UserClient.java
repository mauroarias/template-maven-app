package org.mauro.openfeigh;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class UserClient {
    String name;
    int age;
    String address;
    String companyName;
    String CompanyAddress;
    UUID companyId;
}