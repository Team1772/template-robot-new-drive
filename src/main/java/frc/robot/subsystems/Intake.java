package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.components.SmartSolenoid;
import frc.core.util.Ports;

public class Intake extends Subsystem{

    private VictorSP motorIntake;
    private SmartSolenoid activatorIntake;

    public Intake() {
       motorIntake = new VictorSP(Ports.motorIntake);
       activatorIntake = new SmartSolenoid(Ports.activatorIntakeOne, Ports.activatorIntakeTwo);
    }

    public void pull() {
        motorIntake.set(-1);
    }

    public void pullPush(double speed) {
        motorIntake.set(speed);
    }

    public void push() {
        motorIntake.set(1);
    }

    public void stop() {
        motorIntake.set(0);
    }

    public void enableIntake() {
        activatorIntake.enable(); 
    }

    public void disableIntake() {
        activatorIntake.disable(); 
    }

    @Override
    protected void initDefaultCommand() { }
}