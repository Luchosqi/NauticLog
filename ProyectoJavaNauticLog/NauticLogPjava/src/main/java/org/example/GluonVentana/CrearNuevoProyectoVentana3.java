package org.example.GluonVentana;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.MaquinasBarcos.Barco;
import org.example.MaquinasBarcos.BarcoFactory;
import org.example.MaquinasBarcos.Motor;
import org.example.PDF.Boleta;
import org.example.PDF.Informe;
import org.example.Persona.Cliente;
import org.example.VentanasFx.VentanasIncioMecanico;
import org.example.quillJs.EditorView;
import org.example.quillJs.QuillAPDF;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class CrearNuevoProyectoVentana3 {

    @FXML
    private Button cancelarButton;

    @FXML
    private Button siguienteButton;

    @FXML
    private TextField marcaField;

    @FXML
    private TextField modeloField;

    @FXML
    private TextField numeroMotorField;

    @FXML
    private TextField anioFabricacionField;

    @FXML
    private TextField rpmField;

    @FXML
    private TextField outputField;

    @FXML
    private TextField numeroOrdenField;

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
    private void finalizarCreacion() {
        // Crear el motor
        Motor motor = new Motor(
                marcaField.getText(),
                modeloField.getText(),
                numeroMotorField.getText(),
                LocalDate.parse(anioFabricacionField.getText() + "-01-01"),
                rpmField.getText()
        );

        Collection<Informe> informes = new ArrayList<>();
        Collection<Boleta> boletas = new ArrayList<>();
        Collection<Motor> motores = new ArrayList<>();
        motores.add(motor);

        BarcoFactory barcoFactory = new BarcoFactory(cliente, modeloBarco, marcaBarco, boletas);
        Barco barco = (Barco) barcoFactory.crearMaquina(informes, motores, nombreBarco, boletas);
        cliente.agregarMaquina(barco);




        Stage actual = (Stage) siguienteButton.getScene().getWindow();
        actual.close();


        abrirEditorQuill(barco, motor);
    }

    private void abrirEditorQuill(Barco barco, Motor motor) {

        Stage editorStage = new Stage();
        EditorView editorView = new EditorView(editorStage);
        QuillAPDF quillAPDF = new QuillAPDF();
        editorView.getExportButton().setOnAction(e -> {

            try {


                String htmlContent = editorView.getHtmlContent();
                String outputPath = quillAPDF.exportToPDF(htmlContent, "facturas", "informe_" + nombreBarco + ".pdf");
                System.out.println("PDF generado en: " + outputPath);

                editorStage.close();
                app.interfazPrincipal(stageAnterior);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Scene scene = new Scene(editorView.getRootPane(), 800, 600);
        editorStage.setTitle("Editor de Informe - " + nombreBarco);
        editorStage.setScene(scene);
        editorStage.show();
    }


}
