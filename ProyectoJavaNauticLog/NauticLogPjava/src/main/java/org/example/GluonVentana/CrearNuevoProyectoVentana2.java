package org.example.GluonVentana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Persona.Cliente;
import org.example.VentanasFx.VentanasIncioMecanico;

import java.io.IOException;

public class CrearNuevoProyectoVentana2 {

    @FXML
    private Button cancelarButton;

    @FXML
    private Button siguienteButton;

    @FXML
    private TextField nombreBarcoField;

    @FXML
    private TextField modeloBarcoField;

    @FXML
    private TextField motorField;

    @FXML
    private TextField marcaBarcoField;

    private Stage stageAnterior;
    private VentanasIncioMecanico app;
    private Cliente cliente;
    private String nombreBarco;
    private String modeloBarco;
    private String marcaBarco;
    private String motorBarco;


    public void setDatosDeRetorno(Stage stageAnterior, VentanasIncioMecanico app, Cliente cliente) {
        this.stageAnterior = stageAnterior;
        this.app = app;
        this.cliente = cliente;
    }

    public void setDatosBarco(String nombreBarco, String modeloBarco, String marcaBarco, String motorBarco) {
        this.nombreBarco = nombreBarco;
        this.modeloBarco = modeloBarco;
        this.marcaBarco = marcaBarco;
        this.motorBarco = motorBarco;
    }

    @FXML
    private void volverAlMenu() {
        Stage actual = (Stage) cancelarButton.getScene().getWindow();
        actual.close();

        app.interfazPrincipal(stageAnterior);
    }

    @FXML
    private void irAVentana3() {
        org.example.Persona.AlmacenamientoTemporal.getInstancia().setDatosBarco(
            nombreBarcoField.getText(),
            modeloBarcoField.getText(),
            marcaBarcoField.getText(),
            motorField.getText()
        );

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/crearNuevoProyectoVentana3.fxml"));
            Parent root = loader.load();

            CrearNuevoProyectoVentana3 controlador = loader.getController();
            controlador.setDatosDeRetorno(stageAnterior, app, cliente);
            controlador.setDatosBarco(
                nombreBarcoField.getText(),
                modeloBarcoField.getText(),
                marcaBarcoField.getText(),
                motorField.getText()
            );

            Stage actual = (Stage) siguienteButton.getScene().getWindow();
            actual.close();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Crear Nuevo Proyecto - Motor");
            nuevaVentana.setScene(new Scene(root, 800, 600));
            nuevaVentana.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
