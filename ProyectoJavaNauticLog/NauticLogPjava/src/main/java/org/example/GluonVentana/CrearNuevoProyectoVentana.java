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
import java.util.ArrayList;

/**
 * Controlador para la primera ventana de creación de un nuevo proyecto.
 * Esta ventana permite ingresar los datos del cliente.
 */
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

    /**
     * Establece los datos necesarios para volver a la ventana anterior.
     * @param stageAnterior La ventana anterior
     * @param app La aplicación principal
     */
    public void setDatosDeRetorno(Stage stageAnterior, VentanasIncioMecanico app) {
        this.stageAnterior = stageAnterior;
        this.app = app;
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
     * Avanza a la segunda ventana de creación de proyecto.
     * Crea un cliente con los datos ingresados y lo pasa a la siguiente ventana.
     */
    @FXML
    private void irAVentana2() {
        // Crear un cliente con los datos del formulario
        Cliente cliente = new Cliente(
                nombreField.getText(),
                correoField.getText(),
                celularField.getText(),
                new ArrayList<>() // Lista vacía de barcos
        );

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/crearNuevoProyectoVentana2.fxml"));
            Parent root = loader.load();

            // Preparar el controlador para enviarle la ventana anterior y el cliente
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
