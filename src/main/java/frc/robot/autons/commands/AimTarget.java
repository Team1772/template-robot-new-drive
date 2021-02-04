package frc.robot.autons.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AimTarget extends Command {
  @Override
  protected boolean isFinished() {
    Robot.driver.turnToTarget();

    return isTimedOut(); 
  }

  @Override
  protected void end() {
    Robot.driver.stop();
  }
}
