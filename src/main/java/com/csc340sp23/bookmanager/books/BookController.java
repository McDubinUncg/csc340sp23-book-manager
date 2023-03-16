package com.csc340sp23.bookmanager.books;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johna
 */
@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
@GetMapping("/all")
public String getAllBooks(Model model) {
    List<Book> books = bookService.getAllBooks();
    if(books.isEmpty()){
        return "books";
    }
    System.out.println(books.get(0));
    model.addAttribute("books", books);
    return "books";
}

@GetMapping("/new-book")
public String newBookForm(Model model) {
    return "new-book";
}

@GetMapping("/id={id}")
public String getBookById(@PathVariable long id, Model model){
    model.addAttribute("book", bookService.getBookById(id));
    return "book";
}

@PostMapping("/create")
public String createBook( Book book){
    bookService.createBook(book);
    return "redirect:/books/all";
}

@GetMapping("/delete/id={id}")
public String deleteBook(@PathVariable long id, Model model) {
    bookService.deleteBook(id);
    return "redirect:/books/all";
}
@PostMapping("/update")
 public String updateBook(Book book) {
        bookService.updateBook(book);
        return "redirect:/books/all";
    }
  @GetMapping("/update/id={id}")
    public String updateBookForm(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "update-book";
    }
}