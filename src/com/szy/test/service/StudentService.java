package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Student;

public interface StudentService {
	
	public void add(Student student);
	
	public void delete(Student student);
	
	public void update(Student student);
	
	public Student getStudentByStudentid(int studentid);
	
	public List<Student> getAllStudents();
	
	public InputStream getInputStream();
}
