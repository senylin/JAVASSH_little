package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.ClassesDao;
import com.szy.test.model.Classes;

@Component("classesDao")
public class ClassesDaoImpl implements ClassesDao {
	private HibernateTemplate hibernateTemplate;
	
	public void deleteClasses(Classes classes) {
		hibernateTemplate.delete(classes);
	}

	public List<Classes> findAllClassess() {
		String hql = "from Classes classes order by classes.classesid";
		return (List<Classes>)hibernateTemplate.find(hql);
	}

	public Classes findClassesByClassesid(int classesid) {
		Classes classes = (Classes)hibernateTemplate.get(Classes.class, classesid);
		return classes;
	}

	public void saveClasses(Classes classes) {
		hibernateTemplate.save(classes);
	}

	public void update(Classes classes) {
		System.out.println(classes.getClassesid());
		hibernateTemplate.update(classes);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}