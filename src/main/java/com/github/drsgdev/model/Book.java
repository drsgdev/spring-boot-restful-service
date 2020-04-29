package com.github.drsgdev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Book {

  @Id @GeneratedValue int id;

  @NotEmpty @Size(max = 30, min = 1) String title;

  @NotNull int cost;

  @Size(max = 50) String warehouse;

  int amnt;

  public Book(@NotEmpty @Size(max = 30, min = 1) String title,
              @NotNull int cost, @Size(max = 50) String warehouse, int amnt) {
    this.title = title;
    this.cost = cost;
    this.warehouse = warehouse;
    this.amnt = amnt;
  }
}
