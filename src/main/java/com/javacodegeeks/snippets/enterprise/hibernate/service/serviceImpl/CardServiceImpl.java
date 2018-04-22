package com.javacodegeeks.snippets.enterprise.hibernate.service.serviceImpl;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.DaoImpl.BookDao;
import com.javacodegeeks.snippets.enterprise.hibernate.dao.DaoImpl.CardDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Card;
import com.javacodegeeks.snippets.enterprise.hibernate.service.CardService;

import java.util.List;

public class CardServiceImpl implements CardService {

    private static CardDao cardDao;

    public CardServiceImpl() {
        cardDao = new CardDao();
    }

    public void persist(Card entity) {
        cardDao.openCurrentSessionwithTransaction();
        cardDao.persist(entity);
        cardDao.closeCurrentSessionwithTransaction();
    }

    public void update(Card entity) {
        cardDao.openCurrentSessionwithTransaction();
        cardDao.update(entity);
        cardDao.closeCurrentSessionwithTransaction();
    }

    public Card findById(String id) {
        cardDao.openCurrentSession();
        Card card = cardDao.findById(id);
        cardDao.closeCurrentSession();
        return card;
    }

    public void delete(String id) {
        cardDao.openCurrentSessionwithTransaction();
        Card card = cardDao.findById(id);
        cardDao.delete(card);
        cardDao.closeCurrentSessionwithTransaction();
    }

    public List<Card> findAll() {
        cardDao.openCurrentSession();
        List<Card> cards = cardDao.findAll();
        cardDao.closeCurrentSession();
        return cards;
    }

    public void deleteAll() {
        cardDao.openCurrentSessionwithTransaction();
        cardDao.deleteAll();
        cardDao.closeCurrentSessionwithTransaction();
    }

    public CardDao cardDao() {
        return cardDao;
    }

}
