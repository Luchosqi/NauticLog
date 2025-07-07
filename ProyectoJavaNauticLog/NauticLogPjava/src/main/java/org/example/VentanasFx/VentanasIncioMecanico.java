package org.example.VentanasFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.GluonVentana.CrearNuevoProyectoVentana;
import org.example.Persona.Mecanico;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class VentanasIncioMecanico extends Application {


    @Override
    public void start(Stage primeraVentanaMecanicoRegistro) {
        VBox formularioBox = new VBox(15);
        formularioBox.setPadding(new Insets(30));
        formularioBox.setAlignment(Pos.CENTER);
        formularioBox.setStyle("-fx-background-color:#507AB1 ; -fx-background-radius: 10;");

        Label titulo = new Label("Registro");
        titulo.setFont(Font.font("Lao Muang Khong", FontWeight.BOLD, 30));
        titulo.setTextFill(Color.BLACK);

        Label subtitulo = new Label("Datos del usuario");
        subtitulo.setFont(Font.font("Lao Muang Khong", FontWeight.NORMAL, 18));
        subtitulo.setTextFill(Color.BLACK);

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre de usuario");
        String nombreMecanico = nombre.getText();

        TextField rut = new TextField();
        rut.setPromptText("Rut");
        String rutMecanico = rut.getText();

        TextField correo = new TextField();
        correo.setPromptText("Correo electrónico");
        String correoMecanico = correo.getText();

        TextField celular = new TextField();
        celular.setPromptText("Celular");
        String celularMecanico = celular.getText();

        Mecanico mecanicoPersona = new Mecanico(nombreMecanico,correoMecanico,celularMecanico);

        Button siguiente = new Button("Siguiente");
        siguiente.setPrefWidth(200);
        siguiente.setStyle("-fx-background-color: #2E2B4F; -fx-text-fill: white;");
        siguiente.setOnAction(event -> {
            Stage nuevaVentana = new Stage();
            siguienteRegistro2(nuevaVentana);
            ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
        });


        formularioBox.getChildren().addAll(titulo, subtitulo, nombre, rut, correo, celular, siguiente);


        Image imagen = new Image(getClass().getResource
                ("/8484b30c8d363a0bdaabeb585b767a1772744d81.jpg").toExternalForm());
        ImageView imagenBarco = new ImageView(imagen);

        imagenBarco.setPreserveRatio(true);
        imagenBarco.setFitWidth(400);

        StackPane imagenPane = new StackPane(imagenBarco);
        imagenPane.setAlignment(Pos.CENTER);
        imagenPane.setPadding(new Insets(20));


        HBox root = new HBox();
        root.setPadding(new Insets(30));
        root.setSpacing(20);
        root.getChildren().addAll(formularioBox, imagenPane);

        Scene scene = new Scene(root, 800, 600);
        primeraVentanaMecanicoRegistro.setTitle("Registro de Usuario");
        primeraVentanaMecanicoRegistro.setScene(scene);
        primeraVentanaMecanicoRegistro.show();
    }

    public void siguienteRegistro2(Stage stage) {
        VBox formBox = new VBox(15);
        formBox.setPadding(new Insets(40));
        formBox.setAlignment(Pos.TOP_CENTER);
        formBox.setStyle("""
        -fx-background-color:#507AB1;
        -fx-background-radius:10;
    """);

        Label lblTitulo    = new Label("Registro");
        lblTitulo.setFont(Font.font("Lao Muang Khong", FontWeight.BOLD, 34));

        Label lblSubtitulo = new Label("Datos de la empresa");
        lblSubtitulo.setFont(Font.font("Lao Muang Khong", FontWeight.NORMAL, 18));


        TextField txtRut    = new TextField();  txtRut.setPromptText("Rut de empresa");
        TextField txtNombreEmpresa   = new TextField();  txtNombreEmpresa.setPromptText("Nombre Empresa");
        TextField txtTitulo   = new TextField();  txtTitulo.setPromptText("nivel Titulo");
        TextField txtDireccionEmpresa   = new TextField();  txtDireccionEmpresa.setPromptText("Direccion Empresa");
        String rutEmpresa  = txtRut.getText();



        txtRut .setMaxWidth(260);
        txtNombreEmpresa.setMaxWidth(260);
        txtTitulo.setMaxWidth(260);
        txtDireccionEmpresa.setMaxWidth(260);


        VBox importBox = new VBox(5);
        importBox.setAlignment(Pos.CENTER);
        importBox.setPrefSize(120, 120);
        importBox.setStyle("""
        -fx-background-color:#9EABC3;
        -fx-background-radius:8;
        -fx-cursor:hand;
    """);

        Label plus = new Label("+");
        plus.setFont(Font.font(36));
        Label lblImport = new Label("Importar imagen");
        lblImport.setFont(Font.font(12));
        importBox.getChildren().addAll(plus, lblImport);

        importBox.setOnMouseClicked(e -> {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg"));
            File f = fc.showOpenDialog(stage);
            String logoEmpresa = f.getAbsolutePath();
        });
        Button btnAtras = new Button("Atrás");
        btnAtras.setOnAction(e -> start(stage));
        btnAtras.setPrefWidth(120);
        btnAtras.setStyle("""
        -fx-background-color: transparent;
        -fx-text-fill:#1E1C3B;
        -fx-border-color:#1E1C3B;
        -fx-border-radius:4;
    """);
        Button btnRegistrar = new Button("Registrarse");
        btnRegistrar.setPrefWidth(120);
        btnRegistrar.setStyle("""
        -fx-background-color:#2E2B4F;
        -fx-text-fill:white;
        -fx-background-radius:4;
    """);
        btnRegistrar.setOnAction(e -> interfazPrincipal(stage));
        HBox botones = new HBox(25, btnAtras, btnRegistrar);
        botones.setAlignment(Pos.CENTER);
        formBox.getChildren().addAll(
                lblTitulo, lblSubtitulo,
                txtRut, txtNombreEmpresa, txtTitulo,txtDireccionEmpresa,
                importBox,
                botones
        );
        ImageView imgBarco = new ImageView(
                new Image(getClass().getResource("/8484b30c8d363a0bdaabeb585b767a1772744d81.jpg").toExternalForm())
        );
        imgBarco.setFitWidth(400);
        imgBarco.setPreserveRatio(true);
        StackPane imgPane = new StackPane(imgBarco);
        imgPane.setPadding(new Insets(20));
        HBox root = new HBox(30, formBox, imgPane);
        root.setPadding(new Insets(30));

        stage.setScene(new Scene(root, 800, 600));
        stage.setMinWidth(800);
        stage.setMinHeight(600);

        stage.setTitle("Registro Empresa de Usuario");
        stage.show();
    }

    public void interfazPrincipal(Stage stage) {


        VBox sideBar = new VBox(20);
        sideBar.setPrefWidth(130);
        sideBar.setPadding(new Insets(25, 10, 25, 10));
        sideBar.setStyle("-fx-background-color:#507AB1;");
        StackPane logoPane = new StackPane(new Label("NauticLog"));
        logoPane.setPrefSize(90, 90);
        logoPane.setAlignment(Pos.CENTER);
        logoPane.setStyle("""
            -fx-background-color:white;
            -fx-background-radius:45;
            -fx-font-size:15;
            -fx-font-weight:bold;""");
        ImageView logo = new ImageView(getClass().getResource
                ("/8484b30c8d363a0bdaabeb585b767a1772744d81.jpg").toExternalForm());

        Button btnListaProyectos    = crearBotonSidebar("Lista de proyectos");
        Button btnHistorial         = crearBotonSidebar("Historial de proyectos");
        Button btnFacturasGeneradas = crearBotonSidebar("Facturas generadas");

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        Button btnPerfil = crearBotonSidebar(null);
        String iconoUserEditar= "/userEditICON.png";
        btnPerfil = crearBotonSidebar(iconoUserEditar);
        ImageView iconoeditarUsuario = new ImageView(
                getClass().getResource(iconoUserEditar).toExternalForm()
        );
        iconoeditarUsuario.setFitWidth(60);
        iconoeditarUsuario.setPreserveRatio(true);
        btnPerfil.setGraphic(iconoeditarUsuario);
        btnPerfil.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);


        btnPerfil.setOnAction(e -> {start(stage);});
        sideBar.getChildren().addAll(
                logoPane,
                btnListaProyectos,
                btnHistorial,
                btnFacturasGeneradas,
                spacer,
                btnPerfil
        );

        HBox topBar = new HBox();
        topBar.setPadding(new Insets(20, 40, 20, 40));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setStyle("-fx-background-color:#507AB1;");

        Label lblTitulo = new Label("Lista de Proyectos");
        lblTitulo.setFont(Font.font("Lao Muang Khong", FontWeight.BOLD, 32));
        HBox.setHgrow(lblTitulo, Priority.ALWAYS);

        HBox boxAcciones = new HBox(15);
        // reemplazar estos 3 botones por el archivo grafico
        Button btnAgregarProyecto = crearBotonTop("Añadir proyecto");
        btnAgregarProyecto.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/crearNuevoProyectoVentana.fxml"));
                Parent root = loader.load();

                // Preparar el controlador para enviarle la ventana anterior
                CrearNuevoProyectoVentana controlador = loader.getController();
                controlador.setDatosDeRetorno(stage, this);  // le pasamos el Stage y la app actual

                Stage nuevaVentana = new Stage();
                nuevaVentana.setTitle("Crear Nuevo Proyecto");
                nuevaVentana.setScene(new Scene(root, 800, 600));
                nuevaVentana.show();

                stage.close();  // cerrar ventana anterior

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });




        Button btnGenerarFactura  = crearBotonTop("Generar Factura");
        Button btnInventario      = crearBotonTop("Inventario general");
        boxAcciones.getChildren().addAll(btnAgregarProyecto, btnGenerarFactura, btnInventario);

        topBar.getChildren().addAll(lblTitulo, boxAcciones);


        VBox centerBox = new VBox(20);
        centerBox.setPadding(new Insets(25));
        centerBox.setStyle("-fx-background-color:#B3B8BD;");

        HBox filtros = new HBox(10);
        filtros.setAlignment(Pos.CENTER_RIGHT);

        TextField tfFecha   = new TextField(); tfFecha  .setPromptText("Fecha");
        TextField tfCliente = new TextField(); tfCliente.setPromptText("Cliente");
        TextField tfNombre  = new TextField(); tfNombre .setPromptText("Nombre Proyecto");
        Button    btnFiltrar = new Button("🔍");
        btnFiltrar.setStyle("-fx-background-color: #1E1C3B; -fx-text-fill: white;");

        filtros.getChildren().addAll(tfFecha, tfCliente, tfNombre, btnFiltrar);

        FlowPane flowTarjetas = new FlowPane(Orientation.HORIZONTAL, 25, 25);
        flowTarjetas.getChildren().addAll(
                crearTarjetaProyecto(),   // borrar estas tarjetas
                crearTarjetaProyecto()
        );

        Label lblPaginacion = new Label("Página X de X  >>");  
        lblPaginacion.setPadding(new Insets(10, 0, 0, 0));

        centerBox.getChildren().addAll(filtros, flowTarjetas, lblPaginacion);


        BorderPane root = new BorderPane();
        root.setLeft(sideBar);
        root.setTop(topBar);
        root.setCenter(centerBox);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("NauticLog – Lista de Proyectos");
        stage.show();
    }

    private Button crearBotonSidebar(String texto) {
        Button b = new Button(texto);
        b.setMaxWidth(Double.MAX_VALUE);
        b.setAlignment(Pos.CENTER_LEFT);
        b.setPadding(new Insets(10, 15, 10, 15));
        b.setStyle("""
            -fx-background-color: transparent;
            -fx-text-fill: white;
            -fx-font-size: 12;
            -fx-cursor: hand;""");
        return b;
    }

    private Button crearBotonTop(String texto) {
        Button b = new Button(texto);
        b.setPrefSize(120, 60);
        b.setWrapText(true);
        b.setTextAlignment(TextAlignment.CENTER);
        b.setStyle("""
            -fx-background-color:#1E1B3F;
            -fx-text-fill:white;
            -fx-background-radius:8;
            -fx-cursor:hand;""");
        return b;
    }

    private VBox crearTarjetaProyecto() {
        VBox card = new VBox(8);
        card.setPadding(new Insets(15));
        card.setPrefSize(220, 160);
        card.setStyle("""
            -fx-background-color:#F2F2F2;
            -fx-background-radius:10;""");

        CheckBox chk = new CheckBox();
        Label nombreProyecto = new Label("Nombre Proyecto");
        Label nombreCliente = new Label("Cliente X");
        Label fechadeProyecto = new Label(LocalDate.now().toString());

        Button btnEditar  = new Button("Editar");      // reemplazar
        btnEditar.setStyle("-fx-background-color:#1E1B3F; -fx-text-fill:white;");

        Button btnConfig  = new Button();              // poner engranaje
        btnConfig.setPrefSize(22, 22);

        Button btnImagen  = new Button();              // poner elicono de camara
        btnImagen.setPrefSize(22, 22);

        HBox boxBtns = new HBox(8, btnEditar, btnConfig, btnImagen);
        card.getChildren().addAll(chk, nombreProyecto, nombreCliente, fechadeProyecto, boxBtns);
        return card;
    }




}
