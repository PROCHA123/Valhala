package frc.robot.controlboard;

import frc.robot.Constants;

public class OperatorControlBoard implements IOperatorControlBoard {

    private static OperatorControlBoard mInstance = null;

    public static OperatorControlBoard getInstance() {
        if (mInstance == null) {
            mInstance = new OperatorControlBoard();
        }

        return mInstance;
    }

    private final XboxController mController;

    private OperatorControlBoard() {
        mController = new XboxController(Constants.kOperatorControlPort);
    }
    @Override
    public boolean getContinous() {
        return mController.getButtonReleased(XboxController.Button.X);
    }
    @Override
    public boolean armMove(){
        return mController.getButtonReleased(XboxController.Button.B);
    }
    @Override
    public boolean getAlterno(){
        return mController.getButton(XboxController.Button.A);
    }
}