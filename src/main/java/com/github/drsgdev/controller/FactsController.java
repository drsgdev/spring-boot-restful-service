package com.github.drsgdev.controller;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Facts;
import com.github.drsgdev.repository.FactsRepository.BookOnly;
import com.github.drsgdev.repository.FactsRepository.CustAndBook;
import com.github.drsgdev.repository.FactsRepository.CustAndShop;
import com.github.drsgdev.repository.FactsRepository.ShopNameOnly;
import com.github.drsgdev.repository.FactsRepository.CustAndDate;
import com.github.drsgdev.repository.FactsRepository.CustAndDistrict;
import com.github.drsgdev.service.FactsService;
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
@RequestMapping("/facts")
public class FactsController {

  @Autowired
  private FactsService factsService;

  @GetMapping("/all")
  public ResponseEntity<List<Facts>> findAll() {
    return ResponseEntity.ok(factsService.findAll());
  }

  @GetMapping("/find")
  public ResponseEntity<Facts> findById(@RequestParam int id) {
    Optional<Facts> Facts = factsService.findById(id);

    return ResponseService.res(Facts);
  }

  @PostMapping("/add")
  public ResponseEntity<String> addFacts(@RequestBody Facts Facts) {
    factsService.save(Facts);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/add/list")
  public ResponseEntity<String> addAllFacts(@RequestBody List<Facts> factsList) {
    factsService.saveAll(factsList);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Facts> deleteById(@RequestParam int id) {
    Optional<Facts> deletedFacts = factsService.deleteById(id);

    return ResponseService.res(deletedFacts);
  }

  @DeleteMapping("/delete/json")
  public ResponseEntity<Facts> delete(@RequestBody Facts Facts) {
    Optional<Facts> deletedFacts = factsService.delete(Facts);

    return ResponseService.res(deletedFacts);
  }

  @PutMapping("/replace")
  public ResponseEntity<Facts> replaceFacts(@RequestParam int id, @RequestBody Facts Facts) {
    Optional<Facts> replacedFacts = factsService.replace(id, Facts);

    return ResponseService.res(replacedFacts);
  }

  @PatchMapping("/modify")
  public ResponseEntity<Facts> modifyFacts(@RequestParam int id, @RequestBody Facts Facts) {
    return replaceFacts(id, Facts);
  }

  @GetMapping("/find/month")
  public ResponseEntity<List<String>> findMonth() {
    List<String> res = factsService.findFactsMonth();

    return ResponseService.res(res);
  }

  @GetMapping("/find/cust/shop")
  public ResponseEntity<List<CustAndShop>> findCustAndShop() {
    List<CustAndShop> res = factsService.findCustAndShop();

    return ResponseService.res(res);
  }

  @GetMapping("/find/cust/book")
  public ResponseEntity<List<CustAndBook>> findCustAndBook() {
    List<CustAndBook> res = factsService.findCustAndBook();

    return ResponseService.res(res);
  }

  @GetMapping("/find/cust")
  public ResponseEntity<List<CustAndDate>> findCustOnly(@RequestParam("cost") int cost) {
    List<CustAndDate> res = factsService.findCustOnly(cost);

    return ResponseService.res(res);
  }

  @GetMapping("/find/cust/district")
  public ResponseEntity<List<CustAndDistrict>> findCustAndDistrict(@RequestParam("month") int month) {
    List<CustAndDistrict> res = factsService.findCustAndDistrict(month);

    return ResponseService.res(res);
  }

  @GetMapping("/find/shop")
  public ResponseEntity<List<ShopNameOnly>> findCustAndDistrict(@RequestParam("low") int lo,
      @RequestParam("high") int hi, @RequestParam("district") String district) {

    List<ShopNameOnly> res = factsService.findShop(lo, hi, district);

    return ResponseService.res(res);
  }

  @GetMapping("/find/book")
  public ResponseEntity<List<BookOnly>> findBook(@RequestParam("amnt") int amnt) {

    List<BookOnly> res = factsService.findBook(amnt);

    return ResponseService.res(res);
  }
}
