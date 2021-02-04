package frc.robot.routines;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.autons.AutoLine;
import frc.robot.autons.TrenchRun;

public enum Auton {
    INSTANCE;

    private Command autoSelected;
    private SendableChooser<Command> chooser;

    public void init() {
        this.chooser = new SendableChooser<>();
        this.chooser.setDefaultOption("Auto Line", new AutoLine());
        this.chooser.addOption("Trench Run", new TrenchRun());

        SmartDashboard.putData("SELECT AUTONS", this.chooser);
    }

    public void periodic() {
        Scheduler.getInstance().run();
    }
    
    public void start() {
        this.autoSelected = this.getAutonSelected();

        if (this.autoSelected != null) {
    		System.out.println("AUTONOMOUS START :" + autoSelected.getName());
    		SmartDashboard.putString("Autonomos selected:", autoSelected.getName());
    		autoSelected.start();
    	}
    }

    private Command getAutonSelected() {
        return this.chooser.getSelected();
    } 

    public void cancel() {
    	if (this.autoSelected != null) {
    		System.out.println("AUTONOMOUS END :" + autoSelected.getName());
    		SmartDashboard.putString("Autonomos selected:", autoSelected.getName());
    		autoSelected.cancel();
    	}
    }
}