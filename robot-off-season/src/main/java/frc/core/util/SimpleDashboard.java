package frc.core.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public enum SimpleDashboard {
    INSTANCE;
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

}