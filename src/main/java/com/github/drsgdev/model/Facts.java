package com.github.drsgdev.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
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
}
