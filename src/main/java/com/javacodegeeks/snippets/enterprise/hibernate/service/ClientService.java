package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Client;

import java.util.List;

public interface ClientService {
    void persist(Client client);
    void update(Client client);
    Client findById(String id);
    void delete(String id);
    List<Client> findAll();
    void deleteAll();

}
