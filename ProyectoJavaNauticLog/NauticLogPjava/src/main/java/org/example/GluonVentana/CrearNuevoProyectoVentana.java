package org.example.GluonVentana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.Persona.AlmacenamientoTemporal;
import org.example.Persona.Cliente;
import org.example.VentanasFx.VentanasIncioMecanico;

import java.io.IOException;
import java.util.ArrayList;


public class CrearNuevoProyectoVentana {

    @FXML
    private Button cancelarButton;

    @FXML
    private Button siguienteButton;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField rutField;

    @FXML
    private TextField empresaField;

    @FXML
    private TextField celularField;

    @FXML
    private TextField correoField;

    private Stage stageAnterior;
    private VentanasIncioMecanico app;


    public void setDatosDeRetorno(Stage stageAnterior, VentanasIncioMecanico app) {
        this.stageAnterior = stageAnterior;
        this.app = app;
    }


    @FXML
    private void volverAlMenu() {
        Stage actual = (Stage) cancelarButton.getScene().getWindow();
        actual.close();

        app.interfazPrincipal(stageAnterior);
    }


    @FXML
    private void irAVentana2() {
        AlmacenamientoTemporal.getInstancia().setDatosCliente(
            nombreField.getText(),
            rutField.getText(),
            empresaField.getText(),
            celularField.getText(),
            correoField.getText()
        );

        Cliente cliente = new Cliente(
                nombreField.getText(),
                correoField.getText(),
                celularField.getText(),
                new ArrayList<>()
        );
        app.setClienteActual(cliente);


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/crearNuevoProyectoVentana2.fxml"));
            Parent root = loader.load();
            CrearNuevoProyectoVentana2 controlador = loader.getController();
            controlador.setDatosDeRetorno(stageAnterior, app, cliente);

            Stage actual = (Stage) siguienteButton.getScene().getWindow();
            actual.close();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Crear Nuevo Proyecto - Barco");
            nuevaVentana.setScene(new Scene(root, 800, 600));
            nuevaVentana.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
