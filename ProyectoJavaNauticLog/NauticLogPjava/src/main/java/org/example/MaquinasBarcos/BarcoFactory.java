package org.example.MaquinasBarcos;
import org.example.PDF.Boleta;
import org.example.PDF.Informe;
import org.example.Persona.Cliente;

import java.util.Collection;

public class BarcoFactory extends CreadorMaquinas {

    private Cliente dueño;
    private String modelo;
    private String marca;

    public BarcoFactory(Cliente dueño, String modelo, String marca, Collection<Boleta> listaBoletas) {
        this.dueño = dueño;
        this.modelo = modelo;
        this.marca = marca;

    }

    @Override
    public Maquina crearMaquina(String nombre) {
        return new Barco(nombre, dueño, modelo, marca);
    }

    @Override
    public Maquina crearMaquina(Collection<Informe> informes, Collection<Motor> motores, String nombre, Collection<Boleta> boletas) {
        return null;
    }
}

