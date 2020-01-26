
package frc.core.components;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class GearBox extends SpeedControllerGroup{
    private Encoder encoder;

    public GearBox(SpeedController motor, SpeedController[] motors, Encoder encoder, double distancePerPulse) {
        super(motor, motors);

        this.encoder = encoder;

        if(encoder != null) this.configureEncoder(distancePerPulse);
    }

    public GearBox(SpeedController motor, Encoder encoder, double distancePerPulse){
        this(motor, null, encoder, distancePerPulse);
    }

    public GearBox(SpeedController motor, SpeedController[] motors){
        this(motor, motors, null, 0);
    }
    
    public GearBox(SpeedController motor){
        this(motor, null, null, 0);
    }

    public GearBox(SpeedController[] motors, Encoder encoder, double distancePerPulse){
        this(null, motors, encoder, distancePerPulse);
    }
    
    public GearBox(SpeedController[] motors){
        this(null, motors, null, 0);
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