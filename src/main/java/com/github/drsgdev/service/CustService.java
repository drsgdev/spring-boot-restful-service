package com.github.drsgdev.service;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Cust;
import com.github.drsgdev.repository.CustRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class CustService {

  @Autowired
  private CustRepository custRepository;

  @GraphQLQuery(name = "customers")
  public List<Cust> findAll() {
    return custRepository.findAll();
  }

  @GraphQLQuery(name = "customer")
  public Optional<Cust> findById(int id) {
    return custRepository.findById(id);
  }

  public Cust save(Cust entity) {
    return custRepository.save(entity);
  }

  public List<Cust> saveAll(List<Cust> list) {
    return custRepository.saveAll(list);
  }

  public Optional<Cust> delete(Cust entity) {

    Optional<Cust> bookToDelete = custRepository.findOne(Example.of(entity));

    if (bookToDelete.isPresent()) {
      custRepository.delete(entity);
    }

    return bookToDelete;
  }

  public Optional<Cust> deleteById(int id) {
    Optional<Cust> bookToDelete = custRepository.findById(id);

    if (bookToDelete.isPresent()) {
      custRepository.deleteById(id);
    }

    return bookToDelete;
  }

  public Optional<Cust> replace(int id, Cust entity) {
    Optional<Cust> bookToReplace = custRepository.findById(id);

    if (bookToReplace.isPresent()) {
      custRepository.save(entity);
    }

    return bookToReplace;
  }
}
