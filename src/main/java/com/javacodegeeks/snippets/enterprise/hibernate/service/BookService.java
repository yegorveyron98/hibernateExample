package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;

import java.util.List;

public interface BookService {
    void persist(Book book);

    void update(Book book);

    Book findById(String id);

    void delete(String id);

    List<Book> findAll();

    void deleteAll();

}
