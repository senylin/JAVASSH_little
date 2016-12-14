package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.StudentDao;
import com.szy.test.model.Student;

@Component(value="studentDao")
public class StudentDaoImpl implements StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	public void deleteStudent(Student student) {
		hibernateTemplate.delete(student);
	}

	public List<Student> findAllStudents() {
		String hql = "from Student student order by student.studentid";
		return (List<Student>)hibernateTemplate.find(hql);
	}

	public Student findStudentByStudentid(int studentid) {
		Student student = (Student)hibernateTemplate.get(Student.class, studentid);
		return student;
	}

	public void saveStudent(Student student) {
		hibernateTemplate.save(student);
	}

	public void update(Student student) {
		System.out.println(student.getStudentid());
		hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}