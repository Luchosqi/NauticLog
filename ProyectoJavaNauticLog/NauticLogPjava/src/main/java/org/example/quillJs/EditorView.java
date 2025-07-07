package org.example.quillJs;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

/**
 * Class responsible for managing the rich text editor view using Quill.js in a WebView.
 */
public class EditorView {
    private WebView webView;
    private WebEngine webEngine;
    private BorderPane rootPane;
    private Button exportButton;
    private Button backButton;

    /**
     * Creates a new EditorView with the Quill editor, export button, and back button.
     */
    public EditorView() {
        initializeWebView();
        initializeExportButton();
        initializeBackButton();
        setupLayout();
    }

    /**
     * Initializes the WebView component and loads the editor HTML.
     */
    private void initializeWebView() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("/editor.html").toExternalForm());
    }

    /**
     * Initializes the back button.
     */
    private void initializeBackButton() {
        backButton = new Button("Volver");
    }

    /**
     * Initializes the export button.
     */
    private void initializeExportButton() {
        exportButton = new Button("Exportar a PDF");
    }

    /**
     * Sets up the layout with the WebView and both buttons at the top.
     */
    private void setupLayout() {
        rootPane = new BorderPane();

        HBox topBar = new HBox(10); // Espacio entre botones
        topBar.setPadding(new Insets(10));
        topBar.getChildren().addAll(backButton, exportButton);

        rootPane.setTop(topBar);
        rootPane.setCenter(webView);
    }

    /**
     * Gets the root pane containing the editor.
     *
     * @return The BorderPane containing the editor components
     */
    public BorderPane getRootPane() {
        return rootPane;
    }

    /**
     * Gets the export button to allow setting actions externally.
     *
     * @return The export button
     */
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
