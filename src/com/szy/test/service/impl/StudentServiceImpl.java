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

import com.szy.test.dao.StudentDao;
import com.szy.test.model.Student;
import com.szy.test.service.StudentService;

@Component("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public void add(Student student) {
		studentDao.saveStudent(student);
	}

	public void delete(Student student) {
		studentDao.deleteStudent(student);
	}

	public List<Student> getAllStudents() {
		return studentDao.findAllStudents();
	}

	public Student getStudentByStudentid(int studentid) {
		return studentDao.findStudentByStudentid(studentid);
	}

	public void update(Student student) {
		studentDao.update(student);
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
		
		List<Student> list = studentDao.findAllStudents();
		for(int i=0; i<list.size(); ++i) {
			Student student = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(student.getStudentid())));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(student.getName()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(student.getClassid())));
			
			cell = row.createCell((short)4);
			cell.setCellValue(new HSSFRichTextString(String .valueOf(student.getMajorid())));
			
			cell = row.createCell((short)5);
			cell.setCellValue(new HSSFRichTextString(String .valueOf(student.getRoomid())));
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
