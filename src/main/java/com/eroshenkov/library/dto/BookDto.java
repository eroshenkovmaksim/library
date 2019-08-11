package com.eroshenkov.library.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
public class BookDto {

  private long bookId;

  private String name;

  private String description;

  private Set<String> authors = new HashSet<>();

  private Set<String> genres = new HashSet<>();
}
