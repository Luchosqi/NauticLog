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
import org.example.GluonVentana.InventarioUI;
import org.example.Inventario.GestorInventario;
import org.example.Inventario.Insumo;
import org.example.MaquinasBarcos.Barco;
import org.example.MaquinasBarcos.Maquina;
import org.example.PDF.Boleta;
import org.example.Persona.AlmacenamientoTemporal;
import org.example.Persona.Cliente;
import org.example.Persona.Mecanico;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class VentanasIncioMecanico extends Application {
    private Cliente clienteActual;

    public void setClienteActual(Cliente cliente) {
        this.clienteActual = cliente;
    }




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

        TextField rut = new TextField();
        rut.setPromptText("Rut");

        TextField correo = new TextField();
        correo.setPromptText("Correo electrónico");

        TextField celular = new TextField();
        celular.setPromptText("Celular");

        Button siguiente = new Button("Siguiente");
        siguiente.setPrefWidth(200);
        siguiente.setStyle("-fx-background-color: #2E2B4F; -fx-text-fill: white;");
        siguiente.setOnAction(event -> {
            String nombreMecanico = nombre.getText();
            String rutMecanico = rut.getText();
            String correoMecanico = correo.getText();
            String celularMecanico = celular.getText();
            AlmacenamientoTemporal.getInstancia().setDatos(nombreMecanico, rutMecanico, correoMecanico, celularMecanico);
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

        Button btnAgregarProyecto = crearBotonTop("Añadir proyecto");
        btnAgregarProyecto.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/crearNuevoProyectoVentana.fxml"));
                Parent root = loader.load();

                CrearNuevoProyectoVentana controlador = loader.getController();
                controlador.setDatosDeRetorno(stage, this);

                Stage nuevaVentana = new Stage();
                nuevaVentana.setTitle("Crear Nuevo Proyecto");
                nuevaVentana.setScene(new Scene(root, 800, 600));
                nuevaVentana.show();

                stage.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });




        Button btnGenerarFactura  = crearBotonTop("Generar Factura");

        btnGenerarFactura.setOnAction(e -> {
            mostrarSelectorProyectoYGenerarFactura(stage);
        });

        Button btnInventario      = crearBotonTop("Inventario general");
        boxAcciones.getChildren().addAll(btnAgregarProyecto, btnGenerarFactura, btnInventario);
        btnInventario.setOnAction(ev -> {
            InventarioUI inventarioUI = new InventarioUI();
            inventarioUI.mostrarListaInventario(stage);
        });


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

        String correoCliente = AlmacenamientoTemporal.getInstancia().getCorreoCliente();



        if (clienteActual != null) {
            for (Maquina m : clienteActual.getListaBarcos()) {
                flowTarjetas.getChildren().add(crearTarjetaProyecto(m));
            }
        } else {
            System.out.println("No hay cliente cargado");
        }


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


    private VBox crearTarjetaProyecto(Maquina barco) {
        VBox card = new VBox(8);
        card.setPadding(new Insets(15));
        card.setPrefSize(220, 160);
        card.setStyle("""
        -fx-background-color:#F2F2F2;
        -fx-background-radius:10;""");

        CheckBox chk = new CheckBox();
        Label nombreProyecto = new Label("Proyecto: " + barco.getNombre());
        Barco barcoReal = (Barco) barco;

        Label modelo = new Label("Modelo: " + barcoReal.getModelo());
        Label marca  = new Label("Marca: " + barcoReal.getMarca());
        Label dueño  = new Label("Dueño: " + barcoReal.getDueñoBarco().getNombre());


        Button btnVer = new Button("Ver detalles");
        btnVer.setStyle("-fx-background-color:#1E1B3F; -fx-text-fill:white;");

        btnVer.setOnAction(e -> {

            System.out.println("Detalles de: " + barco.getNombre());
        });
        LocalDate fecha = LocalDate.now();
        Label fechaLabel = new Label("Fecha: " + fecha.toString());
        card.getChildren().addAll(chk, nombreProyecto, modelo, fechaLabel, btnVer);
        return card;
    }

    private void mostrarSelectorProyectoYGenerarFactura(Stage stage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(30));

        Label titulo = new Label("Selecciona un proyecto para generar la factura");
        ComboBox<Maquina> comboProyectos = new ComboBox<>();

        if (clienteActual != null) {
            comboProyectos.getItems().addAll(clienteActual.getListaBarcos());
        }

        Button btnGenerar = new Button("Generar Factura");
        btnGenerar.setStyle("-fx-background-color: #1E1B3F; -fx-text-fill: white;");

        btnGenerar.setOnAction(e -> {
            Maquina barcoSeleccionado = comboProyectos.getValue();
            if (barcoSeleccionado != null) {
                generarFacturaPDF(barcoSeleccionado);
                interfazPrincipal(stage);
            }
        });

        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setOnAction(e -> interfazPrincipal(stage));

        root.getChildren().addAll(titulo, comboProyectos, btnGenerar, btnCancelar);
        Scene scene = new Scene(root, 500, 300);
        stage.setScene(scene);
        stage.setTitle("Generar Factura");
        stage.show();
    }
    private void generarFacturaPDF(Maquina barco) {
        Boleta boleta = new Boleta();

        Cliente cliente = clienteActual;
        Mecanico mecanico = new Mecanico(
                AlmacenamientoTemporal.getInstancia().getNombre(),
                AlmacenamientoTemporal.getInstancia().getCorreo(),
                AlmacenamientoTemporal.getInstancia().getCelular()
        );

        mecanico.setDireccionEmpresa("Dirección ficticia");

        List<Insumo> insumos = GestorInventario.getInstancia().obtenerInsumos();

        boleta.generarFactura(mecanico, (Barco) barco, cliente, insumos);
    }







}
