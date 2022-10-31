package com.mekomi.democarview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class DemoCarSimMainController {
    // FXML objects
    @FXML private Button driveModeButton;
    @FXML private Button interiorModeButton;
    @FXML private Button startButton;
    @FXML private Button resetButton;
    @FXML private Label drivenDistance;
    @FXML private Pane centerPane;
    @FXML private BorderPane mainBorderPane;
    @FXML private Accordion devicesAccordion;
    @FXML private TitledPane gatewayPane;
    @FXML private TitledPane brakeControlModulePane;
    @FXML private TitledPane engineControlUnitPane;

    // Model
    private DemoCarSimModel demoCarSimModel;
    private boolean driveModeActive;
    private boolean interiorModeActive;
    private Scene scene;

    @FXML public void onDriveModeButtonPressed(ActionEvent actionEvent) throws IOException {
        /*FXMLLoader loader = new FXMLLoader(DemoCarSimMainController.class.getResource("demoDrive-view.fxml"));
        Parent root = loader.load();
        DemoCarSimDriveController demoCarSimDiveController = loader.getController();
        demoCarSimDiveController.setModel(demoCarSimModel);


        Stage driveWindow = new Stage();
        Scene scene = new Scene(root,1920, 1080);
        demoCarSimDiveController.setScene(scene);
        demoCarSimDiveController.init();
        driveWindow.setTitle("SimCar Drive!");
        driveWindow.setScene(scene);
        driveWindow.show();*/

        if (!driveModeActive) {
            driveModeActive = true;
            demoCarSimModel.setDriveModeButtonText("Exit drive mode");
            FXMLLoader loader = new FXMLLoader(DemoCarSimMainController.class.getResource("demoDrive-view.fxml"));
            Parent root = loader.load();
            DemoCarSimDriveController demoCarSimDriveController = loader.getController();
            demoCarSimDriveController.setModel(demoCarSimModel);
            demoCarSimDriveController.setScene(scene);
            demoCarSimDriveController.init();

            mainBorderPane.setCenter(root);
        } else {
            driveModeActive = false;
            demoCarSimModel.setDriveModeButtonText("Drive");
            FXMLLoader loader = new FXMLLoader(DemoCarSimMainController.class.getResource("defaultCenter-view.fxml"));
            loader.setController(this);
            Parent root = loader.load();


            mainBorderPane.setCenter(root);
        }
    }

    @FXML public void onInteriorModeButtonPressed(ActionEvent actionEvent) throws IOException {
        if (!interiorModeActive) {
            interiorModeActive = true;
            demoCarSimModel.setInteriorModeButtonText("Exit interior mode");
            FXMLLoader loader = new FXMLLoader(DemoCarSimMainController.class.getResource("demoInterior-view.fxml"));
            Parent root = loader.load();
            DemoCarSimInteriorController demoCarSimInteriorController = loader.getController();
            demoCarSimInteriorController.setModel(demoCarSimModel);
            demoCarSimInteriorController.setScene(scene);
            demoCarSimInteriorController.init();

            mainBorderPane.setCenter(root);
        } else {
            interiorModeActive = false;
            demoCarSimModel.setInteriorModeButtonText("Go to interior");
            FXMLLoader loader = new FXMLLoader(DemoCarSimMainController.class.getResource("defaultCenter-view.fxml"));
            loader.setController(this);
            Parent root = loader.load();


            mainBorderPane.setCenter(root);
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void initialize() {
        driveModeActive = false;
        interiorModeActive = false;
        demoCarSimModel = new DemoCarSimModel();

        driveModeButton.textProperty().bind(demoCarSimModel.getDriveModeButtonTextProperty());
        interiorModeButton.textProperty().bind(demoCarSimModel.getInteriorModeButtonTextProperty());

        driveModeButton.setFocusTraversable(false);
        interiorModeButton.setFocusTraversable(false);
        startButton.setFocusTraversable(false);
        resetButton.setFocusTraversable(false);
        devicesAccordion.setFocusTraversable(false);
        gatewayPane.setFocusTraversable(false);
        engineControlUnitPane.setFocusTraversable(false);
        brakeControlModulePane.setFocusTraversable(false);



        //drivenDistance.textProperty().bind(demoCarSimModel.getDrivenDistanceProperty().asString());
    }
}
