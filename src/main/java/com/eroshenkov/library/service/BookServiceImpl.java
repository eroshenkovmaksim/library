package com.eroshenkov.library.service;

import com.eroshenkov.library.dao.BookDAO;
import com.eroshenkov.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDao;

    public String addBook(String name, long authorId) {
        try{
            Book book = new Book(name, authorId);
            bookDao.save(book);
        }catch (Exception ex){
            return ex.getMessage();
        }
        return "Book added";
    }

    public Book findBook(long bookId) {
       try{
           return bookDao.getById(bookId);
       }catch (Exception ex){
           return null;
       }
    }
}
