package org.mauro.postgres.model;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.mauro.model.Company;
import org.mauro.model.User;

import java.time.ZonedDateTime;

import static java.lang.Boolean.TRUE;
import static java.time.ZoneOffset.UTC;

@Mapper
public interface CompanyMapper {
    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);

    CompanyDto toCompanyDto(Company company);

    UserDto toUserDto(User user);

    @Mapping(source = "company.name", target = "name")
    @Mapping(source = "company.address", target = "address")
    @Mapping(source = "company.created", target = "created")
    @Mapping(source = "company.users", target = "users")
    Company fromCompanyDto(CompanyDao companyDao);

    User fromUserDto(UserDto userDto);

    @AfterMapping
    default void addCreateDateCompany(@MappingTarget CompanyDto dto) {
        dto.setCreated(ZonedDateTime.now(UTC));
    }

    @AfterMapping
    default void addCreateDateUser(@MappingTarget UserDto dto) {
        final ZonedDateTime now = ZonedDateTime.now(UTC);
        dto.setCreated(now);
        dto.setModified(now);
        dto.setStatus(TRUE);
    }
}
