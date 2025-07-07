package org.example.Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.VentanasFx.VentanasIncioMecanico;
import org.example.quillJs.EditorView;
import org.example.quillJs.PDFExporter;

/**
 * Clase principal que inicia la aplicación NauticLog.
 * Esta aplicación permite gestionar proyectos de reparación de barcos,
 * clientes, motores y generar informes.
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Método que inicia la aplicación con la ventana de inicio del mecánico.
     * @param primaryStage El escenario principal de la aplicación
     */
    @Override
    public void start(Stage primaryStage) {
        // Iniciar la aplicación con la ventana de inicio del mecánico
        new VentanasIncioMecanico().start(primaryStage);
    }

    /**
     * Método alternativo para iniciar la aplicación con el editor de texto enriquecido.
     * Actualmente está comentado pero puede ser utilizado para pruebas o desarrollo.
     * @param stage El escenario para mostrar el editor
     */
    /*
    public void iniciarEditor(Stage stage) {
        // Crear la vista del editor
        EditorView editorView = new EditorView();

        // Crear el exportador de PDF
        PDFExporter pdfExporter = new PDFExporter();

        // Configurar la acción del botón de exportar
        editorView.getExportButton().setOnAction(e -> {
            try {
                String htmlContent = editorView.getHtmlContent();
                String outputPath = pdfExporter.exportToPDF(htmlContent);
                System.out.println("PDF generado en: " + outputPath);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Configurar la escena y el escenario
        Scene scene = new Scene(editorView.getRootPane(), 800, 600);
        stage.setTitle("Editor Quill - Demo");
        stage.setScene(scene);
        stage.show();
    }
    */
}
