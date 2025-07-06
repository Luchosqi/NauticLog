package org.example.GluonVentana;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VentanaInformeControlador {

    @FXML
    private Label etiquetaTitulo;

    @FXML
    private ComboBox<String> comboTipoObjeto;

    @FXML
    private TextField campoNombreObjeto;

    @FXML
    private TextField campoCantidad;

    @FXML
    private Button botonAgregar;

    @FXML
    private ListView<String> listaObjetos;

    @FXML
    private Button botonGuardarInforme;

    @FXML
    private TextArea campoDescripcion;

    @FXML
    public void initialize() {
        comboTipoObjeto.getItems().addAll("Insumo", "Pieza", "Herramienta");
    }

    @FXML
    private void agregarObjeto() {
        String tipo = comboTipoObjeto.getValue();
        String nombre = campoNombreObjeto.getText();
        String cantidad = campoCantidad.getText();

        if (tipo != null && !nombre.isEmpty() && !cantidad.isEmpty()) {
            String item = tipo + ": " + nombre + " x" + cantidad;
            listaObjetos.getItems().add(item);
            campoNombreObjeto.clear();
            campoCantidad.clear();
        }
    }

    @FXML
    private void guardarInforme() {
        // Aqui se conectaria con la logica de backend para guardar
        System.out.println("Informe guardado con " + listaObjetos.getItems().size() + " objetos");
        System.out.println("Descripcion: " + campoDescripcion.getText());
    }
}
