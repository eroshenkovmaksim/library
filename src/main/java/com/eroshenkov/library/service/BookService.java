package com.eroshenkov.library.service;

import com.eroshenkov.library.dao.BookRepository;
import com.eroshenkov.library.model.AbstractEntity;
import com.eroshenkov.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends AbstractService {

  @Autowired
  private BookRepository bookRepository;

  public String add(AbstractEntity book) {
    bookRepository.save((Book) book);
    return "Book added";
  }

  public Book findById(long bookId) {
    return bookRepository.findById(bookId).get();
  }

  public String deleteById(long id) {
    bookRepository.deleteById(id);
    return "Book deleted";
  }
}
