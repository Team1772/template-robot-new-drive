package frc.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.autons.commands.DriveForward;
import frc.robot.autons.commands.PushPowerCell;
import frc.robot.autons.commands.TurnToAngle;


public class AutoLine extends CommandGroup {
	public AutoLine() {	
		requires(Robot.driver);
		
		addSequential(new PushPowerCell(), 5);
        addSequential(new TurnToAngle(1, 1, 200), 2.5); 
		addSequential(new DriveForward(100, 0.65));
	}
}