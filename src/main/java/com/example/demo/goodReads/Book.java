package com.example.demo.goodReads;

public class Book {
    private int BookId;
    private String BookName;
    private String Bookimgurl;

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
