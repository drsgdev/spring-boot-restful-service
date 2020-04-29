package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

  List<Book> findAll();
}
