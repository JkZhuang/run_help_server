package com.zjk.dao;

import com.zjk.entity.UserInfo;

public interface UserDao {

	boolean insert(UserInfo userInfo);

	UserInfo query(UserInfo userInfo);

	UserInfo queryByUId(int uId);

	boolean update(UserInfo userInfo);
}
