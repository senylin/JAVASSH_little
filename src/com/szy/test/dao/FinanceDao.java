package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Finance;

public interface FinanceDao {
	
	public void saveFinance(Finance finance);
	
	public void deleteFinance(Finance finance);
	
	public Finance findFinanceById(int id);
	
	public List<Finance> findAllFinances();
	
	public void update(Finance finance);
}
