package org.usfirst.frc.team6755.robot;

import edu.wpi.first.wpilibj.Spark;

public class DriveShooter {
	private Spark shooter, feeder;
	public DriveShooter(Spark shooter, Spark feeder) {
		this.shooter = shooter;
		this.feeder = feeder;
	}
	public void feedBalls(boolean on){
		if(on) {
			//turn motor on
			feeder.set(1); //test speeds
		} else {
			//turn motor off
			feeder.set(0);
		}
	}
}
