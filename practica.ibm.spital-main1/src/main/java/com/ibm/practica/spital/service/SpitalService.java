package com.ibm.practica.spital.service;

import com.ibm.practica.spital.DTO.*;
import com.ibm.practica.spital.entity.HospitalService;
import com.ibm.practica.spital.entity.Pacient;
import com.ibm.practica.spital.repository.PacientRepository;
import com.ibm.practica.spital.repository.PriceRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SpitalService {

 @Autowired
 PacientRepository pacientRepository;
 @Autowired
 PriceRepository priceRepository;
 ModelMapper mapper = new ModelMapper();

 public List<PacientDTO> getAllPacients() {
  log.info("SpitalService.getAllPacients() retrieving all pacients...");


  return pacientRepository.findAll().stream()
          .map(pacient -> mapper.map(pacient, PacientDTO.class)).collect(Collectors.toList());
 }

 public List<Reservation> getReservations() {
  log.info("SpitalService.getReservations() retrieving all reservations...");
  Reservation p = new Reservation();
  p.setId("12");
  p.setPacientID("12313");
  Reservation p1 = new Reservation();
  p1.setPacientID("12314");
  p1.setId("123");
  return List.of(p, p1);
 }

 public Reservation getReservation() {
  log.info("SpitalService.getReservation() retrieving all reservations...");
  Reservation p = new Reservation();
  p.setId("12");
  p.setPacientID("12313");
  return p;
 }

 public List<Reservation> getReservationForPacient(String pacientID) {
  log.info("SpitalService.getReservations() retrieving all reservations...");
  Reservation p = new Reservation();
  p.setId("12");
  p.setPacientID("12313");
  Reservation p1 = new Reservation();
  p1.setPacientID("12314");
  p1.setId("123");
  List<Reservation> list = new ArrayList<>();
  list.add(p);
  list.add(p1);

  return list.stream().filter(r -> r.getPacientID().equals(pacientID)).collect(Collectors.toList());
 }

 public boolean addReservation(AddReservation reservation) {
  return true;
 }

 public boolean deleteReservation(String reservationID) {
  return false;
 }

 public boolean addPrice(AddPriceDTO addPriceDTO){
  HospitalService price = mapper.map(addPriceDTO, HospitalService.class);
  String id = UUID.randomUUID().toString();
  price.setServiceID(id.replace(id, price.getServiceID()));
  HospitalService q = priceRepository.save(price);
  return ObjectUtils.isNotEmpty(q);
 }
 public boolean addPacient(AddPacientDTO pacientDTO) {
  Pacient pacient = mapper.map(pacientDTO, Pacient.class);
  String id = UUID.randomUUID().toString();
  log.info("id is: " + id);
  pacient.setPacientID(id.replace(id, pacient.getPacientID()));
  Pacient p = pacientRepository.save(pacient);
  log.info("saved pacient id is: " + p.getPacientID());
  return ObjectUtils.isNotEmpty(p);
 }


 public boolean deletePacient(String pacientID) {
  return false;
 }

 public boolean editPacient(PacientDTO pacientDTO) {
  return true;
 }

 public List<HospitalServiceDTO> getAllPrices() {
  HospitalService p = new HospitalService();
  p.setServiceID("1");
  p.setServiceName("administrare medicamente");
  p.setPrice(500);

  HospitalService p1 = new HospitalService();
  p1.setServiceID("2");
  p1.setServiceName("operatie cataracta");
  p1.setPrice(3000);

  p = priceRepository.save(p);
  p1 = priceRepository.save(p1);
  return priceRepository.findAll().stream()
          .map(price -> mapper.map(price, HospitalServiceDTO.class))
          .collect(Collectors.toList());
 }


 }
