package com.zjk.entity;

public class Feedback {

	private int fbId;
	private int uId; // UserInfo外键
	private String content;
	private String contack;

	public Feedback() {
	}

	public int getFbId() {
		return fbId;
	}

	public void setFbId(int fbId) {
		this.fbId = fbId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContack() {
		return contack;
	}

	public void setContack(String contack) {
		this.contack = contack;
	}

	@Override
	public String toString() {
		return "Feedback{" +
				"fbId=" + fbId +
				", uId=" + uId +
				", content='" + content + '\'' +
				", contack='" + contack + '\'' +
				'}';
	}
}
