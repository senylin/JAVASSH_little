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

import com.szy.test.dao.MedicineDao;
import com.szy.test.model.Medicine;
import com.szy.test.service.MedicineService;

@Component("medicineService")
public class MedicineServiceImpl implements MedicineService {
	@Autowired
	private MedicineDao medicineDao;
	
	public void add(Medicine medicine) {
		medicineDao.saveMedicine(medicine);
	}

	public void delete(Medicine medicine) {
		medicineDao.deleteMedicine(medicine);
	}

	public List<Medicine> getAllMedicines() {
		return medicineDao.findAllMedicines();
	}

	public Medicine getMedicineById(int id) {
		return medicineDao.findMedicineById(id);
	}

	public void update(Medicine medicine) {
		medicineDao.update(medicine);
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
		
		List<Medicine> list = medicineDao.findAllMedicines();
		for(int i=0; i<list.size(); ++i) {
			Medicine medicine = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(medicine.getId())));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(medicine.getStudentid())));
			
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(medicine.getStatus()));
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
