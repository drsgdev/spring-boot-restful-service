package com.github.drsgdev.service;

import com.github.drsgdev.model.Shop;
import com.github.drsgdev.repository.ShopRepository;
import com.github.drsgdev.util.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService extends AbstractService<Shop> {

  @Autowired
  private ShopRepository shopRepository;

  public ShopService() {
    super();
    super.repository = shopRepository;
  }
}
