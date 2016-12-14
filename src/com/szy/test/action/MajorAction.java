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
import com.szy.test.model.Major;
import com.szy.test.service.MajorService;

@Component("majorAction")
@Scope("prototype")
public class MajorAction {

	private Major major;
	@Autowired
	private MajorService majorService;
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		majorService.add(major);
		return "add";
	}
	public String updateP() {
		major = majorService.getMajorByMajorid(major.getMajorid());
	//	System.out.println(Major.getMajorid());
		return "updateP";
	}
	
	public String update() {
		//System.out.println(Major.getMajorid());
		majorService.update(major);
		return "update";
	}
	public String delete() {
		majorService.delete(major);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String list() {
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", majorService.getAllMajors());
		return "list";
	}
	
	public String download() {
		return "download";
	}

	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}



	public InputStream getDownloadFile() {
		return majorService.getInputStream();
	}

	

}
