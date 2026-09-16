package first.robot.autons;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import first.robot.subsystems.XRPDrivetrain;


public class SimpleAutons {
    public static Command nothing(XRPDrivetrain drivetrain) {
        return Commands.none();
    }

    public static Command forward(XRPDrivetrain drivetrain) {
        return Commands.sequence(
            /**Commands.deadline(
                Commands.waitSeconds(2),
                Commands.run(() -> drivetrain.tankDrive(1.0, 0.968))      
            ), */
            Commands.deadline(
                Commands.waitSeconds(0.25),
                Commands.run(() -> drivetrain.tankDrive(0, 0.9))      
            ),
                        Commands.deadline(
                Commands.waitSeconds(1.6),
                Commands.run(() -> drivetrain.tankDrive(1.0, 0.968))      
            )
        );
    }
}
