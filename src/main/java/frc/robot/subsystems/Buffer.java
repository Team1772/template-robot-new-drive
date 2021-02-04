package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.util.Ports;

public class Buffer extends Subsystem {

    private VictorSP bufferMotor;
    private DigitalInput bufferSensorBottom, bufferSensorTop, bufferSensorLine;

    public Buffer() {
        bufferMotor = new VictorSP(Ports.bufferMotor);
        bufferSensorBottom = new DigitalInput(Ports.bufferSensorBottom);
        bufferSensorTop = new DigitalInput(Ports.bufferSensorTop);
        bufferSensorLine = new DigitalInput(Ports.bufferSensorLine);
    }

    public void pull() {
        bufferMotor.set(1);
    }

    public void push() {
        bufferMotor.set(-1);
    }

    public boolean isPowerCellCollectedBottom() {
        return !bufferSensorBottom.get();
    }

    public boolean isPowerCellCollectedTop() {
        return !bufferSensorTop.get();
    }

    public boolean isPowerCellInLine() {
        return !bufferSensorLine.get();
    }

    public void stop() {
        bufferMotor.set(0);
    }

    public void enableSensors(){
        SmartDashboard.putBoolean("[BUFFER] SENSOR BOTTOM", isPowerCellCollectedBottom());
        SmartDashboard.putBoolean("[BUFFER] SENSOR TOP", isPowerCellCollectedTop());
        SmartDashboard.putBoolean("[BUFFER] SENSOR LINE", isPowerCellInLine());
        
        if (isPowerCellCollectedTop())
            stop();
        else if ((!isPowerCellCollectedBottom() && !isPowerCellCollectedTop() && isPowerCellInLine()) 
            || (isPowerCellInLine() && isPowerCellCollectedBottom() && !isPowerCellCollectedTop())) {
                pull();
        } else if ((isPowerCellCollectedBottom() && isPowerCellCollectedTop()) 
            || !isPowerCellInLine() 
            || (!isPowerCellInLine() && !isPowerCellCollectedBottom() && !isPowerCellCollectedTop())){
            stop(); 
        }
    }

    public void enable(double speed){
        bufferMotor.setSpeed(-speed);
    }

    @Override
    protected void initDefaultCommand() {
    }
}