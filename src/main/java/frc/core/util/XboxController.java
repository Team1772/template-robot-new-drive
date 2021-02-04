package frc.core.util;

import edu.wpi.first.wpilibj.Joystick;

public class XboxController extends Joystick{

    public XboxController(final int port) {
        super(port);
    }

    public double getAxisLeftY(){
        return this.getY();
    }

    public double getAxisLeftX(){
        return this.getX();
    }

    public double getAxisRightY(){
        return this.getRawAxis(5);
    }

    public double getAxisRightX(){
        return this.getRawAxis(4);
    }
    
    public boolean getButtonA() {
		return this.getRawButton(1);
	}
	
	public boolean getButtonX() {
		return this.getRawButton(3);
	}
	
	public boolean getButtonY() {
		return this.getRawButton(4);
	}
	
	public boolean getButtonB() {
		return this.getRawButton(2);
	}
	
	public boolean getButtonL1() {
		return this.getRawButton(5);
	}
	
	public boolean getButtonR1() {
		return this.getRawButton(6);
    }
    
    public double getButtonL2(){
        return this.getRawAxis(2);
    }

    public double getButtonR2(){
        return this.getRawAxis(3);
    }

    public boolean getButtonL3() {
		return this.getRawButton(9);
	}
	
	public boolean getButtonR3() {
		return this.getRawButton(10);
	}
	
	public boolean getButtonStart() {
		return this.getRawButton(8);
	}
	
	public boolean getButtonSelect() {
		return this.getRawButton(7);
	}

	public static enum Direction {
        UP(0), RIGHT(90), DOWN(180), LEFT(270);

        int direction;

        private Direction(int direction) {
            this.direction = direction;
		}
	}

	public boolean getGamePad(Direction direction) {
        int dPadValue = this.getPOV();
        return (dPadValue == direction.direction) || (dPadValue == (direction.direction + 45) % 360)
                || (dPadValue == (direction.direction + 315) % 360);
    }

}