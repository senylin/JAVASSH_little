package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.MedicineDao;
import com.szy.test.model.Medicine;

@Component("medicineDao")
public class MedicineDaoImpl implements MedicineDao {
	private HibernateTemplate hibernateTemplate;
	
	public void deleteMedicine(Medicine medicine) {
		hibernateTemplate.delete(medicine);
	}

	public List<Medicine> findAllMedicines() {
		String hql = "from Medicine medicine order by medicine.id";
		return (List<Medicine>)hibernateTemplate.find(hql);
	}

	public Medicine findMedicineById(int id) {
		Medicine medicine = (Medicine)hibernateTemplate.get(Medicine.class, id);
		return medicine;
	}

	public void saveMedicine(Medicine medicine) {
		hibernateTemplate.save(medicine);
	}

	public void update(Medicine medicine) {
		System.out.println(medicine.getId());
		hibernateTemplate.update(medicine);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}