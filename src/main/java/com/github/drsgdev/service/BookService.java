package com.github.drsgdev.service;

import com.github.drsgdev.model.Book;
import com.github.drsgdev.repository.BookRepository;
import com.github.drsgdev.util.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends AbstractService<Book> {

  @Autowired
  private BookRepository bookRepository;

  public BookService() {
    super();
    super.repository = bookRepository;
  }
}
