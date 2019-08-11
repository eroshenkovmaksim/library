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
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "author_id")
  private long authorId;

  @NotNull private String firstName;

  @NotNull private String secondName;

  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Author author = (Author) o;
    return authorId == author.authorId
        && Objects.equals(firstName, author.firstName)
        && Objects.equals(secondName, author.secondName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(authorId, firstName, secondName);
  }

  @Override
  public String toString() {
    return "Author{"
        + "authorId="
        + authorId
        + ", firstName='"
        + firstName
        + '\''
        + ", secondName='"
        + secondName
        + '\''
        + '}';
  }
}
