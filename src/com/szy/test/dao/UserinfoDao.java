package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Userinfo;

public interface UserinfoDao {
	
	public void saveUser(Userinfo userinfo);
	
	public void deleteUser(Userinfo userinfo);
	
	public Userinfo findUserById(int id);
	
	public List<Userinfo> findUserByName(String name);
	
	public List<Userinfo> findAllUsers();
	
	public void update(Userinfo userinfo);
}
