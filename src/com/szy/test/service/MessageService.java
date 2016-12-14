package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Message;

public interface MessageService {
	
	public void add(Message message);
	
	public void delete(Message message);
	
	public void update(Message message);
	
	public Message getMessageById(int id);
	
	public List<Message> getAllMessages();
	
	public InputStream getInputStream();
}
