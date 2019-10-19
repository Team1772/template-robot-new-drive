package frc.robot.autons;

import frc.robot.Robot;
import frc.robot.autons.commands.*;
import frc.robot.autons.commands.groups.*;

public class AutonomousTemplate extends CommandTypes {

	public AutonomousTemplate() {
		super(Robot.driver);

		addStep(new CommandTemplate(), 10); //Time in seconds
	}

}