package com.eroshenkov.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "genre_id")
  private long genreId;

  @Column(unique = true)
  @NotNull
  private String genre;

  @ManyToMany(mappedBy = "genres")
  private Set<Book> books = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Genre genre1 = (Genre) o;
    return genreId == genre1.genreId && Objects.equals(genre, genre1.genre);
  }

  @Override
  public int hashCode() {

    return Objects.hash(genreId, genre);
  }

  @Override
  public String toString() {
    return "Genre{" + "genreId=" + genreId + ", genre='" + genre + '\'' + '}';
  }
}
