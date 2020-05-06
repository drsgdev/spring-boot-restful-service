package com.github.drsgdev.controller;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Book;
import com.github.drsgdev.repository.BookRepository.TitleAndCost;
import com.github.drsgdev.service.BookService;
import com.github.drsgdev.util.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping("/all")
  public ResponseEntity<List<Book>> findAll() {
    return ResponseEntity.ok(bookService.findAll());
  }

  @GetMapping("/find")
  public ResponseEntity<Book> findById(@RequestParam int id) {
    Optional<Book> book = bookService.findById(id);

    return ResponseService.res(book);
  }

  @PostMapping("/add")
  public ResponseEntity<String> addBook(@RequestBody Book book) {
    bookService.save(book);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/add/list")
  public ResponseEntity<String> addAllBooks(@RequestBody List<Book> bookList) {
    bookService.saveAll(bookList);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Book> deleteById(@RequestParam int id) {
    Optional<Book> deletedBook = bookService.deleteById(id);

    return ResponseService.res(deletedBook);
  }

  @DeleteMapping("/delete/json")
  public ResponseEntity<Book> delete(@RequestBody Book book) {
    Optional<Book> deletedBook = bookService.delete(book);

    return ResponseService.res(deletedBook);
  }

  @PutMapping("/replace")
  public ResponseEntity<Book> replaceBook(@RequestParam int id, @RequestBody Book book) {
    Optional<Book> replacedBook = bookService.replace(id, book);

    return ResponseService.res(replacedBook);
  }

  @PatchMapping("/modify")
  public ResponseEntity<Book> modifyBook(@RequestParam int id, @RequestBody Book book) {
    return replaceBook(id, book);
  }

  @GetMapping("/find/titleandcost")
  public ResponseEntity<List<TitleAndCost>> findTitleAndCost() {
    List<TitleAndCost> res = bookService.findDistinctTitleAndCost();

    return ResponseService.res(res);
  }

  @GetMapping("/find/titleandcost/{title}/{cost}")
  public ResponseEntity<List<TitleAndCost>> findTitleAndCostByConstraints(
                                              @PathVariable("title") String title,
                                              @PathVariable("cost") int cost) {

    List<TitleAndCost> res = bookService.findTitleAndCostByConstraints(title, cost);

    return ResponseService.res(res);
  }
}
