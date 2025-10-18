package org.firstinspires.ftc.teamcode.ButtonMaps;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

public class DPadControl {

    public static MotorPowers dpadStrafe(OpMode opMode, double multiplier) {
        MotorPowers mp = new MotorPowers(0);
        if (opMode.gamepad1.dpad_down) {
            //When dpad down-left is pressed, moves diagonally down-left
            if (opMode.gamepad1.dpad_left) {
                mp = new MotorPowers(-1 * multiplier,
                        0 * multiplier,
                        0 * multiplier,
                        -1 * multiplier);
            }
            //When dpad down-right is pressed, move diagonally down-right
            else if (opMode.gamepad1.dpad_right) {
                mp = new MotorPowers(0 * multiplier,
                        -1 * multiplier,
                        -1 * multiplier,
                        0 * multiplier);
            }
            //When dpad down is pressed, move straight down
            else {
                mp = new MotorPowers(-1 * multiplier,
                        -1 * multiplier,
                        -1 * multiplier,
                        -1 * multiplier);
            }
        } else if (opMode.gamepad1.dpad_up) {
            //When dpad up-left is pressed, move diagonally up-left
            if (opMode.gamepad1.dpad_left) {
                mp = new MotorPowers(0 * multiplier,
                        1 * multiplier,
                        1 * multiplier,
                        0 * multiplier);
            }
            //When dpad up-right is pressed, move diagonally up-right
            else if (opMode.gamepad1.dpad_right) {
                mp = new MotorPowers(1 * multiplier,
                        0 * multiplier,
                        0 * multiplier,
                        1 * multiplier);
                //When dpad up is pressed, move straight up
            } else {
                mp = new MotorPowers(1 * multiplier,
                        1 * multiplier,
                        1 * multiplier,
                        1 * multiplier);
            }
            //When dpad right is pressed, move straight right
        } else if (opMode.gamepad1.dpad_right) {
            mp = new MotorPowers(1 * multiplier,
                    -1 * multiplier,
                    -1 * multiplier,
                    1 * multiplier);
            //When dpad left is pressed, move straight left
        } else if (opMode.gamepad1.dpad_left) {
            mp = new MotorPowers(-1 * multiplier,
                    1 * multiplier,
                    1 * multiplier,
                    -1 * multiplier);
        }
        return mp;
    }


}
