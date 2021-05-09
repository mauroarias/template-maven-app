package org.mauro.repository.model;

import lombok.Data;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static org.mauro.repository.model.JsonbType.TYPE;

@Entity
@Table(name = "COMPANY")
@TypeDef(name = "JsonbType", typeClass = JsonbType.class)
@Data
public class CompanyDao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "data")
    @Type(type = "JsonbType", parameters = @Parameter(name = TYPE, value = "org.mauro.repository.model.CompanyDto"))
    private CompanyDto company;
}