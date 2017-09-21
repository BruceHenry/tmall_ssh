package com.tmall.service;

import java.util.List;

import com.tmall.util.Page;

public interface BaseService {
	public Integer save(Object object);

	public void update(Object object);

	public void delete(Object object);

	public Object get(Class clazz, int id);

	public Object get(int id);

	public List list();

	public List listByPage(Page page);

	public int total();

	public List listByParent(Object parent);

	public List list(Page page, Object parent);

	public int total(Object parentObject);
	
	public List list(Object...pairParms);

}
