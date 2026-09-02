// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.xrp.XRPMotor;

public class XRPDrivetrain {
  private static final double kGearRatio =
      (30.0 / 14.0) * (28.0 / 16.0) * (36.0 / 9.0) * (26.0 / 8.0); // 48.75:1
  private static final double kCountsPerMotorShaftRev = 12.0;
  private static final double kCountsPerRevolution = kCountsPerMotorShaftRev * kGearRatio; // 585.0
  private static final double kWheelDiameterInch = 2.3622; // 60 mm

  // The XRP has the left and right motors set to
  // channels 0 and 1 respectively
  private final XRPMotor leftMotor = new XRPMotor(0);
  private final XRPMotor rightMotor = new XRPMotor(1);

  // The XRP has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private final Encoder leftEncoder = new Encoder(4, 5);
  private final Encoder rightEncoder = new Encoder(6, 7);

  // Set up the differential drive controller
  private final DifferentialDrive diffDrive =
      new DifferentialDrive(leftMotor, rightMotor);

  /** Creates a new XRPDrivetrain. */
  public XRPDrivetrain() {
    // Use inches as unit for encoder distances
    leftEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    rightEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    resetEncoders();

    // Invert right side since motor is flipped
    rightMotor.setInverted(true);
  }

  public void arcadeDrive(double xaxisVelocity, double zaxisRotate) {
      diffDrive.arcadeDrive(xaxisVelocity, zaxisRotate);
    }

  public Command arcadeDriveCmd(DoubleSupplier supp_xaxisVelocity, DoubleSupplier supp_zaxisRotate) {
    return Commands.run(() -> arcadeDrive(supp_xaxisVelocity.getAsDouble(), supp_zaxisRotate.getAsDouble()));
  }

  public void tankDrive(double supp_leftWheelVelocity, double supp_rightWheelVelocity) {
      diffDrive.tankDrive(supp_leftWheelVelocity, supp_rightWheelVelocity);
    }

  public Command tankDriveCmd(DoubleSupplier supp_leftWheelVelocity, DoubleSupplier supp_rightWheelVelocity) {
    return Commands.run(() -> tankDrive(supp_leftWheelVelocity.getAsDouble(), supp_rightWheelVelocity.getAsDouble()));
  }


  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double getLeftDistanceInch() {
    return leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return rightEncoder.getDistance();
  }
}
