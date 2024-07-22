package com.example.demo.goodReads;

import java.util.ArrayList;

public interface BookRepository {
ArrayList<Book> getBooks();
Book getBookById(int BookId);
Book addBook(Book book);
Book updateBook(int bookId, Book book);
void deleteBook(int bookId);



    
}
