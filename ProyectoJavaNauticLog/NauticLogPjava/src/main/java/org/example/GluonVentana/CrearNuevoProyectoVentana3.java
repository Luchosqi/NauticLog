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

/**
 * Controlador para la tercera ventana de creación de un nuevo proyecto.
 * Esta ventana permite ingresar los datos del motor y finalizar la creación del proyecto.
 */
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

    /**
     * Establece los datos necesarios para volver a la ventana anterior.
     * @param stageAnterior La ventana anterior
     * @param app La aplicación principal
     * @param cliente El cliente creado en la primera ventana
     */
    public void setDatosDeRetorno(Stage stageAnterior, VentanasIncioMecanico app, Cliente cliente) {
        this.stageAnterior = stageAnterior;
        this.app = app;
        this.cliente = cliente;
    }

    /**
     * Establece los datos del barco recibidos de la ventana anterior.
     * @param nombreBarco El nombre del barco
     * @param modeloBarco El modelo del barco
     * @param marcaBarco La marca del barco
     */
    public void setDatosBarco(String nombreBarco, String modeloBarco, String marcaBarco) {
        this.nombreBarco = nombreBarco;
        this.modeloBarco = modeloBarco;
        this.marcaBarco = marcaBarco;
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
     * Finaliza la creación del proyecto creando el motor y el barco.
     * Utiliza el patrón de diseño Factory para crear el barco.
     * Después de crear el barco, abre el editor de texto QuillJS para crear un informe.
     */
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

        // Crear colecciones vacías para informes y boletas
        Collection<Informe> informes = new ArrayList<>();
        Collection<Boleta> boletas = new ArrayList<>();
        Collection<Motor> motores = new ArrayList<>();
        motores.add(motor);

        // Crear el barco usando el patrón de diseño Factory
        BarcoFactory barcoFactory = new BarcoFactory(cliente, modeloBarco, marcaBarco, boletas);
        Barco barco = (Barco) barcoFactory.crearMaquina(informes, motores, nombreBarco, boletas);

        // Aquí se guardaría el barco en alguna base de datos o sistema de persistencia

        // Cerrar la ventana actual
        Stage actual = (Stage) siguienteButton.getScene().getWindow();
        actual.close();

        // Abrir el editor de texto QuillJS
        abrirEditorQuill(barco, motor);
    }

    /**
     * Abre el editor de texto QuillJS para crear un informe.
     * 
     * @param barco El barco creado
     * @param motor El motor creado
     */
    private void abrirEditorQuill(Barco barco, Motor motor) {
        // Crear la vista del editor
        EditorView editorView = new EditorView();

        // Crear el exportador de PDF
        QuillAPDF quillAPDF = new QuillAPDF();

        // Configurar la acción del botón de exportar
        editorView.getExportButton().setOnAction(e -> {
            try {
                String htmlContent = editorView.getHtmlContent();
                String outputPath = quillAPDF.exportToPDF(htmlContent, "facturas",
                        "informe_" + nombreBarco + ".pdf");
                System.out.println("PDF generado en: " + outputPath);

                // Volver al menú principal después de exportar
                ((Stage)editorView.getExportButton().getScene().getWindow()).close();
                app.interfazPrincipal(stageAnterior);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Configurar la escena y el escenario
        Stage editorStage = new Stage();
        Scene scene = new Scene(editorView.getRootPane(), 800, 600);
        editorStage.setTitle("Editor de Informe - " + nombreBarco);
        editorStage.setScene(scene);
        editorStage.show();
    }
}
