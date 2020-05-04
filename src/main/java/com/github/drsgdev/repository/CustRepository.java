package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Cust;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustRepository extends JpaRepository<Cust, Integer> {

  List<Cust> findAll();
}
