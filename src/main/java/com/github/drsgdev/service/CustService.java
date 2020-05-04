package com.github.drsgdev.service;

import com.github.drsgdev.model.Cust;
import com.github.drsgdev.repository.CustRepository;
import com.github.drsgdev.util.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustService extends AbstractService<Cust> {

  @Autowired
  private CustRepository custRepository;

  public CustService() {
    super();
    super.repository = custRepository;
  }
}
