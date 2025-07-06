package org.example.MaquinasBarcos;

import org.example.Persona.Cliente;
import org.example.PDF.Boleta;
import org.example.PDF.Informe;

import java.util.Collection;

public abstract class Barco extends Maquina {

    private Cliente dueñoBarco;
    private String imagenBarco;
    private String modelo;
    private String marca;

    public Barco(Collection<Informe> listaInformes, Collection<Motor> motores, String nombre, Cliente dueñoBarco, String modelo, String marca, Collection<Boleta> boletas) {
        super(listaInformes, motores, nombre, boletas);
        this.dueñoBarco = dueñoBarco;
        this.modelo = modelo;
        this.marca = marca;
    }


    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " - Dueño: " + dueñoBarco + " - Modelo: " + modelo + " - Marca: " + marca;
    }

    public void agregarImagenBarco(String imagen) {
        this.imagenBarco = imagen;
    }
}
