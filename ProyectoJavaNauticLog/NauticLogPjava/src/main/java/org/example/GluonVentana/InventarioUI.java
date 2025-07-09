package org.example.GluonVentana;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.example.Inventario.*;
import org.example.VentanasFx.VentanasIncioMecanico;
import java.time.LocalDate;



public class InventarioUI {

    public void mostrarFormularioInsumo(Stage stage) {
        VBox root = new VBox();

        HBox barraSuperior = new HBox(10);
        barraSuperior.setStyle("-fx-background-color: #507AB1; -fx-padding: 15px;");
        Button btnAgregarInsumo = new Button("+ Agregar insumo");
        Button btnGuardar = new Button("Guardar");

        Button btnVolver = new Button("Volver");

        VentanasIncioMecanico ventana = new VentanasIncioMecanico();



        estiloBotonBarra(btnAgregarInsumo);
        estiloBotonBarra(btnGuardar);

        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);
        barraSuperior.getChildren().addAll(btnAgregarInsumo, espacio, btnGuardar, btnVolver);
        btnVolver.setOnAction(ev -> ventana.interfazPrincipal(stage));



        GridPane form = new GridPane();
        form.setPadding(new Insets(20));
        form.setHgap(20);
        form.setVgap(15);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(34);
        form.getColumnConstraints().addAll(col1, col2, col3);

        Label nombreLabel = new Label("Nombre:");
        TextField nombre = new TextField();
        estiloCampo(nombre);

        Label cantidadLabel = new Label("Precio:");
        TextField precio = new TextField();
        estiloCampo(precio);

        Label unidadLabel = new Label("Unidades");
        TextField unidad = new TextField();
        estiloCampo(unidad);

        Label descripcionLabel = new Label("Descripcion:");
        TextArea descripcion = new TextArea();
        btnGuardar.setOnAction(e -> {
            try {
                String nombreVal = nombre.getText();
                String precioVal = precio.getText();
                String unidadesVal = unidad.getText();
                String descripcionVal = descripcion.getText();

                if (nombreVal.isEmpty() || precioVal.isEmpty() || unidadesVal.isEmpty()) {
                    throw new IllegalArgumentException("Todos los campos deben estar llenos.");
                }

                // Creamos el insumo
                InsumoBasico insumo = new InsumoBasico(
                        nombreVal,
                        precioVal,
                        precioVal,
                        descripcionVal
                );


                GestorInventario.getInstancia().agregarInsumo(insumo);

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Insumo guardado");
                alerta.setHeaderText(null);
                alerta.setContentText("¡El insumo fue agregado correctamente!");
                alerta.showAndWait();


                nombre.clear();
                precio.clear();
                unidad.clear();
                descripcion.clear();

            } catch (Exception ex) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("No se pudo guardar el insumo");
                error.setContentText(ex.getMessage());
                error.showAndWait();
                ex.printStackTrace();
            }
        });

        descripcion.setPrefRowCount(4);
        descripcion.setWrapText(true);
        descripcion.setStyle("-fx-background-radius: 6; -fx-padding: 10;");

        form.add(nombreLabel, 0, 0);
        form.add(nombre, 0, 1);
        form.add(cantidadLabel, 1, 0);
        form.add(precio, 1, 1);
        form.add(unidadLabel, 2, 0);
        form.add(unidad, 2, 1);
        form.add(descripcionLabel, 0, 2);
        form.add(descripcion, 0, 3, 3, 1);

        root.getChildren().addAll(barraSuperior, form);

        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Agregar Insumo");
        stage.show();
    }
    public void mostrarListaInventario(Stage stage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color:#EAEAEA;");

        Label titulo = new Label("Inventario General");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ListView<String> lista = new ListView<>();
        for (Insumo i : GestorInventario.getInstancia().obtenerInsumos()) {
            lista.getItems().add(i.getNombre() + " — $" + i.calcularPrecioBoleta());
        }

        Button btnVolver = new Button("Volver");
        btnVolver.setStyle("-fx-background-color: #507AB1; -fx-text-fill: white;");
        btnVolver.setOnAction(e -> new VentanasIncioMecanico().interfazPrincipal(stage));

        root.getChildren().addAll(titulo, lista, btnVolver);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Inventario General");
        stage.show();
    }


    public void mostrarFormularioRepuesto(Stage stage) {
        VBox root = new VBox();

        HBox barraSuperior = new HBox(10);
        barraSuperior.setStyle("-fx-background-color: #507AB1; -fx-padding: 15px;");
        Button btnAgregarRepuesto = new Button("+ Agregar producto");
        Label estadoLabel = new Label("Estado:");
        ComboBox<EstadoUso> estadoCombo = new ComboBox<>();
        estadoCombo.getItems().addAll(EstadoUso.values());

        Label originalidadLabel = new Label("Originalidad:");
        ComboBox<Originalidad> originalidadCombo = new ComboBox<>();
        originalidadCombo.getItems().addAll(Originalidad.values());

        Label lugarOrigenLabel = new Label("Lugar de Origen:");
        TextField lugarOrigen = new TextField();
        estiloCampo(lugarOrigen);

        Label fechaElaboracionLabel = new Label("Fecha de Elaboración (YYYY-MM-DD):");
        TextField fechaElaboracion = new TextField();
        estiloCampo(fechaElaboracion);

        Button btnGuardar = new Button("Guardar");


        Button btnVolver = new Button("Volver");
        VentanasIncioMecanico ventana = new VentanasIncioMecanico();




        estiloBotonBarra(btnAgregarRepuesto);
        estiloBotonBarra(btnGuardar);

        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);
        barraSuperior.getChildren().addAll(btnAgregarRepuesto, espacio, btnGuardar, btnVolver);
        btnVolver.setOnAction(ev -> ventana.interfazPrincipal(stage));

        GridPane form = new GridPane();
        form.setPadding(new Insets(20));
        form.setHgap(20);
        form.setVgap(15);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(34);
        form.getColumnConstraints().addAll(col1, col2, col3);

        Label nombreLabel = new Label("Nombre:");
        TextField nombre = new TextField();
        estiloCampo(nombre);

        Label precioOriginalLabel = new Label("Precio original:");
        TextField precioOriginal = new TextField();
        estiloCampo(precioOriginal);

        Label precioBoletaLabel = new Label("Precio boleta:");
        TextField precioBoleta = new TextField();
        estiloCampo(precioBoleta);

        Label descripcionLabel = new Label("Descripcion:");
        TextArea descripcion = new TextArea();
        descripcion.setPrefRowCount(4);
        descripcion.setWrapText(true);
        descripcion.setStyle("-fx-background-radius: 6; -fx-padding: 10;");

        form.add(nombreLabel, 0, 0);
        form.add(nombre, 0, 1);
        form.add(precioOriginalLabel, 1, 0);
        form.add(precioOriginal, 1, 1);
        form.add(precioBoletaLabel, 2, 0);
        form.add(precioBoleta, 2, 1);
        form.add(descripcionLabel, 0, 2);
        form.add(descripcion, 0, 3, 3, 1);
        form.add(estadoLabel, 0, 4);
        form.add(estadoCombo, 0, 5);
        form.add(originalidadLabel, 1, 4);
        form.add(originalidadCombo, 1, 5);
        form.add(lugarOrigenLabel, 2, 4);
        form.add(lugarOrigen, 2, 5);
        form.add(fechaElaboracionLabel, 0, 6);
        form.add(fechaElaboracion, 0, 7, 3, 1);
        btnGuardar.setOnAction(e -> {
            try {
                Pieza pieza = new Pieza(
                        nombre.getText(),
                        precioOriginal.getText(),
                        precioBoleta.getText(),
                        descripcion.getText(),
                        estadoCombo.getValue(),
                        originalidadCombo.getValue(),
                        lugarOrigen.getText(),
                        descripcion.getText(),
                        LocalDate.parse(fechaElaboracion.getText())
                );

                GestorInventario.getInstancia().agregarInsumo(pieza);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText("¡Repuesto agregado correctamente!");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No se pudo guardar el repuesto");
                alert.setContentText("Revisa que todos los campos estén llenos y correctos.");
                alert.showAndWait();
                ex.printStackTrace();
            }
        });


        root.getChildren().addAll(barraSuperior, form);

        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Agregar Repuesto");
        stage.show();
    }

    private void estiloCampo(TextField campo) {
        campo.setStyle("-fx-background-radius: 6; -fx-padding: 8;");
    }

    private void estiloBotonBarra(Button boton) {
        boton.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
    }
} 