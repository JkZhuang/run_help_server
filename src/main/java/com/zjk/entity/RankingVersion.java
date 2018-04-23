package com.zjk.entity;

import com.zjk.util.GsonUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RankingVersion {

	private int rVId;
	private int uId;  // UserInfo外键
	private String userName;
	private String headUrl;
	private int ranking; // 排名

	@DateTimeFormat(pattern = GsonUtil.DATE_PATTEN)
	private Date time;
	private double distance;

	public RankingVersion() {

	}

	public int getrVId() {
		return rVId;
	}

	public void setrVId(int rVId) {
		this.rVId = rVId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RankingVersion{" +
				"rVId=" + rVId +
				", uId=" + uId +
				", userName='" + userName + '\'' +
				", headUrl='" + headUrl + '\'' +
				", ranking=" + ranking +
				", time=" + time +
				", distance=" + distance +
				'}';
	}
}
