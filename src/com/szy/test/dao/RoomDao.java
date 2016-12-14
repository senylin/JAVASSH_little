package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Room;

public interface RoomDao {
	
	public void saveRoom(Room room);
	
	public void deleteRoom(Room room);
	
	public Room findRoomByRoomid(int roomid);
	
	public List<Room> findAllRooms();
	
	public void update(Room room);
}
