package com.szy.test.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.szy.test.model.Medicine;

public interface MedicineDao {
	
	public void saveMedicine(Medicine medicine);
	
	public void deleteMedicine(Medicine medicine);
	
	public Medicine findMedicineById(int id);
	
	public List<Medicine> findAllMedicines();
	
	public void update(Medicine medicine);
}
