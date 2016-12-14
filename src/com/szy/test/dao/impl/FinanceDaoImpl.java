package com.szy.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.szy.test.dao.FinanceDao;
import com.szy.test.model.Finance;

@Component("financeDao")
public class FinanceDaoImpl implements FinanceDao {
	private HibernateTemplate hibernateTemplate;
	
	public void deleteFinance(Finance finance) {
		hibernateTemplate.delete(finance);
	}

	public List<Finance> findAllFinances() {
		String hql = "from Finance finance order by finance.id";
		return (List<Finance>)hibernateTemplate.find(hql);
	}

	public Finance findFinanceById(int id) {
		Finance finance = (Finance)hibernateTemplate.get(Finance.class, id);
		return finance;
	}

	public void saveFinance(Finance finance) {
		hibernateTemplate.save(finance);
	}

	public void update(Finance finance) {
		System.out.println(finance.getId());
		hibernateTemplate.update(finance);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}