package org.mauro.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "CompanyJsonbType", typeClass = CompanyJsonbType.class)
@Data
public class CompanyDao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "data")
    @Type(type = "CompanyJsonbType")
    private CompanyDto company;
}