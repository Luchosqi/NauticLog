package org.example.Main;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.VentanasFx.VentanasIncioMecanico;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        new VentanasIncioMecanico().start(primaryStage);
    }
}



