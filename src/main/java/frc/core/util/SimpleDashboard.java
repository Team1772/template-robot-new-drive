package frc.core.util;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SimpleDashboard {
	
	public int getDeviceID(String name, double defaultValue) {
		SmartDashboard.putNumber(name, SmartDashboard.getNumber(name, defaultValue));
		return (int) SmartDashboard.getNumber(name, defaultValue);
	}

	public double getNumber(String name, double defaultValue) {
		SmartDashboard.putNumber(name, SmartDashboard.getNumber(name, defaultValue)); 
		return SmartDashboard.getNumber(name, defaultValue);
	}
	
    public Boolean getBoolean(String name, Boolean defaultValue) {
		SmartDashboard.putBoolean(name, SmartDashboard.getBoolean(name, defaultValue)); 
		return SmartDashboard.getBoolean(name, defaultValue);
	}
	
	private static SimpleDashboard instance;
	public static SimpleDashboard getInstance() {
		if(instance == null)
			instance = new SimpleDashboard();

		return instance;
	}

}