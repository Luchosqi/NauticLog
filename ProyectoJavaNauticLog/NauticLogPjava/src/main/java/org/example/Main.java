package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.Inventario.Insumo;
import org.example.Inventario.Pieza;
import org.example.Inventario.EstadoUso;
import org.example.Inventario.Originalidad;
import org.example.MaquinasBarcos.*;
import org.example.PDF.Boleta;
import org.example.PDF.Informe;
import org.example.Persona.Cliente;
import org.example.Persona.Mecanico;

import java.time.LocalDate;
import java.util.*;

import static javafx.application.Application.launch;




import javafx.application.Application;
import javafx.stage.Stage;
import VentanasFx.VentanasIncioMecanico;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args); // no Application.launch(...) aquí
    }

    @Override
    public void start(Stage primaryStage) {
        // Delegamos a la ventana principal de tu app
        new VentanasIncioMecanico().start(primaryStage);
    }
}



