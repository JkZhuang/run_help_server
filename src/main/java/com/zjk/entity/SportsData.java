package com.zjk.entity;

import java.util.ArrayList;
import java.util.Date;

public class SportsData {

	private int sDId;
	private int uId; // UserInfo外键
	private int type; // 0-行走；1-跑步；2-骑行
	private long usedTime; // 花费时间
	private Date startTime; // 开始时间
	private Date endTime; // 结束时间
	private double distance; // 运动路程
	private double maxSpeed; // 最大速度
	private ArrayList<SportsGranularityData> rGDList;

	public SportsData() {
	}

	public int getsDId() {
		return sDId;
	}

	public void setsDId(int sDId) {
		this.sDId = sDId;
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

	public long getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(long usedTime) {
		this.usedTime = usedTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public ArrayList<SportsGranularityData> getrGDList() {
		return rGDList;
	}

	public void setrGDList(ArrayList<SportsGranularityData> rGDList) {
		this.rGDList = rGDList;
	}

	@Override
	public String toString() {
		return "SportsData{" +
				"sDId=" + sDId +
				", uId=" + uId +
				", type=" + type +
				", usedTime=" + usedTime +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", distance=" + distance +
				", maxSpeed=" + maxSpeed +
				", rGDList=" + rGDList +
				'}';
	}
}
