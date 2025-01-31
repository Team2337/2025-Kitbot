// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.CTREUtils;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

/** Class to run the rollers over CAN */
public class CANRollerSubsystem extends SubsystemBase {
  private final TalonFX rolllerMotor = new TalonFX(40);

  public CANRollerSubsystem() {
    // Set up the roller motor as a brushed motor

    // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.


    // Create and apply configuration for roller motor. Voltage compensation helps
    // the roller behave the same as the battery
    // voltage dips. The current limit helps prevent breaker trips or burning out
    // the motor in the event the roller stalls.
    TalonFXConfiguration rollerMotorConfig = new TalonFXConfiguration();
      rollerMotorConfig.withCurrentLimits(CTREUtils.setDefaultCurrentLimit());
      rollerMotorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
      rollerMotorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
      rollerMotorConfig.Voltage.PeakForwardVoltage = 12;
      rollerMotorConfig.Voltage.PeakReverseVoltage = -12;
      rolllerMotor.getConfigurator().apply(rollerMotorConfig);
    }

public void setRollerSpeed(double speed){
  rolllerMotor.set(speed);
}

public void stopRollerMotor() {
  rolllerMotor.set(0);
}

  @Override
  public void periodic() {
  }

  // Command to run the roller with joystick input

}
