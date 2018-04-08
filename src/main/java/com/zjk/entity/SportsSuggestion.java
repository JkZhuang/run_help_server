package com.zjk.entity;

import com.zjk.util.GsonUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SportsSuggestion {

	public int sSId;
	public int uId;  // UserInfo外键
	public int type;

	@DateTimeFormat(pattern = GsonUtil.DATE_PATTEN)
	public Date startTime;
	public long usedTime;

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

	@Override
	public String toString() {
		return "SportsSuggestion{" +
				"sSId=" + sSId +
				", uId=" + uId +
				", type=" + type +
				", startTime=" + startTime +
				", usedTime=" + usedTime +
				'}';
	}
}
