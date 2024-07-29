package com.example.demo.goodReads;


import jakarta.persistence.*;


@Entity
@Table(name="book")
public class Book {

    @Id
    @Column(name="bookid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookId;
    @Column(name="bookname")
    private String BookName;
    @Column(name="bookimgurl")    
    private String Bookimgurl;

    public Book(){}

    public Book(int BookId,String BookName,String Bookimgurl){
        this.BookId=BookId;
        this.BookName=BookName;
        this.Bookimgurl=Bookimgurl;
    }

    public int getBookId(){
        return this.BookId;
    }
    public void setBookId(int BookId){
        this.BookId=BookId;
    }
    public String getBookName(){
        return this.BookName;
    }
    public void setBookName(String BookName){
        this.BookName=BookName;
    }
    public String getBookimgurl(){
        return this.Bookimgurl;
    }
    public void setBookimgurl(String Bookimgurl){
        this.Bookimgurl=Bookimgurl;
    }
}
