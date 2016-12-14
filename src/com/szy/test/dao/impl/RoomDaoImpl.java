package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.RoomDao;
import com.szy.test.model.Room;

@Component("roomDao")
public class RoomDaoImpl implements RoomDao {
	private HibernateTemplate hibernateTemplate;
	
	public void deleteRoom(Room room) {
		hibernateTemplate.delete(room);
	}

	public List<Room> findAllRooms() {
		String hql = "from Room room order by room.roomid";
		return (List<Room>)hibernateTemplate.find(hql);
	}

	public Room findRoomByRoomid(int roomid) {
		Room room = (Room)hibernateTemplate.get(Room.class, roomid);
		return room;
	}

	public void saveRoom(Room room) {
		hibernateTemplate.save(room);
	}

	public void update(Room room) {
		System.out.println(room.getRoomid());
		hibernateTemplate.update(room);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}