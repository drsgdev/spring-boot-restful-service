package com.github.drsgdev.service;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Book;
import com.github.drsgdev.model.Facts;
import com.github.drsgdev.repository.FactsRepository;
import com.github.drsgdev.repository.FactsRepository.CustAndBook;
import com.github.drsgdev.repository.FactsRepository.CustAndDate;
import com.github.drsgdev.repository.FactsRepository.CustAndDistrict;
import com.github.drsgdev.repository.FactsRepository.CustAndShop;
import com.github.drsgdev.repository.FactsRepository.ShopNameOnly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class FactsService {

  @Autowired
  private FactsRepository factsRepository;

  public List<Facts> findAll() {
    return factsRepository.findAll();
  }

  public Optional<Facts> findById(int id) {
    return factsRepository.findById(id);
  }

  public Facts save(Facts entity) {
    return factsRepository.save(entity);
  }

  public List<Facts> saveAll(List<Facts> list) {
    return factsRepository.saveAll(list);
  }

  public Optional<Facts> delete(Facts entity) {

    Optional<Facts> bookToDelete = factsRepository.findOne(Example.of(entity));

    if (bookToDelete.isPresent()) {
      factsRepository.delete(entity);
    }

    return bookToDelete;
  }

  public Optional<Facts> deleteById(int id) {
    Optional<Facts> bookToDelete = factsRepository.findById(id);

    if (bookToDelete.isPresent()) {
      factsRepository.deleteById(id);
    }

    return bookToDelete;
  }

  public Optional<Facts> replace(int id, Facts entity) {
    Optional<Facts> bookToReplace = factsRepository.findById(id);

    if (bookToReplace.isPresent()) {
      factsRepository.save(entity);
    }

    return bookToReplace;
  }

  public List<String> findFactsMonth() {
    return factsRepository.findMonth();
  }

  public List<CustAndShop> findCustAndShop() {
    return factsRepository.findCustAndShop();
  }

  public List<CustAndBook> findCustAndBook() {
    return factsRepository.findCustAndBook();
  }

  public List<CustAndDate> findCustOnly(int cost) {
    if (cost <= 0) {
      cost = 1000;
    }

    return factsRepository.findCustAndDate(cost);
  }

  public List<CustAndDistrict> findCustAndDistrict(int month) {
    if (month < 1 || month > 12) {
      month = 1;
    }

    return factsRepository.findCustAndDistrict(month);
  }

  public List<ShopNameOnly> findShop(int lo, int hi, String district) {
    return factsRepository.findShop(lo, hi, district);
  }

  public List<Book> findBook(int amnt) {
    return factsRepository.findBook(amnt);
  }
}
