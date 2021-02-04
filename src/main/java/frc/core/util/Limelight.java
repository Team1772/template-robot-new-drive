package frc.core.util;

import edu.wpi.first.networktables.*;

public class Limelight {

    private NetworkTable table;
    private String tableName = "limelight";
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry ta;
    private NetworkTableEntry tv;

    public Limelight(int pipeline) {
        this.table = NetworkTableInstance.getDefault().getTable(tableName);
        this.table.getEntry("pipeline").setNumber(pipeline);
        this.tx = table.getEntry("tx");
        this.ty = table.getEntry("ty");
        this.ta = table.getEntry("ta");
        this.tv = table.getEntry("tv");
    }

    public double getX() {
        return this.tx.getDouble(0.0);
    }

    public double getY() {
        return this.ty.getDouble(0.0);
    }

    public double getA() {
        return this.ta.getDouble(0.0);
    }

    public double getV() {
        return this.tv.getDouble(0.0);
    }

    public void ledsOn() {
        this.table.getEntry("letMode").setNumber(1);
    }

    public void ledsOff() {
        this.table.getEntry("letMode").setNumber(3);
    }
}