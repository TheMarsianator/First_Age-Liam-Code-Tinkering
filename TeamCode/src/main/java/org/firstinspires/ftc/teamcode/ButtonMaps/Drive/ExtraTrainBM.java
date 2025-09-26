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
    private MotorPowers mp;// = new MotorPowers(0);
    private double stickMultiplier = 0.7;  //motor multiplier for movement with joystick
    private double slowMultiplier = 0.5;  //motor multiplier to slow down
    private double servoPosition;  //variable that stores servo position

    @Override
    public void loop(FirstAgeRobot robot, OpMode opMode) {
        mp = new MotorPowers(0);  //sets all motor powers to 0


        //forwards
        if(Math.abs(opMode.gamepad1.left_stick_y) > 0.1){
            mp = new MotorPowers(opMode.gamepad1.left_stick_y * stickMultiplier,
                    opMode.gamepad1.left_stick_y * stickMultiplier,
                    opMode.gamepad1.left_stick_y * stickMultiplier,
                    opMode.gamepad1.left_stick_y * stickMultiplier);
            opMode.telemetry.addLine("Joystick (forward) active!");  //shows up in console
        }

        //backwards
        if(Math.abs(opMode.gamepad1.left_stick_y) < -0.1){
            mp = new MotorPowers(-opMode.gamepad1.left_stick_y * stickMultiplier,
                    -opMode.gamepad1.left_stick_y * stickMultiplier,
                    -opMode.gamepad1.left_stick_y * stickMultiplier,
                    -opMode.gamepad1.left_stick_y * stickMultiplier);
            opMode.telemetry.addLine("Joystick (backwards) active!");  //shows up in console
        }

        //turn right
        if(Math.abs(opMode.gamepad1.right_stick_x) > 0.1){
            mp = new MotorPowers(opMode.gamepad1.right_stick_x * stickMultiplier,
                    -opMode.gamepad1.right_stick_x * stickMultiplier,
                    opMode.gamepad1.right_stick_x * stickMultiplier,
                    -opMode.gamepad1.right_stick_x * stickMultiplier);
            opMode.telemetry.addLine("Joystick (right turn) active!");  //shows up in console
        }

        //turn left
        if(Math.abs(opMode.gamepad1.right_stick_x) < -0.1){
            mp = new MotorPowers(-opMode.gamepad1.right_stick_x * stickMultiplier,
                    -opMode.gamepad1.right_stick_x * stickMultiplier,
                    -opMode.gamepad1.right_stick_x * stickMultiplier,
                    -opMode.gamepad1.right_stick_x * stickMultiplier);
            opMode.telemetry.addLine("Joystick (left turn) active!");  //shows up in console
        }

        //accelerate
        if(Math.abs(opMode.gamepad1.right_trigger) > 0.1) {
            mp = new MotorPowers(opMode.gamepad1.right_trigger * 1.1 * stickMultiplier,
                    opMode.gamepad1.right_trigger * 1.1 * stickMultiplier,
                    opMode.gamepad1.right_trigger * 1.1 * stickMultiplier,
                    opMode.gamepad1.right_trigger * 1.1 * stickMultiplier);
            opMode.telemetry.addLine("Right Trigger (accelerate) active!");  //shows up in console
        }

        //slow down
        if (opMode.gamepad1.left_trigger > 0.1) {
            mp = new MotorPowers(opMode.gamepad1.left_trigger * slowMultiplier,
                    opMode.gamepad1.left_trigger * slowMultiplier,
                    opMode.gamepad1.left_trigger * slowMultiplier,
                    opMode.gamepad1.left_trigger * slowMultiplier);
            opMode.telemetry.addLine("Slow Multiplier Active!");  //shows up in console
        }

        //brake
        if (opMode.gamepad1.b) {
            robot.setAllMotorPowers(0);
            robot.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            opMode.telemetry.addLine("Brake!!");  //shows up in console
        }

        //strafe right
        if (opMode.gamepad1.dpad_right) {
            mp = new MotorPowers(0.5,
                    -0.5,
                    -0.5,
                    0.5);
            opMode.telemetry.addLine("Right Strafe active!");  //shows up in console
        }

        //strafe left
        if (opMode.gamepad1.dpad_left) {
            mp = new MotorPowers(-0.5,
                    0.5,
                    0.5,
                    -0.5);
            opMode.telemetry.addLine("Left Strafe active!");  //shows up in console
        }

        //servo positions
        else if (opMode.gamepad1.y) {
            servoPosition = 1;  //assume left
        }
        else if (opMode.gamepad1.x) {
            servoPosition = 0;  //assume rest
        }

        else if (opMode.gamepad1.a) {
            servoPosition = -1;  //assume right
        }

        robot.turnServo.setPosition(servoPosition);
        opMode.telemetry.update();
        robot.setMotorPowers(mp);
    }
}
