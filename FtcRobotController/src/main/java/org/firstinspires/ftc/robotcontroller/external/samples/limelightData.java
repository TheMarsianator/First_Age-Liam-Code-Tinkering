package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.hardware.limelightvision.LLResultTypes;

public class limelightData {

    public static int aprilId;
    public static String aprilFamily;
    public static double aprilXDegrees;
    public static double aprilYDegrees;
    public static boolean accurate = false;

    public static void setParams(int I, String F, double X, double Y) {
        aprilId = I;
        aprilFamily = F;
        aprilXDegrees = X;
        aprilYDegrees = Y;
    }
}
