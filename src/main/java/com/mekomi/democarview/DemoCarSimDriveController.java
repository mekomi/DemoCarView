package com.mekomi.democarview;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class DemoCarSimDriveController {

    // FXML objects
    @FXML private Rectangle vehicle;
    @FXML private BorderPane mainPane;
    @FXML private Pane centerPane;
    @FXML private Label energyConsumption;
    @FXML private Label drivenDistance;
    @FXML private Label currentSpeed;
    @FXML private Label currentBatteryCharge;


    Scene scene;

    // Model
    DemoCarSimModel demoCarSimModel;

    public void setModel(DemoCarSimModel demoCarSimModel) {
        this.demoCarSimModel = demoCarSimModel;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Binds the model to the controller and sets the
     */
    public void init() {
        System.out.println("Run initialize...");
        vehicle.xProperty().bindBidirectional(demoCarSimModel.getCurrentXProperty());
        vehicle.yProperty().bindBidirectional(demoCarSimModel.getCurrentYProperty());

        vehicle.translateXProperty().bind(demoCarSimModel.getCurrentXProperty());
        vehicle.translateYProperty().bind(demoCarSimModel.getCurrentYProperty());

        vehicle.setX(demoCarSimModel.getCurrentX());
        vehicle.setY(demoCarSimModel.getCurrentY());

        //currentSpeed.textProperty().bind(demoCarSimModel.getCurrentSpeedProperty().asString());
        //drivenDistance.textProperty().bind(demoCarSimModel.getDrivenDistanceProperty().asString());




        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.UP) {
                demoCarSimModel.drive(Directions.FORWARD);
            } else if (keyEvent.getCode() == KeyCode.DOWN) {
                demoCarSimModel.drive(Directions.BACKWARD);
            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                demoCarSimModel.drive(Directions.RIGHT);
            } else if (keyEvent.getCode() == KeyCode.LEFT) {
                demoCarSimModel.drive(Directions.LEFT);
            }
        });
    }

}
