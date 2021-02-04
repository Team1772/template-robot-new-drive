package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.util.Ports;
public class Climb extends Subsystem {

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
    
    public void rollUpDown(double speed) {
        climbMotorOne.set(speed);
        climbMotorTwo.set(speed);
    }

    public void rollUp(double speed){
        climbMotorOne.set(speed);
        climbMotorTwo.set(speed);
    }

    public void rollDown(double speed){
        climbMotorOne.set(-speed);
        climbMotorTwo.set(-speed);
    }

    public void rollStop(){
        climbMotorOne.set(0);
        climbMotorTwo.set(0);
    }

    public void stop() { 
        elevatorClimb.set(0);
    }

    public void up() {
        elevatorClimb.set(1);
    }

    public void upDown(double speed) {
        elevatorClimb.set(-speed);
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
    protected void initDefaultCommand() { }
}