package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Book;

public interface BookService {
	
	public void add(Book book);
	
	public void delete(Book book);
	
	public void update(Book book);
	
	public Book getBookById(int id);
	
	public List<Book> getAllBooks();
	
	public InputStream getInputStream();
}
