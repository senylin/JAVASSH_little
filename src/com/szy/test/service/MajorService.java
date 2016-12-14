package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Major;

public interface MajorService {
	
	public void add(Major major);
	
	public void delete(Major major);
	
	public void update(Major major);
	
	public Major getMajorByMajorid(int majorid);
	
	public List<Major> getAllMajors();
	
	public InputStream getInputStream();
}
