package frc.robot;

public final class Constants {
    //Drive Subsistem
    public static final double kDriveRampDeltaSpeed = 0.03;
    public static final double kDriveSensitivity = 1;
    public static final int kDriveRightFrontId = 1;
    public static final int kDriveLeftFrontId =2;
    public static final int kDriveRightBackId = 4;
    public static final int kDriveLeftBackId = 3;
    
    //Control Board
    public static final int kDriverControlPort = 0;
    public static final int kOperatorControlPort = 1;
    public static final double kJoystickDeadband = 0.15;

    //Intake Subsistem
    public static final int kIntakeId = 5;

    //Hopper
    public static final int kHopperId = 6;

    //BoxSystem
    public static final int kArmsId = 7; //checar que ids van a ser

    //Limit Switches
    public static final int kDLimitSwitch = 1;
    public static final int kULimitSwitch = 0;
    public static final int kBLimitSwitch = 2;

}