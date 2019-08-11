package com.eroshenkov.library.service;

import com.eroshenkov.library.model.Book;
import com.eroshenkov.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService{

  @Autowired private BookRepository bookRepository;

  public String add(Book book) {
    bookRepository.save(book);
    return "Book added";
  }

  public Book findById(long id) {
    return bookRepository.findById(id).get();
  }

  public String deleteById(long id) {
    bookRepository.deleteById(id);
    return "Book deleted";
  }

  public List<Book> findBooksByName(String name) {
    return bookRepository.findByName(name);
  }
}
