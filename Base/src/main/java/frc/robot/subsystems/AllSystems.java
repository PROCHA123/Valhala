package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AllSystems extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public VictorSPX intakeMotor = new VictorSPX(Constants.kIntakeId);
  private VictorSPX hopperMotor = new VictorSPX(Constants.kHopperId);

  //INPUTS ------------------------------------------------------------------>
  boolean State = false; 
  boolean Full = false;
  boolean path = true;
  
  public AllSystems() {  } //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  public void TAllSystems(boolean inState, boolean inFull, boolean dead){
    State = inState;
    Full = inFull;
    if (dead){
      path=true;
      intakeMotor.set(ControlMode.PercentOutput, 0.0);
      hopperMotor.set(ControlMode.PercentOutput, 0.0);
    } 
   if(State==true){
    if(path==true){
      path=false;
      intakeMotor.set(ControlMode.PercentOutput, 0.8);
      hopperMotor.set(ControlMode.PercentOutput, -0.8);
    }
    else{
      path=true;
      intakeMotor.set(ControlMode.PercentOutput,-0.5);
      hopperMotor.set(ControlMode.PercentOutput, 0);
    }
   }

   if((path==false)&&(Full==true)){
            while((path==false)&&(Full==true)){
            intakeMotor.set(ControlMode.PercentOutput, 0.5);
            hopperMotor.set(ControlMode.PercentOutput, -0.2);
          }
          intakeMotor.set(ControlMode.PercentOutput, -0.5);
          hopperMotor.set(ControlMode.PercentOutput, 0);
        }
  }
  public void AutoAllSystems(){
       path = false;
      intakeMotor.set(ControlMode.PercentOutput, 0.5);
      hopperMotor.set(ControlMode.PercentOutput, -0.8);

    }
  //Funcion para poner salidas a SmartDashBoard 
  public void IntakeLogsOutput(){
    SmartDashboard.putBoolean("State", State);
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
