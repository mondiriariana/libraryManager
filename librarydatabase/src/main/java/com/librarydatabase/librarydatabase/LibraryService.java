package com.librarydatabase.librarydatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class LibraryService {
    private final List<Book> books = new ArrayList<>(){{
        add(new Book("Adventures of Sherlock Holmes", "Arthur Conan Doyle", "567"));
        add(new Book("Crime and Punishment", "Fyodor Dostoyevsky", "678"));
        add(new Book("Frankenstein", "Mary Shelley", "890"));        
        add(new Book("Grapes of Wrath", "John Steinbeck", "234"));
        add(new Book("Jane Eyre", "Charlotte Bronte", "789"));
        add(new Book("Little Prince", "Antoine de Saint-Exupery", "456"));
        add(new Book("Little Women", "Louisa May Alcott", "345"));
        add(new Book("Pride and Prejudice", "Jane Austin", "123"));
        add(new Book("Tom Sawyer", "Mark Twain", "901"));
    }};

    public List<Book> getAvailableBooks() {
        return books.stream().filter(book -> !book.isBorrowed()).collect(Collectors.toList());
    }

    public List<Book> getBorrowedBooks() {
        return books.stream().filter(book -> book.isBorrowed()).collect(Collectors.toList());
    }

    public void addBook(Book book) { 
        books.add(book);
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    public Book borrowBook(Integer bookId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            int timesBorrowed = book.getTimesBorrowed();
            book.setTimesBorrowed(timesBorrowed +1);
        }
        return book;
    }

    public void returnBook(Integer bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setBorrowed(false);
        }
    }

    private Book findBookById(Integer bookId) {
        return books.stream().filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
    }

}