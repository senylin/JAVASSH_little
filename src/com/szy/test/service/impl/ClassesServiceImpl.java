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

import com.szy.test.dao.ClassesDao;
import com.szy.test.model.Classes;
import com.szy.test.service.ClassesService;

@Component("classesService")
public class ClassesServiceImpl implements ClassesService {
	@Autowired
	private ClassesDao classesDao;
	
	public void add(Classes classes) {
		classesDao.saveClasses(classes);
	}

	public void delete(Classes classes) {
		classesDao.deleteClasses(classes);
	}

	public List<Classes> getAllClassess() {
		return classesDao.findAllClassess();
	}

	public Classes getClassesByClassesid(int classesid) {
		return classesDao.findClassesByClassesid(classesid);
	}

	public void update(Classes classes) {
		classesDao.update(classes);
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
		
		List<Classes> list = classesDao.findAllClassess();
		for(int i=0; i<list.size(); ++i) {
			Classes classes = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(classes.getClassesid())));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(classes.getMajorid())));
			
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(classes.getNumber())));
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
