package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.components.SmartSolenoid;
import frc.core.util.Ports;
import frc.core.util.SimpleDashboard;

public class Climb extends Subsystem{

    private SmartSolenoid angleClimb;
    private VictorSP climbMotorOne;
    private VictorSP climbMotorTwo;
    private Spark elevatorClimb;

    public Climb() {
       climbMotorOne = new VictorSP(Ports.climbMotorOne);
       climbMotorTwo = new VictorSP(Ports.climbMotorTwo);
       elevatorClimb = new Spark(Ports.elevatorClimb);
       
       angleClimb = new SmartSolenoid(Ports.angleClimbOne, Ports.angleClimbTwo);
    }

    public void rollUp() {
        climbMotorOne.set(SimpleDashboard.getInstance().getNumber("CLIMB_UP_ONE", 1));
        climbMotorTwo.set(SimpleDashboard.getInstance().getNumber("CLIMB_UP_TWO", 1));
    }

    public void stop() { 
        climbMotorOne.set(0);
        climbMotorTwo.set(0);
        elevatorClimb.set(0);
    }

    public void up() {
        elevatorClimb.set(1);
    }

    public void down() {
        elevatorClimb.set(-1);
    }

    public void enableAngleClimb() {
        angleClimb.enable(); 
    }

    public void disableAngleClimb() {
        angleClimb.disable(); 
    }

    @Override
    protected void initDefaultCommand() {
    }
}