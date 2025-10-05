package org.firstinspires.ftc.teamcode.ComplexRobots;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ButtonMaps.MotorPowers;
import org.firstinspires.ftc.teamcode.MecanumDrive;

//This is right now the same as the TrikeRobot, add Pivot turn at some point and some more functionality.

@Config
public class FirstAgeTempbot extends MecanumDrive {
    enum Direction {
        UP,DOWN
    }

    //    public final DcMotorEx ShootMotor1;
    //    public final DcMotorEx ShootMotor2;
    //    public final Servo aimServo;
    //    public final Servo angleServo;
    //    public final Servo intakeServo;


    public final Servo turnServo;
//    public final SensorLimelight3A limelight;

    public FirstAgeTempbot(HardwareMap hardwareMap, Pose2d pose) {
        super(hardwareMap, pose);

        //Initialize Servos
        turnServo = hardwareMap.get(Servo.class, "turnServo");
//        aimServo = hardwareMap.get(Servo.class, "aimServo");
//        angleServo = hardwareMap.get(Servo.class, "angleServo");
//        intakeServo = hardwareMap.get(Servo.class, "intakeServo");

        //Initialize Motors
//        ShootMotor1 = hardwareMap.get(DcMotorEx.class, "ShootMotor1");
//        ShootMotor2 = hardwareMap.get(DcMotorEx.class, "ShootMotor2");



        //Initialize Output Servo
        turnServo.scaleRange(-1,1);
//        aimServo.scaleRange(-1,0);
//        intakeServo.scaleRange(-1,0);
//        angleServo.scaleRange(-1,0);
    }


    public MotorPowers setAllMotorPowers(int i) {
        return new MotorPowers(0,0,0,0);
    }


    public void setMotorTo(DcMotorEx motor, int targetPos, double power) {
        if (motor.getCurrentPosition() < targetPos) {
            while (motor.getCurrentPosition() <= targetPos) {
                motor.setPower(power);
            }
        }
        else if (motor.getCurrentPosition() > targetPos) {
            while (motor.getCurrentPosition() >= targetPos) {
                motor.setPower(-power);
            }
        }
    }
    }
