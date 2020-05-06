package com.github.drsgdev.repository;

import java.util.List;

import com.github.drsgdev.model.Cust;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustRepository extends JpaRepository<Cust, Integer> {

  public interface District {
    String getDistrict();
  }

  public interface NameAndDisc {
    String getlname();
    String getDiscount();
  }

  public List<District> findDistinctDistrictsBy();
  public List<NameAndDisc> findDistinctByDistrict(String district);
}
