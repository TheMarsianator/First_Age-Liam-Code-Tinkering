package org.firstinspires.ftc.teamcode.ButtonMaps.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
import org.firstinspires.ftc.teamcode.ButtonMaps.HolonomicDrive;
import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeRobot;

public class OurTeleOpBM extends AbstractButtonMap {

    @Override
    public void loop(FirstAgeRobot robot, OpMode opMode) {
        MotorPowers mp = HolonomicDrive.fieldOrientedDrive(opMode.gamepad1, 1.0);

        opMode.telemetry.update();

        robot.setMotorPowers(mp);
}
}
