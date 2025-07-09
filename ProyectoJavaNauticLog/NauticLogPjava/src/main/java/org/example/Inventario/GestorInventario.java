package org.example.Inventario;

import java.util.ArrayList;
import java.util.List;

public class GestorInventario {
    private static GestorInventario instancia;
    private final List<Insumo> insumos;

    private GestorInventario() {
        this.insumos = new ArrayList<>();
    }

    public static GestorInventario getInstancia() {
        if (instancia == null) {
            instancia = new GestorInventario();
        }
        return instancia;
    }

    public void agregarInsumo(Insumo i) {
        insumos.add(i);
        System.out.println("Insumo agregado: " + i.getNombre());
    }

    public List<Insumo> obtenerInsumos() {
        return insumos;
    }
}
