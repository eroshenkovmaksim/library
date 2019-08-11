package com.eroshenkov.library.converters;

import com.eroshenkov.library.dto.AuthorDto;
import com.eroshenkov.library.model.Author;
import com.eroshenkov.library.model.Book;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorEntityConverter {
  public AuthorDto convert(Author author) {
    AuthorDto authorDto = new AuthorDto();
    authorDto.setFirstName(author.getFirstName());
    authorDto.setSecondName(author.getSecondName());
    authorDto.setAuthorId(author.getAuthorId());
    authorDto.setBooks(author.getBooks().stream().map(Book::getName).collect(Collectors.toSet()));
    return authorDto;
  }
}
