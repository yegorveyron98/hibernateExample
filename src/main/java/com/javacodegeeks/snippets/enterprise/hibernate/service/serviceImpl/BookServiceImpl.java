package com.javacodegeeks.snippets.enterprise.hibernate.service.serviceImpl;

import java.util.List;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.DaoImpl.BookDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;
import com.javacodegeeks.snippets.enterprise.hibernate.service.BookService;


public class BookServiceImpl implements BookService {

	private static BookDao bookBookDao;

	public BookServiceImpl() {
		bookBookDao = new BookDao();
	}

	public void persist(Book entity) {
		bookBookDao.openCurrentSessionwithTransaction();
		bookBookDao.persist(entity);
		bookBookDao.closeCurrentSessionwithTransaction();
	}

	public void update(Book entity) {
		bookBookDao.openCurrentSessionwithTransaction();
		bookBookDao.update(entity);
		bookBookDao.closeCurrentSessionwithTransaction();
	}

	public Book findById(String id) {
		bookBookDao.openCurrentSession();
		Book book = bookBookDao.findById(id);
		bookBookDao.closeCurrentSession();
		return book;
	}

	public void delete(String id) {
		bookBookDao.openCurrentSessionwithTransaction();
		Book book = bookBookDao.findById(id);
		bookBookDao.delete(book);
		bookBookDao.closeCurrentSessionwithTransaction();
	}

	public List<Book> findAll() {
		bookBookDao.openCurrentSession();
		List<Book> books = bookBookDao.findAll();
		bookBookDao.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		bookBookDao.openCurrentSessionwithTransaction();
		bookBookDao.deleteAll();
		bookBookDao.closeCurrentSessionwithTransaction();
	}

	public BookDao bookDao() {
		return bookBookDao;
	}
}
