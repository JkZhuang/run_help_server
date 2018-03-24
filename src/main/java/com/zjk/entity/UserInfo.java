package com.zjk.entity;

public class UserInfo {

	private int uId;
	private String phone;
	private String password;
	private String userName;
	private String headUrl;
	private int height; // 身高(cm)
	private int weight; // 体重(kg)
	private int age; // 年龄
	private int gender; // 性别 0-男,1-女，2-保密
	private String urgentPhone; // 紧急联系人

	public UserInfo() {

	}

	public UserInfo(String phone, String password, String userName, String headUrl, int height,
	                int weight, int age, int gender, String urgentPhone) {
		this.phone = phone;
		this.password = password;
		this.userName = userName;
		this.headUrl = headUrl;
		this.height = height;
		this.weight = weight;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
				", age=" + age +
				", gender=" + gender +
				", urgentPhone='" + urgentPhone + '\'' +
				'}';
	}
}
