package com.zjk.entity;

import com.zjk.util.GsonUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserInfo {

	private int uId;
	private String phone;
	private String password;
	private String userName;
	private String headUrl;
	private int height; // 身高(cm)
	private int weight; // 体重(kg)

	@DateTimeFormat(pattern = GsonUtil.DATE_PATTEN)
	private Date birthday; // 生日
	private int gender; // 性别 0-男,1-女，2-保密
	private String urgentPhone; // 紧急联系人

	public UserInfo() {

	}

	public UserInfo(String phone, String password, String userName, String headUrl, int height,
	                int weight, Date birthday, int gender, String urgentPhone) {
		this.phone = phone;
		this.password = password;
		this.userName = userName;
		this.headUrl = headUrl;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.gender = gender;
		this.urgentPhone = urgentPhone;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUrgentPhone() {
		return urgentPhone;
	}

	public void setUrgentPhone(String urgentPhone) {
		this.urgentPhone = urgentPhone;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"uId=" + uId +
				", phone='" + phone + '\'' +
				", password='" + password + '\'' +
				", userName='" + userName + '\'' +
				", headUrl='" + headUrl + '\'' +
				", height=" + height +
				", weight=" + weight +
				", birthday=" + birthday +
				", gender=" + gender +
				", urgentPhone='" + urgentPhone + '\'' +
				'}';
	}
}
