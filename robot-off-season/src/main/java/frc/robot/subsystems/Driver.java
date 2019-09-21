package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.core.components.GearBox;
import frc.core.components.SmartNavx;

public class Driver extends Subsystem{

    private GearBox leftGearBox, rightGearBox;
    private SmartNavx navx;

    public Driver() {
        boolean isMotorInverted = true;
        leftGearBox = new GearBox(new VictorSP(0), new VictorSP(1));
        rightGearBox = new GearBox(new VictorSP(2), new VictorSP(3), isMotorInverted, isMotorInverted);

        navx = new SmartNavx();
    }

    public double getLeftPulses() {
    	return leftGearBox.getEncoderPulses();
    }
    
    public double getRightPulses() {
    	return rightGearBox.getEncoderPulses();
    }
    
    public double getLeftDistance() {
    	return leftGearBox.getEncoderDistance();
    }

    public double getRightDistance() {
    	return rightGearBox.getEncoderDistance();
    }

    public double getAngle() {
    	return navx.getAngle();
    }

    public boolean reset() {
    	rightGearBox.resetEncoder();
        leftGearBox.resetEncoder();
        navx.reset();
        
    	return true;
    }

    public boolean setSpeed(double left, double right) {
    	leftGearBox.setSpeed(-left);
		rightGearBox.setSpeed(-right);
		
		return true;
    }

	public void arcadeDrive(double sp, double rotation) {
        double minR = 0.4D,
        difR = 0.5D,
        mod = minR + difR * Math.pow(1 - Math.abs(sp), 2), 
        r = Math.pow(rotation, 3) * mod;
        
		leftGearBox.setSpeed((sp - r) * 0.6);
		rightGearBox.setSpeed((sp + r) * 0.7);
	}

	@Override
	protected void initDefaultCommand() {
		
	}
}