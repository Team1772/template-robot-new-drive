package frc.robot.routines;

import frc.core.util.XboxController;
import frc.robot.Robot;

public enum Teleop{
    INSTANCE;

    private XboxController driver, operator;

    public void init(){
        int usbPortDriver = 0, usbPortOperator = 1;
        driver = new XboxController(usbPortDriver);
        operator = new XboxController(usbPortOperator);
    }

    public void periodic(){
        Robot.driver.arcadeDrive(driver.getAxisLeftY(), driver.getAxisRightX());
    }
}
