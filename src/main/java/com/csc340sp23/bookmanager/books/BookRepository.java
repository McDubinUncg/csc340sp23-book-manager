package com.csc340sp23.bookmanager.books;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johna
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
