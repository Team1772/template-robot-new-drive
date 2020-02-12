package frc.robot.subsystems;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.core.components.GearBox;
import frc.core.components.SmartNavx;
import frc.core.util.Ports;

public class Driver extends Subsystem{

    private GearBox leftGearBox, rightGearBox;
    private SmartNavx navx;
    private SpeedControllerGroup controllersLeft;
    private SpeedControllerGroup controllersRight;
    private DifferentialDrive driver;

    public Driver() {
        controllersLeft = new SpeedControllerGroup(new Talon(Ports.driverMotorOne), new Talon(Ports.driverMotorTwo));

        controllersRight = new SpeedControllerGroup(new Talon(Ports.driverMotorThree), new Talon(Ports.driverMotorFour));
        
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
        driver.arcadeDrive(-sp, rotation);
	}

	@Override
	protected void initDefaultCommand() {
		
	}
}