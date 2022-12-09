package frc.robot.controlboard;

public interface IOperatorControlBoard {

        boolean getContinous();
        
        boolean armMove();

        boolean getAlterno();

        boolean dead();

        double movements();

    
}