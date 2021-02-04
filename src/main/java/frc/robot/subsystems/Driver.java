package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.core.components.GearBox;
import frc.core.components.SmartNavx;
import frc.core.util.Limelight;
import frc.core.util.Ports;
import frc.core.util.PID.Constants;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Driver extends Subsystem {

    private GearBox leftGearBox, rightGearBox;
    private SmartNavx navx;
    private SpeedControllerGroup controllersLeft;
    private SpeedControllerGroup controllersRight;
    private DifferentialDrive driver;
    private Limelight limelight;

    public Driver() {
        this.controllersLeft = new SpeedControllerGroup(new Talon(Ports.driverMotorOne), new Talon(Ports.driverMotorTwo));

        this.controllersRight = new SpeedControllerGroup(new Talon(Ports.driverMotorThree),
                new Talon(Ports.driverMotorFour));

        this.leftGearBox = new GearBox(controllersLeft, new Encoder(Ports.encoderLeftOne, Ports.encoderLeftTwo), 492);
        this.rightGearBox = new GearBox(controllersRight, new Encoder(Ports.encoderRightOne, Ports.encoderRightTwo), 500);

        this.driver = new DifferentialDrive(leftGearBox, rightGearBox);

        this.navx = new SmartNavx();

        this.limelight = new Limelight(Constants.pipeline);
    }

    public double getLeftPulses() {
        return leftGearBox.getEncoderPulses();
    }

    public double getRightPulses() {
        return rightGearBox.getEncoderPulses();
    }

    public double getLeftDistance() {
        return Math.abs(leftGearBox.getEncoderDistance());
    }

    public double getAverageDistancePositive() {
        return (getRightDistance() + getLeftDistance()) / 2;
    }

    public double getAverageDistanceNegative() {
        return -1 * (getRightDistance() + getLeftDistance()) / 2;
    }

    public double getRightDistance() {
        return Math.abs(rightGearBox.getEncoderDistance());
    }

    public double getAngle() {
        return navx.getAngle();
    }

    public void reset() {
        rightGearBox.resetEncoder();
        leftGearBox.resetEncoder();
        navx.reset();
    }

    public void setSpeed(double speed) {
        rightGearBox.set(speed);
        leftGearBox.set(speed);
    }

    public void arcadeDrive(double sp, double rotation) {
        driver.arcadeDrive(-sp, rotation);
    }

    public void tankDrive(double speed, double speedTwo) {
        driver.tankDrive(speed, speedTwo);
    }

    public boolean isMotorSafety(){
        return driver.isSafetyEnabled();
    }

    public void stop(){
        this.setSpeed(0);
    }

    public void turnToTarget() {
        this.limelight.ledsOn();
        double x = limelight.getX();
        double headingError = -x;
        double adjust = 0;
        double rightPower = 0;
        double leftPower = 0;

        if (x > 1) 
            adjust = Constants.kLimelightP * headingError - Constants.kLimelightMinCommand;
        else if (x < 1) 
            adjust = Constants.kLimelightP * headingError + Constants.kLimelightMinCommand;

        rightPower -= adjust;
        leftPower += adjust;

        driver.tankDrive(leftPower, rightPower);
    }

    public void ledsOff() {
        this.limelight.ledsOff();
    }

    @Override
    protected void initDefaultCommand() { }
}