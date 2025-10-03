package org.firstinspires.ftc.teamcode.ButtonMaps.Drive;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeRobot;

@Config
public class ExtraTrainBM extends AbstractButtonMap {
    //TODO: Change back to private final when done with dash
    private double currentMotorPower;
    private MotorPowers mp;// = new MotorPowers(0);
    private double stickMultipler = 0.7;
    private double slowStrafeMultiplier = 0.5;
    private double servoPosition;

    @Override
    public void loop(FirstAgeRobot robot, OpMode opMode) {
        mp = new MotorPowers(0);

        if(Math.abs(opMode.gamepad1.left_stick_y) > 0.1){
            mp = new MotorPowers(-opMode.gamepad1.left_stick_y * stickMultipler,
                    -opMode.gamepad1.left_stick_y * stickMultipler,
                    -opMode.gamepad1.left_stick_y * stickMultipler,
                    -opMode.gamepad1.left_stick_y * stickMultipler);
            opMode.telemetry.addLine("Joystick (forward) active!");
            opMode.telemetry.addData("Joystick: ", opMode.gamepad1.left_stick_y);
        }
        if(Math.abs(opMode.gamepad1.left_stick_y) < -0.1){
            mp = new MotorPowers(opMode.gamepad1.left_stick_y * stickMultipler,
                    opMode.gamepad1.left_stick_y * stickMultipler,
                    opMode.gamepad1.left_stick_y * stickMultipler,
                    opMode.gamepad1.left_stick_y * stickMultipler);
            opMode.telemetry.addLine("Joystick (backwards) active!");
            opMode.telemetry.addData("Joystick: ", opMode.gamepad1.left_stick_y);
        }

        if(Math.abs(opMode.gamepad1.right_stick_x) > 0.1){
            mp = new MotorPowers(opMode.gamepad1.right_stick_x * stickMultipler,
                    -opMode.gamepad1.right_stick_x * stickMultipler,
                    opMode.gamepad1.right_stick_x * stickMultipler,
                    -opMode.gamepad1.right_stick_x * stickMultipler);
            opMode.telemetry.addLine("Joystick (right turn) active!");
            opMode.telemetry.addData("Joystick: ", opMode.gamepad1.right_stick_x);
        }

        if(Math.abs(opMode.gamepad1.right_stick_x) < -0.1){
            mp = new MotorPowers(-opMode.gamepad1.right_stick_x * stickMultipler,
                    -opMode.gamepad1.right_stick_x * stickMultipler,
                    -opMode.gamepad1.right_stick_x * stickMultipler,
                    -opMode.gamepad1.right_stick_x * stickMultipler);
            opMode.telemetry.addLine("Joystick (left turn) active!");
            opMode.telemetry.addData("Joystick: ", opMode.gamepad1.right_stick_x);
        }

        if(Math.abs(opMode.gamepad1.right_trigger) > 0.1) {
            mp = new MotorPowers(opMode.gamepad1.right_trigger * 1.1 * stickMultipler,
                    opMode.gamepad1.right_trigger * 1.1 * stickMultipler,
                    opMode.gamepad1.right_trigger * 1.1 * stickMultipler,
                    opMode.gamepad1.right_trigger * 1.1 * stickMultipler);
            opMode.telemetry.addLine("Right Trigger (accelerate) active!");
            opMode.telemetry.addData("Right Trigger: ", opMode.gamepad1.right_trigger);
        }

        if (opMode.gamepad1.left_trigger > 0.1) {
            mp = new MotorPowers(opMode.gamepad1.left_trigger * slowStrafeMultiplier,
                    opMode.gamepad1.left_trigger * slowStrafeMultiplier,
                    opMode.gamepad1.left_trigger * slowStrafeMultiplier,
                    opMode.gamepad1.left_trigger * slowStrafeMultiplier);
            opMode.telemetry.addLine("Slow Multiplier Active!");
        }

        if (opMode.gamepad1.b) {
            robot.setAllMotorPowers(0);
            robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            opMode.telemetry.addLine("Brake!!");
        }

        //strafe right
        if (opMode.gamepad1.dpad_right) {
            mp = new MotorPowers(0.5,
                    -0.5,
                    0.5,
                    0.5);
            opMode.telemetry.addLine("Right Strafe active!");
        }

        //strafe left
        if (opMode.gamepad1.dpad_left) {
            mp = new MotorPowers(-0.5,
                    0.5,
                    -0.5,
                    -0.5);
            opMode.telemetry.addLine("Left Strafe active!");
        }

        else if (opMode.gamepad1.y) {
            servoPosition = 1;
        }
        else if (opMode.gamepad1.x) {
            servoPosition = 0;
        }

        else if (opMode.gamepad1.a) {
            servoPosition = -1;
            }



        robot.turnServo.setPosition(servoPosition);
        opMode.telemetry.update();
        robot.setMotorPowers(mp);
    }
}
