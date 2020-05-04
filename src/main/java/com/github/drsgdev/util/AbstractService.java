package com.github.drsgdev.util;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractService<T> {

  protected JpaRepository<T, Integer> repository;

  public List<T> findAll() {
    return repository.findAll();
  }

  public Optional<T> findById(int id) {
    return repository.findById(id);
  }

  public T save(T entity) {
    return repository.save(entity);
  }

  public List<T> saveAll(List<T> list) {
    return repository.saveAll(list);
  }

  public Optional<T> delete(T entity) {

    Optional<T> bookToDelete = repository.findOne(Example.of(entity));

    if (bookToDelete.isPresent()) {
      repository.delete(entity);
    }

    return bookToDelete;
  }

  public Optional<T> deleteById(int id) {
    Optional<T> bookToDelete = repository.findById(id);

    if (bookToDelete.isPresent()) {
      repository.deleteById(id);
    }

    return bookToDelete;
  }

  public Optional<T> replace(int id, T entity) {
    Optional<T> bookToReplace = repository.findById(id);

    if (bookToReplace.isPresent()) {
      repository.save(entity);
    }

    return bookToReplace;
  }
}
