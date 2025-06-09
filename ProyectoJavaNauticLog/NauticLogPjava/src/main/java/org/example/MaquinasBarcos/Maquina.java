package org.example.MaquinasBarcos;

import org.example.PDF.Boleta;
import org.example.PDF.Historial;
import org.example.PDF.Informe;

import java.util.*;

public abstract class Maquina implements Historial {

    private Collection<Informe> listaInformes;
    private Collection<Motor> motores;
    private String nombre;
    private Collection<Boleta> listaFacturas;


    public Maquina(Collection<Informe> listaInformes, Collection<Motor> motores, String nombre, Collection<Boleta> boletas) {
        this.listaInformes = listaInformes;
        this.motores = motores;
        this.nombre = nombre;
        this.listaFacturas = boletas;
    }


    public String getNombre() {
        return nombre;
    }

    public String mostrarInformacion() {
        return nombre + " - " + motores.toString() + " - " + listaInformes.toString();
    }

    public void registrarTrabajo(Informe informe) {
        listaInformes.add(informe);
        System.out.println("Informe registrado: " + informe.getTitulo());
    }

    @Override
    public void registrarTrabajo() {
        listaInformes.add(new Informe());
    }

    public void buscarTrabajo(String tituloInforme) {
        for (Informe informe : listaInformes) {
            if (tituloInforme.equals(informe.getTitulo())) {
                System.out.println(informe.toString());
            }
        }
    }

    public void borrarTrabajo(String tituloInforme) {
        Informe encontrado = null;
        for (Informe informe : listaInformes) {
            if (tituloInforme.equals(informe.getTitulo())) {
                encontrado = informe;
                break;
            }
        }
        if (encontrado != null) {
            listaInformes.remove(encontrado);
            System.out.println("Informe ha sido borrado");
        }
    }

    public void agregarFactura(Boleta boleta) {
        listaFacturas.add(boleta);
    }

    @Override
    public void listarTrabajo() {
        for (Informe informe : listaInformes) {
            System.out.println(informe.toString());
        }
    }

    public void eliminarMotor(String modelo) {
        Motor encontrado = null;
        for (Motor motor : motores) {
            if (modelo.equals(motor.getModelo())) {
                encontrado = motor;
                break;
            }
        }
        if (encontrado != null) {
            motores.remove(encontrado);
            System.out.println("Motor eliminado");
        }
    }

    public void buscarMotor(String modelo) {
        for (Motor motor : motores) {
            if (modelo.equals(motor.getModelo())) {
                System.out.println(motor.toString());
            }
        }
    }

    public void agregarMotor(Motor motor) {
        motores.add(motor);
    }

    public void listarMotores() {
        System.out.println("Lista de motores:");
        for (Motor motor : motores) {
            System.out.println(motor.toString());
        }
    }
}
