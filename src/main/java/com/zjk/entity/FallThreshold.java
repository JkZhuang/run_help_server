package com.zjk.entity;

public class FallThreshold {

	private int fTId;
	private double fallThreshold;

	public FallThreshold() {

	}

	public int getfTId() {
		return fTId;
	}

	public void setfTId(int fTId) {
		this.fTId = fTId;
	}

	public double getFallThreshold() {
		return fallThreshold;
	}

	public void setFallThreshold(double fallThreshold) {
		this.fallThreshold = fallThreshold;
	}

	@Override
	public String toString() {
		return "FallThreshold{" +
				"fTId=" + fTId +
				", fallThreshold=" + fallThreshold +
				'}';
	}
}
