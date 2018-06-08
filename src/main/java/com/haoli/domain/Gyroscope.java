package com.haoli.domain;

public class Gyroscope {
	private double gx;
	private double gy;
	private double gz;
	

	
	public Gyroscope() {
		this.gx = 0;
		this.gy = 0;
		this.gz = 0;
	}
	
	
	public Gyroscope(double[] accel) {
		gx = accel[0];
		gy = accel[1];
		gz = accel[2];
	}
	
	public Gyroscope(double gx, double gy, double gz) {
		this.gx = gx;
		this.gy = gy;
		this.gz = gz;
	}

	public double getGx() {
		return gx;
	}

	public void setGx(double gx) {
		this.gx = gx;
	}

	public double getGy() {
		return gy;
	}

	public void setGy(double gy) {
		this.gy = gy;
	}

	public double getGz() {
		return gz;
	}

	public void setGz(double gz) {
		this.gz = gz;
	}
	
	
}
