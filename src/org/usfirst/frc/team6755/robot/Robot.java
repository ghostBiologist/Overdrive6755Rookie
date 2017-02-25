package org.usfirst.frc.team6755.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
	
	Joystick Driver, Secondary;
	Spark L1, R1, CL, CR, SC, FC;
	
	
	DriveCarDrive m_drive;
	DriveDrive drive;
	DriveShooter shooter;
	DriveClimber climber;
	
	public Robot() {
		//Spark Controllers
		L1 = new Spark(0);
		R1 = new Spark(1);
		CL = new Spark(2);
		CR = new Spark(3);
		SC = new Spark(4);
		FC = new Spark(5);
		
		//Joysticks
		Driver = new Joystick(0);
		Secondary = new Joystick(1);
		
		
		//Overdrive drive classes
		drive = new DriveDrive(L1, R1);
		m_drive = new DriveCarDrive(drive);
		climber = new DriveClimber(CL, CR);
		shooter = new DriveShooter(SC, FC);
		
	}

	@Override
	public void robotInit() {
		
	}

	@Override
	public void autonomous() {
		SC.set(1.0f);
	}

	@Override
	public void operatorControl() {
		
		//set shooter to on
		SC.set(1.0f);
		
		while(isEnabled()) {
			m_drive.ArcadeDrive(getLetfY(), getRightX(), true);
			
			if (Secondary.getRawAxis(1) != 0.0f) { //confirm axis value
				climber.setClimberSpeed(1); //test speeds
			} else {
				climber.setClimberSpeed(0);
			}
			
			if (Secondary.getRawButton(1)) {
				shooter.feedBalls(true);	
			} else {
				shooter.feedBalls(false);
			}
		}
	}


	@Override
	public void test() {
		
	}
	
	public double getLetfY() {
		return Driver.getRawAxis(1);
	}
	
	public double getRightX() {
		return Driver.getRawAxis(4);
	}
}
