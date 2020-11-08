/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private Spark leftFront,leftRear,rightFront,rightRear;
  private SpeedControllerGroup leftMotors,rightMotors;
  private DifferentialDrive drive;
  public DriveTrain() {
    leftFront = new Spark(Constants.LEFT_FRONT_PWM);
    leftRear = new Spark(Constants.LEFT_REAR_PWM);
    rightFront = new Spark(Constants.RIGHT_FRONT_PWM);
    rightRear = new Spark(Constants.RIGHT_REAR_PWM);
    leftMotors = new SpeedControllerGroup(leftFront,leftRear);
    rightMotors = new SpeedControllerGroup(rightFront,rightRear);
    leftMotors.setInverted(true);
    rightMotors.setInverted(false);
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveWithJoysticks(XboxController controller){
    drive.tankDrive(controller.getRawAxis(Constants.LEFT_JOY_AXIS)*Constants.DRIVETRAIN_SPEED, controller.getRawAxis(Constants.RIGHT_JOY_AXIS)*Constants.DRIVETRAIN_SPEED);
  }
  public void stop(){
    drive.stopMotor();
  }
  public void driveForward(double speed){
    drive.tankDrive(speed, speed);
  }
}
