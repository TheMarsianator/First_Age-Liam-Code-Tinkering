package org.firstinspires.ftc.teamcode.ButtonMaps.Drive;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
import org.firstinspires.ftc.teamcode.ButtonMaps.DPadControl;
import org.firstinspires.ftc.teamcode.ButtonMaps.HolonomicDrive;
import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeRobot;

@Config
public class TrainingBM extends AbstractButtonMap {

    private MotorPowers mp;// = new MotorPowers(0);
    private boolean servoState=false;

    @Override
    public void loop(FirstAgeRobot robot, OpMode opMode) {
        mp = new MotorPowers(0);
        double multiplier = 1;
        int leftFrontWheel = 0;
        int leftBackWheel = 0;
        int rightFrontWheel = 0;
        int rightBackWheel = 0;


        if (opMode.gamepad1.right_bumper) {
            multiplier += 0.1;
        }
        if (opMode.gamepad1.left_bumper) {
            multiplier -= 0.1;
        }
        if (opMode.gamepad1.x) {
            multiplier = 1;
        }
        if (opMode.gamepad1.a) {
            servoState = !servoState;
            if (servoState) {
                robot.turnServo.setPosition(1);
            } else {
                robot.turnServo.setPosition(-1);
            }
        }
        if (opMode.gamepad1.left_trigger>0.3){
            mp = new MotorPowers(-1 * multiplier * opMode.gamepad1.right_trigger,
                    1 * multiplier * opMode.gamepad1.right_trigger,
                    -1 * multiplier * opMode.gamepad1.right_trigger,
                    1 * multiplier* opMode.gamepad1.right_trigger);
        }
        if (opMode.gamepad1.right_trigger>0.3){
            mp = new MotorPowers(1 * multiplier * opMode.gamepad1.right_trigger,
                    -1 * multiplier * opMode.gamepad1.right_trigger,
                    1 * multiplier * opMode.gamepad1.right_trigger,
                    -1 * multiplier* opMode.gamepad1.right_trigger);
        }


        if (opMode.gamepad1.dpad_down) {
            if (opMode.gamepad1.dpad_left) {
                mp = new MotorPowers(-1 * multiplier,
                        0 * multiplier,
                        0 * multiplier,
                        -1 * multiplier);
            }
            if (opMode.gamepad1.dpad_right){
                mp = new MotorPowers(0 * multiplier,
                        -1 * multiplier,
                        -1 * multiplier,
                        0 * multiplier);
            }
            else {
                mp = new MotorPowers(-1 * multiplier,
                        -1 * multiplier,
                        -1 * multiplier,
                        -1 * multiplier);
            }
        } else if (opMode.gamepad1.dpad_up) {
            if (opMode.gamepad1.dpad_left) {
                mp = new MotorPowers(0 * multiplier,
                        1 * multiplier,
                        1 * multiplier,
                        0 * multiplier);
            }
           else if (opMode.gamepad1.dpad_right) {
                mp = new MotorPowers(1 * multiplier,
                        0 * multiplier,
                        0 * multiplier,
                        1 * multiplier);
            } else {
                mp = new MotorPowers(1 * multiplier,
                        1 * multiplier,
                        1 * multiplier,
                        1 * multiplier);
            }
        } else if (opMode.gamepad1.dpad_right){
            mp = new MotorPowers(1 * multiplier,
                    -1 * multiplier,
                    -1 * multiplier,
                    1 * multiplier);
        } else if (opMode.gamepad1.dpad_left){
            mp = new MotorPowers(-1 * multiplier,
                    1 * multiplier,
                    1 * multiplier,
                    -1 * multiplier);
        }
        if (Math.abs(opMode.gamepad1.left_stick_x) > 0.2 || Math.abs(opMode.gamepad1.left_stick_y) > 0.2){
            mp = HolonomicDrive.JoystickHoloDrive(opMode.gamepad1);
        }
        opMode.telemetry.update();
        robot.setMotorPowers(mp);


    }
}