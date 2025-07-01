package com.jsp.lms.service;

import com.jsp.lms.entiry.Book;

import java.util.List;
import java.util.Optional;

public interface BookService  {
   public Book addBook(Book book);

   public List<Book> findAllBook();

  public Book findById(int id);

  public Book updateById(int id,Book updateBook);

 public Book deleteById(int id);
}
