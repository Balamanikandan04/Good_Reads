package com.example.demo.goodReads;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class BookH2Service implements BookRepository {
    @Autowired
    private JdbcTemplate db;


    @Override
    public ArrayList<Book> getBooks() {
        String sql = "select * from book";
        List<Book> bookList = db.query(sql, new BookRowMapper());
        return new ArrayList<>(bookList);
    }

    @Override
    public Book getBookById(int BookId) {
        try{
        Book book=db.queryForObject("select * from book where BookId=?", new BookRowMapper(),BookId);
        return book;
    }
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    
}

    @Override
    public Book addBook(Book book) {

        db.update("insert into book(BookName,Bookimgurl) values(?,?)",book.getBookName(),book.getBookimgurl());
        Book savedBook=db.queryForObject("select * from book where BookName=? and Bookimgurl=?",new BookRowMapper(),book.getBookName(),book.getBookimgurl());
        return savedBook;
    }

    @Override
    public Book updateBook(int bookId, Book book) {

        if(book.getBookName()!=null){
            db.update("update book set BookName=? where BookId=?",book.getBookName(),bookId);
        }
        if(book.getBookimgurl()!=null){
            db.update("update book set Bookimgurl=? where BookId=? ",book.getBookimgurl(),bookId);
        }
        return getBookById(bookId);
    }

    @Override
    public void deleteBook(int bookId) {
       db.update("delete from book where BookId=?",bookId);

    }
}
