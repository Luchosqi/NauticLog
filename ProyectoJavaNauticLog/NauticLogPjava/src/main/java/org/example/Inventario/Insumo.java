package org.example.Inventario;

public abstract class Insumo {

    private String nombre;
    private String precioOriginal;
    private String precioBoleta;
    private String descripcion;
    private double tasaInteres = 0.3;

    public Insumo(String nombre, String precioOriginal, String precioBoleta, String descripcion) {
        this.nombre = nombre;
        this.precioOriginal = precioOriginal;
        this.precioBoleta = precioBoleta;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public Double calcularPrecioBoleta() {
        double precioBoletaCalculado = Double.parseDouble(precioBoleta);
        return precioBoletaCalculado * tasaInteres;
    }

    public String mostrarPrecioBoleta(double precioBoletaCalculado) {
        String precioBoletaCalculadoCadena = precioBoleta;
        return precioBoletaCalculadoCadena;
    }

}
