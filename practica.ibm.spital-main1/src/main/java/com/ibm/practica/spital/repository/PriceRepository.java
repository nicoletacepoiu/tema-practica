package com.ibm.practica.spital.repository;

import com.ibm.practica.spital.entity.HospitalService;
import com.ibm.practica.spital.entity.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

public interface PriceRepository extends JpaRepository<HospitalService,String> {
}
