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

import com.szy.test.dao.FinanceDao;
import com.szy.test.model.Finance;
import com.szy.test.service.FinanceService;

@Component("financeService")
public class FinanceServiceImpl implements FinanceService {
	@Autowired
	private FinanceDao financeDao;
	
	public void add(Finance finance) {
		financeDao.saveFinance(finance);
	}

	public void delete(Finance finance) {
		financeDao.deleteFinance(finance);
	}

	public List<Finance> getAllFinances() {
		return financeDao.findAllFinances();
	}

	public Finance getFinanceById(int id) {
		return financeDao.findFinanceById(id);
	}

	public void update(Finance finance) {
		financeDao.update(finance);
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
		
		List<Finance> list = financeDao.findAllFinances();
		for(int i=0; i<list.size(); ++i) {
			Finance finance = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(finance.getId())));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(finance.getStudentid())));
			
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(finance.getStatus()));
			
			cell = row.createCell((short)4);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(finance.getRoomfee()+finance.getTuitionfee()+finance.getClassesfee())));
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
