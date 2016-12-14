package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Major;

public interface MajorDao {
	
	public void saveMajor(Major major);
	
	public void deleteMajor(Major major);
	
	public Major findMajorByMajorid(int majorid);
	
	public List<Major> findAllMajors();
	
	public void update(Major major);
}
