package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.util.Ports;
import frc.core.util.SimpleDashboard;

public class Buffer extends Subsystem{

    private VictorSP bufferMotor;
    private DigitalInput bufferSensor;

    public Buffer() {
       bufferMotor = new VictorSP(Ports.bufferMotor);
    //    bufferSensor = new DigitalInput(Ports.bufferSensor);
    }

    public void pull() {
        bufferMotor.set(SimpleDashboard.getInstance().getNumber("BUFFER_SPEED", 1));
    }

    public void push() {
        bufferMotor.set(SimpleDashboard.getInstance().getNumber("BUFFER_SPEED", -1 * 1));
    }

    public boolean isPowerCellCollected() {
        return bufferSensor.get();
    }

    public void stop() {
        bufferMotor.set(0);
    }

    @Override
    protected void initDefaultCommand() {
    }
}