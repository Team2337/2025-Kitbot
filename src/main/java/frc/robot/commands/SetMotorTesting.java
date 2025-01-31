package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANRollerSubsystem;

public class SetMotorTesting extends Command{
    private CANRollerSubsystem motorTesting;

    public SetMotorTesting(CANRollerSubsystem motorTesting) {
        this.motorTesting = motorTesting;
        addRequirements(motorTesting);
    }

    @Override
    public void initialize(){

    }

    @Override 
    public void execute() {
        motorTesting.setRollerSpeed(-0.2);
    }

    @Override
    public void end(boolean interrupted) {
        motorTesting.stopRollerMotor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}