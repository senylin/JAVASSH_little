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

import com.szy.test.dao.MajorDao;
import com.szy.test.model.Major;
import com.szy.test.service.MajorService;

@Component("majorService")
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorDao majorDao;
	
	public void add(Major major) {
		majorDao.saveMajor(major);
	}

	public void delete(Major major) {
		majorDao.deleteMajor(major);
	}

	public List<Major> getAllMajors() {
		return majorDao.findAllMajors();
	}

	public Major getMajorByMajorid(int majorid) {
		return majorDao.findMajorByMajorid(majorid);
	}

	public void update(Major major) {
		majorDao.update(major);
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
		
		List<Major> list = majorDao.findAllMajors();
		for(int i=0; i<list.size(); ++i) {
			Major major = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(major.getMajorid())));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(major.getName()));
			
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(major.getCollege()));
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
