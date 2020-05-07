package com.github.drsgdev.controller;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Cust;
import com.github.drsgdev.repository.CustRepository.District;
import com.github.drsgdev.repository.CustRepository.NameAndDiscount;
import com.github.drsgdev.service.CustService;
import com.github.drsgdev.util.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustController {

  @Autowired
  private CustService custService;

  @GetMapping("/all")
  public ResponseEntity<List<Cust>> findAll() {
    return ResponseEntity.ok(custService.findAll());
  }

  @GetMapping("/find")
  public ResponseEntity<Cust> findById(@RequestParam int id) {
    Optional<Cust> Cust = custService.findById(id);

    return ResponseService.res(Cust);
  }

  @PostMapping("/add")
  public ResponseEntity<String> addCust(@RequestBody Cust Cust) {
    custService.save(Cust);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/add/list")
  public ResponseEntity<String> addAllCusts(@RequestBody List<Cust> custList) {
    custService.saveAll(custList);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Cust> deleteById(@RequestParam int id) {
    Optional<Cust> deletedCust = custService.deleteById(id);

    return ResponseService.res(deletedCust);
  }

  @DeleteMapping("/delete/json")
  public ResponseEntity<Cust> delete(@RequestBody Cust Cust) {
    Optional<Cust> deletedCust = custService.delete(Cust);

    return ResponseService.res(deletedCust);
  }

  @PutMapping("/replace")
  public ResponseEntity<Cust> replaceCust(@RequestParam int id, @RequestBody Cust Cust) {
    Optional<Cust> replacedCust = custService.replace(id, Cust);

    return ResponseService.res(replacedCust);
  }

  @PatchMapping("/modify")
  public ResponseEntity<Cust> modifyCust(@RequestParam int id, @RequestBody Cust Cust) {
    return replaceCust(id, Cust);
  }

  @GetMapping("/find/districts")
  public ResponseEntity<List<District>> getDistricts() {
    List<District> res = custService.findDistricts();

    return ResponseService.res(res);
  }

  @GetMapping("/find/name/discount")
  public ResponseEntity<List<NameAndDiscount>> getNameAndDisc(@RequestParam String district) {
    List<NameAndDiscount> res = custService.findInfoByDistrict(district);

    return ResponseService.res(res);
  }
}
