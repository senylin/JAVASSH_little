package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Student;

public interface StudentDao {
	
	public void saveStudent(Student student);
	
	public void deleteStudent(Student student);
	
	public Student findStudentByStudentid(int studentid);
	
	public List<Student> findAllStudents();
	
	public void update(Student student);
}
