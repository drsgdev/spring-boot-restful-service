package com.github.drsgdev.repository;

import java.util.Date;
import java.util.List;

import com.github.drsgdev.model.Book;
import com.github.drsgdev.model.Facts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FactsRepository extends JpaRepository<Facts, Integer> {

  interface LastNameOnly {
    String getlname();
  }

  public interface ShopNameOnly {
    String getName();
  }

  interface DateOnly {
    Date getDate();
  }

  interface BookTitleOnly {
    String getTitle();
  }

  interface BookAmntOnly {
    int getAmnt();
  }

  public interface CustAndShop extends LastNameOnly, ShopNameOnly {
  }

  public interface CustAndBook extends LastNameOnly, DateOnly, BookTitleOnly, BookAmntOnly {
    int getDiscount();
  }

  public interface CustAndDate extends LastNameOnly, DateOnly {
    int getId();
  }

  public interface CustAndDistrict extends LastNameOnly, DateOnly {
    String getDistrict();
  }

  @Query(nativeQuery = false, value = "SELECT to_char(f.date, 'MON') FROM Facts f")
  public List<String> findMonth();

  @Query(nativeQuery = true,
         value = "SELECT lname, name " +
                 "FROM Facts f " + 
                 "JOIN Cust c ON c.id = f.cust " +
                 "JOIN Shop s ON s.id = f.retailer")
  public List<CustAndShop> findCustAndShop();

  @Query(nativeQuery = true,
         value = "SELECT date, lname, discount, title, f.amnt as amnt " +
                 "FROM Facts f " + 
                 "JOIN Cust c ON c.id = f.cust " +
                 "JOIN Book b ON b.id = f.book")
  public List<CustAndBook> findCustAndBook();

  @Query(nativeQuery = true,
         value = "SELECT f.id, lname, date " +
                 "FROM Facts f " + 
                 "JOIN Cust c ON c.id = f.cust " +
                 "WHERE f.cost >= :cost")
  public List<CustAndDate> findCustAndDate(@Param("cost") int cost);

  @Query(nativeQuery = true,
         value = "SELECT c.lname, c.district, f.date " +
                 "FROM Facts f " +
                 "JOIN Shop s ON s.id = f.retailer " +
                 "JOIN Cust c ON c.district = s.district AND c.id = f.cust " +
                 "WHERE EXTRACT(month FROM f.date) <= :month " +
                 "ORDER BY c.lname")
  public List<CustAndDistrict> findCustAndDistrict(@Param("month") int month);

  @Query(nativeQuery = true,
         value = "SELECT DISTINCT s.name " +
                 "FROM Facts f JOIN Cust c ON c.id = f.cust " +
                 "JOIN Shop s ON s.district = c.district " +
                 "WHERE s.district != :district " +
                 "AND c.discount BETWEEN :lo AND :hi")
  public List<ShopNameOnly> findShop(@Param("lo") int lo, @Param("hi") int hi, @Param("district") String district);

  @Query(nativeQuery = true,
         value = "SELECT b.title, b.warehouse, b.cost, b.amnt " +
                 "FROM Facts f JOIN Book b ON b.id = f.book " +
                 "JOIN Shop s ON s.id = f.retailer " +
                 "WHERE b.warehouse = s.district " +
                 "AND b.amnt >= :amnt " +
                 "ORDER BY b.cost")
  public List<Book> findBook(@Param("amnt") int amnt);
}
