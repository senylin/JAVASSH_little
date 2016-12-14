package com.szy.test.action;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.szy.test.model.Userinfo;
import com.szy.test.service.UserinfoService;
import com.szy.test.model.Student;
import com.szy.test.service.StudentService;

@Component("userinfoAction")
@Scope("prototype")
public class UserinfoAction {
	
	private Userinfo userinfo;
	private UserinfoService userinfoService;
	private Student student;
	private StudentService studentService;
	
	
	public String loginUI(){
		return "loginUI";
	}
	
	public String login(){

		int a= userinfoService.login(userinfo);
		if(a==1){
			List<Userinfo> uis = userinfoService.getUserByName(userinfo.getName());
			userinfo = uis.get(0);
			ActionContext.getContext().getSession().put("userinfo", userinfo);

			return "login";
		}
		return "loginUI";
	}
	public String loginCherk(){
		Userinfo userinfo = (Userinfo)ActionContext.getContext().getSession().get("userinfo");
		if(userinfo.equals(null))
		return "loginUI";
		
		return "";
	}
	public String logout(){
		ActionContext.getContext().getSession().put("userinfo", null);
		ActionContext.getContext().getSession().put("msg", "退出成功");
		return "loginUI";
	}
	public String addUI() {
		return "addUI";
	}
	
	public String add() {
		userinfoService.add(userinfo);
		ActionContext.getContext().getSession().put("msg", "注册成功");
		return "add";
	}
	
	public String updateP() {
		userinfo = userinfoService.getUserById(userinfo.getId());
		return "updateP";
	}
	
	public String update() {
		userinfoService.update(userinfo);
		return "update";
	}
	
	public String delete() {
		userinfoService.delete(userinfo);
		return "delete";
	}
	
	@SuppressWarnings("unchecked")
	public String list2() {
		
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list2", userinfoService.getAllUsers());
		return "list2";
	}
	
	public String download() {
		return "download";
	}
	
	public InputStream getDownloadFile() {
		return userinfoService.getInputStream();
	}
	
	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}


	public UserinfoService getUserinfoService() {
		return userinfoService;
	}


	@Resource
	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	
}
