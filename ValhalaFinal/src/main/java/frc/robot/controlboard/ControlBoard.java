package frc.robot.controlboard;


// Clase para juntar las clases de los controlles
public class ControlBoard implements IControlBoard {
    private static ControlBoard mInstance = null;

    public static ControlBoard getInstance() {
        if (mInstance == null) {
            mInstance = new ControlBoard();
        }

        return mInstance;
    }

    private final IDriverControlBoard mDriverControlBoard;
    private final IOperatorControlBoard mOperatorControlBoard;

    private ControlBoard() {
        mDriverControlBoard =  DriverControlBoard.getInstance();
        mOperatorControlBoard = OperatorControlBoard.getInstance();
    }
    @Override
    public double getTotalVelocityX(){
        return mDriverControlBoard.getTotalVelocityX();
    }
    
    @Override
    public double getVelocityX() {
        return mDriverControlBoard.getVelocityX();
    }

    @Override
    public double getVelocityY() {
        return mDriverControlBoard.getVelocityY();
    }

    @Override
    public double getDirectThrottle() {
        return mDriverControlBoard.getDirectThrottle();
    }

    @Override
    public double getTurn() {
        return mDriverControlBoard.getTurn();
    }

    @Override
    public boolean getInverted() {
        return mDriverControlBoard.getInverted();
    }
    //parte de mecanismos
    @Override
    public boolean getContinous() {
        return mOperatorControlBoard.getContinous();
    }
    @Override
    public boolean armMove(){
        return mOperatorControlBoard.armMove();
    }
    @Override
    public boolean getAlterno(){
        return mOperatorControlBoard.getAlterno();
    }
  
  
}