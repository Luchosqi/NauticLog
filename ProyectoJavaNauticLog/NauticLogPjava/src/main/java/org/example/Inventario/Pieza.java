package org.example.Inventario;

import java.time.LocalDate;

public class Pieza extends Insumo {
    public Pieza(String nombre, String precioOriginal, String precioBoleta, String descripcion, EstadoUso estadoDeUso, Originalidad originalidad, String lugarOrigen, String descripcion1, LocalDate fechaElaboracion) {
        super(nombre, precioOriginal, precioBoleta, descripcion);
        this.estadoDeUso = estadoDeUso;
        this.originalidad = originalidad;
        this.lugarOrigen = lugarOrigen;
        this.descripcion = descripcion1;
        this.fechaElaboracion = fechaElaboracion;
    }

    private EstadoUso estadoDeUso;
    private Originalidad originalidad;
    private String lugarOrigen;
    private String descripcion;
    private LocalDate fechaElaboracion;

}
