package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  public interface TitleAndCost {
    String getTitle();
    String getCost();
  }

  public List<TitleAndCost> findDistinctTitleAndCostBy();
  public List<TitleAndCost> findAllByTitleContainingOrCostIsGreaterThanEqual(String containing, int bound);
}
