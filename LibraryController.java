package com.librarydatabase.librarydatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", libraryService.getAvailableBooks());
        model.addAttribute("borrowedBooks", libraryService.getBorrowedBooks());
        model.addAttribute("newBook", new Book());
        return "library";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book newBook) {
        libraryService.addBook(newBook);
        return "redirect:/library";
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
