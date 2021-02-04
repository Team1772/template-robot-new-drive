
package frc.core.components;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.core.util.PID.Constants;

public class GearBox extends SpeedControllerGroup{
    private Encoder encoder;

    public GearBox(SpeedControllerGroup motors, Encoder encoder, double pulsesPerRevolution) {
        super(motors);

        this.encoder = encoder;

        if(encoder != null) this.configureEncoder(pulsesPerRevolution);
    }

    public GearBox(SpeedControllerGroup motors){
        this(motors, null, 0);
    }

    public double getMeasurement(){
        return encoder.getRate();
    }

    private void configureEncoder(double pulsesPerRevolution){
        double distancePerPulse = (Constants.wheelSizeCM * Math.PI) / pulsesPerRevolution; 
        
        encoder.setDistancePerPulse(distancePerPulse);
    }

    public void setEncoderInverted(boolean reverseDirection){
        encoder.setReverseDirection(reverseDirection);
    }

    public void resetEncoder(){
        encoder.reset();
    }

    public double getEncoderPulses(){
        return encoder.get();
    }

    public double getEncoderDistance(){
        return encoder.getDistance();
    }
}