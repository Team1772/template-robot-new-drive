package frc.robot.autons.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PushPowerCell extends Command {
  public PushPowerCell() {
      Robot.shooter.push();
      Robot.buffer.push();
  }

  @Override
  public boolean isFinished() {
    int count = 0;
    if(Robot.buffer.isPowerCellCollected())
        count += 1;

    return count > 3;
  }
}
