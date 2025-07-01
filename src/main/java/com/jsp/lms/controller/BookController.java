package com.jsp.lms.controller;

import com.jsp.lms.entiry.Book;
import com.jsp.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

   @PostMapping
     public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

  @GetMapping
    public List<Book> findAllBook(){
        return bookService.findAllBook();
   }

  @GetMapping("/id")
    public Book findById(@RequestParam int id){
        return bookService.findById(id);
   }


  @PutMapping("/id")
    public Book updateById(@RequestParam int id, @RequestBody Book updateBook)  {
        return bookService.updateById(id,updateBook);
   }

 @DeleteMapping("/id")
    public Book deleteById(@RequestParam int id){
        return bookService.deleteById(id);
   }

}
