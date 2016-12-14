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
import org.springframework.stereotype.Component;

import com.szy.test.dao.UserinfoDao;
import com.szy.test.model.Userinfo;
import com.szy.test.service.UserinfoService;

@Component("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
	
	private UserinfoDao userinfoDao;
	
	public int login(Userinfo userinfo){
		List<Userinfo> userinfos = userinfoDao.findUserByName(userinfo.getName());
		if(userinfos.size()==0)return 0;
		if(userinfos.get(0).getPassword().equals(userinfo.getPassword()))return 1;
		return 0;
	}
	public void add(Userinfo userinfo) {
		userinfoDao.saveUser(userinfo);
	}

	public void delete(Userinfo userinfo) {
		userinfoDao.deleteUser(userinfo);
	}

	public List<Userinfo> getAllUsers() {
		return userinfoDao.findAllUsers();
	}

	public Userinfo getUserById(int id) {
		return userinfoDao.findUserById(id);
	}
	
	public List<Userinfo> getUserByName(String name){
		return userinfoDao.findUserByName(name);
	}
	public void update(Userinfo userinfo) {
		System.out.println(userinfo.getId());
		userinfoDao.update(userinfo);
	}

	public UserinfoDao getUserinfoDao() {
		return userinfoDao;
	}

	@Resource
	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
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
		
		List<Userinfo> list = userinfoDao.findAllUsers();
		for(int i=0; i<list.size(); ++i) {
			Userinfo user = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(user.getId())));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(user.getName()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(user.getPassword()));
			
			cell = row.createCell((short)4);
			cell.setCellValue(new HSSFRichTextString(user.getStatus()));
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