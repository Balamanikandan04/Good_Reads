package com.example.demo.goodReads;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
public class Bookservice  implements BookRepository{
    private HashMap<Integer,Book> hmap=new HashMap<>();
    int uniqueBookId=3;
    public Bookservice(){
        Book b1=new Book(1,"Java","Rahul.jpeg");
        Book b2=new Book(2,"kavi","kavi.jpeg");
        hmap.put(b1.getBookId(),b1);
        hmap.put(b2.getBookId(),b2);
    }
    @Override
    public ArrayList<Book> getBooks(){
        Collection<Book> bookcollection=hmap.values();
        ArrayList<Book> booklist=new ArrayList<>(bookcollection);
        return booklist;
    }
    @Override
    public Book getBookById(int bookId) {
        Book book = hmap.get(bookId);
        return book;
    }
       @Override
    public Book updateBook(int bookId, Book book) {
        Book existingBook=hmap.get(bookId);

        if(existingBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (book.getBookName() != null) {
            existingBook.setBookName(book.getBookName());
        }
        
        if (book.getBookimgurl() != null) {
            existingBook.setBookimgurl(book.getBookimgurl());
        }
        return existingBook;
    }

    @Override
    public Book addBook(Book book) {
        book.setBookId(uniqueBookId);
        hmap.put(uniqueBookId, book);
        uniqueBookId += 1;

        return book;
    }
    @Override
    public void deleteBook(int bookId){
        Book book=hmap.get(bookId);

        if(book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else{
            hmap.remove(bookId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }


}
