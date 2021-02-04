
package frc.robot.autons.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class TurnToAngle extends Command {
	double leftSpeed, rightSpeed, targetAngle, error, adjust;
	private Timer timer;

	public TurnToAngle(double leftVoltage, double rightVoltage, double angle) {
		leftSpeed   = Math.abs(leftVoltage);
		rightSpeed  = Math.abs(rightVoltage);
		targetAngle = angle;

		timer = new Timer();
		
		if (this.targetAngle > 0)
			this.rightSpeed = -rightSpeed;
		else
			this.leftSpeed = -leftSpeed;
	}

	@Override
	protected boolean isFinished() {
        double x = this.targetAngle - Robot.driver.getAngle();
        double headingError = -x;
        double adjust = 0;
        double rightPower = 0;
        double leftPower = 0;

		if (x > 1) 
            adjust = -0.2 * headingError - 0.6;
        else if (x < 1) 
            adjust = -0.2 * headingError + 0.6;

        rightPower -= adjust;
		leftPower += adjust;
		
		Robot.driver.tankDrive(leftPower, rightPower);
		
		if (timer.get() > 1){
			timer.reset();
			timer.start();

			return Math.abs(x) < 5;
		}

		return false;
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		timer.start();
		Robot.driver.reset();
		SmartDashboard.putNumber("Angle", Robot.driver.getAngle());
	}
	
	@Override
	protected void end() {
		super.end();
		Robot.driver.tankDrive(0, 0);
		SmartDashboard.putString("TurnToAngle", this.targetAngle + " (" + Robot.driver.getAngle() + ")");
		Robot.driver.reset();
	}
}