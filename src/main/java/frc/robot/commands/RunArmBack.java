// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class RunArmBack extends CommandBase {
  /** Creates a new RunArm. */

  private final Arm arm;
  private final XboxController secondary;

  public RunArmBack(Arm arm, XboxController secondary) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.arm = arm;
    this.secondary = secondary;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.setPower(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (secondary.getAButtonPressed()) {
      arm.setPower(0.24);
    } else {
      arm.setPower(secondary.getLeftTriggerAxis() * -0.1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
