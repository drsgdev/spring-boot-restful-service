package com.github.drsgdev.repository;

import com.github.drsgdev.model.Cust;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustRepository extends CrudRepository<Cust, Integer> {

  List<Cust> findAll();
}
