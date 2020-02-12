package frc.robot.routines;

import frc.core.util.Ports;
import frc.core.util.XboxController;
import frc.robot.Robot;

public enum Teleop{
    INSTANCE;

    private XboxController driver, operator;

    public void init() {
        driver = new XboxController(Ports.driverJoystick);
        // operator = new XboxController(Ports.operatorJoystick);
    }

    public void periodic() {
        Robot.driver.arcadeDrive(driver.getAxisLeftY(), driver.getAxisRightX());

        // if (operator.getButtonL1()) {
        //     Robot.intake.enableIntake();
        //     // Robot.buffer.pull();
        //     Robot.intake.pull();
        // } else {
        //     Robot.intake.disableIntake();
        //     Robot.intake.stop();
        //     // Robot.buffer.stop();
        // }

        if (driver.getButtonR1()) {
            // Robot.buffer.push();
            Robot.shooter.push();
            Robot.shooter.getSensorVelocity();
        } else {
            // Robot.buffer.stop();
            Robot.shooter.stop();
        }


        // if (operator.getButtonX()) Robot.shooter.enableAngle();
        // else Robot.shooter.disableAngle();
        
        // if (operator.getButtonY()) { 
        //     Robot.climb.rollUp();
        //     Robot.climb.enableAngleClimb();
        //     Robot.climb.up();
        // } else {
        //     Robot.climb.stop();
        //     Robot.climb.disableAngleClimb();
        // } 
    }
}
