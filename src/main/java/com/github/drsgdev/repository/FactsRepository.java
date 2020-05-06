package com.github.drsgdev.repository;

import java.util.Date;
import java.util.List;

import com.github.drsgdev.model.Facts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FactsRepository extends JpaRepository<Facts, Integer> {

  public interface CustAndShop {
    String getlname();
    String getName();
  }

  public interface CustAndBook {
    Date getDate();
    String getlname();
    int getDiscount();
    String getTitle();
    int getAmnt();
  }

  @Query(nativeQuery = false, value = "SELECT to_char(f.date, 'MON') FROM Facts f")
  public List<String> findMonth();

  @Query(nativeQuery = true,
         value = "SELECT lname, name " +
                 "FROM Facts f " + 
                 "LEFT JOIN Cust c ON c.id = f.cust " +
                 "LEFT JOIN Shop s ON s.id = f.retailer")
  public List<CustAndShop> findCustAndShop();

  @Query(nativeQuery = true,
         value = "SELECT date, lname, discount, title, f.amnt as amnt " +
                 "FROM Facts f " + 
                 "LEFT JOIN Cust c ON c.id = f.cust " +
                 "LEFT JOIN Book b ON b.id = f.book")
  public List<CustAndBook> findCustAndBook();
}
