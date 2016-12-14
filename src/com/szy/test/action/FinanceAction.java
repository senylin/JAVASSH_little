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
import com.szy.test.model.Finance;
import com.szy.test.service.FinanceService;

@Component("financeAction")
@Scope("prototype")
public class FinanceAction {

	private Finance finance;
	@Autowired
	private FinanceService financeService;
	
	public String addUI(){
		return "addUI";
	}
	public String add(){
		financeService.add(finance);
		return "add";
	}
	public String updateP() {
		finance = financeService.getFinanceById(finance.getId());
	//	System.out.println(Finance.getFinanceid());
		return "updateP";
	}
	
	public String update() {
		//System.out.println(Finance.getFinanceid());
		financeService.update(finance);
		return "update";
	}
	public String delete() {
		financeService.delete(finance);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String list() {
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", financeService.getAllFinances());
		return "list";
	}
	
	public String download() {
		return "download";
	}

	public Finance getFinance() {
		return finance;
	}
	public void setFinance(Finance finance) {
		this.finance = finance;
	}



	public InputStream getDownloadFile() {
		return financeService.getInputStream();
	}

	

}
