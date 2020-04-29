package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Shop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

  List<Shop> findAll();
}
