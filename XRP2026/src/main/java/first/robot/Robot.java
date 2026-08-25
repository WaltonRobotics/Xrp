// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import first.robot.autons.SimpleAutons;
import first.robot.subsystems.XRPDrivetrain;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  private final XRPDrivetrain m_drivetrain = new XRPDrivetrain();
  private XboxController m_controller = new XboxController(0);

  private DoubleSupplier m_leftY = () -> -m_controller.getLeftY();
  private DoubleSupplier m_rightX = () -> -m_controller.getRightX();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {}

  /** This function is for configuring all button bindings. */
  private void configureButtonBindings() {}

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and utility.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /** This function is called once when autonomous is enabled. */
  @Override
  public void autonomousInit() {
    m_drivetrain.resetEncoders();
    CommandScheduler.getInstance().schedule(SimpleAutons.forward(m_drivetrain));
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().schedule(m_drivetrain.arcadeDriveCmd(m_leftY, m_rightX));
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}
}
