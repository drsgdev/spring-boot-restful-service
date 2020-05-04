package com.github.drsgdev.model;

import javax.persistence.Column;
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
  @Column
  private String date;

  @Positive
  @Column
  private int retailer;

  @Positive
  @Column
  private int cust;

  @Column
  int book;

  @Column
  int amnt;

  @Positive
  @Column
  private int cost;
}
