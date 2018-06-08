package com.haoli.domain;

public class Displacement {
	private double dx;
	private double dy;
	private double dz;
	

	
	public Displacement() {
		this.dx = 0;
		this.dy = 0;
		this.dz = 0;
	}
	
	
	public Displacement(double[] displacement) {
		dx = displacement[0];
		dy = displacement[1];
		dz = displacement[2];
	}
	
	public Displacement(double dx, double dy, double dz) {
		this.dx = dx;
		this.dy = dy;
		this.dz = dz;
	}


	public double getDx() {
		return dx;
	}


	public void setDx(double dx) {
		this.dx = dx;
	}


	public double getDy() {
		return dy;
	}


	public void setDy(double dy) {
		this.dy = dy;
	}


	public double getDz() {
		return dz;
	}


	public void setDz(double dz) {
		this.dz = dz;
	}
}
