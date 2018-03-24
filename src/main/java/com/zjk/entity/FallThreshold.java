package com.zjk.entity;

public class FallThreshold {

	private double fallThreshold;

	public FallThreshold() {

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
				"fallThreshold=" + fallThreshold +
				'}';
	}
}
