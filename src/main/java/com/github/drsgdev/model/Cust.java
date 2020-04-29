package com.github.drsgdev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Cust {

  @Id @GeneratedValue int id;

  @NotEmpty @Size(max = 30, min = 2) String lname;

  @Size(max = 50) String district;

  int discount;

  public Cust(@NotEmpty @Size(max = 30, min = 2) String lname,
              @Size(max = 50) String district, int discount) {
    this.lname = lname;
    this.district = district;
    this.discount = discount;
  }
}
