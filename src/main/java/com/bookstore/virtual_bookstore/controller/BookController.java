package com.bookstore.virtual_bookstore.controller;


import com.bookstore.virtual_bookstore.model.Book;
import com.bookstore.virtual_bookstore.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    // Create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    // Get a book by ID
    @GetMapping("/{Id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long Id) {
        Optional<Book> book = bookService.getBookById(Id);
        return book.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //update book details
    @PutMapping("/{Id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long Id, @RequestBody Book updatedBook) {
        try{
            Book book = bookService.updateBook(Id, updatedBook);
            return ResponseEntity.ok(book);

        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }


    }

    //delete
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long Id){
        bookService.deleteBook((Id));
        return ResponseEntity.ok("Book Delete Successfully");
    }





}
