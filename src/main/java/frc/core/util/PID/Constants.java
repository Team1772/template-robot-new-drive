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

    public static double kDriveStraightP = 1;
    public static double kDriveStraightI = 1;
    public static double kDriveStraightD = 1;

    public static double kTurnToAngleP = 0;
    public static double kTurnToAngleI = 0;
    public static double kTurnToAngleD = 0;

    // public static double kLimelightP = -0.1;
    public static double kLimelightP = -0.1;
    public static double kLimelightMinCommand = 0.095;

    public static final double kTurnToleranceDeg = 5;
    public static final double kTurnRateToleranceDegPerS = 10; 

    public static double driveStraightTolerance = 0.01;
    
    public static double wheelSizeCM = 15.24;

    public static int pipeline = 0;

    public static final Gains kGains = new Gains(
        SimpleDashboard.getInstance().getNumber("kP", 1E-06), 
        SimpleDashboard.getInstance().getNumber("kI", 0.0001), 
        SimpleDashboard.getInstance().getNumber("kD", 0.1), 
        SimpleDashboard.getInstance().getNumber("kF", 1.5),
        SimpleDashboard.getInstance().getDeviceID("kIzone", 300), 
        SimpleDashboard.getInstance().getNumber("kPeakOutput", 1)
    );
}