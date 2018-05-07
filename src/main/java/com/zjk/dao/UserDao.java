package com.zjk.dao;

import com.zjk.entity.UserInfo;

import java.util.ArrayList;

public interface UserDao {

	ArrayList<UserInfo> queryAll();

	boolean insert(UserInfo userInfo);

	UserInfo query(UserInfo userInfo);

	UserInfo queryByUId(int uId);

	boolean update(UserInfo userInfo);
}
