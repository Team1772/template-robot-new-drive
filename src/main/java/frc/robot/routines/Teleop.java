package frc.robot.routines;

import frc.core.util.Ports;
import frc.core.util.XboxController;
import frc.robot.Robot;

public enum Teleop{
    INSTANCE;

    private XboxController driver, operator;

    public void init() {
        driver = new XboxController(Ports.driverJoystick);
        operator = new XboxController(Ports.operatorJoystick);
    }

    public void periodic() {
        Robot.driver.arcadeDrive(driver.getAxisLeftY(), driver.getAxisRightX());

        if (operator.getButtonL1()) {
            Robot.intake.enableIntake();
            Robot.intake.pull();
        } else {
            Robot.intake.disableIntake();
            Robot.intake.stop();
        }

        if (driver.getButtonR1()) {
            Robot.shooter.push();
        } else {
            Robot.shooter.stop();
        }

        if(operator.getButtonY())
            Robot.climb.enableAngleClimb();



        if (operator.getButtonX()) Robot.shooter.enableAngle();
        else Robot.shooter.disableAngle();
        
            Robot.climb.upDown(operator.getAxisLeftY());
       

        // Robot.climb.rollUpDown(operator.getButtonR2());
    }
}
