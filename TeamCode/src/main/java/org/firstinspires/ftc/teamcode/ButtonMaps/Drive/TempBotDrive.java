package org.firstinspires.ftc.teamcode.ButtonMaps.Drive;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
import org.firstinspires.ftc.teamcode.ButtonMaps.DPadControl;
import org.firstinspires.ftc.teamcode.ButtonMaps.HolonomicDrive;
import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeTempbot;

@Config
public class TempBotDrive extends AbstractButtonMap {

    private MotorPowers mp;// = new MotorPowers(0);
    private boolean servoState = false;

    @Override
    public void loop(FirstAgeTempbot robot, OpMode opMode) {
        mp = new MotorPowers(0);
        double multiplier = .8;

        mp = DPadControl.dpadStrafe(opMode, multiplier);

        //Turn Left
        if (opMode.gamepad1.left_bumper) {
            mp = new MotorPowers(-1 * multiplier,
                    1 * multiplier,
                    -1 * multiplier ,
                    1 * multiplier);
        }

        //Turn Right
        if (opMode.gamepad1.right_bumper) {
            mp = new MotorPowers(1 * multiplier,
                    -1 * multiplier,
                    1 * multiplier ,
                    -1 * multiplier);
        }


        //When left trigger is pressed, go backward
        if (opMode.gamepad1.left_trigger > 0.3) {
            mp = new MotorPowers(-1 * multiplier * opMode.gamepad1.left_trigger,
                    -1 * multiplier * opMode.gamepad1.left_trigger,
                    -1 * multiplier * opMode.gamepad1.left_trigger,
                    -1 * multiplier * opMode.gamepad1.left_trigger);
        }
        //When right trigger is pressed move forward
        if (opMode.gamepad1.right_trigger > 0.3) {
            mp = new MotorPowers(1 * multiplier * opMode.gamepad1.right_trigger,
                    1 * multiplier * opMode.gamepad1.right_trigger,
                    1 * multiplier * opMode.gamepad1.right_trigger,
                    1 * multiplier * opMode.gamepad1.right_trigger);
        }




        //Allows Joystick to control where the robot goes
        if (Math.abs(opMode.gamepad1.left_stick_y) > 0.2 || Math.abs(opMode.gamepad1.left_stick_x) > 0.2) {
            mp = HolonomicDrive.JoystickHoloDrive(opMode.gamepad1, opMode);
            opMode.telemetry.addData("Holonomic Drive", mp.leftFront);
            opMode.telemetry.addData("Holonomic Drive", mp.rightFront);
            opMode.telemetry.addData("Holonomic Drive", mp.leftBack);
            opMode.telemetry.addData("Holonomic Drive", mp.rightBack);
        }


        //Slow straife while holding x
        if (opMode.gamepad1.x) {
            mp = new MotorPowers(mp.leftFront / 2, mp.rightFront / 2, mp.leftBack / 2, mp.rightBack / 2);
        }

        mp = new MotorPowers(mp.leftFront, mp.rightFront, mp.leftBack, mp.rightBack);

        opMode.telemetry.update();
        robot.setMotorPowers(mp);
        }
    }
