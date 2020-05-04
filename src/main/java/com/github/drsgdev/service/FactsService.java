package com.github.drsgdev.service;

import com.github.drsgdev.model.Facts;
import com.github.drsgdev.repository.FactsRepository;
import com.github.drsgdev.util.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactsService extends AbstractService<Facts> {

  @Autowired
  private FactsRepository factsRepository;

  public FactsService() {
    super();
    super.repository = factsRepository;
  }
}
