package com.eroshenkov.library.dao;

import com.eroshenkov.library.domain.Book;




import java.util.List;

public interface BookDAO {
    void save(Book book);

    void delete(Book book);

    List<Book> getAll();

    Book getById(long id);

    void update(Book book);

}
