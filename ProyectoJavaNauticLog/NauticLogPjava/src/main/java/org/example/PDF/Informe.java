package org.example.PDF;

import org.example.Inventario.Insumo;
import org.example.MaquinasBarcos.Maquina;

import java.util.*;

public class Informe {

    private Maquina maquina;
    private Collection<Insumo> listaInsumos;
    private String titulo;
    String path;

    public String getTitulo() {
        return titulo;
    }

    public void generarPortada() {

    }

    public void generarInformaciones() {

    }

    public void recibirInputs() {

    }

    public void generarBoleta() {

    }

    public void agregarProductos(Insumo insumo) {
        listaInsumos.add(insumo);
        System.out.println(insumo.getNombre()+" Insumo Agregado");
    }

    public void eliminarProductos(String nombre) {
        for (Insumo insumo : listaInsumos) {
            if (insumo.getNombre().equals(nombre)) {
                listaInsumos.remove(insumo);
                System.out.println("Insumo Eliminado");
            }
        }
    }

    public void buscarProductos(String nombre) {
       for (Insumo insumo : listaInsumos) {
           if (insumo.getNombre().equals(nombre)) {
               System.out.println(insumo.toString());
           }
       }
    }

    public void listarProductos() {
        if (listaInsumos.size() == 0) {
        } else {
            System.out.println("La lista de insumos es:");
            for (Insumo insumo : listaInsumos) {
                System.out.println(insumo.toString());
            }
        }
    }

}
