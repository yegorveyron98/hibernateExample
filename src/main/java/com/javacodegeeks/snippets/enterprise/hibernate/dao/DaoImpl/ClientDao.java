package com.javacodegeeks.snippets.enterprise.hibernate.dao.DaoImpl;

import java.util.List;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.DaoInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.javacodegeeks.snippets.enterprise.hibernate.model.Client;

public class ClientDao implements DaoInterface<Client, String> {

    private Session currentSession;

    private Transaction currentTransaction;

    public ClientDao() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Client entity) {
        getCurrentSession().save(entity);
    }

    public void update(Client entity) {
        getCurrentSession().update(entity);
    }

    public Client findById(String id) {
        Client client = (Client) getCurrentSession().get(Client.class, id);
        return client;
    }

    public void delete(Client entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Client> findAll() {
        List<Client> clients = (List<Client>) getCurrentSession().createQuery("from Client").list();
        return clients;
    }

    public void deleteAll() {
        List<Client> entityList = findAll();
        for (Client entity : entityList) {
            delete(entity);
        }
    }
}
