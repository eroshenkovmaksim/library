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
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private long bookId;

  @NotNull private String name;

  private String description;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
    name = "books_authors",
    joinColumns = {@JoinColumn(name = "book_id")},
    inverseJoinColumns = {@JoinColumn(name = "author_id")}
  )
  private Set<Author> authors = new HashSet<>();

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
    name = "books_genres",
    joinColumns = {@JoinColumn(name = "book_id")},
    inverseJoinColumns = {@JoinColumn(name = "genre_id")}
  )
  private Set<Genre> genres = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return bookId == book.bookId
        && Objects.equals(name, book.name)
        && Objects.equals(description, book.description);
  }

  @Override
  public int hashCode() {

    return Objects.hash(bookId, name, description);
  }

  @Override
  public String toString() {
    return "Book{"
        + "bookId="
        + bookId
        + ", name='"
        + name
        + '\''
        + ", description='"
        + description
        + '\''
        + ", authors="
        + authors
        + ", genres="
        + genres
        + '}';
  }
}
