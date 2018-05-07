package com.zjk.service;

import com.zjk.entity.UserInfo;

import java.util.ArrayList;

public interface UserService {

	ArrayList<UserInfo> queryAll();

	int insert(UserInfo userInfo);

	UserInfo query(UserInfo userInfo);

	boolean update(UserInfo userInfo);
}
