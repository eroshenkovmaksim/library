package com.eroshenkov.library.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class GenreDto {
  private Long genreId;

  private String genre;
}
