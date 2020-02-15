package frc.robot.autons.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.core.util.PID.Constants;
import frc.robot.subsystems.Driver;

public class DriveStraight extends PIDCommand {
  private final Driver driver;
  public DriveStraight(double distance, Driver driver) {
    super(new PIDController(Constants.kDriveStraightP, Constants.kDriveStraightI, Constants.kDriveStraightD),
        driver::getAveregeDistance,
        distance,
        speed -> driver.tankDrive(speed),
        driver);

    this.driver = driver;

    getController().setTolerance(Constants.driveStraightTolerance);
  }

  @Override
  public void initialize() {
    this.driver.reset();
    super.initialize();
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}