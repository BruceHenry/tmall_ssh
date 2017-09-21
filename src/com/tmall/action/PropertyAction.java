package com.tmall.action;

import org.apache.struts2.convention.annotation.Action;

import com.tmall.util.Page;

public class PropertyAction extends Action4Result {
	@Action("admin_property_list")
	public String list(){
		if(page==null)
			page=new Page();
		int total =propertyService.total(category);
		page.setTotal(total);
		page.setParam("&category.id="+category.getId());
		propertys=propertyService.list(page,category);
		t2p(category);
		return "listProperty";
	}
	@Action("admin_property_add")
	public String add(){
		propertyService.save(property);
		return "listPropertyPage";	
	}
	@Action("admin_property_delete")
	public String delete(){
		t2p(property);
		propertyService.delete(property);
		return "listPropertyPage";
	}
	@Action("admin_property_edit")
	public String edit(){
		t2p(property);
		return "editProperty";
	}
	@Action("admin_property_update")
	public String update(){
		propertyService.update(property);
		return "listPropertyPage";
	}
	
	
}
