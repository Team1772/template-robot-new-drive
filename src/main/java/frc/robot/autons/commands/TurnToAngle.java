package frc.robot.autons.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.core.util.PID.Constants;
import frc.robot.subsystems.Driver;

public class TurnToAngle extends PIDCommand {
  public TurnToAngle(double targetAngleDegrees, Driver driver) {
    super(
        new PIDController(Constants.kTurnToAngleP, Constants.kTurnToAngleI, Constants.kTurnToAngleD),
        driver::getAngle,
        targetAngleDegrees,
        output -> driver.arcadeDrive(0, output),
        driver);

    getController().enableContinuousInput(-180, 180);
    getController()
        .setTolerance(Constants.kTurnToleranceDeg, Constants.kTurnRateToleranceDegPerS);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
