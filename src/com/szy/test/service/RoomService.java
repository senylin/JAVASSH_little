package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Room;

public interface RoomService {
	
	public void add(Room room);
	
	public void delete(Room room);
	
	public void update(Room room);
	
	public Room getRoomByRoomid(int roomid);
	
	public List<Room> getAllRooms();
	
	public InputStream getInputStream();
}
