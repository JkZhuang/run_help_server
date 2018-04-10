package com.zjk.entity;

import com.zjk.util.GsonUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

public class ForumInfo {

	private int fId;
	private int uId; // UserInfo外键
	private String headPhotoUrl;
	private String userName;
	private String content;
	private String photoUrl;

	@DateTimeFormat(pattern = GsonUtil.DATE_PATTEN)
	private Date time;
	private ArrayList<CommentForumInfo> cFList; // 评论
	private ArrayList<LikeForumInfo> lFList; // 点赞

	public ForumInfo() {
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

	public String getHeadPhotoUrl() {
		return headPhotoUrl;
	}

	public void setHeadPhotoUrl(String headPhotoUrl) {
		this.headPhotoUrl = headPhotoUrl;
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

	public ArrayList<CommentForumInfo> getcFList() {
		return cFList;
	}

	public void setcFList(ArrayList<CommentForumInfo> cFList) {
		this.cFList = cFList;
	}

	public ArrayList<LikeForumInfo> getlFList() {
		return lFList;
	}

	public void setlFList(ArrayList<LikeForumInfo> lFList) {
		this.lFList = lFList;
	}

	@Override
	public String toString() {
		return "ForumInfo{" +
				"fId=" + fId +
				", uId=" + uId +
				", headPhotoUrl='" + headPhotoUrl + '\'' +
				", userName='" + userName + '\'' +
				", content='" + content + '\'' +
				", photoUrl='" + photoUrl + '\'' +
				", time=" + time +
				", cFList=" + cFList +
				", lFList=" + lFList +
				'}';
	}
}
