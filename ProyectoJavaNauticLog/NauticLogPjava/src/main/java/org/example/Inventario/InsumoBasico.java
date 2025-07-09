package org.example.Inventario;

public class InsumoBasico extends Insumo {
    public InsumoBasico(String nombre, String precioOriginal, String precioBoleta, String descripcion) {
        super(nombre, precioOriginal, precioBoleta, descripcion);
    }

    @Override
    public String toString() {
        return "InsumoBasico: " + getNombre();
    }
}

