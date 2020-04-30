package com.github.drsgdev.controller;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Book;
import com.github.drsgdev.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping("/all")
  public ResponseEntity<List<Book>> findAll() {
    return ResponseEntity.ok(bookRepository.findAll());
  }

  @GetMapping("/find")
  public ResponseEntity<Book> findById(@RequestParam int id) {
    Optional<Book> book = bookRepository.findById(id);

    if (book.isPresent()) {
      return ResponseEntity.ok(book.get());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @PostMapping("/add")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> addBook(@RequestBody Book book) {
    bookRepository.save(book);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBookById(@RequestParam int id) {
    bookRepository.deleteById(id);
  }

  @DeleteMapping("/delete")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteBook(@RequestBody Book book) {
    bookRepository.delete(book);
  }

  @PutMapping("/replace/{id}")
  public ResponseEntity<Book> replaceBook(@RequestParam int id, @RequestBody Book book) {
    if (bookRepository.existsById(id)) {
      Book replacedBook = bookRepository.findById(id).get();

      bookRepository.deleteById(id);
      bookRepository.save(book);

      return ResponseEntity.ok(replacedBook);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
