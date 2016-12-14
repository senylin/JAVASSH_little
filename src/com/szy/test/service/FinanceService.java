package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Finance;

public interface FinanceService {
	
	public void add(Finance finance);
	
	public void delete(Finance finance);
	
	public void update(Finance finance);
	
	public Finance getFinanceById(int id);
	
	public List<Finance> getAllFinances();
	
	public InputStream getInputStream();
}
