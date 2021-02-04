package frc.core.util.PID;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.core.util.SimpleDashboard;

public class PIDTalonSRXVelocity {
    private TalonSRX motor, follower;

    public PIDTalonSRXVelocity(TalonSRX motor, TalonSRX follower, int kPIDLoopIdx,
            int kTimeoutMs, boolean kSensorPhase, double nominalOutputForwardValue, double nominalOutputReverseValue,
            double peakOutputForwardValue, double peakOutputReverseValue, boolean kMotorInvert, Gains gains) {
        this.motor = motor;
        this.follower = follower;
        configSelectedFeedbackSensor(kPIDLoopIdx, kTimeoutMs);
        setSensorPhase(kSensorPhase);
        setFollower(kMotorInvert);
        setOutputs(nominalOutputForwardValue, nominalOutputReverseValue, peakOutputForwardValue, peakOutputReverseValue,
                kTimeoutMs);
        setPIDValues(kPIDLoopIdx, gains, kTimeoutMs);
    }

    public void resetEncoder() {
        FeedbackDevice.valueOf(0);
    }

    private void configSelectedFeedbackSensor(int kPIDLoopIdx, int kTimeoutMs) {
        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDLoopIdx, kTimeoutMs);
    }

    private void setFollower(boolean inverted) {
        follower.configFactoryDefault();
        follower.setInverted(inverted);
        follower.follow(motor);
    }

    private void setSensorPhase(boolean kSensorPhase) {
        motor.setSensorPhase(kSensorPhase);
    }

    private void setOutputs(double nominalOutputForwardValue, double nominalOutputReverseValue,
            double peakOutputForwardValue, double peakOutputReverseValue, int kTimeoutMs) {
        motor.configNominalOutputForward(nominalOutputForwardValue, kTimeoutMs);
        motor.configNominalOutputReverse(nominalOutputReverseValue, kTimeoutMs);
        motor.configPeakOutputForward(peakOutputForwardValue, kTimeoutMs);
        motor.configPeakOutputReverse(peakOutputReverseValue, kTimeoutMs);
    }

    private void setPIDValues(int kPIDLoopIdx, Gains gains, int kTimeoutMs) {
        motor.config_kF(kPIDLoopIdx, gains.kF, kTimeoutMs);
        motor.config_kP(kPIDLoopIdx, gains.kP, kTimeoutMs);
        motor.config_kI(kPIDLoopIdx, gains.kI, kTimeoutMs);
        motor.config_kD(kPIDLoopIdx, gains.kD, kTimeoutMs);
    }

    public void setPower(double power) {
        motor.set(ControlMode.Velocity, power);
    }

    
    public int getSensorVelocity(){
        SimpleDashboard.getInstance().getNumber("MOTOR VELOCITY", motor.getSelectedSensorVelocity());
        
        return motor.getSelectedSensorVelocity();
    }

    public void stop(){
        motor.set(ControlMode.PercentOutput, 0);
    }
}