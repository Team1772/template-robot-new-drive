package frc.core.util;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SimpleDashboard {
	
	public int getDeviceID(String name, double defaultValue) {
		SmartDashboard.putNumber(name, defaultValue);

		return (int) SmartDashboard.getNumber(name, defaultValue);
	}

	public double getNumber(String name, double defaultValue) {
		SmartDashboard.putNumber(name, defaultValue); 

		return SmartDashboard.getNumber(name, defaultValue);
	}
	
    public boolean getBoolean(String name, boolean defaultValue) {
		SmartDashboard.putBoolean(name, defaultValue); 

		return SmartDashboard.getBoolean(name, defaultValue);
	}

	public Sendable getOjbect(String name, Sendable defaultValue){
		SmartDashboard.putData("Auto choices", defaultValue);

		return SmartDashboard.getData(name);
	}
	
	private static SimpleDashboard instance;
	public static SimpleDashboard getInstance() {
		if(instance == null)
			instance = new SimpleDashboard();

		return instance;
	}

}