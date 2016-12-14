package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Classes;

public interface ClassesService {
	
	public void add(Classes classes);
	
	public void delete(Classes classes);
	
	public void update(Classes classes);
	
	public Classes getClassesByClassesid(int classesid);
	
	public List<Classes> getAllClassess();
	
	public InputStream getInputStream();
}
