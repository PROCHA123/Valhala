package frc.robot.Auto.Actions;

import frc.robot.subsystems.AllSystems;

public class StartSystems {
    AllSystems mAllSystems = new AllSystems();

    public void AutoStartSystems(){
        mAllSystems.AutoAllSystems();
    }
}
