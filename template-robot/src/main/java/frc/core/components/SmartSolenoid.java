package frc.core.components;

import edu.wpi.first.wpilibj.Solenoid;

public class SmartSolenoid {
    private Solenoid solenoidIn, solenoidOut;

    public SmartSolenoid(int channelIn, int channelOut){
        solenoidIn = new Solenoid(channelIn);
        solenoidOut = new Solenoid(channelOut);
    }

    public void set(boolean push){
        solenoidIn.set(push);
        solenoidOut.set(!push);
    }
}