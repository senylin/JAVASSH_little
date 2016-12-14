package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Message;

public interface MessageDao {
	
	public void saveMessage(Message message);
	
	public void deleteMessage(Message message);
	
	public Message findMessageById(int id);
	
	public List<Message> findAllMessages();
	
	public void update(Message message);
}
