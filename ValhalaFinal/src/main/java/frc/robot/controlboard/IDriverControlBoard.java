// ✓
package frc.robot.controlboard;

public interface IDriverControlBoard {
    double getVelocityX();

    double getVelocityY();

    double getTotalVelocityX();

    double getDirectThrottle();

    double getTurn();

    boolean getInverted();
}