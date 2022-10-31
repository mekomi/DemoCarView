package com.mekomi.democarview;

import javafx.beans.property.*;

import static com.mekomi.democarview.DemoDriveUtils.checkBorders;
import static com.mekomi.democarview.Directions.NONE;

public class DemoCarSimModel {
    private static final double RATE = 1; // Rate how fast the vehicle drives...
    private static final int DISTANCE_RATE = 2;

    // Image stats for rotations
    private static final double VEHICLE_WIDTH = 40;
    private static final double VEHICLE_HEIGHT = 75;

    // localisation
    private StringProperty driveModeButtonText;
    private StringProperty interiorModeButtonText;




    private DoubleProperty currentX;
    private DoubleProperty currentY;
    private IntegerProperty drivenDistance;
    private IntegerProperty energyConsumption;
    private IntegerProperty currentSpeed;
    private IntegerProperty currentBatteryCharge;

    public DemoCarSimModel() {
        currentX = new SimpleDoubleProperty(0.0);
        currentY = new SimpleDoubleProperty(0.0);
        currentSpeed = new SimpleIntegerProperty(0);
        drivenDistance = new SimpleIntegerProperty(0);

        driveModeButtonText = new SimpleStringProperty("Drive");
        interiorModeButtonText = new SimpleStringProperty("Go to interior");
    }

    public double getCurrentX() {
        return currentX.get();
    }

    public double getCurrentY() {
        return currentY.get();
    }

    public DoubleProperty getCurrentXProperty() {
        return currentX;
    }

    public DoubleProperty getCurrentYProperty() {
        return currentY;
    }

    public IntegerProperty getCurrentSpeedProperty() {
        return currentSpeed;
    }

    public IntegerProperty getDrivenDistanceProperty() {
        return drivenDistance;
    }

    public StringProperty getDriveModeButtonTextProperty() {
        return driveModeButtonText;
    }

    public StringProperty getInteriorModeButtonTextProperty() {
        return interiorModeButtonText;
    }

    public void setDriveModeButtonText(String s) {
        driveModeButtonText.set(s);
    }

    public void setInteriorModeButtonText(String s) {
        interiorModeButtonText.set(s);
    }

    public void drive(Directions directions) {
        /* bugged needs fixing...
        if (!checkBorders(currentX.get(), currentY.get())) {
            directions = NONE;
        }*/

        switch (directions) {
            case FORWARD :
                currentY.set(currentY.get() - RATE);
                drivenDistance.set(drivenDistance.get() + DISTANCE_RATE);

                // example function
                currentSpeed.set(currentSpeed.get() + 1);
                break;
            case BACKWARD :
                currentY.set(currentY.get() + RATE);
                drivenDistance.set(drivenDistance.get() + DISTANCE_RATE);

                // example function
                currentSpeed.set(currentSpeed.get() - 1);
                drivenDistance.set(drivenDistance.get() + DISTANCE_RATE);
                break;
            case RIGHT :
                currentX.set(currentX.get() + RATE);
                drivenDistance.set(drivenDistance.get() + DISTANCE_RATE);
                // rotate vehicle here...
                break;
            case LEFT :
                currentX.set(currentX.get() - RATE);
                drivenDistance.set(drivenDistance.get() + DISTANCE_RATE);
                // rotate vehicle here...
                break;
            default:
                // invalid input or border detected
                break;
        }
    }
}
