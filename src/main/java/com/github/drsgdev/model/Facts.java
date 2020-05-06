package com.github.drsgdev.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
public class Facts {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @DateTimeFormat
  @Column
  private Date date;

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
