package org.example.MaquinasBarcos;

import java.time.LocalDate;

public class Motor {

    private String marca;
    private String modelo;
    private String numeroMotor;
    private LocalDate fechaFabricacion;
    private String rpmMotor;

    public Motor(String marca, String modelo, String numeroMotor, LocalDate fechaFabricacion, String rpmMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroMotor = numeroMotor;
        this.fechaFabricacion = fechaFabricacion;
        this.rpmMotor = rpmMotor;
    }

    public String getModelo() {
        return modelo;
    }

    public void mostarInformacion() {
        System.out.println("Los Detalles del motor son: ");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Numero Motor: " + numeroMotor);
        System.out.println("Fecha de Fabricacion: " + fechaFabricacion);
        System.out.println("RPM: " + rpmMotor);
    }

    @Override
    public String toString() {
        return "Motor{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroMotor='" + numeroMotor + '\'' +
                ", fechaFabricacion=" + fechaFabricacion +
                ", rpmMotor='" + rpmMotor + '\'' +
                '}';
    }
}
