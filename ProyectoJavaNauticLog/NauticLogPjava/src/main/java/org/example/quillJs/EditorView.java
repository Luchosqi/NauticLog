package org.example.quillJs;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.example.GluonVentana.InventarioUI;

public class EditorView {
    private WebView webView;
    private WebEngine webEngine;
    private BorderPane rootPane;

    private Button botonVolver;
    private Button botonAgregarInsumo;
    private Button botonAgregarRepuesto;
    private Button exportButton;

    public EditorView(Stage stage) {
        initializeWebView();
        initializeButtons(stage);
        setupLayout();
    }

    private void initializeWebView() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("/editor.html").toExternalForm());
    }

    private void initializeButtons(Stage stage) {
        botonVolver = new Button("Volver");
        botonAgregarInsumo = new Button("+ Agregar insumo");
        botonAgregarRepuesto = new Button("+ Agregar repuesto");
        exportButton = new Button("Exportar a PDF");

        InventarioUI inventarioUI = new InventarioUI();

        botonAgregarInsumo.setOnAction(e -> inventarioUI.mostrarFormularioInsumo(stage));
        botonAgregarRepuesto.setOnAction(e -> inventarioUI.mostrarFormularioRepuesto(stage));

        botonVolver.setOnAction(e -> {
            Stage ventana = (Stage) botonVolver.getScene().getWindow();
            ventana.close();
        });
    }

    private void setupLayout() {
        rootPane = new BorderPane();

        HBox barraSuperior = new HBox(10);
        barraSuperior.setPadding(new Insets(10));
        barraSuperior.getChildren().addAll(botonVolver, botonAgregarInsumo, botonAgregarRepuesto, exportButton);

        rootPane.setTop(barraSuperior);
        rootPane.setCenter(webView);
    }

    public BorderPane getRootPane() {
        return rootPane;
    }

    public Button getBotonVolver() {
        return botonVolver;
    }

    public Button getExportButton() {
        return exportButton;
    }

    public WebEngine getWebEngine() {
        return webEngine;
    }

    public String getHtmlContent() {
        return (String) webEngine.executeScript("getHTML()");
    }
}
