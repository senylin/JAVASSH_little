package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.BookDao;
import com.szy.test.model.Book;

@Component("bookDao")
public class BookDaoImpl implements BookDao {
	private HibernateTemplate hibernateTemplate;
	
	public void deleteBook(Book book) {
		hibernateTemplate.delete(book);
	}

	public List<Book> findAllBooks() {
		String hql = "from Book book order by book.id";
		return (List<Book>)hibernateTemplate.find(hql);
	}

	public Book findBookById(int id) {
		Book book = (Book)hibernateTemplate.get(Book.class, id);
		return book;
	}

	public void saveBook(Book book) {
		hibernateTemplate.save(book);
	}

	public void update(Book book) {
		System.out.println(book.getId());
		hibernateTemplate.update(book);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}