package com.szy.test.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.szy.test.dao.BookDao;
import com.szy.test.model.Book;
import com.szy.test.service.BookService;

@Component("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	public void add(Book book) {
		bookDao.saveBook(book);
	}

	public void delete(Book book) {
		bookDao.deleteBook(book);
	}

	public List<Book> getAllBooks() {
		return bookDao.findAllBooks();
	}

	public Book getBookById(int id) {
		return bookDao.findBookById(id);
	}

	public void update(Book book) {
		bookDao.update(book);
	}



	public InputStream getInputStream() {
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell = row.createCell((short)0);
		cell.setCellValue(new HSSFRichTextString("ÐòºÅ"));
		
		cell = row.createCell((short)2);
		cell.setCellValue(new HSSFRichTextString("ÐÕ"));
		
		cell = row.createCell((short)3);
		cell.setCellValue(new HSSFRichTextString("Ãû"));
		
		cell = row.createCell((short)4);
		cell.setCellValue(new HSSFRichTextString("ÄêÁä"));
		
		List<Book> list = bookDao.findAllBooks();
		for(int i=0; i<list.size(); ++i) {
			Book book = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(book.getId())));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(book.getStudentid())));
			
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(book.getStatus()));
			
			}
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		
		InputStream is = new ByteArrayInputStream(content);
		
		return is;
	}

}
