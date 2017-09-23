package com.tmall.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAnonymousName(){
		if(null==name)
			return null;
		if(name.length()<=1)
			return "*";
		if(name.length()==2)
			return name.substring(0, 1)+"*";
		char [] cs =name.toCharArray();
		for(int i=1;i<cs.length-1;i++){
			cs[i]='*';
		}
		return new String(cs);
	}
	
	
	
}
