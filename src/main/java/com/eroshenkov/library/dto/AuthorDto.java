package com.eroshenkov.library.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
public class AuthorDto {
  private long authorId;

  private String firstName;

  private String secondName;

  private Set<String> books = new HashSet<>();
}
