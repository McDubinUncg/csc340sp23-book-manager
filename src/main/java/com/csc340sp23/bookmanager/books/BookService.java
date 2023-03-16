package com.csc340sp23.bookmanager.books;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johna
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    
    public Book getBookById(long id){
        return bookRepository.getReferenceById(id);
    }
    
    public Book createBook(Book book){
        return (Book) bookRepository.save(book);
    }
    
    public void updateBook(Book book){
        Optional<Book> existingBook = bookRepository.findById(book.getId());
        if(existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setIsbn(book.getIsbn());
            updatedBook.setPrice(book.getPrice());
            bookRepository.save(updatedBook);
       }
    }
    
    public boolean deleteBook(long id){
        Optional<Book> optionalBook= bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
