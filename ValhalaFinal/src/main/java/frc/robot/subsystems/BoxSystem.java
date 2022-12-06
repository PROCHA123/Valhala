package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BoxSystem extends SubsystemBase{
    
    //Hardware ----------------------------------------------------------------->
    public TalonSRX armMotor = new TalonSRX(Constants.kArmsId);
    //INPUTS ------------------------------------------------------------------>
    boolean BoxState = false; 
    boolean ArmIn = true;
    DigitalInput DLimitSwitch = new DigitalInput(Constants.kDLimitSwitch);
    DigitalInput ULimitSwitch = new DigitalInput(Constants.kULimitSwitch);

    public BoxSystem() {} //constructor del subsistema

    //------------------// Funciones del subsistema //-------------------------------//

    //Funcion para disparar
    public void TBoxSystem(boolean inArm){
        ArmIn = inArm;
            if(BoxState==false){
           GoDown();
        }

            else if (BoxState==true){
            GoUp();
              }
    
        }
public void GoDown(){
    BoxState=true;
    while(!DLimitSwitch.get()){
armMotor.set(ControlMode.PercentOutput, 1);
    }
armMotor.set(ControlMode.PercentOutput, 0);
}

public void GoUp(){
BoxState=false;
        while(!ULimitSwitch.get()){
    armMotor.set(ControlMode.PercentOutput, -1);
                }
    armMotor.set(ControlMode.PercentOutput, 0);
}
    //Funcion para poner salidas a SmartDashBoard 
    public void ShooterLogsOutput(){/*codigo para dar salidas a SmartDashBoard*/
        SmartDashboard.putBoolean("Estado de LImits", ULimitSwitch.get());
    }
        
    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    }
}


