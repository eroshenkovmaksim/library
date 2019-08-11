package com.eroshenkov.library.controllers;

import com.eroshenkov.library.model.Book;
import com.eroshenkov.library.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

  @Autowired private BookService bookService;

  @ApiOperation(value = "Get a book by id")
  @GetMapping(value = "/{id}")
  public Book getBookById(@PathVariable Long id) {
    try {
      return bookService.findById(id);
    } catch (Exception ex) {
      return null;
    }
  }

  @ApiOperation(value = "Add a book")
  @PostMapping(value = "/")
  public ResponseEntity<String> create(@RequestBody Book book) {
    try {
      bookService.add(book);
    } catch (Exception ex) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Book added", HttpStatus.OK);
  }

  @ApiOperation(value = "Delete a book by id")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long bookId) {
    try {
      bookService.deleteById(bookId);
    } catch (Exception ex) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Book deleted", HttpStatus.OK);
  }
}
