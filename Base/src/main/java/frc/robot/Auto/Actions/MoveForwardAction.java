package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;

public class MoveForwardAction{
  Drive mAutoDrive = new Drive();
  
  public void finalMoveForwardAction(double velocity){
    mAutoDrive.outMotoresAuto(velocity,-velocity,velocity,-velocity);
  }
}