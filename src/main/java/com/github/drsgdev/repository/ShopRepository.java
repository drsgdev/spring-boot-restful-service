package com.github.drsgdev.repository;

import com.github.drsgdev.model.Shop;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Integer> {

  List<Shop> findAll();

  List<Shop> findAllById(List<Integer> ids);
}
