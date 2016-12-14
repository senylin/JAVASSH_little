package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.MessageDao;
import com.szy.test.model.Message;

@Component("messageDao")
public class MessageDaoImpl implements MessageDao {
	private HibernateTemplate hibernateTemplate;
	
	public void deleteMessage(Message message) {
		hibernateTemplate.delete(message);
	}

	public List<Message> findAllMessages() {
		String hql = "from Message message order by message.id";
		return (List<Message>)hibernateTemplate.find(hql);
	}

	public Message findMessageById(int id) {
		Message message = (Message)hibernateTemplate.get(Message.class, id);
		return message;
	}

	public void saveMessage(Message message) {
		hibernateTemplate.save(message);
	}

	public void update(Message message) {
		System.out.println(message.getId());
		hibernateTemplate.update(message);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}