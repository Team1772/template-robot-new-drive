
package frc.core.components;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class GearBox extends SpeedControllerGroup{
    private Encoder encoder;

    public GearBox(SpeedControllerGroup motors, Encoder encoder, double distancePerPulse) {
        super(motors);

        this.encoder = encoder;

        if(encoder != null) this.configureEncoder(distancePerPulse);
    }

    public GearBox(SpeedControllerGroup motors){
        this(motors, null, 0);
    }

    private void configureEncoder(double distancePerPulse){
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