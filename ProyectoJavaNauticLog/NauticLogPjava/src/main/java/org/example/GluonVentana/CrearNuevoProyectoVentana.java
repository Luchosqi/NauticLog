package org.example.GluonVentana;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.VentanasFx.VentanasIncioMecanico;

public class CrearNuevoProyectoVentana {

    @FXML
    private Button cancelarButton;

    private Stage stageAnterior;
    private VentanasIncioMecanico app;

    public void setDatosDeRetorno(Stage stageAnterior, VentanasIncioMecanico app) {
        this.stageAnterior = stageAnterior;
        this.app = app;
    }

    @FXML
    private void volverAlMenu() {
        // Cierra la ventana actual
        Stage actual = (Stage) cancelarButton.getScene().getWindow();
        actual.close();

        // Vuelve al menú principal
        app.interfazPrincipal(stageAnterior);
    }
}
