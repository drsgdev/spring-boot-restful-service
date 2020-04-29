package com.github.drsgdev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {

  @Id @GeneratedValue private int id;

  @NotEmpty @Size(max = 30, min = 1) private String title;

  @NotNull private int cost;

  @Size(max = 50) private String warehouse;

  private int amnt;
}
