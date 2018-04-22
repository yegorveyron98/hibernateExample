package com.javacodegeeks.snippets.enterprise.hibernate;

import java.util.List;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.DaoImpl.BookDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;
import com.javacodegeeks.snippets.enterprise.hibernate.service.serviceImpl.BookServiceImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        Book book1 = new Book(3, "The Brothers", "Fyodor");
        bookServiceImpl.persist(book1);
        List<Book> books1 = bookServiceImpl.findAll();
        System.out.println("Books Persisted are :");
        for (Book b : books1) {
            System.out.println("-" + b.toString());
        }

        Session session = BookDao.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from cardEntity where date > current_date");

        int result = query.executeUpdate();

        tx.commit();


        session.close();

        Session session2 = BookDao.getSessionFactory().openSession();

        Transaction tx2 = session2.beginTransaction();

        Query query2 = session2.createQuery("select ");

        int result2 = query2.executeUpdate();

        tx2.commit();
        session2.close();

    }
}
