package com.zjk.entity;

import java.util.Date;

public class SportsGranularityData {

	private int sGDId;
	private int sDId; // SportsData外键
	private int type;
	private Date time;
	private double speed; // 瞬时速度
	private double longitude; // 经度
	private double latitude; // 纬度

	public SportsGranularityData() {

	}

	public int getsGDId() {
		return sGDId;
	}

	public void setsGDId(int sGDId) {
		this.sGDId = sGDId;
	}

	public int getsDId() {
		return sDId;
	}

	public void setsDId(int sDId) {
		this.sDId = sDId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "SportsGranularityData{" +
				"sGDId=" + sGDId +
				", sDId=" + sDId +
				", type=" + type +
				", time=" + time +
				", speed=" + speed +
				", longitude=" + longitude +
				", latitude=" + latitude +
				'}';
	}
}
