package com.zjk.entity;

/**
 * 统计用户运动的总数据以及平均值等
 */
public class SportsStatisticsData {

	private int sSDId;
	private int uId;
	private int type;
	/**
	 * 周日 1
	 * 周一 2
	 * .
	 * .
	 * .
	 * 周六 7
	 */
	private int day;
	private int times; // 运动了几次
	private double averDistance;
	private long averUsedTime;

	public SportsStatisticsData() {

	}

	public int getsSDId() {
		return sSDId;
	}

	public void setsSDId(int sSDId) {
		this.sSDId = sSDId;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
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
		return "SportsStatisticsData{" +
				"sSDId=" + sSDId +
				", uId=" + uId +
				", type=" + type +
				", day=" + day +
				", times=" + times +
				", averDistance=" + averDistance +
				", averUsedTime=" + averUsedTime +
				'}';
	}
}
