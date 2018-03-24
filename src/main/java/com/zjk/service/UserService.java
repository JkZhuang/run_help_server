package com.zjk.service;

import com.zjk.entity.UserInfo;

public interface UserService {

	int insert(UserInfo userInfo);

	UserInfo query(UserInfo userInfo);

	boolean update(UserInfo userInfo);
}
