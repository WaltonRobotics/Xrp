package first.robot.autons;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import first.robot.subsystems.XRPDrivetrain;


public class SimpleAutons {
    public static Command dance(XRPDrivetrain drivetrain) {
        return Commands.sequence(
            forward(drivetrain),
            backward(drivetrain),
            forward(drivetrain),
            backward(drivetrain),
            spin(drivetrain)
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

    public static Command forward2_Feet(XRPDrivetrain drivetrain) {
        BooleanSupplier isDistanceMet = () -> (drivetrain.getLeftDistanceInch() >= 24.0);
        return Commands.deadline( 
            Commands.waitUntil(isDistanceMet) ,
             Commands.run(() -> drivetrain.arcadeDrive(1, 0))
        );
    } 

        public static Command backward2_Feet(XRPDrivetrain drivetrain) { /////////////////////////////////////////
        BooleanSupplier isDistanceMet = () -> (drivetrain.getLeftDistanceInch() <= -24.0);
        return Commands.deadline( 
            Commands.waitUntil(isDistanceMet) ,
             Commands.run(() -> drivetrain.arcadeDrive(-1, 0))
        );
    } 
   
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
             Commands.waitSeconds(2),
             Commands.run(() -> drivetrain.tankDrive(1, -1)) // Should Spin in place using tankDrive
        );
    }
    public static Command spinF(XRPDrivetrain drivetrain) {
        return Commands.deadline( 
             Commands.run(() -> drivetrain.tankDrive(1, -1)) // Should Spin in place using tankDrive
        );
    }
}

// RunEnd
