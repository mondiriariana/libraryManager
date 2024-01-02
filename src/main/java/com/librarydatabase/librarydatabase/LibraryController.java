package com.librarydatabase.librarydatabase;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/library")
@EnableWebSecurity
@Validated
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public String redirectToLibrary() {
        return "forward:/library";
    }
    

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", libraryService.getAvailableBooks());
        model.addAttribute("borrowedBooks", libraryService.getBorrowedBooks());
        model.addAttribute("newBook", new Book());
        return "library";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute Book newBook, BindingResult bindingResult) {
        System.out.println("Author is: " + newBook.getAuthor());
        System.out.println("ISBN is " + newBook.getIsbn());
        System.out.println("Title is " + newBook.getTitle());
        System.out.println("Has error?: " + bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            return "redirect:/library";
        }
        else{
        libraryService.addBook(newBook);
        return "redirect:/library";
        }
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Integer bookId) {
        libraryService.borrowBook(bookId);
        return "redirect:/library";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Integer bookId) {
        libraryService.returnBook(bookId);
        return "redirect:/library";
    }
}