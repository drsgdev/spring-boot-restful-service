package com.github.drsgdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cust {

  @Id
  @GeneratedValue
  private int id;

  @NotEmpty
  @Size(max = 30, min = 2)
  @Column
  private String lname;

  @Size(max = 50)
  @Column
  private String district;

  @Column
  private int discount;
}
