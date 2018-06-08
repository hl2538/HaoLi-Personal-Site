package com.haoli.domain;

public class Accelerometer {
	
	private double ax;
	private double ay;
	private double az;
	

	
	public Accelerometer() {
		this.ax = 0;
		this.ay = 0;
		this.az = 0;
	}
	
	
	public Accelerometer(double[] accel) {
		ax = accel[0];
		ay = accel[1];
		az = accel[2];
	}
	
	public Accelerometer(double ax, double ay, double az) {
		this.ax = ax;
		this.ay = ay;
		this.az = az;
	}
	
	
	public double getAx() {
		return ax;
	}

	public void setAx(double ax) {
		this.ax = ax;
	}

	public double getAy() {
		return ay;
	}

	public void setAy(double ay) {
		this.ay = ay;
	}

	public double getAz() {
		return az;
	}

	public void setAz(double az) {
		this.az = az;
	}

}
