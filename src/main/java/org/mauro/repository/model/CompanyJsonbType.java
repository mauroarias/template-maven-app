package org.mauro.repository.model;

public class CompanyJsonbType extends AbstractJsonbType {

    @Override
    public Class<CompanyDto> returnedClass() {
        return CompanyDto.class;
    }
}
