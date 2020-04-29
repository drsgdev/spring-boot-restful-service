package com.github.drsgdev.repository;

import com.github.drsgdev.model.Facts;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FactsRepository extends CrudRepository<Facts, Integer> {

  List<Facts> findAll();
}
