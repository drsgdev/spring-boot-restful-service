package com.github.drsgdev.model;

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

  @Id @GeneratedValue private int id;

  @NotEmpty @Size(max = 30, min = 2) private String lname;

  @Size(max = 50) private String district;

  private int discount;
}
