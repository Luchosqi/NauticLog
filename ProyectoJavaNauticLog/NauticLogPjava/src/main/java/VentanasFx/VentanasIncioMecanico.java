package VentanasFx;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

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
            Stage nuevaVentana = new Stage();
            siguiente(nuevaVentana);
            ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
        });


        formularioBox.getChildren().addAll(titulo, subtitulo, nombre, rut, correo, celular, siguiente);


        Image imagen = new Image(getClass().getResource("/8484b30c8d363a0bdaabeb585b767a1772744d81.jpg").toExternalForm());
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

        Scene scene = new Scene(root, 900, 500);
        primeraVentanaMecanicoRegistro.setTitle("Registro de Usuario");
        primeraVentanaMecanicoRegistro.setScene(scene);
        primeraVentanaMecanicoRegistro.show();
    }

    public void siguiente(Stage segundaVentanaMecanicoRegistro) {

        VBox formularioBox = new VBox(15);
        formularioBox.setPadding(new Insets(30));
        formularioBox.setAlignment(Pos.CENTER);
        formularioBox.setStyle("-fx-background-color:#507AB1 ; -fx-background-radius: 10;");

        Label titulo = new Label("Registro Empresa");
        titulo.setFont(Font.font("Lao Muang Khong", FontWeight.BOLD, 30));
        titulo.setTextFill(Color.BLACK);

        Label subtitulo = new Label("Datos de la Empresa");
        subtitulo.setFont(Font.font("Lao Muang Khong", FontWeight.NORMAL, 18));
        subtitulo.setTextFill(Color.BLACK);

        TextField rutEmpresa = new TextField();
        rutEmpresa.setPromptText("Rut Empresa");

        TextField correoElectronicoEmpresa = new TextField();
        correoElectronicoEmpresa.setPromptText("Correo Electronico Empresa");

        TextField numeroTelefonicoEmpresa = new TextField();
        numeroTelefonicoEmpresa.setPromptText("Numero Telefonico Empresa");

        Button siguiente = new Button("Registrarse");

        siguiente.setPrefWidth(200);
        siguiente.setStyle("-fx-background-color: #2E2B4F; -fx-text-fill: white;");
        Button atras = new Button("Atras");
        atras.setPrefWidth(200);
        atras.setStyle("-fx-background-color: #1E1C3B; -fx-text-fill: white;");
        formularioBox.getChildren().addAll(titulo, subtitulo, rutEmpresa, correoElectronicoEmpresa, numeroTelefonicoEmpresa, siguiente);


        Image imagen = new Image(getClass().getResource("/8484b30c8d363a0bdaabeb585b767a1772744d81.jpg").toExternalForm());
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

        Scene scene = new Scene(root, 900, 500);
        segundaVentanaMecanicoRegistro.setTitle("Registro Empresa de Usuario");
        segundaVentanaMecanicoRegistro.setScene(scene);
        segundaVentanaMecanicoRegistro.show();
    }
}
