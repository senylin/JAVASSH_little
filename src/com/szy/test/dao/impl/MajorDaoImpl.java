package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.MajorDao;
import com.szy.test.model.Major;

@Component("majorDao")
public class MajorDaoImpl implements MajorDao {
	private HibernateTemplate hibernateTemplate;
	
	public void deleteMajor(Major major) {
		hibernateTemplate.delete(major);
	}

	public List<Major> findAllMajors() {
		String hql = "from Major major order by major.majorid";
		return (List<Major>)hibernateTemplate.find(hql);
	}

	public Major findMajorByMajorid(int majorid) {
		Major major = (Major)hibernateTemplate.get(Major.class, majorid);
		return major;
	}

	public void saveMajor(Major major) {
		hibernateTemplate.save(major);
	}

	public void update(Major major) {
		System.out.println(major.getMajorid());
		hibernateTemplate.update(major);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}