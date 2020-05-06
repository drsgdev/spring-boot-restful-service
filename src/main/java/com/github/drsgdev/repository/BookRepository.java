package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  public interface TitleAndCost {
    String getTitle();
  }

  public List<TitleAndCost> findDistinctBy();

  @Query(nativeQuery = true, value = "SELECT DISTINCT :fields FROM Book b;")
  public List<String> findDistinct(@Param("fields") String fields);
}
