package com.github.drsgdev.controller;

import com.github.drsgdev.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/books")
public class BooksController {

  @Autowired
  BookRepository bookRepository;

  @GetMapping("/all")
  public String getMethodName(@RequestParam String param) {
      return new SomeData();
  }
  
}