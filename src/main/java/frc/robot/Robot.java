package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.routines.Auton;
import frc.robot.routines.Teleop;
import frc.robot.subsystems.Buffer;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Driver;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Robot extends TimedRobot {
  private Compressor compressor;

  public static Driver driver;
  public static Shooter shooter;
  public static Intake intake;
  public static Climb climb;
  public static Buffer buffer;

  @Override
  public void robotInit() {
    compressor = new Compressor();
    
    driver = new Driver();
    shooter = new Shooter();
    intake = new Intake();
    climb = new Climb();
    buffer = new Buffer();
    
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
    Teleop.INSTANCE.init();
  }
  
  @Override
  public void teleopPeriodic() {
    Teleop.INSTANCE.periodic();
  }
  
  @Override
  public void testPeriodic() {
  }
  
  @Override 
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    driver.reset();
  }
}
