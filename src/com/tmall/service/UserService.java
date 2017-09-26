package com.tmall.service;

import com.tmall.pojo.User;

public interface UserService extends BaseService {
	boolean isExist(String name);

	User get(String name, String password);
}
