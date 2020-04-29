package com.github.drsgdev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Shop {

  @Id @GeneratedValue int id;

  @NotEmpty @Size(max = 50, min = 2) String name;

  @Size(max = 50) String district;

  int fee;

  public Shop(@NotEmpty @Size(max = 50, min = 2) String name,
              @Size(max = 50) String district, int fee) {
    this.name = name;
    this.district = district;
    this.fee = fee;
  }
}
