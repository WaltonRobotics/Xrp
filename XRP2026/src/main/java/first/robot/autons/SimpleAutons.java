package first.robot.autons;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import first.robot.subsystems.XRPDrivetrain;


public class SimpleAutons {
    public static Command RunningXrp(XRPDrivetrain drivetrain) {
        return Commands.none();
    }

    public static Command forward (XRPDrivetrain drivetrain) {
        return Commands.deadline(
            Commands.waitSeconds(7),
            Commands.run(() -> drivetrain.arcadeDrive(0.7, 0))
        );
    
    }
    public Command Parallel(XRPDrivetrain drivetrainXRPDrivetrain) {

        return Commands.parallel();
     
        
    }

    public static Command leftRight(XRPDrivetrain drivetrainXRPDrivetrain) {
        return Commands.sequence(forward(drivetrainXRPDrivetrain),
        Command. ,
        );
    }
}
