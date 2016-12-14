package com.szy.test.action;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szy.test.model.Book;
import com.szy.test.service.BookService;

@Component("bookAction")
@Scope("prototype")
public class BookAction {

	private Book book;
	@Autowired
	private BookService bookService;
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		bookService.add(book);
		return "add";
	}
	public String updateP() {
		book = bookService.getBookById(book.getId());
	//	System.out.println(Book.getBookid());
		return "updateP";
	}
	
	public String update() {
		//System.out.println(Book.getBookid());
		bookService.update(book);
		return "update";
	}
	public String delete() {
		bookService.delete(book);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String list() {
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", bookService.getAllBooks());
		return "list";
	}
	
	public String download() {
		return "download";
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}



	public InputStream getDownloadFile() {
		return bookService.getInputStream();
	}

	

}
