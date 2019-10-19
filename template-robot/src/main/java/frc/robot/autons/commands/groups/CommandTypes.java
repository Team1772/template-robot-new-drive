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
	public void addStep(ICommandTypes step) {
		super.addSequential(this.toCommand(step));
	}
	public void addStep(ICommandTypes step, double timeOut) {
		super.addSequential(this.toCommand(step), timeOut);
	}
	public void addParallelStep(ICommandTypes step) {
		super.addParallel(this.toCommand(step));
	}
	public void addParallelStep(ICommandTypes step, double timeOut) {
		super.addParallel(this.toCommand(step), timeOut);
	}
	public void addStep(Command step) {
		super.addSequential(step);
	}
	public void addStep(Command step, double timeOut) {
		super.addSequential(step, timeOut);
	}
	public void addParallelStep(Command step) {
		super.addParallel(step);
	}
	public void addParallelStep(Command step, double timeOut) {
		super.addParallel(step, timeOut);
	}

	private Command toCommand(ICommandTypes step) {
		return new Command() {
			@Override
			protected boolean isFinished() {
				return step.run();
			}
		};
	}
}