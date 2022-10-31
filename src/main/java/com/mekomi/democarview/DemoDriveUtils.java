package com.mekomi.democarview;

public class DemoDriveUtils {
    private static final double MAX_X = 1920;
    private static final double MAX_Y = 1080;
    public static boolean checkBorders(double currentX, double currentY) {
        return ((currentX >= 0) && (currentX <= MAX_X)) && ((currentY >= 0) && (currentY <= MAX_Y));
    }
}
