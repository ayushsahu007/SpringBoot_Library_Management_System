package com.jsp.lms.controller;

import com.jsp.lms.entiry.Book;
import com.jsp.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add-book",method = RequestMethod.POST)
     public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

   @RequestMapping(value = "/find-all-book",method = RequestMethod.GET)
    public List<Book> findAllBook(){
        return bookService.findAllBook();
   }

   @RequestMapping(value = "/find-by-id",method = RequestMethod.GET)
    public Book findById(int id){
        return bookService.findById(id);
   }


  //@RequestMapping(value = "/update-by-id/{id}", method = RequestMethod.PUT)
   @RequestMapping(value = "/update-by-id",method = RequestMethod.PUT)
    public Book updateById(@RequestParam int id, @RequestBody Book updateBook)  {
        return bookService.updateById(id,updateBook);
   }

   @RequestMapping(value = "/delete-by-id" , method = RequestMethod.DELETE)
    public Book deleteById(@RequestParam int id){
        return bookService.deleteById(id);
   }

}
