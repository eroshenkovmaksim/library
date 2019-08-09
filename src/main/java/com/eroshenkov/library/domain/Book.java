package com.eroshenkov.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String name;

  @NotNull
  private Long authorId;
  public Book(String name, Long authorId) {
    this.name = name;
    this.authorId = authorId;
  }
}
