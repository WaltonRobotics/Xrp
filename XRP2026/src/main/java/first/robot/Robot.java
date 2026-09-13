// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot;

import java.util.function.DoubleSupplier;
import java.util.function.BooleanSupplier;

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
  private DoubleSupplier m_tankLeftY = () -> -m_controller.getLeftY();
  private DoubleSupplier m_tankRightY = () -> -m_controller.getRightY();
    private DoubleSupplier m_scruedupdesignnumberdos = () -> m_controller.getLeftTriggerAxis();
  private DoubleSupplier m_scruedupdesignnumberunos = () -> m_controller.getRightTriggerAxis(); // what does - due
  private BooleanSupplier m_buttonPressedA = () -> m_controller.getAButton();
  private BooleanSupplier m_buttonPressedB = () -> m_controller.getBButton();
  private BooleanSupplier m_buttonPressedX = () -> m_controller.getXButton();
  private BooleanSupplier m_buttonPressedY = () -> m_controller.getYButton();


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
    //CommandScheduler.getInstance().schedule(SimpleAutons.forward2_Feet(m_drivetrain));
        m_drivetrain.resetEncoders();
        CommandScheduler.getInstance().schedule(SimpleAutons.forward2_Feet(m_drivetrain));
 // should make robot go backward NOT TESTED
    }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
  //  if(m_buttonPressedA.getAsBoolean() == true) {
  //    CommandScheduler.getInstance().schedule(m_drivetrain.tankDriveCmd(m_tankLeftY, m_tankRightY));
  //}
  //  if(m_buttonPressedB.getAsBoolean() == true) {
    CommandScheduler.getInstance().schedule(m_drivetrain.TarcadeDriveCmd(m_leftY, m_rightX));
  //}
}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
      if(m_buttonPressedA.getAsBoolean() == true) {
        //CommandScheduler.getInstance().schedule(m_drivetrain.tankDriveCmd(m_tankLeftY, m_tankRightY));
        m_drivetrain.resetEncoders();
        CommandScheduler.getInstance().schedule(SimpleAutons.forward2_Feet(m_drivetrain));
      }
      if(m_buttonPressedB.getAsBoolean() == true) {
        //CommandScheduler.getInstance().schedule(m_drivetrain.arcadeDriveCmd(m_leftY, m_rightX));
        m_drivetrain.resetEncoders();
        CommandScheduler.getInstance().schedule(SimpleAutons.backward2_Feet(m_drivetrain)); 
      }
      if(m_buttonPressedY.getAsBoolean() == true) {
        //CommandScheduler.getInstance().schedule(m_drivetrain.arcadeDriveCmd(m_scruedupdesignnumberunos, m_scruedupdesignnumberdos));
        m_drivetrain.resetEncoders();
        CommandScheduler.getInstance().schedule(SimpleAutons.dance(m_drivetrain)); 
      }   
       if(m_buttonPressedX.getAsBoolean() == true) {
        CommandScheduler.getInstance().schedule(m_drivetrain.tankDriveCmd(m_leftY, m_rightX));
        //m_drivetrain.resetEncoders();
        //CommandScheduler.getInstance().schedule(SimpleAutons.spinF(m_drivetrain));  
      }
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}
}
