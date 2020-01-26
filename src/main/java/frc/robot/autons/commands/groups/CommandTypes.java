package frc.robot.autons.commands.groups;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CommandTypes extends CommandGroup {
	private Timer timer;

	public CommandTypes(Subsystem subsys) {
		timer = new Timer();

		requires(subsys);
	}

	public boolean timeOut(double seconds) {
		timer = timer == null ? new Timer() : timer;
		timer.start();

		if (timer.get() > seconds) {
			timer.reset();
			timer.stop();

			return true;
		}
		return false;
	}

	/* COMMAND BASED AUTONOMOUS */
	public void addStep(ICommandTypes command) {
		super.addSequential(this.toCommand(command));
	}
	public void addStep(ICommandTypes command, double timeOut) {
		super.addSequential(this.toCommand(command), timeOut);
	}
	public void addParallelStep(ICommandTypes command) {
		super.addParallel(this.toCommand(command));
	}
	public void addParallelStep(ICommandTypes command, double timeOut) {
		super.addParallel(this.toCommand(command), timeOut);
	}
	public void addStep(Command command) {
		super.addSequential(command);
	}
	public void addStep(Command command, double timeOut) {
		super.addSequential(command, timeOut);
	}
	public void addParallelStep(Command command) {
		super.addParallel(command);
	}
	public void addParallelStep(Command command, double timeOut) {
		super.addParallel(command, timeOut);
	}

	private Command toCommand(ICommandTypes command) {
		return new Command() {
			@Override
			protected boolean isFinished() {
				return command.run();
			}
		};
	}
}
