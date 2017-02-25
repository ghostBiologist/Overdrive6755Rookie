package org.usfirst.frc.team6755.robot;
import edu.wpi.first.wpilibj.Spark;

public class DriveClimber {
private Spark Sleft, Sright;
	
	public DriveClimber(Spark left, Spark right) {
		Sleft = left;
		Sright = right;
	}
	
	//
	public void setClimberSpeed(double Speed) {
		Sleft.set(Speed);
		Sright.set(Speed);
	}
	
	public void StartClimbing() {
		
	}
	
	public void StopClimbing() {
		
	}
}
