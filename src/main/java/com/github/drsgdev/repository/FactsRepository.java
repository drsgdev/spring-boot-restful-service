package com.github.drsgdev.repository;

import com.github.drsgdev.model.Facts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactsRepository extends JpaRepository<Facts, Integer> {
}
