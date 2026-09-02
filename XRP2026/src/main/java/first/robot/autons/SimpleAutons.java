package first.robot.autons;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import first.robot.subsystems.XRPDrivetrain;


public class SimpleAutons {
    public static Command doItAll(XRPDrivetrain drivetrain) {
        return Commands.sequence(
            forward(drivetrain),
            forward(drivetrain),
            backward(drivetrain)
        );
    }

    public static Command nothing(XRPDrivetrain drivetrain) {
        return Commands.none();
    }

    //public static Command forward(XRPDrivetrain drivetrain) {
      //  return Commands.deadline(
        //    Commands.waitSeconds(3),
          //  Commands.run(() -> drivetrain.arcadeDrive(0.7, 0))
       // );
    //}

    public static Command forward(XRPDrivetrain drivetrain) {
        return Commands.deadline( 
             Commands.waitSeconds(1),
             Commands.run(() -> drivetrain.arcadeDrive(1, 0))
        );
    }

    public static Command wait(XRPDrivetrain drivetrain) {
        return Commands.deadline( 
             Commands.waitSeconds(1),
             Commands.run(() -> drivetrain.arcadeDrive(0, 0))
        );
    }


    public static Command backward(XRPDrivetrain drivetrain) {
        return Commands.deadline( 
             Commands.waitSeconds(1),
             Commands.run(() -> drivetrain.arcadeDrive(-1, 0)) // should move backward
        );
    }
    public static Command spin(XRPDrivetrain drivetrain) {
        return Commands.deadline( 
             Commands.waitSeconds(4),
             Commands.run(() -> drivetrain.tankDrive(1, -1)) // Should Spin in place using tankDrive
        );
    }
}
