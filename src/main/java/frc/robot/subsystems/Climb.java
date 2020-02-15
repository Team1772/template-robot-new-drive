package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.components.SmartSolenoid;
import frc.core.util.Ports;
import frc.core.util.SimpleDashboard;

public class Climb extends Subsystem{

    private Solenoid angleClimb;
    private VictorSP climbMotorOne;
    private VictorSP climbMotorTwo;
    private Spark elevatorClimb;

    public Climb() {
       climbMotorOne = new VictorSP(Ports.climbMotorOne);
       climbMotorTwo = new VictorSP(Ports.climbMotorTwo);
       elevatorClimb = new Spark(Ports.elevatorClimb);
       
       angleClimb = new Solenoid(Ports.angleClimb);
    }

    // public void rollUp() {
    //     climbMotorOne.set(SimpleDashboard.getInstance().getNumber("CLIMB_UP_ONE", 1));
    //     climbMotorTwo.set(SimpleDashboard.getInstance().getNumber("CLIMB_UP_TWO", 1));
    // }

    public void rollUpDown(double speed) {
        climbMotorOne.set(speed);
        climbMotorTwo.set(speed);
    }

    public void stop() { 
        climbMotorOne.set(0);
        climbMotorTwo.set(0);
        elevatorClimb.set(0);
    }

    public void up() {
        elevatorClimb.set(1);
    }

    public void upDown(double speed) {
        elevatorClimb.set(speed);
    }

    public void down() {
        elevatorClimb.set(-1);
    }

    public void enableAngleClimb() {
        angleClimb.set(true); 
    }

    public void disableAngleClimb() {
        angleClimb.set(false); 
    }

    @Override
    protected void initDefaultCommand() {
    }
}