package org.mauro.postgres.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.mauro.postgres.jsonbType.JsonbType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

import static org.mauro.postgres.jsonbType.JsonbType.TYPE;

@Entity
@Table(name = "COMPANY")
@TypeDef(name = "JsonbType", typeClass = JsonbType.class)
@Data
public class CompanyDao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "data")
    @Type(type = "JsonbType", parameters = @Parameter(name = TYPE, value = "org.mauro.postgres.model.CompanyDto"))
    private CompanyDto company;
}