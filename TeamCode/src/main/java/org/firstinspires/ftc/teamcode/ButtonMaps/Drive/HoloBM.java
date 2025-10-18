package org.firstinspires.ftc.teamcode.ButtonMaps.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
import org.firstinspires.ftc.teamcode.ButtonMaps.DPadControl;
import org.firstinspires.ftc.teamcode.ButtonMaps.HolonomicDrive;
import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeTempbot;

public class HoloBM extends AbstractButtonMap {

    @Override
    public void loop(FirstAgeTempbot robot, OpMode opMode) {
        double forward = 0;
        double strafe = 0;
        double turn = 0;

        MotorPowers m = DPadControl.dpadStrafe(opMode, .8);

        forward += (m.leftBack + m.leftFront + m.rightBack + m.rightFront) / 4;
        strafe += (-m.leftBack + m.leftFront + m.rightBack - m.rightFront) / 4;

        if (opMode.gamepad1.left_bumper)
            turn -= 1;
        if (opMode.gamepad1.right_bumper)
            turn += 1;
        if (opMode.gamepad1.left_trigger > 0.1)
            forward -= opMode.gamepad1.left_trigger;
        if (opMode.gamepad1.right_trigger > 0.1)
            forward += opMode.gamepad1.right_trigger;


        MotorPowers mp = HolonomicDrive.omniFunctionDrive(strafe + opMode.gamepad1.left_stick_y, forward + opMode.gamepad1.left_stick_x, turn + opMode.gamepad1.right_stick_x, .8);
        opMode.telemetry.update();
        robot.setMotorPowers(mp);
    }
}
