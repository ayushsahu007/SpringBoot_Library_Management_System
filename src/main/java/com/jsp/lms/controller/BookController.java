package com.jsp.lms.controller;

import com.jsp.lms.entiry.Book;
import com.jsp.lms.service.BookService;
import com.jsp.lms.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

   @PostMapping
     public ResponseEntity<ResponseStructure<Book>> addBook(@RequestBody Book book){
       book =  bookService.addBook(book);
       ResponseStructure<Book> responseStructure = new ResponseStructure<>();
       responseStructure.setStatusCode(HttpStatus.CREATED.value());
       responseStructure.setMsg("Book Created");
       responseStructure.setData(book);

         return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.CREATED);
    }

  @GetMapping
    public ResponseEntity<ResponseStructure<List<Book>>> findAllBook(){
        List<Book> books =  bookService.findAllBook();
        ResponseStructure<List<Book>> responseStructure = new ResponseStructure<>();
      if (books == null){
          responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
          responseStructure.setMsg("Book not Found id:" );
          responseStructure.setData(null);
          return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
      }
        responseStructure.setStatusCode(HttpStatus.FOUND.value());
      responseStructure.setMsg("Find All Book");
      responseStructure.setData(books);
      return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure,HttpStatus.FOUND);
   }

  @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Book> > findById(@PathVariable int id){
        Book book  =  bookService.findById(id);
        ResponseStructure<Book> responseStructure = new ResponseStructure<>();
      if (book == null) {
          // Book not found
          responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
          responseStructure.setMsg("Book not found with id: " + id);
          responseStructure.setData(null);
          return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
      }

      responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMsg("Find Book by Id");
        responseStructure.setData(book);

        return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK);
   }


  @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Book>> updateById(@PathVariable int id, @RequestBody Book updateBook)  {
       Book book = bookService.findById(id);
      ResponseStructure<Book> responseStructure = new ResponseStructure<>();
       if (book == null){
           responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
           responseStructure.setMsg("Book not found with id: " + id);
           responseStructure.setData(null);
           return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
        }else {
           bookService.updateById(id,updateBook);
           responseStructure.setStatusCode(HttpStatus.OK.value());
           responseStructure.setMsg("Update by Id");
           responseStructure.setData(book);
           return  new ResponseEntity<>(responseStructure,HttpStatus.OK);
       }


   }

 @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<Book>>deleteById(@PathVariable int id){
        Book book = bookService.findById(id);

            ResponseStructure<Book> responseStructure = new ResponseStructure<>();
            if (book == null ){
                responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
                responseStructure.setMsg("Book not found with id: " + id);
                responseStructure.setData(null);
                return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
            }else {
                bookService.deleteById(id);
                responseStructure.setStatusCode(HttpStatus.OK.value());
                responseStructure.setMsg("Delete Book by Id");
                responseStructure.setData(book);
                return new ResponseEntity<>(responseStructure, HttpStatus.OK);
            }
   }

}
