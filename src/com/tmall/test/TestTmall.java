package com.tmall.test;

import java.util.List;
import java.util.Random;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmall.dao.impl.DAOImpl;
import com.tmall.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTmall {
	@Autowired
	DAOImpl dao;
	
	// @Test
	    public void delete() {
	        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
	        List<Category> cs = dao.findByCriteria(dc);
	        for (Category c : cs) {
	            dao.delete(c);
	        }
	    }
	 
	 //   @Test
	    public void test() {
	        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
	        List<Category> cs = dao.findByCriteria(dc);
	        if (cs.isEmpty()) {
	            for (int i = 0; i < 10; i++) {
	                Category c = new Category();
	                c.setName("测试分类" + (i + 1));
	                dao.save(c);
	            }
	            System.out.println("成功添加10个测试分类");
	        }
	    }
	   // @Test
	    public void Bubblesort(){
	    	Random random =new Random();
	    	int []a=new int [100]; 
	    	for(int i=0;i<100;i++){
	    		a[i]=random.nextInt(100);
	    	}
	    	for(int i=1;i<100;i++)
	    		for(int j=0;j<100-i;j++)
	    		{
	    			if(a[j]<a[j+1]){
	    				int temp= a[j];
	    				a[j]=a[j+1];
	    				a[j+1]=temp;
	    			}
	    		}
	    	for(int i:a)
	    		System.out.print(i+" ");
	    }
}
