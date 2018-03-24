package com.zjk.entity;

public class TrainingSuggestData {

	private int tSDId;
	private int uId; // UserInfo外键
	private double maxWalkSpeed;
	private double maxWalkTime;
	private double maxRunSpeed;
	private double maxRunTime;
	private double maxRidingSpeed;
	private double maxRidingTime;

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

	public double getMaxWalkSpeed() {
		return maxWalkSpeed;
	}

	public void setMaxWalkSpeed(double maxWalkSpeed) {
		this.maxWalkSpeed = maxWalkSpeed;
	}

	public double getMaxWalkTime() {
		return maxWalkTime;
	}

	public void setMaxWalkTime(double maxWalkTime) {
		this.maxWalkTime = maxWalkTime;
	}

	public double getMaxRunSpeed() {
		return maxRunSpeed;
	}

	public void setMaxRunSpeed(double maxRunSpeed) {
		this.maxRunSpeed = maxRunSpeed;
	}

	public double getMaxRunTime() {
		return maxRunTime;
	}

	public void setMaxRunTime(double maxRunTime) {
		this.maxRunTime = maxRunTime;
	}

	public double getMaxRidingSpeed() {
		return maxRidingSpeed;
	}

	public void setMaxRidingSpeed(double maxRidingSpeed) {
		this.maxRidingSpeed = maxRidingSpeed;
	}

	public double getMaxRidingTime() {
		return maxRidingTime;
	}

	public void setMaxRidingTime(double maxRidingTime) {
		this.maxRidingTime = maxRidingTime;
	}

	@Override
	public String toString() {
		return "TrainingSuggestData{" +
				"tSDId=" + tSDId +
				", uId=" + uId +
				", maxWalkSpeed=" + maxWalkSpeed +
				", maxWalkTime=" + maxWalkTime +
				", maxRunSpeed=" + maxRunSpeed +
				", maxRunTime=" + maxRunTime +
				", maxRidingSpeed=" + maxRidingSpeed +
				", maxRidingTime=" + maxRidingTime +
				'}';
	}
}
