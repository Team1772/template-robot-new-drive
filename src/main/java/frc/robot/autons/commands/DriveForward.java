
package frc.robot.autons.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveForward extends Command {
  private final double driveForwardSpeed;
  private final double distance;
  private double error;
  private static final double kTolerance = 0.1;
  private static final double kP = 0.035;
  private double avarageDistance = 0;

  public DriveForward() {
    this(10, 0.9);
  }

  public DriveForward(double dist) {
    this(dist, 0.9);
  }

  public DriveForward(double dist, double maxSpeed) {
    requires(Robot.driver);
    distance = dist;
    driveForwardSpeed = maxSpeed;
    execute();
  }

  @Override
  protected void initialize() {
    Robot.driver.reset();
  }

  @Override
  protected void execute() {
    avarageDistance = distance > 0 ? Robot.driver.getAverageDistancePositive() : Robot.driver.getAverageDistanceNegative();
    error = distance - avarageDistance;
    if (Math.abs(driveForwardSpeed) * kP * error >= Math.abs(driveForwardSpeed)) {
      Robot.driver.tankDrive(driveForwardSpeed, driveForwardSpeed);
    } else {
      Robot.driver.tankDrive(driveForwardSpeed * kP * error,
          driveForwardSpeed * kP * error);
    }
  }

  @Override
  protected boolean isFinished() {
    return Math.abs(error) <= kTolerance || isTimedOut();
  }

  @Override
  protected void end() {
    Robot.driver.stop();
  }
}
