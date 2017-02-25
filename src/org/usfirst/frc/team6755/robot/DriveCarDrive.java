package org.usfirst.frc.team6755.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveCarDrive {

	    private DriveDrive m_jagDrive;

	    public DriveCarDrive(DriveDrive jagDrive) {
	        m_jagDrive = jagDrive;
	    }
	    public double getStickY(Joystick stick){
	        double x = -stick.getY();
	        if(Math.abs(x) > 0.5){
	            x = Math.abs(x)/x;
	        }
	        return x;
	    }

	    public void wait(double t){
	        long startTime = System.currentTimeMillis();
	        while((System.currentTimeMillis() - startTime) / 1000.0 < t){
	            
	        }
	    }

	    //Converted Arcade Drive to Car Drive
	    public void ArcadeDrive(double LeftY, double RightX, boolean squaredInputs) {

	        double leftMotorSpeed;
	        double rightMotorSpeed;

	        // get negative of the stick controls. forward on stick gives negative value  
	        double stickX = RightX;
	        double stickY = LeftY;

	        // adjust joystick by dead zone
	        if (Math.abs(stickX) <= 0.2 && (Math.abs(stickY)) <= 0.2) {
	            stickX = 0.0;
	            stickY = 0.0;
	        }
	       

	        // make sure X and Y don't go beyond the limits of -1 to 1
	        if(Math.abs(stickX) > 1.0){
	        	stickX = Math.abs(stickX)/stickX;
	        }
	        if(Math.abs(stickY) > 1.0){
	        	stickY = Math.abs(stickY)/stickY;
	        }

	        // square the inputs to produce an exponential power curve
	        // this allows finer control with joystick movement and full power as you approach joystick limits
	        if (squaredInputs) {
	            if (stickX >= 0.0) {
	                stickX = (stickX * stickX);
	            } else {
	                stickX = -(stickX * stickX);
	            }

	            if (stickY >= 0.0) {
	                stickY = (stickY * stickY);
	            } else {
	                stickY = -(stickY * stickY);
	            }
	        }

	        if(Math.abs(stickY) < 0.1){
	            leftMotorSpeed = stickX*0.5;
	            rightMotorSpeed = -0.5*stickX;
	        }
	        else if (stickY > 0.0) {
	            if (stickX > 0.0) {
	            	leftMotorSpeed = stickY * (1-stickX);
	                rightMotorSpeed = stickY;
	            } else {
	            	leftMotorSpeed = stickY;
	                rightMotorSpeed = stickY * ( 1 + stickX );
	                
	            }
	        } else {
	            if (stickX > 0.0) {
	            	leftMotorSpeed = stickY * (1-stickX);
	                rightMotorSpeed = stickY;
	            } else {
	            	leftMotorSpeed = stickY;
	                rightMotorSpeed = stickY * (1+stickX);
	                
	            }
	        }
	        m_jagDrive.setSparkSpeed(rightMotorSpeed, leftMotorSpeed);

	    }
	    
	}
