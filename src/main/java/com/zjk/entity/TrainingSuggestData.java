package com.zjk.entity;

public class TrainingSuggestData {

	private int tSDId;
	private int uId; // UserInfo外键
	private int type;
	private double maxSpeed;
	private double maxTime;

	public TrainingSuggestData() {

	}

	public int gettSDId() {
		return tSDId;
	}

	public void settSDId(int tSDId) {
		this.tSDId = tSDId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(double maxTime) {
		this.maxTime = maxTime;
	}

	@Override
	public String toString() {
		return "TrainingSuggestData{" +
				"tSDId=" + tSDId +
				", uId=" + uId +
				", type=" + type +
				", maxSpeed=" + maxSpeed +
				", maxTime=" + maxTime +
				'}';
	}
}
