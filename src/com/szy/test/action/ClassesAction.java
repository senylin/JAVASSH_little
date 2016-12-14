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
import com.szy.test.model.Classes;
import com.szy.test.service.ClassesService;

@Component("classesAction")
@Scope("prototype")
public class ClassesAction {

	private Classes classes;
	@Autowired
	private ClassesService classesService;
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		classesService.add(classes);
		return "add";
	}
	public String updateP() {
		classes = classesService.getClassesByClassesid(classes.getClassesid());
	//	System.out.println(Classes.getClassesid());
		return "updateP";
	}
	
	public String update() {
		//System.out.println(Classes.getClassesid());
		classesService.update(classes);
		return "update";
	}
	public String delete() {
		classesService.delete(classes);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String list() {
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", classesService.getAllClassess());
		return "list";
	}
	
	public String download() {
		return "download";
	}

	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}



	public InputStream getDownloadFile() {
		return classesService.getInputStream();
	}

	

}
