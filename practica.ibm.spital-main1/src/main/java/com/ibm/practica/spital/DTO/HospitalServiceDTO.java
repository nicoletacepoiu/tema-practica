package com.ibm.practica.spital.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HospitalServiceDTO {
    private String serviceID;
    private String serviceName;
    private int price; }