package com.github.drsgdev.service;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Facts;
import com.github.drsgdev.repository.FactsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class FactsService {

  @Autowired
  private FactsRepository factsRepository;

  @GraphQLQuery(name = "facts")
  public List<Facts> findAll() {
    return factsRepository.findAll();
  }

  @GraphQLQuery(name = "fact")
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
}
