
package frc.core.components;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class GearBox{
    private SpeedController motorOne, motorTwo;
    private Encoder encoder;
    
    public GearBox(SpeedController motorOne, SpeedController motorTwo, Encoder encoder, boolean isMotorOneInverted, boolean isMotorTwoIsInverted, double distancePerPulse) {
        this.motorOne = motorOne;
        this.motorTwo = motorTwo;
        this.encoder = encoder;

        motorOne.setInverted(isMotorOneInverted);

        if(motorTwo != null) motorTwo.setInverted(isMotorTwoIsInverted);

        if(encoder != null) this.configureEncoder(distancePerPulse);
    }

    public GearBox(SpeedController motorOne, SpeedController motorTwo, Encoder encoder, double distancePerPulse){
        this(motorOne, motorTwo, encoder, false, false, distancePerPulse);
    }

    public GearBox(SpeedController motorOne, boolean isMotorOneInverted, Encoder encoder, double distancePerPulse){
        this(motorOne, null, encoder, isMotorOneInverted, false, distancePerPulse);
    }
    
    public GearBox(SpeedController motorOne, Encoder encoder, double distancePerPulse){
        this(motorOne, null, encoder, false, false, distancePerPulse);
    }

    public GearBox(SpeedController motorOne, SpeedController motorTwo){
        this(motorOne, motorTwo, null, false, false, 0);
    }

    public GearBox(SpeedController motorOne, boolean isMotorOneInverted){
        this(motorOne, null, null, isMotorOneInverted, false, 0);
    }
    
    public GearBox(SpeedController motorOne){
        this(motorOne, null, null, false, false, 0);
    }

    public GearBox(SpeedController motorOne, SpeedController motorTwo, boolean isMotorOneInverted, boolean isMotorTwoIsInverted){
        this(motorOne, motorTwo, null, isMotorOneInverted, isMotorTwoIsInverted, 0);
    }

    private void configureEncoder(double distancePerPulse){
        encoder.setDistancePerPulse(distancePerPulse);
    }

    public void setEncoderInverted(boolean reverseDirection){
        encoder.setReverseDirection(reverseDirection);
    }

    public void setSpeed(double speed){
        motorOne.set(speed);

        if(motorTwo != null) motorTwo.set(speed);
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