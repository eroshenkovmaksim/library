package com.eroshenkov.library.controllers;

import com.eroshenkov.library.converters.BookEntityConverter;
import com.eroshenkov.library.dto.BookDto;
import com.eroshenkov.library.model.Book;
import com.eroshenkov.library.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

  @Autowired private BookService bookService;
  @Autowired private BookEntityConverter bookEntityConverter;

  @ApiOperation(value = "Get a book by bookId")
  @GetMapping(value = "/{id}")
  public BookDto getBookById(@PathVariable Long id) {
    try {
      return bookEntityConverter.convert(bookService.findById(id));
    } catch (Exception ex) {
      return null;
    }
  }

  @ApiOperation(value = "Find books by name")
  @GetMapping(value = "/list/{name}")
  public List<BookDto> findBooksByName(@PathVariable String name) {
    try {
      return bookService
          .findBooksByName(name)
          .stream()
          .map(book -> bookEntityConverter.convert(book))
          .collect(Collectors.toList());
    } catch (Exception ex) {
      return null;
    }
  }

  @ApiOperation(value = "Add a book")
  @PostMapping(value = "/")
  public ResponseEntity<String> addBook(@RequestBody Book book) {
    try {
      bookService.add(book);
    } catch (Exception ex) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Book added", HttpStatus.OK);
  }

  @ApiOperation(value = "Delete a book by bookId")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteBook(@PathVariable(value = "id") Long bookId) {
    try {
      bookService.deleteById(bookId);
    } catch (Exception ex) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Book deleted", HttpStatus.OK);
  }
}
