package com.eroshenkov.library.converters;

import com.eroshenkov.library.dto.BookDto;
import com.eroshenkov.library.model.Book;
import com.eroshenkov.library.model.Genre;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookEntityConverter {
  public BookDto convert(Book book) {
    BookDto bookDto = new BookDto();
    bookDto.setName(book.getName());
    bookDto.setBookId(book.getBookId());
    bookDto.setAuthors(
        book.getAuthors()
            .stream()
            .map(author -> author.getFirstName() + " " + author.getSecondName())
            .collect(Collectors.toSet()));
    bookDto.setGenres(book.getGenres().stream().map(Genre::getGenre).collect(Collectors.toSet()));
    return bookDto;
  }
}
