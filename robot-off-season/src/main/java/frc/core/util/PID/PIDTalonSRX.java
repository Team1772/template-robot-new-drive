package frc.core.util.PID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class PIDTalonSRX {
    private TalonSRX motor, follower;

    public PIDTalonSRX(TalonSRX motor, TalonSRX follower, int kPIDLoopIdx, int kTimeoutMs, boolean kSensorPhase, double nominalOutputForwardValue,
        double nominalOutputReverseValue, double peakOutputForwardValue, double peakOutputReverseValue, boolean kMotorInvert, Gains gains){
        this.motor = motor;
        this.follower = follower;

        configSelectedFeedbackSensor(kPIDLoopIdx, kTimeoutMs);
        setSensorPhase(kSensorPhase);
        setInverted(kMotorInvert);
        setFollower();
        setOutputs(nominalOutputForwardValue, nominalOutputReverseValue, peakOutputForwardValue, peakOutputReverseValue, kTimeoutMs);
        configAllowableClosedloopError(kPIDLoopIdx, kTimeoutMs);
        setPIDValues(kPIDLoopIdx, gains, kTimeoutMs);
        setAbsolutePosition(kPIDLoopIdx, kTimeoutMs, kMotorInvert, kSensorPhase);
    }

    public PIDTalonSRX(TalonSRX motor, TalonSRX follower, int kTimeoutMs, boolean kSensorPhase, double peakOutputForwardValue,
        double peakOutputReverseValue, boolean kMotorInvert, Gains gains){
        this(motor, follower, 0, kTimeoutMs, kSensorPhase, 0, 0, peakOutputForwardValue, peakOutputReverseValue, kMotorInvert, gains);
    }

    public void resetEncoder(){
        FeedbackDevice.valueOf(0);
    }

    private void configSelectedFeedbackSensor(int kPIDLoopIdx, int kTimeoutMs){
        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, kPIDLoopIdx, kTimeoutMs);                               
    }

    private void setFollower(){
        follower.configFactoryDefault();
		follower.setInverted(true);
        follower.follow(motor);
    }

    private void setSensorPhase(boolean kSensorPhase){
        motor.setSensorPhase(kSensorPhase);
    }

    private void setInverted(boolean kMotorInvert){
        motor.setInverted(kMotorInvert);
    }

    private void setOutputs(double nominalOutputForwardValue, double nominalOutputReverseValue, double peakOutputForwardValue, double peakOutputReverseValue, int kTimeoutMs){
        motor.configNominalOutputForward(nominalOutputForwardValue, kTimeoutMs);
        motor.configNominalOutputReverse(nominalOutputReverseValue, kTimeoutMs);
        motor.configPeakOutputForward(peakOutputForwardValue, kTimeoutMs);
        motor.configPeakOutputReverse(peakOutputReverseValue, kTimeoutMs);
    }

    private void configAllowableClosedloopError(int kPIDLoopIdx, int kTimeoutMs){
        motor.configAllowableClosedloopError(0, kPIDLoopIdx, kTimeoutMs);
    }

    private void setPIDValues(int kPIDLoopIdx, Gains gains, int kTimeoutMs){
        motor.config_kF(kPIDLoopIdx, gains.kF, kTimeoutMs);
        motor.config_kP(kPIDLoopIdx, gains.kP, kTimeoutMs);
        motor.config_kI(kPIDLoopIdx, gains.kI, kTimeoutMs);
        motor.config_kD(kPIDLoopIdx, gains.kD, kTimeoutMs);       
    }

    private int getAbsolutePosition(){
        return motor.getSensorCollection().getPulseWidthPosition();
    }

    private void setAbsolutePosition(int kPIDLoopIdx, int kTimeoutMs, boolean kMotorInvert, boolean kSensorPhase){
        int absolutePosition =  getAbsolutePosition();

        absolutePosition &= 0xFFF;

        if (kSensorPhase) { absolutePosition *= -1; }
        if (kMotorInvert) { absolutePosition *= -1; }
        
        motor.setSelectedSensorPosition(absolutePosition, kPIDLoopIdx, kTimeoutMs);
    }

    public boolean isMaxPosition(double value){
        return (getSelectedSensorPosition() - getSelectedSensorPosition()) <  (-value);
    }

    public int getSelectedSensorPosition(){
        return motor.getSelectedSensorPosition(0);
    }

    public double getMotorOutput(){
        return motor.getMotorOutputPercent();
    }

    public void setSpeed(int position){
        motor.set(ControlMode.Position, getSelectedSensorPosition() - position);
    }
}