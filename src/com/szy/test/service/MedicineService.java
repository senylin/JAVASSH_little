package com.szy.test.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Medicine;

public interface MedicineService {
	
	public void add(Medicine medicine);
	
	public void delete(Medicine medicine);
	
	public void update(Medicine medicine);
	
	public Medicine getMedicineById(int id);
	
	public List<Medicine> getAllMedicines();
	
	public InputStream getInputStream();
}
