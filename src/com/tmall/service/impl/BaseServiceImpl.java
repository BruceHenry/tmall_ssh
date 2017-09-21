package com.tmall.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall.dao.impl.DAOImpl;
import com.tmall.pojo.Category;
import com.tmall.pojo.Product;
import com.tmall.service.BaseService;
import com.tmall.util.Page;

@Service
public class BaseServiceImpl extends ServiceDelegateDAO implements BaseService {

	@Autowired
	DAOImpl dao;
	protected Class clazz;
	public static void main(String[] args){
		new CategoryServiceImpl().showClass();
	}
	public void showClass(){
		System.out.println(clazz);
	}
	public BaseServiceImpl(){
		
		try {
			throw new Exception();
		} catch (Exception e) {
			StackTraceElement stes[] =e.getStackTrace();
			String serviceImpleClassName =stes[1].getClassName();
			 try {
	                Class  serviceImplClazz= Class.forName(serviceImpleClassName);
	                String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
	                String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
	                String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
	                String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
	                clazz=Class.forName(pojoFullName);
	            } catch (ClassNotFoundException e1) {
	                e1.printStackTrace();
	            }
		}
	}

	@Override
	public Integer save(Object object) {
		return (Integer) super.save(object);
	}

//  因为继承了ServiceDelegateDAO，所以就继承了update和delete方法
//	@Override
//	public void update(Object object) {
//		dao.update(object);
//
//	}
//
//	@Override
//	public void delete(Object object) {
//		dao.delete(object);
//
//	}

	@Override
	public Object get(Class clazz, int id) {
		return super.get(clazz, id);
	}

	@Override
	public Object get(int id) {
		return super.get(clazz, id);
	}

	@Override
	public List list() {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}

	@Override
	public List listByPage(Page page) {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc, page.getStart(), page.getCount());
	}

	@Override
	public int total() {
		String hql = "select count(*) from " + clazz.getName();
		List<Long> l = dao.find(hql);
		if (l.isEmpty())
			return 0;
		Long result = l.get(0);
		return result.intValue();

	}
	@Override
	public List listByParent(Object parent) {
		String parentName =parent.getClass().getSimpleName();
		String parentNameWithFirstLetterLower =StringUtils.uncapitalize(parentName);
		DetachedCriteria dc  =DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}
	@Override
	public List list(Page page, Object parent) {
		String parentName =parent.getClass().getSimpleName();
		String parentNameWithFirstLetterLower =StringUtils.uncapitalize(parentName);
		DetachedCriteria dc  =DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(parentNameWithFirstLetterLower, parent));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc, page.getStart(), page.getCount());
	}
	@Override
	public int total(Object parentObject) {
		String parentName =parentObject.getClass().getSimpleName();
		String parentNameWithFirstLetterLower =StringUtils.uncapitalize(parentName);
		
		String sqlFormat ="select count(*) from %s bean where bean.%s= ?";
		String hql = String.format(sqlFormat, clazz.getName(),parentNameWithFirstLetterLower);
		
		List<Long> l =this.find(hql,parentObject);
		if(l.isEmpty())
			return 0;
		Long result =l.get(0);
		return result.intValue();
	}
	@Override
	public List list(Object... pairParms) {
		HashMap<String,Object> m =new HashMap<>();
		for(int i=0;i<pairParms.length;i=i+2)
			m.put(pairParms[i].toString(), pairParms[i+1]);
		DetachedCriteria dc =DetachedCriteria.forClass(clazz);
		
		Set<String>ks =m.keySet();
		for(String key:ks){
			if(null==m.get(key))
				dc.add(Restrictions.isNull(key));
			else
				dc.add(Restrictions.eq(key, m.get(key)));
		}
		dc.addOrder(Order.desc("id"));
		return this.findByCriteria(dc);
	}
	
	
	
	
	

}
