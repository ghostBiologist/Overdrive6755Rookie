package org.usfirst.frc.team6755.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

class DriveDrive {
	
	private Spark Sleft, Sright;
	
	public DriveDrive(Spark left, Spark right) {
		Sleft = left;
		Sright = right;
	}
	
	public void setSparkSpeed(double rightSpeed, double leftSpeed) {
		Sleft.set(rightSpeed);
		Sright.set(leftSpeed);
	}
	
}
