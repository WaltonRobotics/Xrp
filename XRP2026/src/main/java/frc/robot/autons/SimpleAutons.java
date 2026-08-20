package frc.robot.autons;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Drivetrain;

public class SimpleAutons {
    public static Command nothing(Drivetrain drivetrain) {
        return Commands.sequence(
            Commands.none()
        );
    }

    public static Command forward(Drivetrain drivetrain) {
        return Commands.sequence(
            Commands.run(() -> drivetrain.arcadeDrive(0.7, 0.7))
        );
    }
}
