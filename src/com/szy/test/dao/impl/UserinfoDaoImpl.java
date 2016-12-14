package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.UserinfoDao;
import com.szy.test.model.Userinfo;

@Component("userinfoDao")
public class UserinfoDaoImpl implements UserinfoDao {
	
	private HibernateTemplate hibernateTemplate;
	
	public void deleteUser(Userinfo userinfo) {
		hibernateTemplate.delete(userinfo);
	}

	public List<Userinfo> findAllUsers() {
		String hql = "from Userinfo userinfo order by userinfo.id";
		return (List<Userinfo>)hibernateTemplate.find(hql);
	}

	public Userinfo findUserById(int id) {
		Userinfo userinfo = (Userinfo)hibernateTemplate.get(Userinfo.class, id);
		return userinfo;
	}
	
	public List<Userinfo> findUserByName(String name) {
		List<Userinfo> userinfos = hibernateTemplate.find("from Userinfo userinfo where userinfo.name=?", name);

		return userinfos;
	}

	public void saveUser(Userinfo userinfo) {
		hibernateTemplate.save(userinfo);
	}

	public void update(Userinfo userinfo) {
		System.out.println(userinfo.getId());
		hibernateTemplate.update(userinfo);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}