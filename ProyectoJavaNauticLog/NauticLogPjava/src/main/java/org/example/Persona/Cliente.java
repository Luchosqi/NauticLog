package org.example.Persona;

import org.example.MaquinasBarcos.Maquina;

import java.util.*;

public class Cliente extends Persona {

    private Collection<Maquina> listaBarcos;

    public Cliente(String nombre, String correoElectronico, String numeroTelefonico, Collection<Maquina> listaBarcos) {
        super(nombre, correoElectronico, numeroTelefonico);
        this.listaBarcos = listaBarcos;
    }

    public void agregarMaquina(Maquina m) {
        listaBarcos.add(m);
        System.out.println("Barco agregado: " + m.getNombre());
    }

    public void buscarMaquina(String nombre) {
        for (Maquina maquina : listaBarcos) {
            if (nombre.equals(maquina.getNombre())) {
                System.out.println("El barco buscado es: "+maquina.toString());
            }
        }
    }

    public void listarMaquina() {
        System.out.println("Lista de barcos: ");
        for (Maquina barco : listaBarcos) {
            System.out.println(barco.toString());
        }
    }

    public void eliminarMaquina(String nombre) {
        for (Maquina barco : listaBarcos) {
            if (nombre.equals(barco.getNombre())) {
                listaBarcos.remove(barco);
                System.out.println("El barco eliminado");
            }
        }
    }

    public Maquina[] getListaBarcos() {
        Maquina[] barcosArray = new Maquina[listaBarcos.size()];
        return listaBarcos.toArray(barcosArray);
    }

    @Override
    public String toString() {
        return "Cliente: " + getNombre();
    }

}
