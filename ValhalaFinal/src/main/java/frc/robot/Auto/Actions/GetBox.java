package frc.robot.Auto.Actions;

import frc.robot.subsystems.BoxSystem;

public class GetBox {
BoxSystem mBoxSystem = new BoxSystem();
    public void GetAutoBox(boolean nearBox){
        if(nearBox){
            mBoxSystem.GoDown();
        }
    }

}
