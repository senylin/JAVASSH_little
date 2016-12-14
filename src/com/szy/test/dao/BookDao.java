package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Book;

public interface BookDao {
	
	public void saveBook(Book book);
	
	public void deleteBook(Book book);
	
	public Book findBookById(int id);
	
	public List<Book> findAllBooks();
	
	public void update(Book book);
}
