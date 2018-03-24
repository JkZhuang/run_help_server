package com.zjk.entity;

import java.util.Date;

public class LikeForumInfo {

	private int lFId;
	private int fId; // Forum外键
	private int uId; // UserInfo外键
	private String userName;
	private Date time;

	public LikeForumInfo() {

	}

	public int getlFId() {
		return lFId;
	}

	public void setlFId(int lFId) {
		this.lFId = lFId;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "LikeForumInfo{" +
				"lFId=" + lFId +
				", fId=" + fId +
				", uId=" + uId +
				", userName='" + userName + '\'' +
				", time=" + time +
				'}';
	}
}
