package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Card;

import java.util.List;

public interface CardService {

    void persist(Card card );

    void update(Card card);

    Card findById(String id);

    void delete(String id);

    List<Card> findAll();

    void deleteAll();

}
