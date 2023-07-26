package com.ibm.practica.spital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="price")
public class HospitalService {

    @Id
    @NotNull
    @Column(name="service_id")
    private String serviceID;

    @NotNull
    @Column(name="service_name")
    private String serviceName;

    @NotNull
    @Column(name="price")
    private int price;
}
