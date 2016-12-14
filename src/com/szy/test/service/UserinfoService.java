package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import com.szy.test.model.Userinfo;

public interface UserinfoService {
	
	public int login(Userinfo userinfo);

	public void add(Userinfo userinfo);
	
	public void delete(Userinfo userinfo);
	
	public void update(Userinfo userinfo);
	
	public Userinfo getUserById(int id);
	
	public List<Userinfo> getUserByName(String name);
	
	public List<Userinfo> getAllUsers();
	
	public InputStream getInputStream();
}
