package org.firstinspires.ftc.teamcode.TeleOp;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
//import org.firstinspires.ftc.teamcode.ButtonMaps.Drive.TestingTeleOpBM;
import org.firstinspires.ftc.teamcode.ButtonMaps.Drive.TrainingBM;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeRobot;
import org.firstinspires.ftc.teamcode.ComplexRobots.TrikeRobot;

@TeleOp(name="Training TeleOp")
public class trainingTeleOp extends OpMode {
    //Global Variables
    FirstAgeRobot robot;

    //Button Maps
    AbstractButtonMap driveButtonMap;

    @Override
    public void init() {
        telemetry.addLine("Initializing, please wait...");
        telemetry.update();
        robot = new FirstAgeRobot(hardwareMap, new Pose2d(0,0,0));
        driveButtonMap = new TrainingBM();
        telemetry.addLine("Ready.");
        telemetry.update();
    }

    @Override
    public void loop() {
        driveButtonMap.loop(robot, this);
        telemetry.update();
    }
}
