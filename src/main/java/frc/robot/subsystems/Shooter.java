package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.components.SmartSolenoid;
import frc.core.util.SimpleDashboard;
import frc.core.util.PID.Constants;
import frc.core.util.PID.PIDTalonSRXVelocity;
import frc.core.util.Ports;

public class Shooter extends Subsystem{

    private Solenoid shooterAngle;
    private PIDTalonSRXVelocity shooterPID;
    public Shooter() {
        shooterPID = new PIDTalonSRXVelocity(new TalonSRX(Ports.shooterMotorOne), new TalonSRX(Ports.shooterMotorTwo), Constants.kPIDLoopIdx ,Constants.kTimeoutMs,
         Constants.kSensorPhase, Constants.nominalOutputForwardValue, Constants.nominalOutputReverseValue,
          Constants.peakOutputForwardValue, Constants.peakOutputReverseValue, false, Constants.kGains);

        shooterAngle = new Solenoid(Ports.shooterAngle);
    }

    // public void pull() {
    //     shooterMotorOne.set(ControlMode.PercentOutput, SimpleDashboard.getInstance().getNumber("SHOOTER_SPEED", -1));
    //     shooterMotorTwo.set(ControlMode.PercentOutput, SimpleDashboard.getInstance().getNumber("SHOOTER_SPEED", -1));
    // }

    public void push() {
        shooterPID.setPower(SimpleDashboard.getInstance().getNumber("SHOOTER_SPEED", 1));
    }

    public void enableAngle() {
        shooterAngle.set(true); 
    }

    public void disableAngle() {
        shooterAngle.set(false); 
    }

    public void stop(){
       shooterPID.stop();
    }

    public void getSensorVelocity(){
        shooterPID.getSensorVelocity();
    }

    @Override
    protected void initDefaultCommand() {
    }
}