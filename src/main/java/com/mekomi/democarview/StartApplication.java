package com.mekomi.democarview;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("demoCarSimMain-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        DemoCarSimMainController demoCarSimMainController = fxmlLoader.getController();
        demoCarSimMainController.setScene(scene);
        stage.setFullScreen(true);
        stage.setTitle("demoCarSimMain");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
