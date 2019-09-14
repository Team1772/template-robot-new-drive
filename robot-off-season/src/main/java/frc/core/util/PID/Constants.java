package frc.core.util.PID;

public class Constants {
	
    public static final int kSlotIdxOne = 0;
    public static final int kSlotIdxTwo = 0;

    public static final int kPIDLoopIdxOne = 0;
    public static final int kPIDLoopIdxTwo = 0;

    public static final int kTimeoutMsOne = 30;
    public static final int kTimeoutMsTwo = 0;

    
    public static boolean kSensorPhaseOne = true;
    public static boolean kSensorPhaseTwo = true;


    public static boolean kMotorInvertOne = false;
    public static boolean kMotorInvertTwo = false;

    
    static final Gains kGainsOne = new Gains(0.2, 0.0, 2.5, 0.0, 0, 1.0);
    static final Gains kGainsTwo = new Gains(0.6, 0.0, 6.0, 0.0, 0, 1.0);

}