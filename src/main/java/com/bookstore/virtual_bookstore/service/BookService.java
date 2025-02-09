package com.bookstore.virtual_bookstore.service;


import com.bookstore.virtual_bookstore.model.Book;
import com.bookstore.virtual_bookstore.repository.BookRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //create a new Book

    public Book saveBook(Book book){
        return bookRepository.save(book);

    }
    //Get All Books

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    //Get book by Id
    public Optional<Book> getBookById(Long Id){
        return bookRepository.findById(Id);
    }

    //update book
    public Book updateBook(Long Id, Book updatedBook){
        if(bookRepository.existsById(Id)){
            updatedBook.setId(Id);
            return bookRepository.save(updatedBook);
        }
        return null;
    }

    //Delete book
    public void deleteBook(Long id){
        bookRepository.deleteById(Id);

    }


}
