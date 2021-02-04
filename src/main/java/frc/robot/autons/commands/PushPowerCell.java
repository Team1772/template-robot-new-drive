package frc.robot.autons.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PushPowerCell extends Command {
  private Timer timer;
  public PushPowerCell(){
    timer = new Timer();
  }

  @Override
  protected void initialize() {
    Robot.driver.stop();
    Robot.shooter.enableAngle();
    timer.start();
  }

  @Override
  protected boolean isFinished() {
    Robot.shooter.pushAuton();

    if (timer.get() > 1.6) 
      Robot.buffer.pull();

    return isTimedOut(); 
  }

  @Override
  protected void end() {
    Robot.buffer.stop();
    Robot.shooter.stop();
  }
}
