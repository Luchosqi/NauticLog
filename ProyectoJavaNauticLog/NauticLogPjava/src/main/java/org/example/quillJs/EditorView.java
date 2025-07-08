package org.example.quillJs;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

public class EditorView {
    private WebView webView;
    private WebEngine webEngine;
    private BorderPane rootPane;
    private Button exportButton;
    private Button backButton;

    public EditorView() {
        initializeWebView();
        initializeExportButton();
        initializeBackButton();
        setupLayout();
    }

    private void initializeWebView() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("/editor.html").toExternalForm());
    }


    private void initializeBackButton() {
        backButton = new Button("Volver");
    }


    private void initializeExportButton() {
        exportButton = new Button("Exportar a PDF");
    }


    private void setupLayout() {
        rootPane = new BorderPane();

        HBox topBar = new HBox(10); // Espacio entre botones
        topBar.setPadding(new Insets(10));
        topBar.getChildren().addAll(backButton, exportButton);

        rootPane.setTop(topBar);
        rootPane.setCenter(webView);
    }

    public BorderPane getRootPane() {
        return rootPane;
    }


    public Button getExportButton() {
        return exportButton;
    }

    /**
     * Gets the back button to allow setting actions externally.
     *
     * @return The back button
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     * Gets the WebEngine to allow JavaScript execution.
     *
     * @return The WebEngine
     */
    public WebEngine getWebEngine() {
        return webEngine;
    }

    /**
     * Gets the HTML content from the editor.
     *
     * @return The HTML content as a String
     */
    public String getHtmlContent() {
        return (String) webEngine.executeScript("getHTML()");
    }
}
