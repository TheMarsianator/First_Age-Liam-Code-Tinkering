package org.firstinspires.ftc.teamcode.ButtonMaps.Drive;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
import org.firstinspires.ftc.teamcode.ButtonMaps.DPadControl;
import org.firstinspires.ftc.teamcode.ButtonMaps.HolonomicDrive;
import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.ButtonMaps.SkystoneAbstractButtonMap;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeRobot;

@Config
public class TrainingBM extends AbstractButtonMap {

    private MotorPowers mp;// = new MotorPowers(0);


    @Override
    public void loop(FirstAgeRobot robot, OpMode opMode) {
        mp = new MotorPowers(0);

        


        opMode.telemetry.update();
        robot.setMotorPowers(mp);
    }
}
