package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;

public class MoveBackAction{
  Drive mAutoDrive = new Drive();
  
  public void finalMoveBackACtion(){
    mAutoDrive.outMotoresAuto(-0.3, 0.3, -0.3, 0.3);
  }
}
