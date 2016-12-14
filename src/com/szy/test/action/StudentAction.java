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
import com.szy.test.model.Student;
import com.szy.test.service.StudentService;

@Component("studentAction")
@Scope("prototype")
public class StudentAction {

	private Student student;
	@Autowired
	private StudentService studentService;
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		studentService.add(student);
		return "add";
	}
	public String updateP() {
		student = studentService.getStudentByStudentid(student.getStudentid());
		System.out.println(student.getStudentid());
		return "updateP";
	}
	
	public String update() {
		//System.out.println(student.getStudentid());
		studentService.update(student);
		return "update";
	}
	public String delete() {
		studentService.delete(student);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String slist() {
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("slist", studentService.getAllStudents());
		return "slist";
	}
	
	public String download() {
		return "download";
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}



	public InputStream getDownloadFile() {
		return studentService.getInputStream();
	}

	

}
