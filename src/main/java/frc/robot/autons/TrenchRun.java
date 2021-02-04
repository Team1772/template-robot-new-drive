package frc.robot.autons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.autons.commands.DriveForward;
import frc.robot.autons.commands.PullPowerCell;
import frc.robot.autons.commands.PushPowerCell;
import frc.robot.autons.commands.TurnToAngle;


public class TrenchRun extends CommandGroup {
	public TrenchRun() {
        requires(Robot.driver);
			
        addSequential(new PushPowerCell(), 5);
        addSequential(new TurnToAngle(1, 1, 150), 2.5); //150
        addParallel(new PullPowerCell());
        addSequential(new DriveForward(150, 0.7), 4.5);
        addSequential(new TurnToAngle(1, 1, 25), 2);
        addSequential(new DriveForward(20, 0.7));
	}
}
