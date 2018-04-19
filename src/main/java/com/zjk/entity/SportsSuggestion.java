package com.zjk.entity;

import com.zjk.util.GsonUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SportsSuggestion {

	private int sSId;
	private int uId;  // UserInfo外键
	private int type;

	@DateTimeFormat(pattern = GsonUtil.DATE_PATTEN)
	private Date startTime;
	private long usedTime;
	private double distance; // 运动路程

	public SportsSuggestion() {

	}

	public int getsSId() {
		return sSId;
	}

	public void setsSId(int sSId) {
		this.sSId = sSId;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public long getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(long usedTime) {
		this.usedTime = usedTime;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "SportsSuggestion{" +
				"sSId=" + sSId +
				", uId=" + uId +
				", type=" + type +
				", startTime=" + startTime +
				", usedTime=" + usedTime +
				", distance=" + distance +
				'}';
	}
}
