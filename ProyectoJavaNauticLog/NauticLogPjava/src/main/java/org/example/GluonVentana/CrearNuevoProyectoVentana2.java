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

/**
 * Controlador para la segunda ventana de creación de un nuevo proyecto.
 * Esta ventana permite ingresar los datos del barco.
 */
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

    /**
     * Establece los datos necesarios para volver a la ventana anterior y
     * para pasar a la siguiente ventana.
     * @param stageAnterior La ventana anterior
     * @param app La aplicación principal
     * @param cliente El cliente creado en la ventana anterior
     */
    public void setDatosDeRetorno(Stage stageAnterior, VentanasIncioMecanico app, Cliente cliente) {
        this.stageAnterior = stageAnterior;
        this.app = app;
        this.cliente = cliente;
    }

    /**
     * Vuelve al menú principal.
     */
    @FXML
    private void volverAlMenu() {
        Stage actual = (Stage) cancelarButton.getScene().getWindow();
        actual.close();

        app.interfazPrincipal(stageAnterior);
    }

    /**
     * Avanza a la tercera ventana de creación de proyecto.
     * Pasa los datos del barco a la siguiente ventana.
     */
    @FXML
    private void irAVentana3() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/crearNuevoProyectoVentana3.fxml"));
            Parent root = loader.load();

            // Preparar el controlador para enviarle la ventana anterior, el cliente y los datos del barco
            CrearNuevoProyectoVentana3 controlador = loader.getController();
            controlador.setDatosDeRetorno(stageAnterior, app, cliente);
            controlador.setDatosBarco(
                nombreBarcoField.getText(),
                modeloBarcoField.getText(),
                marcaBarcoField.getText()
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
