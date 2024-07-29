package com.example.demo.goodReads;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class BookJpaService implements BookRepository{
@Autowired
private BookJpaRepository bookjpaRepository;

    @Override
    public ArrayList<Book> getBooks(){
        List<Book> booklist=bookjpaRepository.findAll();
        ArrayList<Book> books=new ArrayList<>(booklist);
        return books;


        
    }

    @Override
    public Book getBookById(int BookId) {
try{
    Book book=bookjpaRepository.findById(BookId).get();
    return book;
}catch(Exception e){
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}
 }

    @Override
    public Book addBook(Book book) {
       bookjpaRepository.save(book);
       return book;
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        try{
            Book newBook=bookjpaRepository.findById(bookId).get();
            if(book.getBookName()!=null){
                newBook.setBookName(book.getBookName());
            }
            if(book.getBookimgurl()!=null){
                newBook.setBookimgurl(book.getBookimgurl());
            }
            bookjpaRepository.save(newBook);
            return newBook;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteBook(int bookId) {
        try{
            bookjpaRepository.deleteById(bookId);

        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }
    
}
