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

import com.szy.test.dao.RoomDao;
import com.szy.test.model.Room;
import com.szy.test.service.RoomService;

@Component("roomService")
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao roomDao;
	
	public void add(Room room) {
		roomDao.saveRoom(room);
	}

	public void delete(Room room) {
		roomDao.deleteRoom(room);
	}

	public List<Room> getAllRooms() {
		return roomDao.findAllRooms();
	}

	public Room getRoomByRoomid(int roomid) {
		return roomDao.findRoomByRoomid(roomid);
	}

	public void update(Room room) {
		roomDao.update(room);
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
		
		List<Room> list = roomDao.findAllRooms();
		for(int i=0; i<list.size(); ++i) {
			Room room = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell((short)0);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(room.getRoomid())));
			
			cell = row.createCell((short)2);
			cell.setCellValue(new HSSFRichTextString(room.getSize()));
			
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(room.getPlace()));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(room.getBed())));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(room.getChargeid())));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(String.valueOf(room.getScore())));
			
			cell = row.createCell((short)3);
			cell.setCellValue(new HSSFRichTextString(room.getStatus()));
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
