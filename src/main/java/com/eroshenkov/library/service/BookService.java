package com.eroshenkov.library.service;

import com.eroshenkov.library.domain.Book;

public interface BookService {

  String addBook(String name, long authorId);

  Book findBook(long bookId);
}
