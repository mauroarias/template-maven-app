package org.mauro.repository.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mauro.model.Company;

@Mapper
public interface CompanyMapper {
    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);

    CompanyDto toCompanyDto(Company company);

    Company fromCompanyDto(CompanyDto companyDto);
}
