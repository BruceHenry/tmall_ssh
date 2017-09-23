package com.tmall.action;

import org.apache.struts2.convention.annotation.Action;

import com.tmall.util.Page;

public class UserAction extends Action4Result {
	@Action("admin_user_list")
	public String list(){
		if(page==null)
			page = new Page();
		int total =userService.total();
		page.setTotal(total);
		users =userService.listByPage(page);
		return "listUser";
		
	}
}
