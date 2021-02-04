package frc.robot.autons.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PullPowerCell extends Command {
  @Override
  protected boolean isFinished() {
    Robot.intake.pull();
    Robot.intake.enableIntake();

    return isTimedOut(); 
  }

  @Override
  protected void end() {
    Robot.intake.disableIntake();
    Robot.intake.stop();
  }
}
