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
import com.szy.test.model.Room;
import com.szy.test.service.RoomService;

@Component("roomAction")
@Scope("prototype")
public class RoomAction {

	private Room room;
	@Autowired
	private RoomService roomService;
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		roomService.add(room);
		return "add";
	}
	public String updateP() {
		room = roomService.getRoomByRoomid(room.getRoomid());
	//	System.out.println(Room.getRoomid());
		return "updateP";
	}
	
	public String update() {
		//System.out.println(Room.getRoomid());
		roomService.update(room);
		return "update";
	}
	public String delete() {
		roomService.delete(room);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String list() {
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", roomService.getAllRooms());
		return "list";
	}
	
	public String download() {
		return "download";
	}

	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}



	public InputStream getDownloadFile() {
		return roomService.getInputStream();
	}

	

}
