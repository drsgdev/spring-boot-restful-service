package com.github.drsgdev.service;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Book;
import com.github.drsgdev.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  @GraphQLQuery(name = "books")
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  @GraphQLQuery(name = "book")
  public Optional<Book> findById(int id) {
    return bookRepository.findById(id);
  }

  public Book save(Book entity) {
    return bookRepository.save(entity);
  }

  public List<Book> saveAll(List<Book> list) {
    return bookRepository.saveAll(list);
  }

  public Optional<Book> delete(Book entity) {

    Optional<Book> bookToDelete = bookRepository.findOne(Example.of(entity));

    if (bookToDelete.isPresent()) {
      bookRepository.delete(entity);
    }

    return bookToDelete;
  }

  public Optional<Book> deleteById(int id) {
    Optional<Book> bookToDelete = bookRepository.findById(id);

    if (bookToDelete.isPresent()) {
      bookRepository.deleteById(id);
    }

    return bookToDelete;
  }

  public Optional<Book> replace(int id, Book entity) {
    Optional<Book> bookToReplace = bookRepository.findById(id);

    if (bookToReplace.isPresent()) {
      bookRepository.save(entity);
    }

    return bookToReplace;
  }
}
