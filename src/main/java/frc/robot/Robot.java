package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.routines.Auton;
import frc.robot.routines.Teleop;
import frc.robot.subsystems.Driver;

public class Robot extends TimedRobot {

  public static Driver driver;
  private static Compressor compressor;

  @Override
  public void robotInit() {
    driver = new Driver();
    compressor = new Compressor();

    Auton.INSTANCE.init();
  }
  
  @Override
  public void autonomousInit() {
    Auton.INSTANCE.start();
  }
  
  @Override
  public void autonomousPeriodic() {
    Auton.INSTANCE.periodic();
  }
  
  @Override
  public void teleopInit() {
    Auton.INSTANCE.cancel();
    Teleop.INSTANCE.init();
  }
  
  @Override
  public void teleopPeriodic() {
    Teleop.INSTANCE.periodic();
  }
  

  @Override
  public void testPeriodic() {
  }

}
