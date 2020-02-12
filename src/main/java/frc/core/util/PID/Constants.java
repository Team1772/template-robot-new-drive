package frc.core.util.PID;

import frc.core.util.SimpleDashboard;

public class Constants {
	
    public static final int kSlotIdxOne = 0;
    public static final int kSlotIdxTwo = 0;

    public static final int kPIDLoopIdxOne = 0;
    public static final int kPIDLoopIdxTwo = 0;

    public static final int kPIDLoopIdx = 0;

    public static final int kTimeoutMsOne = 30;
    public static final int kTimeoutMsTwo = 0;

    public static final int kTimeoutMs = 30;

    
    public static boolean kSensorPhaseOne = SimpleDashboard.getInstance().getBoolean("kSensorPhase", true);
    public static boolean kSensorPhaseTwo = true;

    public static boolean kSensorPhase = false;


    public static boolean kMotorInvertOne = SimpleDashboard.getInstance().getBoolean("kMotorInvert", true);;
    public static boolean kMotorInvertTwo = false;

    public static int nominalOutputForwardValue = 0;
    public static int nominalOutputReverseValue = 0;
    public static int peakOutputForwardValue = 1;
    public static int peakOutputReverseValue = -1;

    
    public static final Gains kGains = new Gains(
        SimpleDashboard.getInstance().getNumber("kP", 0), 
        SimpleDashboard.getInstance().getNumber("kI",0),
        SimpleDashboard.getInstance().getNumber("kD", 10), 
        SimpleDashboard.getInstance().getNumber("kF", 1023.0/7200.0),
        SimpleDashboard.getInstance().getDeviceID("kIzone", 300), 
        SimpleDashboard.getInstance().getNumber("kPeakOutput", 1.00)
    );
    static final Gains kGainsTwo = new Gains(0.6, 0.0, 6.0, 0.0, 0, 1.0);

}