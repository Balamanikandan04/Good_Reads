package com.example.helloworldexample;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworldexample.goodReads.Book;
import com.example.helloworldexample.goodReads.Bookservice;

@RestController
public class BookController {
    @GetMapping("/Books")
    public ArrayList<Book> getBook(){
        Bookservice bookService=new Bookservice();
        return bookService.getBooks();
    }
}
