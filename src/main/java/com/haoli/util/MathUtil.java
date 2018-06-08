package com.haoli.util;

import java.util.ArrayList;
import java.util.List;

import com.haoli.domain.Accelerometer;
import com.haoli.domain.Displacement;
import com.haoli.domain.Gyroscope;
import com.haoli.domain.Velocity;

public class MathUtil {
	

	
	List<Accelerometer> accelerometer;
	List<Gyroscope> gyro ;
	List<Velocity> velocity ;
	List<Displacement> displacement;
	int indexAccel ;
	int indexVelocity ;
	int indexGyro ;
	int indexDis ;
	double time;
	
	public MathUtil(double time) {

		accelerometer = new ArrayList<Accelerometer>();
		gyro = new ArrayList<Gyroscope>();
		velocity = new ArrayList<Velocity>();
		displacement = new ArrayList<Displacement>();
		indexAccel = 0;
		indexVelocity = 0;
		indexGyro = 0;
		indexDis = 0;
		this.time = time;
		
		Accelerometer a = new Accelerometer();
		a.setAx(0);
		a.setAy(0);
		a.setAz(0);
		
		Gyroscope g = new Gyroscope();
		g.setGx(0);
		g.setGy(0);
		g.setGz(0);
		
		Velocity v = new Velocity();
		v.setVx(0);
		v.setVy(0);
		v.setVz(0);
		
		Displacement d = new Displacement();
		d.setDx(0);
		d.setDy(0);
		d.setDz(0);
		
		accelerometer.add(a);
		gyro.add(g);
		velocity.add(v);
		displacement.add(d);
		
		
	}
	
	
	
	public Velocity computeVelocity(Accelerometer accel) {
		Accelerometer formerAccel = accelerometer.get(indexAccel);
		Velocity formerVelocity = velocity.get(indexVelocity);
		double formerAx = formerAccel.getAx();
		double formerAy = formerAccel.getAy();
		double formerAz = formerAccel.getAz();
		double formerVx = formerVelocity.getVx();
		double formerVy = formerVelocity.getVy();
		double formerVz = formerVelocity.getVz();
		double ax = accel.getAx();
		double ay = accel.getAy();
		double az = accel.getAz();
		
		double vx = computeSingleV(formerAx, formerVx, ax);
		double vy = computeSingleV(formerAy, formerVy, ay);
		double vz = computeSingleV(formerAz, formerVz, az);

		Velocity velocityNow = new Velocity();
		velocityNow.setVx(vx);
		velocityNow.setVy(vy);
		velocityNow.setVz(vz);
		velocity.add(velocityNow);
		indexVelocity++;
		return velocityNow;

	}
	
	public double computeSingleV(double formerA, double formerV, double a) {
		double v = formerV + (a + formerA)*time;
		return v;
	}
	
	public Displacement computeDisplacement(Accelerometer accel) {
		Accelerometer formerAccel = accelerometer.get(indexAccel);
		Velocity formerVelocity = velocity.get(indexVelocity);
		Displacement formerDisplacement = displacement.get(indexDis);
		double formerAx = formerAccel.getAx();
		double formerAy = formerAccel.getAy();
		double formerAz = formerAccel.getAz();
		double formerVx = formerVelocity.getVx();
		double formerVy = formerVelocity.getVy();
		double formerVz = formerVelocity.getVz();
		double formerDx = formerDisplacement.getDx();
		double formerDy = formerDisplacement.getDy();
		double formerDz = formerDisplacement.getDz();

		double ax = accel.getAx();
		double ay = accel.getAy();
		double az = accel.getAz();
		
		double dx = computeSingleD(formerDx,formerAx, formerVx, ax);
		double dy = computeSingleD(formerDy, formerAy, formerVy, ay);
		double dz = computeSingleD(formerDz, formerAz, formerVz, az);
		
		Displacement disNow = new Displacement();
		disNow.setDx(dx);
		disNow.setDy(dy);
		disNow.setDz(dz);
		
		displacement.add(disNow);
		indexDis++;
		
		return disNow;
	}
	
	public double computeSingleD(double formerD, double formerA, double formerV, double a) {
		double d = formerD+formerV*time+0.25*time*(a + formerA);
		return d;
	}

	public List<Accelerometer> getAccelerometer() {
		return accelerometer;
	}

	public void setAccelerometer(List<Accelerometer> accelerometer) {
		this.accelerometer = accelerometer;
	}

	public List<Gyroscope> getGyro() {
		return gyro;
	}

	public void setGyro(List<Gyroscope> gyro) {
		this.gyro = gyro;
	}

	public List<Velocity> getVelocity() {
		return velocity;
	}

	public void setVelocity(List<Velocity> velocity) {
		this.velocity = velocity;
	}

	public List<Displacement> getDisplacement() {
		return displacement;
	}

	public void setDisplacement(List<Displacement> displacement) {
		this.displacement = displacement;
	}

	public int getIndexAccel() {
		return indexAccel;
	}

	public void setIndexAccel(int indexAccel) {
		this.indexAccel = indexAccel;
	}

	public int getIndexVelocity() {
		return indexVelocity;
	}

	public void setIndexVelocity(int indexVelocity) {
		this.indexVelocity = indexVelocity;
	}

	public int getIndexGyro() {
		return indexGyro;
	}

	public void setIndexGyro(int indexGyro) {
		this.indexGyro = indexGyro;
	}

	public int getIndexDis() {
		return indexDis;
	}

	public void setIndexDis(int indexDis) {
		this.indexDis = indexDis;
	}



	public double getTime() {
		return time;
	}



	public void setTime(double time) {
		this.time = time;
	}


	
	

}
