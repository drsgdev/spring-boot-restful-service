package com.github.drsgdev.controller;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Shop;
import com.github.drsgdev.repository.ShopRepository.Name;
import com.github.drsgdev.service.ShopService;
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
@RequestMapping("/shop")
public class ShopController {

  @Autowired
  private ShopService shopService;

  @GetMapping("/all")
  public ResponseEntity<List<Shop>> findAll() {
    return ResponseEntity.ok(shopService.findAll());
  }

  @GetMapping("/find")
  public ResponseEntity<Shop> findById(@RequestParam int id) {
    Optional<Shop> Shop = shopService.findById(id);

    return ResponseService.res(Shop);
  }

  @PostMapping("/add")
  public ResponseEntity<String> addShop(@RequestBody Shop Shop) {
    shopService.save(Shop);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/add/list")
  public ResponseEntity<String> addAllShops(@RequestBody List<Shop> shopList) {
    shopService.saveAll(shopList);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Shop> deleteById(@RequestParam int id) {
    Optional<Shop> deletedShop = shopService.deleteById(id);

    return ResponseService.res(deletedShop);
  }

  @DeleteMapping("/delete/json")
  public ResponseEntity<Shop> delete(@RequestBody Shop Shop) {
    Optional<Shop> deletedShop = shopService.delete(Shop);

    return ResponseService.res(deletedShop);
  }

  @PutMapping("/replace")
  public ResponseEntity<Shop> replaceShop(@RequestParam int id, @RequestBody Shop Shop) {
    Optional<Shop> replacedShop = shopService.replace(id, Shop);

    return ResponseService.res(replacedShop);
  }

  @PatchMapping("/modify")
  public ResponseEntity<Shop> modifyShop(@RequestParam int id, @RequestBody Shop Shop) {
    return replaceShop(id, Shop);
  }

  @GetMapping("/find/names")
  public ResponseEntity<List<Name>> findNamesByDistrict(@RequestParam String district) {
    List<Name> res = shopService.getNamesByDistrict(district);

    return ResponseService.res(res);
  }
}
