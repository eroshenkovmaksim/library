package com.eroshenkov.library.dao;

import com.eroshenkov.library.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

  @Autowired private SessionFactory sessionFactory;

  private Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public void save(Book book) {
    getSession().save(book);
  }

  public void delete(Book book) {
    getSession().delete(book);
  }

  public List<Book> getAll() {
    return getSession().createQuery("from Book").list();
  }

  public Book getById(long id) {
    Book book = (Book) getSession().createQuery("from Book").list().get(0);
    return book;
  }

  public void update(Book book) {
    getSession().update(book);
  }
}
