package org.firstinspires.ftc.teamcode.ButtonMaps.Drive;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ButtonMaps.AbstractButtonMap;
import org.firstinspires.ftc.teamcode.ButtonMaps.HolonomicDrive;
import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.ComplexRobots.FirstAgeTempbot;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
public class RomanDrive extends AbstractButtonMap {
    // defines deadzones for triggers and joystick
    //MAGIC NUMBERS!!!!!
static double triggerDeadZone = .1;
static double triggerLinearity = 1; //1 is linear relation, 2 is quadratic finer controll at lower motor speeds less at high speeds, .2 is opposite controll at high speeds
static double joystickDeadZone = .1;
static double joystickLinearity = 4;
    @Override
    public void loop(FirstAgeTempbot robot, OpMode opMode) {
        MotorPowers mp = getMotorPowers(
                opMode.gamepad1.dpad_up,
                opMode.gamepad1.dpad_down,
                opMode.gamepad1.dpad_left,
                opMode.gamepad1.dpad_right,
                opMode.gamepad1.left_bumper,
                opMode.gamepad1.right_bumper,
                opMode.gamepad1.left_trigger,
                opMode.gamepad1.right_trigger,
                opMode.gamepad1.left_stick_y,
                opMode.gamepad1.left_stick_x,
                opMode.gamepad1.x);
        opMode.telemetry.update();
        robot.setMotorPowers(mp);
    }

    public static MotorPowers getMotorPowers(
            boolean dpad_up,
            boolean dpad_down,
            boolean dpad_left,
            boolean dpad_right,
            boolean left_bumper,
            boolean right_bumper,
            double left_trigger,
            double right_trigger,
            double left_stick_y,
            double left_stick_x,
            boolean x) {

        double forward = 0;
        double strafe = 0;
        double turn = 0;
        double speed = .8;

        if (dpad_up) {
            forward += 1;
        }
        if (dpad_down) {
           forward -= 1;
        }
        if (dpad_left) {
            strafe -=1;
        }
        if (dpad_right) {
            strafe += 1;
        }

        //Turn Left or Right
        if (left_trigger > triggerDeadZone || right_trigger > triggerDeadZone) {
            turn += Math.pow((right_trigger-triggerDeadZone), triggerLinearity)/Math.pow((1-triggerDeadZone), triggerLinearity) - Math.pow((left_trigger-triggerDeadZone), triggerLinearity)/Math.pow((1-triggerDeadZone), triggerLinearity); //look mommy an afront to coders everywhere (it also works first try :333)
        }

        //Turn Right
        if (right_trigger > triggerDeadZone) {
            turn += right_trigger;
        }

        //When left trigger is pressed, go backward
        if (left_trigger > 0.3) {
            turn -= left_trigger;
        }
        //When right trigger is pressed move forward

        //the MOAMF (Mother Of All Movement Functions
        //Allows Joystick and triggers to control where the robot goes
        if (Math.abs(left_stick_y) > joystickDeadZone || Math.abs(left_stick_x) > joystickDeadZone || left_trigger > triggerDeadZone || right_trigger > triggerDeadZone) {
            double scalingFactor = Math.max(1, Math.abs(left_stick_x * 1.1));
            double turnSpeed = Math.pow((right_trigger-triggerDeadZone), triggerLinearity)/Math.pow((1-triggerDeadZone), triggerLinearity) - Math.pow((left_trigger-triggerDeadZone), triggerLinearity)/Math.pow((1-triggerDeadZone), triggerLinearity);
            double forwardSpeed = 0;
            double strafeSpeed = 0;
            if (left_stick_y > joystickDeadZone) {
                forwardSpeed = Math.pow((left_stick_y-joystickDeadZone), joystickLinearity)/Math.pow((1-joystickDeadZone), joystickLinearity);
            }
            if (left_stick_x > joystickDeadZone) {
                strafeSpeed = Math.pow((left_stick_x-joystickDeadZone), joystickLinearity)/Math.pow((1-joystickDeadZone), joystickLinearity);
            }
            if (left_stick_y < -joystickDeadZone) {
                forwardSpeed = -Math.pow((left_stick_y+joystickDeadZone), joystickLinearity)/Math.pow((1-joystickDeadZone), joystickLinearity); //congrats you got the the end of this line of code, would you like to see more :3
            }
            if (left_stick_x < -joystickDeadZone) {
                strafeSpeed = -Math.pow((left_stick_x+joystickDeadZone), joystickLinearity)/Math.pow((1-joystickDeadZone), joystickLinearity);
            }
            forward -= forwardSpeed;
            strafe += strafeSpeed;
            turn += turnSpeed;
        }

        //Slow strafe while holding x
        if (x) {
            speed = .5;
        }

        return HolonomicDrive.omniFunctionDrive(forward, strafe, turn, speed);
    }

}