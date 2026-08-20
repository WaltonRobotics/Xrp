package first.robot.autons;

import org.wpilib.command2.Command;
import org.wpilib.command2.Commands;
import first.robot.subsystems.XRPDrivetrain;


public class SimpleAutons {
    public static Command nothing(XRPDrivetrain drivetrain) {
        return Commands.sequence(
            Commands.none()
        );
    }

    public static Command forward(XRPDrivetrain drivetrain) {
        return Commands.sequence(
            Commands.run(() -> drivetrain.arcadeDrive(0.7, 0.7))
        );
    }
}
