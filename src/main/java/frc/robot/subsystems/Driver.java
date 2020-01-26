package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.core.components.GearBox;
import frc.core.components.SmartNavx;

public class Driver extends Subsystem{

    private GearBox leftGearBox, rightGearBox;
    private SmartNavx navx;
    private SpeedController[] controllersLeft;
    private SpeedController[] controllersRight;
    private DifferentialDrive driver;

    public Driver() {
        controllersLeft = new SpeedController[] {
            new Talon(0), new Talon(1), new Talon(2)  
        };

        controllersRight = new SpeedController[] { 
            new Talon(3), new Talon(4), new Talon(5)  
        };

        leftGearBox = new GearBox(controllersLeft);
        rightGearBox = new GearBox(controllersRight);

        driver = new DifferentialDrive(leftGearBox, rightGearBox);

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

    public void setSpeed(double speed){
        rightGearBox.set(speed);
        leftGearBox.set(speed);
    }

	public void arcadeDrive(double sp, double rotation) {
        driver.arcadeDrive(sp, rotation);
	}

	@Override
	protected void initDefaultCommand() {
		
	}
}