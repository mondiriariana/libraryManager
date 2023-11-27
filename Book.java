package com.librarydatabase.librarydatabase;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    private static final AtomicInteger count = new AtomicInteger(0); 
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private boolean borrowed;
    private int timesBorrowed;

    public Book() {
        this.id = count.incrementAndGet();
        this.timesBorrowed = 0;
    }

    public Book(String title, String author, String isbn) {
        this.id = count.incrementAndGet();
        this.timesBorrowed = 0;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowed = false;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getIsbn(){
        return this.isbn;
    }

    public void setBorrowed(boolean borrowed){
        this.borrowed = borrowed;
    }

    public boolean isBorrowed(){
        return this.borrowed;
    }

    public void setTimesBorrowed(int times){
        this.timesBorrowed = times;
    }

    public int getTimesBorrowed(){
        return this.timesBorrowed;
    }


}
