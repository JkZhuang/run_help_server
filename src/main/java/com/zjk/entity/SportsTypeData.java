package com.zjk.entity;

public class SportsTypeData {

	private int uId;
	private int type;
	private int times; // 运动了几次
	private double averDistance;
	private long averUsedTime;

	public SportsTypeData() {
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

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public double getAverDistance() {
		return averDistance;
	}

	public void setAverDistance(double averDistance) {
		this.averDistance = averDistance;
	}

	public long getAverUsedTime() {
		return averUsedTime;
	}

	public void setAverUsedTime(long averUsedTime) {
		this.averUsedTime = averUsedTime;
	}

	@Override
	public String toString() {
		return "SportsTypeData{" +
				"uId=" + uId +
				", type=" + type +
				", times=" + times +
				", averDistance=" + averDistance +
				", averUsedTime=" + averUsedTime +
				'}';
	}
}
