package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BoxSystem extends SubsystemBase{
    
    //Hardware ----------------------------------------------------------------->
    public VictorSPX armMotor = new VictorSPX(Constants.kArmsId);
    //INPUTS ------------------------------------------------------------------>
    boolean BoxState = true; 
    boolean ArmIn = false;
    double movement= 0;
    DigitalInput DLimitSwitch = new DigitalInput(Constants.kDLimitSwitch);
    DigitalInput ULimitSwitch = new DigitalInput(Constants.kULimitSwitch);

    public BoxSystem() {} //constructor del subsistema

    //------------------// Funciones del subsistema //-------------------------------//

    //Funcion para disparar
    public void TBoxSystem(boolean inArm, double movementIn ){
        ArmIn = inArm;
        movement=-movementIn;
        if(ArmIn){
            if(BoxState==false){
            BoxState=true;
            while(!DLimitSwitch.get()){
        armMotor.set(ControlMode.PercentOutput, -1);
            }
        armMotor.set(ControlMode.PercentOutput, 0);
        }

        else if (BoxState==true){
            BoxState=false;
            while(!ULimitSwitch.get()){
        armMotor.set(ControlMode.PercentOutput, 1);
                    }
        armMotor.set(ControlMode.PercentOutput, 0);
            }
        }
        if (movement!= 0){
            while((movement>0)&&!ULimitSwitch.get()){
                armMotor.set(ControlMode.PercentOutput, movement);
                BoxState=false;
            }
            while((movement<0)&&!DLimitSwitch.get()){
                armMotor.set(ControlMode.PercentOutput, movement);
                BoxState=true;
            }
            if(ULimitSwitch.get()||movement==0||DLimitSwitch.get()){
                armMotor.set(ControlMode.PercentOutput, 0);
                }
        }
    }
            public void GoDown(){
                BoxState=true;
                while(!DLimitSwitch.get()){
            armMotor.set(ControlMode.PercentOutput, -1);
                }
                    armMotor.set(ControlMode.PercentOutput, 0);
            }

            public void GoUp(){
            BoxState=false;
                    while(!ULimitSwitch.get()){
                armMotor.set(ControlMode.PercentOutput, 1);
                            }
                armMotor.set(ControlMode.PercentOutput, 0);
            }
    



    //Funcion para poner salidas a SmartDashBoard 
    public void ShooterLogsOutput(){/*codigo para dar salidas a SmartDashBoard*/
        SmartDashboard.putBoolean("Estado de LImitsU", ULimitSwitch.get());
        SmartDashboard.putBoolean("Estado de LImitsD", DLimitSwitch.get());
    }
        
    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    }

    public void armMotor(ControlMode percentoutput, int i) {
    }
}


