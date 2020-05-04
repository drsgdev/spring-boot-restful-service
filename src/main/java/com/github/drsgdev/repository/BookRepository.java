package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  List<Book> findAll();
}
