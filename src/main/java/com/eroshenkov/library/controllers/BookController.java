package com.eroshenkov.library.controllers;


import com.eroshenkov.library.domain.Book;
import com.eroshenkov.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/book")
public class BookController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value="/get-book-name")
  @ResponseBody
  public String getBookNameById(Long id) {
    try {
      Book book = bookService.findBook(id);
      return book.getName();
    }
    catch(Exception ex) {
      return "book not found";
    }
  }

  @RequestMapping(value="/add-book")
  @ResponseBody
  public String create(String name, Long authorId) {
    try {
      bookService.addBook(name,authorId);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Book successfully saved!";
  }

}
