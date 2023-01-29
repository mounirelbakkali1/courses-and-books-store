package com.pluralsight.controllers;


import com.pluralsight.models.Book;
import com.pluralsight.models.Review;
import com.pluralsight.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class ViewController {

    @Autowired
    BookService service;

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Book showBook(@PathVariable(value = "id") int id){
        Book book = Optional.ofNullable(service.finBook(id)).get().orElse(new Book());
        return book;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> findBooks(){
        return service.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
       service.saveBook(book);
    }
}
