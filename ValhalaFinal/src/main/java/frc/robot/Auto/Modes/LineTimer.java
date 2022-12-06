package frc.robot.Auto.Modes;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;
import frc.robot.Auto.Actions.GetBox;
import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveBackAction;
import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StartSystems;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.Auto.Actions.TurnLeftAction;
import frc.robot.Auto.Actions.TurnRightAction;
import frc.robot.subsystems.Drive;

public class LineTimer{
  Drive mAutoDrive = new Drive();
  MoveForwardAction mForwardAction = new MoveForwardAction();
  MoveBackAction mMoveBackAction = new MoveBackAction();
  StopAction mStopAction = new StopAction();
  GetTimeAction mGetTimeAction = new GetTimeAction();
  TurnLeftAction mTurnLeftAction = new TurnLeftAction();
  TurnRightAction mTurnRightAction = new TurnRightAction();
  GetBox mGetBox = new GetBox();
  StartSystems mStartSystems = new StartSystems();
  
  //--------------------------------input---------------------------//
  DigitalInput BLimitSwitch = new DigitalInput(Constants.kBLimitSwitch);
 //--------------------------------variables---------------------------//
  boolean caja = false;
  public void finalLineTimer(){
    if(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<3){
        mForwardAction.finalMoveForwardAction();
    }
    else if(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<5){
        mTurnRightAction.finalTurnRightACtion();
    }
    else if(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<6){
        mMoveBackAction.finalMoveBackACtion();
    }
    else if(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<13){
    while(!BLimitSwitch.get()&&(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<13)){
        while(!BLimitSwitch.get()&&(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<13)){
          mMoveBackAction.finalMoveBackACtion();
         }
      mStopAction.finalStopAction();
      mGetBox.GetAutoBox(BLimitSwitch.get());
      caja = true;
      mStartSystems.AutoStartSystems();
        }
    }
    else if(caja&&(mGetTimeAction.getAbsoluteTimer()-mGetTimeAction.getRelativeTimer()<15)){
          mForwardAction.finalMoveForwardAction();   
    }
    else{
      mStopAction.finalStopAction();
    }
        
    }


  }
