package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

  public interface ShopNameOnly {
    String getName();
  }

  public List<ShopNameOnly> findDistinctNamesByDistrict(String district);
}
