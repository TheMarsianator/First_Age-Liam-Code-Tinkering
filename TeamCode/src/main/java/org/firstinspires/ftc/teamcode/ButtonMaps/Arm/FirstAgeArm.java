package org.firstinspires.ftc.teamcode.ButtonMaps.Arm;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeTempbot;

@Config
public class FirstAgeArm extends AbstractButtonMap {
    //TODO: Change back to private final when done with dash
    private MotorPowers mp;// = new MotorPowers(0);
    private double servoPosition;

    @Override
    public void loop(FirstAgeTempbot robot, OpMode opMode) {
//        mp = new MotorPowers(0);







//        robot.turnServo.setPosition(servoPosition);
        opMode.telemetry.update();
//        robot.setMotorPowers(mp);
    }
}
