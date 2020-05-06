package com.github.drsgdev.service;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Shop;
import com.github.drsgdev.repository.ShopRepository;
import com.github.drsgdev.repository.ShopRepository.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

  @Autowired
  private ShopRepository shopRepository;

  public List<Shop> findAll() {
    return shopRepository.findAll();
  }

  public Optional<Shop> findById(int id) {
    return shopRepository.findById(id);
  }

  public Shop save(Shop entity) {
    return shopRepository.save(entity);
  }

  public List<Shop> saveAll(List<Shop> list) {
    return shopRepository.saveAll(list);
  }

  public Optional<Shop> delete(Shop entity) {

    Optional<Shop> bookToDelete = shopRepository.findOne(Example.of(entity));

    if (bookToDelete.isPresent()) {
      shopRepository.delete(entity);
    }

    return bookToDelete;
  }

  public Optional<Shop> deleteById(int id) {
    Optional<Shop> bookToDelete = shopRepository.findById(id);

    if (bookToDelete.isPresent()) {
      shopRepository.deleteById(id);
    }

    return bookToDelete;
  }

  public Optional<Shop> replace(int id, Shop entity) {
    Optional<Shop> bookToReplace = shopRepository.findById(id);

    if (bookToReplace.isPresent()) {
      shopRepository.save(entity);
    }

    return bookToReplace;
  }

  public List<Name> getNamesByDistrict(String district) {
    return shopRepository.findDistinctNamesByDistrict(district);
  }
}
