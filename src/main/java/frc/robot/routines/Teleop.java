package frc.robot.routines;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import frc.core.util.Camera;
import frc.core.util.Ports;
import frc.core.util.XboxController;
import frc.robot.Robot;


public enum Teleop {
    INSTANCE;

    private XboxController driver, operator;
    Solenoid solenoid;
    private Camera camera;

    public void init() {
        driver = new XboxController(Ports.driverJoystick);
        operator = new XboxController(Ports.operatorJoystick);
        camera = new Camera();
    }

    public void periodic() {
        if (driver.getButtonL1())
            Robot.driver.turnToTarget();
        else
            Robot.driver.arcadeDrive(driver.getAxisLeftY(), driver.getAxisRightX());

        if (operator.getButtonL1())
            Robot.intake.enableIntake();
        else if (driver.getButtonR1())
            Robot.intake.enableIntake();
        else
            Robot.intake.disableIntake();

        if (operator.getButtonL2() > 0.1) {
            Robot.intake.pull();
        } else if (operator.getButtonR2() > 0.1)
            Robot.intake.push();
        else
            Robot.intake.stop();

        if (operator.getButtonR1()) {
            Robot.shooter.push();
        } else {
            Robot.shooter.stop();
        }

        if (operator.getButtonY())
            Robot.buffer.pull();
        else if (operator.getButtonA())
            Robot.buffer.push();
        else 
            Robot.buffer.enableSensors();        

        if (operator.getGamePad(XboxController.Direction.UP))
            Robot.climb.enableAngleClimb();
        else if (operator.getGamePad(XboxController.Direction.DOWN))
            Robot.climb.disableAngleClimb();

        if (operator.getGamePad(XboxController.Direction.RIGHT))
            Robot.shooter.setPower(true);
        else if (operator.getGamePad(XboxController.Direction.LEFT))
            Robot.shooter.setPower(false);

        if (operator.getButtonX())
            Robot.shooter.disableAngle(); 
        else
            Robot.shooter.enableAngle();
        

        Robot.climb.upDown(operator.getAxisLeftY());

        if (driver.getButtonL2() > 0.1)
            Robot.climb.rollUp(driver.getButtonL2());
        else if (driver.getButtonR2() > 0.1)
            Robot.climb.rollDown(driver.getButtonR2());
        else
            Robot.climb.rollStop();
    }
}
