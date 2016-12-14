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
import com.szy.test.model.Message;
import com.szy.test.service.MessageService;

@Component("messageAction")
@Scope("prototype")
public class MessageAction {

	private Message message;
	@Autowired
	private MessageService messageService;
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		messageService.add(message);
		return "add";
	}
	public String updateP() {
		message = messageService.getMessageById(message.getId());
	//	System.out.println(Message.getMessageid());
		return "updateP";
	}
	
	public String update() {
		//System.out.println(Message.getMessageid());
		messageService.update(message);
		return "update";
	}
	public String delete() {
		messageService.delete(message);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String list() {
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", messageService.getAllMessages());
		return "list";
	}
	
	public String download() {
		return "download";
	}

	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}



	public InputStream getDownloadFile() {
		return messageService.getInputStream();
	}

	

}
