package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Facts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FactsRepository extends JpaRepository<Facts, Integer> {

  List<Facts> findAll();
}
