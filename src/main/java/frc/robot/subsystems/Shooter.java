package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.core.util.PID.Constants;
import frc.core.util.PID.PIDTalonSRXVelocity;
import frc.core.util.Ports;

public class Shooter extends Subsystem{

    private Solenoid shooterAngle;
    private PIDTalonSRXVelocity shooterPID;
    private int shooterPower = 1000;
    private Timer timer;
    public Shooter() {
        shooterPID = new PIDTalonSRXVelocity(new TalonSRX(Ports.shooterMotorOne), new TalonSRX(Ports.shooterMotorTwo), Constants.kPIDLoopIdx ,Constants.kTimeoutMs,
         Constants.kSensorPhase, Constants.nominalOutputForwardValue, Constants.nominalOutputReverseValue,
          Constants.peakOutputForwardValue, Constants.peakOutputReverseValue, false, Constants.kGains);

        shooterAngle = new Solenoid(Ports.shooterAngle);
        timer = new Timer();

        getSensorVelocity();
    }

    public void pull() {
        shooterPID.setPower(-this.shooterPower);
    }
    
    public void push() {
        SmartDashboard.putNumber("[INTAKE] Velocity", getSensorVelocity());
        shooterPID.setPower(this.shooterPower);
    }

    public void pushAuton() {
        shooterPID.setPower(750);
    }

    public void enableAngle() {
        shooterAngle.set(!true); 
    }

    public void disableAngle() {
        shooterAngle.set(!false); 
    }

    public void setPower(boolean encrease){
        if (encrease) this.shooterPower = 7000;
        else this.shooterPower = 1000;
    }

    public void stop(){
        SmartDashboard.putNumber("[INTAKE] Shooter Power", this.shooterPower);

        shooterPID.stop();
    }

    public int getSensorVelocity(){
        return shooterPID.getSensorVelocity();
    }

    @Override
    protected void initDefaultCommand() { }
}