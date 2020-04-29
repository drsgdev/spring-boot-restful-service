package com.github.drsgdev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Facts {

  @Id @GeneratedValue int oid;

  @DateTimeFormat String date;

  @NotNull int retailer;

  @NotNull int cust;

  int book;
  int amnt;

  @NotNull int cost;

  public Facts(String date, @NotNull int retailer, @NotNull int cust, int book,
               int amnt, @NotNull int cost) {
    this.date = date;
    this.retailer = retailer;
    this.cust = cust;
    this.book = book;
    this.amnt = amnt;
    this.cost = cost;
  }
}
