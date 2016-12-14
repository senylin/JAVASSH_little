package com.szy.test.action;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szy.test.model.Medicine;
import com.szy.test.service.MedicineService;

@Component("medicineAction")
@Scope("prototype")
public class MedicineAction {

	private Medicine medicine;
	@Autowired
	private MedicineService medicineService;
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		medicineService.add(medicine);
		return "add";
	}
	public String updateP() {
		medicine = medicineService.getMedicineById(medicine.getId());
	//	System.out.println(Medicine.getMedicineid());
		return "updateP";
	}
	
	public String update() {
		//System.out.println(Medicine.getMedicineid());
		medicineService.update(medicine);
		return "update";
	}
	public String delete() {
		medicineService.delete(medicine);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String list() {
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", medicineService.getAllMedicines());
		return "list";
	}
	
	public String download() {
		return "download";
	}

	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}



	public InputStream getDownloadFile() {
		return medicineService.getInputStream();
	}

	

}
