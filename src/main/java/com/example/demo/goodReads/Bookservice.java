package com.example.helloworldexample.goodReads;
import java.util.*;
public class Bookservice  implements BookRepository{
    private HashMap<Integer,Book> hmap=new HashMap<>();
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

}
