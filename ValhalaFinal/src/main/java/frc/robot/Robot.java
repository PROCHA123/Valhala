package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Auto.Actions.GetTimeAction;
import frc.robot.Auto.Actions.MoveForwardAction;
import frc.robot.Auto.Actions.StopAction;
import frc.robot.Auto.Modes.LineTimer;
import frc.robot.controlboard.ControlBoard;
import frc.robot.subsystems.AllSystems;
import frc.robot.subsystems.BoxSystem;
import frc.robot.subsystems.Drive;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  //private RobotContainer m_robotContainer;
    Drive mDrive = new Drive();
    AllSystems mAllSystems = new AllSystems();
    BoxSystem mBoxSystem = new BoxSystem();
  //Incializacion de acciones autonomo  
    GetTimeAction mAutoTimer = new GetTimeAction();
    MoveForwardAction mMoveForwardAction = new MoveForwardAction();
    StopAction mStopAction = new StopAction();
    LineTimer mLineTimerMode = new LineTimer();

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    mAutoTimer.autoRelativeTimeControl(); //inicializar el timeStap relativo a auto
  }

  @Override
  public void autonomousPeriodic() {
   mAutoTimer.autoAbsoluteTimeControl(); //inicializa el timeStap absoluto
    if(mAutoTimer.getAbsoluteTimer()-mAutoTimer.getRelativeTimer()<2){
     mMoveForwardAction.finalMoveForwardACtion();
    }
    else mStopAction.finalStopAction();
 }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    //drive
    mDrive.mainDrive( ControlBoard.getInstance().getVelocityY(), ControlBoard.getInstance().getTotalVelocityX(), 
    ControlBoard.getInstance().getDirectThrottle(), ControlBoard.getInstance().getInverted());
    //Movimient general con joystick derecho. solo adelante gatillos y solo girar sobre su eje es el joystick izquierdo.
// Hopper y intake
    mAllSystems.TAllSystems(ControlBoard.getInstance().getContinous(), ControlBoard.getInstance().getAlterno()); //boton X y funcion alterno es algo especial solo cuando este apagdo, se enciede los sistemas mientras que este boton este presionado.
    // arms
   mBoxSystem.TBoxSystem(ControlBoard.getInstance().armMove());//boton B
  }
  


  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
