package com.jsp.lms.serviceImpl;

import com.jsp.lms.entiry.Book;
import com.jsp.lms.repository.BookRepository;
import com.jsp.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBook(){
       List<Book> books =  bookRepository.findAll();

       if (books.isEmpty()){
           return null;
       }else {
           return books;
       }
    }

    @Override
    public Book findById(int id){
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }else {
           Book book = optional.get();
           return book;
        }
    }
    public Book updateById(int id,Book updateBook){
     Optional<Book> optional =  bookRepository.findById(id);
     if (optional.isEmpty()){
         return null;
     }else {
                Book existingBook = optional.get();
                updateBook.setId(existingBook.getId());
                return bookRepository.save(updateBook);
     }
    }

    public Book deleteById(int id){
        Optional<Book> optional =  bookRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }else {
          Book bookId = optional.get();
          bookRepository.delete(bookId);
          return bookId;
        }

    }
}

