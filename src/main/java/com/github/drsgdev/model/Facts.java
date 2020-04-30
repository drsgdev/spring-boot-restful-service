package com.github.drsgdev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Facts {

  @Id
  @GeneratedValue
  private int oid;

  @DateTimeFormat
  private String date;

  @Positive
  private int retailer;

  @Positive
  private int cust;

  int book;
  int amnt;

  @Positive
  private int cost;
}
