package com.haoli.domain;

public class Velocity {
	
	private double vx;
	private double vy;
	private double vz;
	
	public Velocity() {
		this.vx = 0;
		this.vy = 0;
		this.vz = 0;
	}
	
	public Velocity(double[] v) {
		this.vx = v[0];
		this.vy = v[1];
		this.vz = v[2];
	}
	
	public Velocity(double vx, double vy, double vz) {
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public double getVz() {
		return vz;
	}

	public void setVz(double vz) {
		this.vz = vz;
	}

}
