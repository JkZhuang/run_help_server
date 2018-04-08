package com.zjk.entity;

import com.zjk.util.GsonUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CommentForumInfo {

	private int cFId;
	private int fId; // Forum外键
	private int uId; // UserInfo外键
	private String userName;
	private String content;
	private String photoUrl;

	@DateTimeFormat(pattern = GsonUtil.DATE_PATTEN)
	private Date time;

	public CommentForumInfo() {

	}

	public int getcFId() {
		return cFId;
	}

	public void setcFId(int cFId) {
		this.cFId = cFId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CommentForumInfo{" +
				"cFId=" + cFId +
				", fId=" + fId +
				", uId=" + uId +
				", userName='" + userName + '\'' +
				", content='" + content + '\'' +
				", photoUrl='" + photoUrl + '\'' +
				", time=" + time +
				'}';
	}
}
