package frc.core.util.PID;

import frc.core.util.SimpleDashboard;

public class Constants {
	
    public static final int kSlotIdxOne = 0;
    public static final int kSlotIdxTwo = 0;

    public static final int kPIDLoopIdxOne = 0;
    public static final int kPIDLoopIdxTwo = 0;

    public static final int kTimeoutMsOne = 30;
    public static final int kTimeoutMsTwo = 0;

    
    public static boolean kSensorPhaseOne = SimpleDashboard.INSTANCE.getBoolean("kSensorPhase", true);
    public static boolean kSensorPhaseTwo = true;


    public static boolean kMotorInvertOne = SimpleDashboard.INSTANCE.getBoolean("kMotorInvert", true);;
    public static boolean kMotorInvertTwo = false;

    
    static final Gains kGainsOne = new Gains(
        SimpleDashboard.INSTANCE.getNumber("kP", 0.2), 
        SimpleDashboard.INSTANCE.getNumber("kI",0.0),
        SimpleDashboard.INSTANCE.getNumber("kD", 2.5), 
        SimpleDashboard.INSTANCE.getNumber("kF", 0.0),
        SimpleDashboard.INSTANCE.getDeviceID("kIzone", 0), 
        SimpleDashboard.INSTANCE.getNumber("kPeakOutput", 1.0)
    );
    static final Gains kGainsTwo = new Gains(0.6, 0.0, 6.0, 0.0, 0, 1.0);

}