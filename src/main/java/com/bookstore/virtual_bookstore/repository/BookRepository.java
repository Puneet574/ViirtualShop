package com.bookstore.virtual_bookstore.repository;

import com.bookstore.virtual_bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}



