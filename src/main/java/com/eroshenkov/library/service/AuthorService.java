package com.eroshenkov.library.service;

import com.eroshenkov.library.model.Author;
import com.eroshenkov.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  @Autowired private AuthorRepository authorRepository;

  public String add(Author author) {
    authorRepository.save(author);
    return "Author added";
  }

  public Author findById(long id) {
    return authorRepository.findById(id).get();
  }

  public String deleteById(long id) {
    authorRepository.deleteById(id);
    return "Author deleted";
  }
}
