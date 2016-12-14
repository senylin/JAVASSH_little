package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Classes;

public interface ClassesDao {
	
	public void saveClasses(Classes classes);
	
	public void deleteClasses(Classes classes);
	
	public Classes findClassesByClassesid(int classesid);
	
	public List<Classes> findAllClassess();
	
	public void update(Classes classes);
}
