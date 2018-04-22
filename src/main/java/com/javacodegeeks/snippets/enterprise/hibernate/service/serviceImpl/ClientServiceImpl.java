package com.javacodegeeks.snippets.enterprise.hibernate.service.serviceImpl;

import java.util.List;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.DaoImpl.ClientDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Client;
import com.javacodegeeks.snippets.enterprise.hibernate.service.ClientService;

public class ClientServiceImpl implements ClientService {

    private static ClientDao clientDao;

    public ClientServiceImpl() {
        clientDao = new ClientDao();
    }

    public void persist(Client entity) {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.persist(entity);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public void update(Client entity) {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.update(entity);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public Client findById(String id) {
        clientDao.openCurrentSession();
        Client client = clientDao.findById(id);
        clientDao.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        clientDao.openCurrentSessionwithTransaction();
        Client client = clientDao.findById(id);
        clientDao.delete(client);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public List<Client> findAll() {
        clientDao.openCurrentSession();
        List<Client> clients = clientDao.findAll();
        clientDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.deleteAll();
        clientDao.closeCurrentSessionwithTransaction();
    }

    public ClientDao clientDao() {
        return clientDao;
    }
}
