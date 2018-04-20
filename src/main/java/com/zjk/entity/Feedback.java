package com.zjk.entity;

public class Feedback {

	private int fbId;
	private int uId; // UserInfo外键
	private String content;
	private String contact;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Feedback{" +
				"fbId=" + fbId +
				", uId=" + uId +
				", content='" + content + '\'' +
				", contact='" + contact + '\'' +
				'}';
	}
}
