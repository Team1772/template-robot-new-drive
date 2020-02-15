package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.components.SmartSolenoid;
import frc.core.util.SimpleDashboard;
import frc.core.util.Ports;

public class Intake extends Subsystem{

    private VictorSP motorIntake;
    private Solenoid activatorIntake;

    public Intake() {
       motorIntake = new VictorSP(Ports.motorIntake);
       activatorIntake = new Solenoid(Ports.activatorIntakeOne);
    }

    public void pull() {
        motorIntake.set(SimpleDashboard.getInstance().getNumber("INTAKE_SPEED", 1));
    }

    public void push() {
        motorIntake.set(SimpleDashboard.getInstance().getNumber("INTAKE_SPEED", -1 * 1));
    }

    public void stop() {
        motorIntake.set(0);
    }

    public void enableIntake() {
        activatorIntake.set(true); 
    }

    public void disableIntake() {
        activatorIntake.set(false); 
    }

    @Override
    protected void initDefaultCommand() {
    }
}