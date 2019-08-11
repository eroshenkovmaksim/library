package com.eroshenkov.library.controllers;

import com.eroshenkov.library.converters.AuthorEntityConverter;
import com.eroshenkov.library.dto.AuthorDto;
import com.eroshenkov.library.model.Author;
import com.eroshenkov.library.service.AuthorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

  @Autowired private AuthorService authorService;
  @Autowired private AuthorEntityConverter authorEntityConverter;

  @ApiOperation(value = "Get an author by id")
  @GetMapping(value = "/{id}")
  public AuthorDto getAuthorById(@PathVariable Long id) {
    try {
      return authorEntityConverter.convert(authorService.findById(id));
    } catch (Exception ex) {
      return null;
    }
  }

  @ApiOperation(value = "Add an author")
  @PostMapping(value = "/")
  public ResponseEntity<String> addBook(@RequestBody Author author) {
    try {
      authorService.add(author);
    } catch (Exception ex) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Author added", HttpStatus.OK);
  }

  @ApiOperation(value = "Delete an author by id")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAuthor(@PathVariable(value = "id") Long authorId) {
    try {
      authorService.deleteById(authorId);
    } catch (Exception ex) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>("Author deleted", HttpStatus.OK);
  }
}
