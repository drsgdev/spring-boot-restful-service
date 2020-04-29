package com.github.drsgdev.repository;

import com.github.drsgdev.model.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface BookRepository extends CrudRepository<Book, Integer> {

  List<Book> findAll();
}
